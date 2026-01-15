package gg.noscam.api.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record UserResponseDTO(
        Long userId,
        String steamId,
        String avatarUrl,
        String profileUrl,
        String tradeUrl,
        String email,
        String cpf,
        String status,
        @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "UTC")
        Instant createdAt
) {

}
