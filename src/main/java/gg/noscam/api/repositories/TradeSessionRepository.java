package gg.noscam.api.repositories;

import gg.noscam.api.models.tradeSession.TradeSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TradeSessionRepository extends JpaRepository<TradeSession, Long> {

    Optional<TradeSession> findByPublicId(String publicId);
}
