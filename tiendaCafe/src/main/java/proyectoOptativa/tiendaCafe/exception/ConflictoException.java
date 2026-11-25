package proyectoOptativa.tiendaCafe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ConflictoException extends ResponseStatusException {
    public ConflictoException(String message) {
        super(HttpStatus.CONFLICT, message); // 409
    }
}
