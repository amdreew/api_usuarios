package mx.inova_core.infrastructure.controller.filter;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface IValidatorGenericParams {
    ResponseEntity<?> validateParams(BindingResult result);
}
