package gg.noscam.api.init;

import gg.noscam.api.models.user.UserStatus;
import gg.noscam.api.models.user.enums.EnumUserStatus;
import gg.noscam.api.repositories.UserStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class UserStatusInitializer implements ApplicationRunner {

    @Autowired
    private UserStatusRepository userStatusRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (EnumUserStatus role : EnumUserStatus.values()) {

            if(userStatusRepository.findByStatus(role).isEmpty()){
                UserStatus userStatus = new UserStatus();
                userStatus.setStatus(role);
                userStatusRepository.save(userStatus);
            }

        }
    }
}
