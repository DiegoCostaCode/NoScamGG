package gg.noscam.api.dto.authLogin;

import gg.noscam.api.dto.user.UserResponseDTO;

public record AuthResponseDTO(
        String token,
        UserResponseDTO user
) {
}
