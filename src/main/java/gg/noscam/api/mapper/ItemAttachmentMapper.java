package gg.noscam.api.mapper;

import gg.noscam.api.dto.items.ItemAttachmentDTO;
import gg.noscam.api.models.inventory.ItemAttachment;
import gg.noscam.api.models.inventory.enums.ItemAttachementEnum;
import org.springframework.stereotype.Component;

@Component
public class ItemAttachmentMapper {

    public ItemAttachment toEntity(
            ItemAttachmentDTO dto,
            ItemAttachementEnum type
    ) {
        ItemAttachment attachment = new ItemAttachment();

        attachment.setId(dto.id());
        attachment.setName(dto.name());
        attachment.setRarity(dto.rarity());
        attachment.setType(type);

        if (type == ItemAttachementEnum.STICKER) {
            attachment.setSlot(dto.slot());
            attachment.setWear(dto.wear());
        }

        return attachment;
    }

    public ItemAttachmentDTO toDTO(ItemAttachment attachment) {
        return new ItemAttachmentDTO(
                attachment.getId(),
                attachment.getName(),
                attachment.getRarity(),
                attachment.getType().name().toLowerCase(),
                attachment.getSlot(),
                attachment.getWear()
        );
    }
}