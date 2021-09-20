package mx.inova_core.infrastructure.controller;

import lombok.AllArgsConstructor;
import mx.inova_core.app.dto.UserDTO;
import mx.inova_core.app.port.UserAppPort;
import mx.inova_core.infrastructure.controller.config.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserAppPort userAppPort;

    @GetMapping(path = "/byUsername/{userName}")
    public ApiResponse<UserDTO> getByUserNAme(@PathVariable String userName) {
        return new ApiResponse<>(this.userAppPort.getByUserName(userName), null);
    }
}
