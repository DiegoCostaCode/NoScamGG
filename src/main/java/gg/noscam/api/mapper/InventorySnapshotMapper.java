package gg.noscam.api.mapper;

import gg.noscam.api.dto.inventory.snapshots.InventorySnapshotRequestDTO;
import gg.noscam.api.dto.integration.steamWebApi.InventoryAssetInfo;
import gg.noscam.api.interfaces.IRequestResponseMapper;
import gg.noscam.api.models.inventory.InventorySnapshot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InventorySnapshotMapper {

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
