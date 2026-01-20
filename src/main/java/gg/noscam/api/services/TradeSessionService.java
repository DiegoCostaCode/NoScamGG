package gg.noscam.api.services;

import gg.noscam.api.dto.trades.TradeSessionRequestDTO;
import gg.noscam.api.dto.trades.TradeSessionResponseDTO;
import gg.noscam.api.mapper.TradeMapper;
import gg.noscam.api.models.tradeSession.TradeSession;
import gg.noscam.api.repositories.TradeSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeSessionService {

    @Autowired
    private final TradeSessionRepository tradeSessionRepository;

    @Autowired
    private final UserService userService;

    @Autowired
    private final TradeMapper tradeMapper;

    public TradeSessionResponseDTO createTradeSession(Long userId, TradeSessionRequestDTO request){

        /*
            To do:
                Implement a findUserById to find the authenticated user info and input in tradeSession
        */

        TradeSession tradeSession = tradeMapper.toEntity(request);

        return tradeMapper.toDTO(tradeSession);
    }
}
