package gg.noscam.api.models.tradeSession;

import gg.noscam.api.models.BaseEntity;
import gg.noscam.api.models.itemCustody.ItemCustody;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "trade_item")
public class TradeItem extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trade_session_id", nullable = false)
    private TradeSession tradeSession;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_custody_id", nullable = false)
    private ItemCustody itemCustody;

    @Column(nullable = false)
    private BigDecimal price;
}
