package gg.noscam.api.models.inventory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "inventory_item")
@Getter
@Setter
public class InventoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "asset_id", nullable = false, unique = true)
    private String assetId;

    @Column(name = "app_id", nullable = false)
    private Integer appId;

    @Column(name = "context_id", nullable = false)
    private String contextId;

    @Column(name = "market_hash_name", nullable = false)
    private String marketHashName;

    @Column(name = "inspect_link")
    private String inspectLink;

    @Column(name = "current_owner_steamid")
    private String currentOwnerSteamId;

    @Column(nullable = false)
    private boolean locked = false;

    @Column(name = "lock_reason")
    private String lockReason;

    @Column(name = "last_seen_at")
    private Instant lastSeenAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
}
