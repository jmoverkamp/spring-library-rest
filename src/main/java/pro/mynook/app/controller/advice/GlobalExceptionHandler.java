package pro.mynook.app.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.mynook.app.pojo.RequestError;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jaxichael on 2/17/2017.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    RequestError handleBadRequest(HttpServletRequest req, Exception e) {
        return new RequestError(req.getRequestURI(), e);
    }
}
