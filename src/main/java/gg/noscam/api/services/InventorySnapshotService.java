package gg.noscam.api.services;

import gg.noscam.api.dto.inventory.InventorySnapshotRequestDTO;
import gg.noscam.api.dto.steamWebApi.InventoryAssetInfo;
import gg.noscam.api.mapper.InventoryMapper;
import gg.noscam.api.models.inventory.InventorySnapshot;
import gg.noscam.api.repositories.InventorySnapshotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventorySnapshotService {

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private final InventorySnapshotRepository inventorySnapshotRepository;

    @Autowired
    private final SteamWebApiService steamWebApiService;

    public InventorySnapshot saveSnapshot(InventorySnapshotRequestDTO inventorySnapshotRequestDTO) {

        InventorySnapshot inventorySnap = inventoryMapper.toEntity(inventorySnapshotRequestDTO);

        return inventorySnapshotRepository.save(inventorySnap);
    };

    public InventorySnapshot takeSnapshot(String steamId, String tradeUrl){

        List<InventoryAssetInfo> inventorySnapshot = steamWebApiService.retrieveInventory(steamId, tradeUrl);

        InventorySnapshotRequestDTO inventorySnapRequestDTO = inventoryMapper.toRequestDTO(steamId, inventorySnapshot);

        return saveSnapshot(inventorySnapRequestDTO);
    }

}
