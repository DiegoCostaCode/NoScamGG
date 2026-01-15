package gg.noscam.api.services;

import gg.noscam.api.config.SteamWebApiConfig;
import gg.noscam.api.dto.steamWebApi.InventoryAssetId;
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

    public List<InventoryAssetId> retrieveInventorySnapshot(String steamId, String tradeUrl) {

        String url = UriComponentsBuilder
                .fromUriString(steamWebApiConfig.getUrl())
                .path("/inventory")
                .queryParam("key", steamWebApiConfig.getToken())
                .queryParam("steam_id", steamId)
                .queryParam("group", 1)
                .queryParam("select", "assetid")
                .queryParam("with_no_tradable", 1)
                .queryParam("trade_url", tradeUrl)
                .encode()
                .toUriString();

        ResponseEntity<List<InventoryAssetId>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<InventoryAssetId>>() {}
        );

        List<InventoryAssetId> inventoryAssetIds = response.getBody();

        return inventoryAssetIds;
    }

    /*,count,wear,rarity,float,quality,color,image,marketable,tradable,tradelocked,inspectlink,isstar,isstattrak*/
}
