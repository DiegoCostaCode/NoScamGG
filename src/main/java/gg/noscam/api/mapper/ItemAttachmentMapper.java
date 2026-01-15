package gg.noscam.api.mapper;

import gg.noscam.api.dto.items.details.ItemAttachmentDTO;
import gg.noscam.api.interfaces.IRequestResponseMapper;
import gg.noscam.api.models.inventory.ItemAttachment;
import gg.noscam.api.models.inventory.enums.ItemAttachementEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemAttachmentMapper implements IRequestResponseMapper<ItemAttachment, ItemAttachmentDTO, ItemAttachmentDTO> {

    @Override
    public ItemAttachment toEntity(ItemAttachmentDTO dto) {
        return null;
    }

    @Override
    public ItemAttachmentDTO toDTO(ItemAttachment entity) {
        return new ItemAttachmentDTO(
                entity.getId(),
                entity.getName(),
                entity.getRarity(),
                entity.getType().name().toLowerCase(),
                entity.getSlot(),
                entity.getWear()
        );
    }

    private ItemAttachment base(ItemAttachmentDTO dto) {
        ItemAttachment attachment = new ItemAttachment();
        attachment.setId(dto.id());
        attachment.setName(dto.name());
        attachment.setRarity(dto.rarity());
        return attachment;
    }

    public ItemAttachment createSticker(ItemAttachmentDTO dto) {
        ItemAttachment attachment = base(dto);
        attachment.setType(ItemAttachementEnum.STICKER);
        attachment.setSlot(dto.slot());
        attachment.setWear(dto.wear());
        return attachment;
    }

    public ItemAttachment createKeychain(ItemAttachmentDTO dto) {
        ItemAttachment attachment = base(dto);
        attachment.setType(ItemAttachementEnum.KEYCHAIN);
        return attachment;
    }
}