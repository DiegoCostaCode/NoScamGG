package gg.noscam.api.models.inventory;

import gg.noscam.api.models.inventory.enums.ExteriorEnum;
import gg.noscam.api.models.inventory.enums.RarityEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "item_details")
@Getter
@Setter
public class ItemDetails {

    @Id
    private String id;

    @Indexed
    private String assetId;

    private Float floatvalue;

    private String wear;

    private String pattern;

    private String paintseed;

    private Boolean startTrak;

    private RarityEnum rarity;

    private ExteriorEnum exterior;

    private List<ItemAttachment> attachments;

    private Instant updatedAt;
}
