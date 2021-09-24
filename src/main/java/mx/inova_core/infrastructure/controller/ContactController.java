package mx.inova_core.infrastructure.controller;

import lombok.AllArgsConstructor;
import mx.inova_core.app.dto.ContactDTO;
import mx.inova_core.app.port.ContactAppPort;
import mx.inova_core.infrastructure.controller.config.ApiResponse;
import mx.inova_core.infrastructure.controller.filter.IValidatorGenericParams;
import mx.inova_core.infrastructure.controller.filter.ValidatorGenericParams;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
@AllArgsConstructor
@CrossOrigin("*")
public class ContactController {


    private final ContactAppPort port;
    private final IValidatorGenericParams iValidatorGenericParams;

    @GetMapping(path = "/{id}")
    public ApiResponse<ContactDTO> getById(@PathVariable Long id) {
        return new ApiResponse<>(this.port.getById(id), null);
    }

    @GetMapping
    public ApiResponse<List<ContactDTO>> getAll() {
        return new ApiResponse<>(this.port.getAll(), null);
    }

    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody ContactDTO contactDTO, BindingResult result) {
        ResponseEntity<?> responseValidator = this.iValidatorGenericParams.validateParams(result);
        return responseValidator == null? new ResponseEntity<>(this.port.save(contactDTO), HttpStatus.CREATED)
                : responseValidator;
    }

    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody ContactDTO contactDTO, BindingResult result) {
        ResponseEntity<?> responseValidator = this.iValidatorGenericParams.validateParams(result);
        return responseValidator == null? new ResponseEntity<>(this.port.update(contactDTO), HttpStatus.CREATED)
                : responseValidator;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteByID(@PathVariable Long id) {
      this.port.deleteById(id);
    }

}
