package gg.noscam.api.mapper;

import gg.noscam.api.dto.inventory.InventorySnapshotRequestDTO;
import gg.noscam.api.dto.steam.UserPublicInfoDTO;
import gg.noscam.api.dto.steamWebApi.InventoryAssetId;
import gg.noscam.api.dto.user.UserRequestDTO;
import gg.noscam.api.models.inventory.InventorySnapshot;
import gg.noscam.api.models.user.enums.EnumUserStatus;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InventoryMapper {

    public InventorySnapshotRequestDTO toRequestDTO(
            String steamId,
            List<InventoryAssetId> assets
    ) {
        Set<String> assetIds = assets.stream()
                .map(InventoryAssetId::assetid)
                .collect(Collectors.toSet());

        return new InventorySnapshotRequestDTO(
                steamId,
                assetIds
        );
    }

    public InventorySnapshot toEntity(InventorySnapshotRequestDTO dto) {
        InventorySnapshot snapshot = new InventorySnapshot();

        snapshot.setSteamId(dto.steamId());
        snapshot.setAssetIds(dto.assetsIds());

        return snapshot;
    }
}
