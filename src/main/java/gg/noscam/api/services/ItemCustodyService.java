package gg.noscam.api.services;

import gg.noscam.api.dto.items.custody.ItemCustodyWithDetailsResponseDTO;
import gg.noscam.api.dto.items.details.ItemDetailsResponseDTO;
import gg.noscam.api.dto.items.custody.ItemCustodyRequestDTO;
import gg.noscam.api.dto.items.custody.ItemCustodyResponseDTO;
import gg.noscam.api.mapper.ItemCustodyMapper;
import gg.noscam.api.models.itemCustody.ItemCustody;
import gg.noscam.api.repositories.ItemCustodyReposity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemCustodyService {

    @Autowired
    private final ItemCustodyMapper itemCustodyMapper;

    @Autowired
    private final ItemDetailsService itemADetailsService;

    @Autowired
    private final ItemCustodyReposity itemCustodyReposity;

    @Transactional
    public ItemCustodyWithDetailsResponseDTO registerItemCustody(ItemCustodyRequestDTO itemDTO){

        ItemCustody itemCustody = itemCustodyReposity.save(
                itemCustodyMapper.toEntity(itemDTO)
        );

        ItemDetailsResponseDTO itemDetailsDTO = itemADetailsService.getItemInfo(itemCustody.getInspectLink());

        return itemCustodyMapper.toCompositeDTO(itemCustody, itemDetailsDTO);
    }

}
