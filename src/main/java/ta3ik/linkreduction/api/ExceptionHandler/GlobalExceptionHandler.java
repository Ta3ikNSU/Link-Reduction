package ta3ik.linkreduction.api.ExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ta3ik.linkreduction.model.exception.LinkNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<Object> handleLinkNotFoundException(LinkNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleLinkNotFoundException(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Something went wrong, try again later.", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
