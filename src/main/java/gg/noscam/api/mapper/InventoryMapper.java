package gg.noscam.api.mapper;

import gg.noscam.api.dto.inventory.InventorySnapshotRequestDTO;
import gg.noscam.api.dto.steamWebApi.InventoryAssetInfo;
import gg.noscam.api.models.inventory.InventorySnapshot;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InventoryMapper {

    public InventorySnapshotRequestDTO toRequestDTO(
            String steamId,
            List<InventoryAssetInfo> inventoryAssetInfos
    ) {

        Set<InventoryAssetInfo> setInventoryAsset = new HashSet<>(inventoryAssetInfos);

        return new InventorySnapshotRequestDTO(
                steamId,
                setInventoryAsset
        );
    }

    public InventorySnapshot toEntity(InventorySnapshotRequestDTO dto) {
        InventorySnapshot snapshot = new InventorySnapshot();

        snapshot.setSteamId(dto.steamId());
        snapshot.setAssetIds(dto.itemsTrivialInfo());

        return snapshot;
    }
}
