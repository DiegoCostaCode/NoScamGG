package gg.noscam.api.dto.items.custody;

import gg.noscam.api.dto.items.ItemDetailsResponseDTO;

public record ItemCustodyResponseDTO(
        String assetid,
        String inspectlink,
        Boolean locked,
        ItemDetailsResponseDTO itemDetails
) {
}
