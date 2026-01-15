package gg.noscam.api.mapper;

import gg.noscam.api.dto.items.ItemDetailsResponseDTO;
import gg.noscam.api.dto.items.custody.ItemCustodyRequestDTO;
import gg.noscam.api.dto.items.custody.ItemCustodyResponseDTO;
import gg.noscam.api.models.inventory.ItemCustody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemCustodyMapper {

    @Autowired
    private ItemDetailsMapper itemDetailsMapper;

    public ItemCustody toEntity(ItemCustodyRequestDTO itemDTO){
        ItemCustody itemCustody = new ItemCustody();

        itemCustody.setAssetId(itemDTO.assetid());
        itemCustody.setInspectLink(itemDTO.inspectlink());
        itemCustody.setCurrentOwnerSteamId(itemDTO.currentOwnerSteamId());
        itemCustody.setIsTradeLocked(itemDTO.tradelocked());

        return itemCustody;
    }

    public ItemCustodyResponseDTO toDTO(ItemCustody itemCustody, ItemDetailsResponseDTO itemDetailsDTO){

        return new ItemCustodyResponseDTO(
                itemCustody.getAssetId(),
                itemCustody.getInspectLink(),
                itemCustody.getIsTradeLocked(),
                itemDetailsDTO
        );
    }
}
