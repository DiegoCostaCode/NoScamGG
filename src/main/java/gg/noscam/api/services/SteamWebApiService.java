package gg.noscam.api.services;

import gg.noscam.api.config.SteamWebApiConfig;
import gg.noscam.api.dto.items.details.ItemDetailsRequestDTO;
import gg.noscam.api.dto.integration.steamWebApi.InventoryAssetInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SteamWebApiService {

    private final SteamWebApiConfig steamWebApiConfig;
    private final RestTemplate restTemplate;

    public List<InventoryAssetInfo> retrieveInventory(String steamId, String tradeUrl) {

        String url = UriComponentsBuilder
                .fromUriString(steamWebApiConfig.getUrl())
                .path("/inventory")
                .queryParam("key", steamWebApiConfig.getToken())
                .queryParam("steam_id", steamId)
                .queryParam("group", 1)
                .queryParam("select", "assetid,inspectlink,tradelocked")
                .queryParam("with_no_tradable", 1)
                .queryParam("trade_url", tradeUrl)
                .queryParam("format", "json")
                .encode()
                .toUriString();

        ResponseEntity<List<InventoryAssetInfo>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<InventoryAssetInfo>>() {}
        );

        return response.getBody();
    }

    public ItemDetailsRequestDTO retrieveEnrichmentInfo(String inspectLink) {

        String url = UriComponentsBuilder
                .fromUriString(steamWebApiConfig.getUrl())
                .path("/steam/api/float")
                .queryParam("key", steamWebApiConfig.getToken())
                .queryParam("url", inspectLink)
                .queryParam("format", "json")
                .encode()
                .toUriString();

        ResponseEntity<ItemDetailsRequestDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ItemDetailsRequestDTO>() {}
        );

        return response.getBody();
    }

    /*,count,wear,rarity,float,quality,color,image,marketable,tradable,istradelocked,inspectlink,isstar,isstattrak*/
}
