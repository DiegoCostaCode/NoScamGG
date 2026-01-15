package gg.noscam.api.dto.inventory.snapshots;

import gg.noscam.api.dto.integration.steamWebApi.InventoryAssetInfo;

import java.util.Set;

public record InventorySnapshotRequestDTO(
        String steamId,
        Set<InventoryAssetInfo> itemsTrivialInfo
    ) {}
