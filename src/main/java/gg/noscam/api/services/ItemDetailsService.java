package gg.noscam.api.services;

import gg.noscam.api.dto.items.details.ItemDetailsRequestDTO;
import gg.noscam.api.dto.items.details.ItemDetailsResponseDTO;
import gg.noscam.api.mapper.ItemDetailsMapper;
import gg.noscam.api.models.inventory.ItemDetails;
import gg.noscam.api.repositories.ItemDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemDetailsService {

    @Autowired
    private ItemDetailsMapper itemDetailsMapper;

    @Autowired
    private ItemDetailsRepository itemDetailsRepository;

    @Autowired
    private final SteamWebApiService steamWebApiService;

    public ItemDetailsResponseDTO getItemInfo(String inspectLink) {

        ItemDetailsRequestDTO itemDetailsDTO = steamWebApiService.retrieveEnrichmentInfo(
                inspectLink
        );

        ItemDetails itemDetails = itemDetailsMapper.toEntity(itemDetailsDTO);

        return itemDetailsMapper.toDTO(itemDetailsRepository.save(itemDetails));
    }

}
