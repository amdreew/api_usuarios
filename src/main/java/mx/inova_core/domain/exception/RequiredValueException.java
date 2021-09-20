package mx.inova_core.domain.exception;

public class RequiredValueException extends RuntimeException {

    public RequiredValueException(String msj) {
        super(msj);
    }
}
