package gg.noscam.api.services;

import gg.noscam.api.dto.authLogin.AuthResponseDTO;
import gg.noscam.api.dto.user.UserResponseDTO;
import gg.noscam.api.mapper.UserMapper;
import gg.noscam.api.models.user.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private SteamService steamService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtService jwtService;

    public AuthResponseDTO authenticateWithSteam(HttpServletRequest request) {

        String claimedId = steamService.getOpenId(request);

        User user = userService.findOrCreateUser(claimedId);

        String token = jwtService.generateToken(user);

        UserResponseDTO userDTO = userMapper.toDTO(user);

        return new AuthResponseDTO(token, userDTO);
    }

}
