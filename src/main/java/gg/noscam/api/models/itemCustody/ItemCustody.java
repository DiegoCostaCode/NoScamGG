package gg.noscam.api.models.itemCustody;

import gg.noscam.api.models.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "steam_item_custody")
@Getter
@Setter
public class ItemCustody extends BaseEntity {

    @Column(name = "asset_id", nullable = false, unique = true)
    private String assetId;

    @Column(name = "inspect_link")
    private String inspectLink;

    @Column(name = "current_owner_steamid")
    private String currentOwnerSteamId;

    @Column(nullable = false)
    private Boolean isTradeLocked = false;
}
