package gg.noscam.api.mapper;

import gg.noscam.api.dto.trades.CreateTradeItemRequestDTO;
import gg.noscam.api.dto.trades.TradeSessionRequestDTO;
import gg.noscam.api.dto.trades.TradeSessionResponseDTO;
import gg.noscam.api.interfaces.IRequestResponseMapper;
import gg.noscam.api.models.tradeSession.TradeItem;
import gg.noscam.api.models.tradeSession.TradeSession;
import gg.noscam.api.models.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TradeMapper implements IRequestResponseMapper<TradeSession, TradeSessionRequestDTO, TradeSessionResponseDTO> {

    @Override
    public TradeSession toEntity(TradeSessionRequestDTO dto) {

        TradeSession tradeSession = new TradeSession();

        List<TradeItem> tradeItems = dto.items().stream().map(this::toTradeItem).toList();
        tradeSession.setItems(tradeItems);

        return tradeSession;
    }

    @Override
    public TradeSessionResponseDTO toDTO(TradeSession entity) {
        return null;
    }

    private TradeItem toTradeItem(CreateTradeItemRequestDTO itemDto) {
        TradeItem item = new TradeItem();
        item.setPrice(itemDto.price());
        return item;
    }
}
