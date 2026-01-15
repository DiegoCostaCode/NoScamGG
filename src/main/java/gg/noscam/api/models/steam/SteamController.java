package gg.noscam.api.models.steam;

import gg.noscam.api.services.SteamService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/steam/")
public class SteamController {

    @Autowired
    private SteamService verifier;

    private static String extractSteamId(String claimedId) {

        if (claimedId == null || claimedId.isEmpty()) {
            return null;
        }

        String[] parts = claimedId.split("/");
        return parts.length > 0 ? parts[parts.length - 1] : null;
    }

    @GetMapping("/auth/")
    public void redirectToSteam(HttpServletResponse response) throws IOException {
        String steamLoginUrl =
                "https://steamcommunity.com/openid/login" +
                        "?openid.ns=http://specs.openid.net/auth/2.0" +
                        "&openid.mode=checkid_setup" +
                        "&openid.return_to=https://yourdomain.com/auth/steam/callback" +
                        "&openid.realm=https://yourdomain.com" +
                        "&openid.identity=http://specs.openid.net/auth/2.0/identifier_select" +
                        "&openid.claimed_id=http://specs.openid.net/auth/2.0/identifier_select";

        response.sendRedirect(steamLoginUrl);
    }

//    @PostMapping("/auth/steam/callback")
//    public ResponseEntity<?> handleSteamCallback(@RequestParam Map<String, String> params) {
//
//        if (!verifier.verify(params)) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//
//        String steamId = extractSteamId(params.get("openid.claimed_id"));
//
//        userService.loginWithSteam(steamId);
//
//        return ResponseEntity.ok().build();
//    }





}
