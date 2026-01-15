package gg.noscam.api.dto.items.custody;

import gg.noscam.api.dto.items.details.ItemDetailsResponseDTO;

public record ItemCustodyWithDetailsResponseDTO(
        String assetid,
        String inspectlink,
        Boolean locked,
        ItemDetailsResponseDTO itemDetails
) {
}
