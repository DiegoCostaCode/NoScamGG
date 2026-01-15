package gg.noscam.api.repositories;

import gg.noscam.api.models.user.UserStatus;
import gg.noscam.api.models.user.enums.EnumUserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {

    Optional<UserStatus> findByStatus(EnumUserStatus status);
    
}
