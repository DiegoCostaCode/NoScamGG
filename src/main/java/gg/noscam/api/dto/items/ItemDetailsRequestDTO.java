package gg.noscam.api.dto.items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ItemDetailsRequestDTO(
        String assetid,
        @JsonProperty("float")
        String floatvalue,
        String wear,
        String quality,
        String pattern,
        String paintseed,
        Boolean startTrak,
        String rarity,
        List<ItemAttachmentDTO> stickers,
        List<ItemAttachmentDTO> keychans
) {
}
