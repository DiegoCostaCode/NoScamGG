package gg.noscam.api.mapper;

import gg.noscam.api.dto.steam.UserPublicInfoDTO;
import gg.noscam.api.dto.user.UserRequestDTO;
import gg.noscam.api.dto.user.UserResponseDTO;
import gg.noscam.api.models.user.User;
import gg.noscam.api.models.user.UserStatus;
import gg.noscam.api.models.user.enums.EnumUserStatus;
import gg.noscam.api.services.UserStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

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

    public UserResponseDTO toDTO(User user) {

        return new UserResponseDTO(
                user.getId(),
                user.getSteamId(),
                user.getAvatarBaseUrl(),
                user.getProfileUrl(),
                user.getTradeurl(),
                user.getEmail(),
                user.getCpf(),
                user.getStatus().getStatus().toString(),
                user.getCreatedAt()
        );
    }


//    public void updateEntity(User user, UserRequestDTO dto) {
//        user.setPersonaName(dto.getPersonaName());
//        user.setAvatarUrl(dto.getAvatarUrl());
//        user.setProfileUrl(dto.getProfileUrl());
//        user.setStatus(dto.getStatus());
//    }
}
