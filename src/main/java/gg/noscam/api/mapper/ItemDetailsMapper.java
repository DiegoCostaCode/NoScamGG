package gg.noscam.api.mapper;

import gg.noscam.api.dto.items.details.ItemAttachmentDTO;
import gg.noscam.api.dto.items.details.ItemDetailsRequestDTO;
import gg.noscam.api.dto.items.details.ItemDetailsResponseDTO;
import gg.noscam.api.interfaces.IRequestResponseMapper;
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
public class ItemDetailsMapper implements IRequestResponseMapper<ItemDetails, ItemDetailsRequestDTO, ItemDetailsResponseDTO> {

    private final ItemAttachmentMapper attachmentMapper;

    @Override
    public ItemDetails toEntity(ItemDetailsRequestDTO dto) {
        List<ItemAttachment> attachments = new ArrayList<>();

        if (dto.stickers() != null) {
            attachments.addAll(
                    dto.stickers().stream()
                            .map(attachmentMapper::createSticker)
                            .toList()
            );
        }

        if (dto.keychans() != null) {
            attachments.addAll(
                    dto.keychans().stream()
                            .map(attachmentMapper::createKeychain)
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

    @Override
    public ItemDetailsResponseDTO toDTO(ItemDetails entity) {
        List<ItemAttachmentDTO> stickers = entity.getAttachments().stream()
                .filter(a -> a.getType() == ItemAttachementEnum.STICKER)
                .map(attachmentMapper::toDTO)
                .toList();

        ItemAttachmentDTO keychain = entity.getAttachments().stream()
                .filter(a -> a.getType() == ItemAttachementEnum.KEYCHAIN)
                .findFirst()
                .map(attachmentMapper::toDTO)
                .orElse(null);

        return new ItemDetailsResponseDTO(
                entity.getFloatvalue(),
                entity.getWear(),
                entity.getPattern(),
                entity.getPaintseed(),
                entity.getStartTrak(),
                entity.getRarity().name(),
                stickers,
                keychain
        );
    }
}
