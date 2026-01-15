package gg.noscam.api.mapper;

import gg.noscam.api.dto.integration.steam.UserPublicInfoDTO;
import gg.noscam.api.dto.user.UserRequestDTO;
import gg.noscam.api.dto.user.UserResponseDTO;
import gg.noscam.api.interfaces.IRequestResponseMapper;
import gg.noscam.api.models.user.User;
import gg.noscam.api.models.user.UserStatus;
import gg.noscam.api.models.user.enums.EnumUserStatus;
import gg.noscam.api.services.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IRequestResponseMapper<User, UserRequestDTO, UserResponseDTO> {

    @Autowired
    private UserStatusService userStatusService;

    public UserRequestDTO toRequestDTO(UserPublicInfoDTO.SteamPlayer player, EnumUserStatus status) {
        return new UserRequestDTO(
                player.steamid(),
                player.personaname(),
                player.avatarfull(),
                player.profileurl(),
                status
        );

    }

    @Override
    public User toEntity(UserRequestDTO dto) {
        User user = new User();
        user.setSteamId(dto.steamId());
        user.setNickname(dto.steamPersonaName());
        user.setAvatarBaseUrl(dto.steamAvatar());
        user.setProfileUrl(dto.profileUrl());

        UserStatus status = userStatusService.findByStatus(dto.status());
        user.setStatus(status);
        return user;
    }

    @Override
    public UserResponseDTO toDTO(User entity) {
        return new UserResponseDTO(
                entity.getId(),
                entity.getSteamId(),
                entity.getAvatarBaseUrl(),
                entity.getProfileUrl(),
                entity.getTradeurl(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getStatus().getStatus().toString(),
                entity.getCreatedAt()
        );
    }
}
