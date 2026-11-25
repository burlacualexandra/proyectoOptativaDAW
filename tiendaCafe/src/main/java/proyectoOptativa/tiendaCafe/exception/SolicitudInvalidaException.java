package proyectoOptativa.tiendaCafe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SolicitudInvalidaException extends ResponseStatusException {
    public SolicitudInvalidaException(String message) {
        super(HttpStatus.BAD_REQUEST, message); // 400
    }
}
