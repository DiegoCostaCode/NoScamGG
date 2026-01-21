package gg.noscam.api.services;

import gg.noscam.api.dto.integration.steam.UserPublicInfoDTO;
import gg.noscam.api.dto.user.UserRequestDTO;
import gg.noscam.api.mapper.UserMapper;
import gg.noscam.api.models.user.User;
import gg.noscam.api.models.user.enums.EnumUserStatus;
import gg.noscam.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SteamService steamService;


    public User saveUser(UserRequestDTO userRequestDTO) {

        User user = userMapper.toEntity(userRequestDTO);

        return userRepository.save(user);
    }

    public User findOrCreateUser(String openId){

        Optional<User> user = userRepository.findBySteamId(openId);

        if (user.isPresent()){
            return user.get();
        }

        UserPublicInfoDTO.SteamPlayer player = steamService.findPublicInfosFromOpenId(openId)
                .response()
                .players()
                .getFirst();

        UserRequestDTO userReqDTO = userMapper.toRequestDTO(player, EnumUserStatus.RESTRICTED);

        return saveUser(userReqDTO);
    }
}
