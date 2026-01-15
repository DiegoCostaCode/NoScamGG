package gg.noscam.api.dto.inventory;

import java.util.Set;

public record InventorySnapshotRequestDTO(
        String steamId,
        Set<String> assetsIds
    ) {}
