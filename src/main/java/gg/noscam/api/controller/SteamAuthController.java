package gg.noscam.api.controller;

import gg.noscam.api.dto.integration.steam.UserPublicInfoDTO;
import gg.noscam.api.dto.user.UserResponseDTO;
import gg.noscam.api.services.SteamService;
import gg.noscam.api.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private final UserService userService;

    @GetMapping("/")
    public String redirectToSteam() {
        return steam.buildURL();
    }

    @GetMapping("/callback")
    public ResponseEntity<UserResponseDTO> handleSteamCallback(HttpServletRequest request) {

        String claimedId = steam.getOpenId(request);

        UserPublicInfoDTO steamInfosDTO = steam.findPublicInfosFromOpenId(claimedId);

        UserResponseDTO userResDTO = userService.createUser(steamInfosDTO);

        return new ResponseEntity<>(userResDTO,  HttpStatus.CREATED);

    }


}