package gg.noscam.api.dto.items.details;

public record ItemAttachmentDTO(
        String id,
        String name,
        String rarity,
        String type,
        Integer slot,
        Float wear
) {
}
