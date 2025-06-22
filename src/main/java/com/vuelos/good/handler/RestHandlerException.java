package com.vuelos.good.handler;
import com.vuelos.good.exceptions.BadRequestException;
import com.vuelos.good.exceptions.ResourcetNotFoundRequestException;
import com.vuelos.good.services.iService.sistema.iMensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class RestHandlerException {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    iMensajeService mensajeService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlerValidationException(MethodArgumentNotValidException methodArgumentNotValidException){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle(mensajeService.getMensaje("error.handler.MethodArgumentNotValid","BASICO"));
        problemDetail.setType(URI.create("http://good-company.com/unprocessable-entity"));
        problemDetail.setDetail(mensajeService.getMensaje("error.handler.MethodArgumentNotValid.detail","BASICO"));

        Set<String> errors = new HashSet<>();
        List<FieldError> fieldErrors = methodArgumentNotValidException.getFieldErrors();

        for(FieldError fe: fieldErrors){
            String codigo = fe.getDefaultMessage();
            String mensaje = mensajeService.getMensaje(codigo);
            errors.add(mensaje);
        }
        problemDetail.setProperty("errors", errors);
        return problemDetail;
    }

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail badRequestException(BadRequestException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setTitle(mensajeService.getMensaje("error.handler.badRequestException","BASICO"));
        problemDetail.setType(URI.create("http://good-company.com/badRequest"));
        return problemDetail;
    }

    @ExceptionHandler(ResourcetNotFoundRequestException.class)
    public ProblemDetail handlerResourceNotFound(ResourcetNotFoundRequestException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle(mensajeService.getMensaje("error.handler.notFoundException","BASICO"));
        problemDetail.setType(URI.create("http://good-company.com/NotFound"));
        return problemDetail;
    }

}
