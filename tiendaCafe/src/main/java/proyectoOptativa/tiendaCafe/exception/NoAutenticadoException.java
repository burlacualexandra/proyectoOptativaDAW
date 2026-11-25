package proyectoOptativa.tiendaCafe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoAutenticadoException extends ResponseStatusException {
    public NoAutenticadoException(String message) {
        super(HttpStatus.UNAUTHORIZED, message); //401
    }
}
