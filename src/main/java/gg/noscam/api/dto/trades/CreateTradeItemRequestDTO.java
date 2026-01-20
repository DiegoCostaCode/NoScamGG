package gg.noscam.api.dto.trades;

import java.math.BigDecimal;

public record CreateTradeItemRequestDTO(
        String assetId,
        BigDecimal price
) {
}
