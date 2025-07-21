package tech.challenge.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandlerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultErrorMessage> handlerNotFoundException(NotFoundException e) {
        var error = new DefaultErrorMessage(HttpStatus.NOT_FOUND.value(), e.getReason());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

//    @ExceptionHandler(SQLException.class)
//    public ResponseEntity<DefaultErrorMessage> handlerEmailAlreadyExistsException(SQLException e) {
//        var error = new DefaultErrorMessage(HttpStatus.BAD_REQUEST.value(), "Duplicated entry for one or more unique fields");
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//    }
}
