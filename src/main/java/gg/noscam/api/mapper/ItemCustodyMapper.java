package gg.noscam.api.mapper;

import gg.noscam.api.dto.items.details.ItemDetailsResponseDTO;
import gg.noscam.api.dto.items.custody.ItemCustodyRequestDTO;
import gg.noscam.api.dto.items.custody.ItemCustodyResponseDTO;
import gg.noscam.api.dto.items.custody.ItemCustodyWithDetailsResponseDTO;
import gg.noscam.api.interfaces.IRequestResponseMapper;
import gg.noscam.api.models.inventory.ItemCustody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemCustodyMapper implements IRequestResponseMapper<ItemCustody, ItemCustodyRequestDTO, ItemCustodyResponseDTO> {


    @Override
    public ItemCustody toEntity(ItemCustodyRequestDTO dto) {
        ItemCustody itemCustody = new ItemCustody();

        itemCustody.setAssetId(dto.assetid());
        itemCustody.setInspectLink(dto.inspectlink());
        itemCustody.setCurrentOwnerSteamId(dto.currentOwnerSteamId());
        itemCustody.setIsTradeLocked(dto.tradelocked());

        return itemCustody;
    }

    @Override
    public ItemCustodyResponseDTO toDTO(ItemCustody entity) {
        return new ItemCustodyResponseDTO(
                entity.getAssetId(),
                entity.getInspectLink(),
                entity.getIsTradeLocked()
        );
    }

    public ItemCustodyWithDetailsResponseDTO toCompositeDTO(ItemCustody entity, ItemDetailsResponseDTO details) {
        return new ItemCustodyWithDetailsResponseDTO(
                entity.getAssetId(),
                entity.getInspectLink(),
                entity.getIsTradeLocked(),
                details
        );
    }
}
