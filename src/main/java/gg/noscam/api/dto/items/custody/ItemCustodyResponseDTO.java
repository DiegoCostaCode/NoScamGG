package gg.noscam.api.dto.items.custody;

public record ItemCustodyResponseDTO(
        String assetid,
        String inspectlink,
        Boolean locked
) {
}
