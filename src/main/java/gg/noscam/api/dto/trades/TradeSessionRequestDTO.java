package gg.noscam.api.dto.trades;

import java.util.List;

public record TradeSessionRequestDTO(
    List<CreateTradeItemRequestDTO> items
) {
}
