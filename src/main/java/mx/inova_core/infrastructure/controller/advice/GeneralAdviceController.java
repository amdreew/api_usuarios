package mx.inova_core.infrastructure.controller.advice;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import mx.inova_core.domain.exception.ParametroInvalidoException;
import mx.inova_core.domain.exception.RequiredValueException;
import mx.inova_core.infrastructure.controller.config.ApiResponse;
import mx.inova_core.infrastructure.controller.config.Notification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

// TODO - Añadir excepciones para poder controlar los mayores fallos posibles
// TODO - Por ejemplo DataNotFoundExcepcion
@ControllerAdvice
@Slf4j
public class
GeneralAdviceController extends ResponseEntityExceptionHandler {
    private static final List<ErrorDescriptor> ERROR_CATALOG = new ArrayList<>();

    static {

        ERROR_CATALOG.add(new ErrorDescriptor(RequiredValueException.class, HttpStatus.OK, HttpStatus.OK.toString()));
        ERROR_CATALOG.add(new ErrorDescriptor(ParametroInvalidoException.class, HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.toString()));

    }

    @ExceptionHandler({
            RequiredValueException.class,
            ParametroInvalidoException.class
    })
    public final ResponseEntity<ApiResponse> handleAllExceptions(Exception exception) {
        log.error(exception.getMessage(), exception);
        ErrorDescriptor errorDescriptor = findDescriptorByException(exception);
        Notification notification = new Notification(exception.getMessage(), errorDescriptor.getResponseCode());
        return ResponseEntity.status(errorDescriptor.getHttpStatus()).body(new ApiResponse<>(null, notification));
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ApiResponse> handleRuntimeNotificatios(RuntimeException exception) {
        log.error(exception.getMessage(), exception);
        ErrorDescriptor errorDescriptor = findDescriptorByException(exception);
        Notification notification = new Notification(exception.getMessage(), errorDescriptor.getResponseCode());
        return ResponseEntity.status(errorDescriptor.getHttpStatus()).body(new ApiResponse<>(null, notification));
    }

    @Getter
    private static class ErrorDescriptor {
        Class<? extends Throwable> exType;
        HttpStatus httpStatus;
        String responseCode;


        private ErrorDescriptor(Class<? extends Throwable> exType,
                                HttpStatus httpStatus,
                                String responseCode) {
            this.exType = exType;
            this.httpStatus = httpStatus;
            this.responseCode = responseCode;
        }
    }

    private ErrorDescriptor findDescriptorByException(Exception ex) {
        return ERROR_CATALOG.stream().filter(errorDescriptor -> errorDescriptor.getExType().equals(ex.getClass())).findFirst().orElse(
                new ErrorDescriptor(null, HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString())
        );
    }

}
