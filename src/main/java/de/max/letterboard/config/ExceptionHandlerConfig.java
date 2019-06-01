package de.max.letterboard.config;

import de.max.letterboard.exception.InvalidMottoException;
import de.max.letterboard.exception.NoMottoProvidedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {
            NoMottoProvidedException.class,
            InvalidMottoException.class})
    public ResponseEntity<ApiError> handle(NoMottoProvidedException e) {
        ApiError apiError = ApiError.builder()
                .exception(e.getClass().getSimpleName())
                .message(e.getMessage()).build();
        return ResponseEntity.badRequest().body(apiError);
    }
}
