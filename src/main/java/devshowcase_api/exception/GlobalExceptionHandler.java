package devshowcase_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {

        Map<String, Object> erro = new HashMap<>();
        erro.put("status", 404);
        erro.put("error", "Not Found");
        erro.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
    Map<String, Object> erro = new HashMap<>();

    erro.put("status", 400);
    erro.put("error", "Bad Request");
    erro.put("message",
        ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
}

}