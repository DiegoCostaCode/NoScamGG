package gg.noscam.api.dto.inventory;

import gg.noscam.api.dto.steamWebApi.InventoryAssetInfo;

import java.util.Set;

public record InventorySnapshotRequestDTO(
        String steamId,
        Set<InventoryAssetInfo> itemsTrivialInfo
    ) {}
