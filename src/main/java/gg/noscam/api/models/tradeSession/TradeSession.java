package gg.noscam.api.models.tradeSession;

import gg.noscam.api.models.BaseEntity;
import gg.noscam.api.models.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "trade_sessions")
public class TradeSession extends BaseEntity {

    @Column(name = "public_id", nullable = false, unique = true, length = 36)
    private String publicId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @OneToMany(
            mappedBy = "tradeSession",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TradeItem> items = new ArrayList<>();

    @PrePersist
    private void prePersist() {
        this.publicId = UUID.randomUUID().toString();
    }

}
