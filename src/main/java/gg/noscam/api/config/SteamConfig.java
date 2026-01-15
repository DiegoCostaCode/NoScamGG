package gg.noscam.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "steam")
public class SteamConfig {
    private String apiUrl;
    private String url;
    private String returnUrl;
    private String token;
}
