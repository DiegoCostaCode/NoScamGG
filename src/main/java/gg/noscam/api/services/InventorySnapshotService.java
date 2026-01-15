package gg.noscam.api.services;

import gg.noscam.api.dto.inventory.snapshots.InventorySnapshotRequestDTO;
import gg.noscam.api.dto.integration.steamWebApi.InventoryAssetInfo;
import gg.noscam.api.mapper.InventorySnapshotMapper;
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
    private InventorySnapshotMapper inventorySnapshotMapper;

    @Autowired
    private final InventorySnapshotRepository inventorySnapshotRepository;

    @Autowired
    private final SteamWebApiService steamWebApiService;

    public InventorySnapshot saveSnapshot(InventorySnapshotRequestDTO inventorySnapshotRequestDTO) {

        InventorySnapshot inventorySnap = inventorySnapshotMapper.toEntity(inventorySnapshotRequestDTO);

        return inventorySnapshotRepository.save(inventorySnap);
    };

    public InventorySnapshot takeSnapshot(String steamId, String tradeUrl){

        List<InventoryAssetInfo> inventorySnapshot = steamWebApiService.retrieveInventory(steamId, tradeUrl);

        InventorySnapshotRequestDTO inventorySnapRequestDTO = inventorySnapshotMapper.toRequestDTO(steamId, inventorySnapshot);

        return saveSnapshot(inventorySnapRequestDTO);
    }

}
