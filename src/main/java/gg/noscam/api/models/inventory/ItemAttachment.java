package gg.noscam.api.models.inventory;

import gg.noscam.api.models.inventory.enums.ItemAttachementEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemAttachment {

    private String id;
    private String name;
    private String rarity;
    private ItemAttachementEnum type;
    private Integer slot;
    private Float wear;

}
