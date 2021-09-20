package mx.inova_core.infrastructure.controller.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Notification {
    private String description;
    private String responseTime;
    private String code;

    public Notification(String decription, String code) {
        this.description = decription;
        this.code = code;
        this.responseTime = LocalDateTime.now().toString();
    }
}
