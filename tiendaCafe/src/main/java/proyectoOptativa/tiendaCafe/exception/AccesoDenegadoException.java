package proyectoOptativa.tiendaCafe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AccesoDenegadoException extends ResponseStatusException {
    public AccesoDenegadoException(String message) {
        super(HttpStatus.FORBIDDEN, message); // 403
    }
}
