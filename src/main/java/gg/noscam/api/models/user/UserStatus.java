package gg.noscam.api.models.user;

import gg.noscam.api.models.BaseEntity;
import gg.noscam.api.models.user.enums.EnumUserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "users_status")
@Getter
@Setter
public class UserStatus extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private EnumUserStatus status;

}
