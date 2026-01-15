package gg.noscam.api.dto.steam;

import java.util.List;

public record UserPublicInfoDTO(SteamResponse response) {

    public record SteamResponse(List<SteamPlayer> players) {
    }

    public record SteamPlayer(
            String steamid,
            int communityvisibilitystate,
            int profilestate,
            String personaname,
            Integer commentpermission,
            String profileurl,
            String avatar,
            String avatarmedium,
            String avatarfull,
            String avatarhash,
            Long lastlogoff,
            int personastate,
            String realname,
            String primaryclanid,
            Long timecreated,
            Integer personastateflags,
            String loccountrycode
    ) {
    }
}
