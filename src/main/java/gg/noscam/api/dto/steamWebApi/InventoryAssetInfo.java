package gg.noscam.api.dto.steamWebApi;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InventoryAssetInfo(
        String assetid,
        String inspectlink,
        @JsonProperty("tradelocked")
        Boolean istradelocked
) {}
