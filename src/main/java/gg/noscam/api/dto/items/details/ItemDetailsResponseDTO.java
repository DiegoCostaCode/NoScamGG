package gg.noscam.api.dto.items.details;

import java.util.List;

public record ItemDetailsResponseDTO(
        Float floatvalue,
        String wear,
        String pattern,
        String paintseed,
        Boolean startTrak,
        String rarity,
        List<ItemAttachmentDTO> stickers,
        ItemAttachmentDTO keychans
) {}
