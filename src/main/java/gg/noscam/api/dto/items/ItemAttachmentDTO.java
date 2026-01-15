package gg.noscam.api.dto.items;

public record ItemAttachmentDTO(
        String id,
        String name,
        String rarity,
        String type,
        Integer slot,
        Float wear
) {
}
