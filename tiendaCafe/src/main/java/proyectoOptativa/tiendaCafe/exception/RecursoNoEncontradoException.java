package proyectoOptativa.tiendaCafe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RecursoNoEncontradoException extends ResponseStatusException {
    public RecursoNoEncontradoException(String message) {
        super(HttpStatus.NOT_FOUND, message); // 404
    }
}
