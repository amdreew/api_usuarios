package mx.inova_core.infrastructure.controller.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(value = "parameter.security")
public class SecurityProperties {

    private boolean enable;
}

