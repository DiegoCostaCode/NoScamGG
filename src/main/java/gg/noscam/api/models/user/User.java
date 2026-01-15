package gg.noscam.api.models.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="steam_id", nullable = false, unique = true)
    private String steamId;

    @Column(name="name")
    private String name;

    @Column(name="nickname")
    private String nickname;

    @Column(name="avatar_base_url")
    private String avatarBaseUrl;

    @Column(name="profile_url", unique = true, nullable = false)
    private String profileUrl;

    @Column(name="trade_url", unique = true)
    private String tradeurl;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="cpf", unique = true)
    private String cpf;

    @OneToOne
    @JoinColumn(name= "status", referencedColumnName = "status", nullable = false)
    private UserStatus status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();


}
