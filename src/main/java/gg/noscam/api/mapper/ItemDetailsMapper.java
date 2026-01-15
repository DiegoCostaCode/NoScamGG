package gg.noscam.api.mapper;

import gg.noscam.api.dto.items.ItemAttachmentDTO;
import gg.noscam.api.dto.items.ItemDetailsRequestDTO;
import gg.noscam.api.dto.items.ItemDetailsResponseDTO;
import gg.noscam.api.models.inventory.ItemAttachment;
import gg.noscam.api.models.inventory.ItemDetails;
import gg.noscam.api.models.inventory.enums.ItemAttachementEnum;
import gg.noscam.api.models.inventory.enums.RarityEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class ItemDetailsMapper {

    private final ItemAttachmentMapper attachmentMapper;

    public ItemDetails toEntity(ItemDetailsRequestDTO dto) {

        List<ItemAttachment> attachments = new ArrayList<>();

        if (dto.stickers() != null) {
            attachments.addAll(
                    dto.stickers().stream()
                            .map(s -> attachmentMapper.toEntity(
                                    s,
                                    ItemAttachementEnum.STICKER
                            ))
                            .toList()
            );
        }

        if (dto.keychans() != null) {
            attachments.addAll(
                    dto.keychans().stream()
                            .map(k -> attachmentMapper.toEntity(
                                    k,
                                    ItemAttachementEnum.KEYCHAIN
                            ))
                            .toList()
            );
        }

        ItemDetails details = new ItemDetails();
        details.setAssetId(dto.assetid());
        details.setFloatvalue(Float.valueOf(dto.floatvalue()));
        details.setWear(dto.wear());
        details.setPattern(dto.pattern());
        details.setPaintseed(dto.paintseed());
        details.setStartTrak(dto.startTrak());
        details.setRarity(RarityEnum.valueOf(dto.rarity()));
        details.setAttachments(attachments);
        details.setUpdatedAt(Instant.now());

        return details;
    }

    public ItemDetailsResponseDTO toDTO(ItemDetails itemDetails) {

        List<ItemAttachmentDTO> stickers = itemDetails.getAttachments().stream()
                .filter(a -> a.getType() == ItemAttachementEnum.STICKER)
                .map(attachmentMapper::toDTO)
                .toList();

        ItemAttachmentDTO keychain = itemDetails.getAttachments().stream()
                .filter(a -> a.getType() == ItemAttachementEnum.KEYCHAIN)
                .findFirst()
                .map(attachmentMapper::toDTO)
                .orElse(null);

        return new ItemDetailsResponseDTO(
                itemDetails.getFloatvalue(),
                itemDetails.getWear(),
                itemDetails.getPattern(),
                itemDetails.getPaintseed(),
                itemDetails.getStartTrak(),
                itemDetails.getRarity().name(),
                stickers,
                keychain
        );
    }
}
