package gg.noscam.api.controller;

import gg.noscam.api.dto.authLogin.AuthResponseDTO;
import gg.noscam.api.services.AuthService;
import gg.noscam.api.services.SteamService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth/steam")
@RequiredArgsConstructor
public class SteamAuthController {

    @Autowired
    private final SteamService steam;

    @Autowired
    private final AuthService authService;

    @GetMapping("/")
    public String redirectToSteam() {
        return steam.buildURL();
    }

    @GetMapping("/callback")
    public ResponseEntity<AuthResponseDTO> handleSteamCallback(HttpServletRequest request) {
        return ResponseEntity.ok(authService.authenticateWithSteam(request));
    }

}