package gg.noscam.api.services;

import gg.noscam.api.models.user.UserStatus;
import gg.noscam.api.models.user.enums.EnumUserStatus;
import gg.noscam.api.repositories.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatusService {

    @Autowired
    private UserStatusRepository userStatusRepository;

    public UserStatus findByStatus(EnumUserStatus status) {
        return userStatusRepository.findByStatus(status)
                .orElseThrow(() -> new RuntimeException("Status não encontrado: " + status.toString()));
    }
}
