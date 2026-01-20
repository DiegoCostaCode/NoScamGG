package gg.noscam.api.controller;

import gg.noscam.api.dto.trades.TradeSessionRequestDTO;
import gg.noscam.api.dto.trades.TradeSessionResponseDTO;
import gg.noscam.api.models.tradeSession.TradeSession;
import gg.noscam.api.services.TradeSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trades/")
public class TradesController {

    @Autowired
    private TradeSessionService tradeSessionService;

    @PostMapping("/trades")
    public ResponseEntity<TradeSessionResponseDTO> createTrade(
            @RequestBody TradeSessionRequestDTO request
    ) {

        /*
        To do:
            Implement @AuthenticationPrincipal in order to safely create a trade session for the authenticated user
        */

        TradeSessionResponseDTO tradeSessionDTO = tradeSessionService.createTradeSession(12356L, request);

        return new  ResponseEntity<>(tradeSessionDTO, HttpStatus.CREATED);
    }
}
