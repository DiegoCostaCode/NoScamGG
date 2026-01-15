package gg.noscam.api.models.inventory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Set;

@Document(collection = "inventory_snapshots")
@Getter
@Setter
public class InventorySnapshot {

    @Id
    private String id;

    @Indexed
    private String steamId;

    private Set<String> assetIds;

    @Indexed
    private Instant takenAt = Instant.now();
}