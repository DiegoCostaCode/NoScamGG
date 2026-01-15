package gg.noscam.api.models.inventory;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "steam_item_custody")
@Getter
@Setter
public class ItemCustody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_id", nullable = false, unique = true)
    private String assetId;

    @Column(name = "inspect_link")
    private String inspectLink;

    @Column(name = "current_owner_steamid")
    private String currentOwnerSteamId;

    @Column(nullable = false)
    private Boolean isTradeLocked = false;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
}
