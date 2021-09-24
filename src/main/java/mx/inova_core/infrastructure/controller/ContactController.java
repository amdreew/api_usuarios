package mx.inova_core.infrastructure.controller;

import lombok.AllArgsConstructor;
import mx.inova_core.app.dto.ContactDTO;
import mx.inova_core.app.port.ContactAppPort;
import mx.inova_core.infrastructure.controller.config.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@AllArgsConstructor
@CrossOrigin("*")
public class ContactController {


    private final ContactAppPort port;

    @GetMapping(path = "/{id}")
    public ApiResponse<ContactDTO> getById(@PathVariable Long id) {
        return new ApiResponse<>(this.port.getById(id), null);
    }

    @GetMapping
    public ApiResponse<List<ContactDTO>> getAll() {
        return new ApiResponse<>(this.port.getAll(), null);
    }

}
