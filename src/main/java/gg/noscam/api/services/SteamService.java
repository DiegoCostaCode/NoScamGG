package gg.noscam.api.services;

import gg.noscam.api.config.SteamConfig;
import gg.noscam.api.dto.steam.UserPublicInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class SteamService {

    private final SteamConfig config;
    private final RestTemplate restTemplate;

    public String getOpenId(HttpServletRequest request) {

        String claimedId = request.getParameter("openid.claimed_id");

        return claimedId.substring(claimedId.lastIndexOf("/") + 1);
    }

    public UserPublicInfoDTO findPublicInfosFromOpenId(String openId) {

        if (openId == null || openId.isBlank()) {
            throw new IllegalArgumentException("Steam ID não pode ser nulo ou vazio");
        }

        String url = UriComponentsBuilder
                .fromUriString(config.getApiUrl())
                .path("/ISteamUser/GetPlayerSummaries/v0002/")
                .queryParam("key", config.getToken())
                .queryParam("steamids", openId)
                .build()
                .toUriString();

        UserPublicInfoDTO response = restTemplate.getForObject(url, UserPublicInfoDTO.class);

        if (response == null) {
            throw new RuntimeException("Steam API retornou resposta vazia para Steam ID: " + openId);
        }

        return response;
    }

    public String buildURL() {

        return UriComponentsBuilder.fromUriString(config.getUrl())
                .queryParam("openid.ns", "http://specs.openid.net/auth/2.0")
                .queryParam("openid.mode", "checkid_setup")
                .queryParam("openid.return_to", config.getReturnUrl())
                .queryParam("openid.realm", config.getReturnUrl())
                .queryParam("openid.identity", "http://specs.openid.net/auth/2.0/identifier_select")
                .queryParam("openid.claimed_id", "http://specs.openid.net/auth/2.0/identifier_select")
                .build()
                .toUriString();
    }


}
