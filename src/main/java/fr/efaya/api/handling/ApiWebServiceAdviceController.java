package fr.efaya.api.handling;

import fr.efaya.repository.service.CommonObjectNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * Created by sktifa on 27/11/2016.
 */
@ControllerAdvice
public class ApiWebServiceAdviceController {

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(CommonObjectNotFound.class)
    public ErrorMessage handleNotFound() {
        return new ErrorMessage("Entity not found", new Date());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)  // 404
    @ExceptionHandler(AccessDeniedException.class)
    public ErrorMessage handleAccessDenied() {
        return new ErrorMessage("You are not allowed to execute this request", new Date());
    }
}