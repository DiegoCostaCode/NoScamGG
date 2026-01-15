package gg.noscam.api.dto.user;

import gg.noscam.api.models.user.enums.EnumUserStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotBlank(message = "Steam ID was not passed")
        String steamId,
        @NotBlank(message = "Personaname was not passed")
        String steamPersonaName,
        String steamAvatar,
        String profileUrl,
        @NotNull(message = "Status was not passed")
        EnumUserStatus status
        ) { }
