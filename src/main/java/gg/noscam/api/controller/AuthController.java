package gg.noscam.api.controller;

import gg.noscam.api.dto.authLogin.AuthRequestDTO;
import gg.noscam.api.models.user.User;
import gg.noscam.api.services.JwtService;
import gg.noscam.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/dev-login")
    public ResponseEntity<?> devLogin(@RequestBody AuthRequestDTO request) {

        User user = userService.findOrCreateBySteamId(request.steamId());
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(Map.of("token", token));
    }
}
