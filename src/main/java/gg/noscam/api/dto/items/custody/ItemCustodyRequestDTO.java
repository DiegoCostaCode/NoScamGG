package gg.noscam.api.dto.items.custody;

public record ItemCustodyRequestDTO(
        String assetid,
        String inspectlink,
        String currentOwnerSteamId,
        Boolean tradelocked
){
}
