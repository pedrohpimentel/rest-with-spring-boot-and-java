package br.com.pedro.exception.handler;

//Está classe irá interceptar as exceções e vai substituir pelo JSON que o ExceptionResponse gerar,
//Servindo igualmente para o Status Code que UnsuportedMathOperationException gerar.


import br.com.pedro.exception.ExceptionResponse;
import br.com.pedro.exception.UnsuportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice //Iremos usar para um tratamento que seria espalhado em todos os controllers,
// se algum controller der alguma exceção e não tiver o tratamento adequado irá cair no tratamento global que é o Advice.
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)//Irá tratar todos os erros/exceções genéricas do servidor
    public final ResponseEntity<ExceptionResponse> handleAllExcpetions(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsuportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequeestExcpetions(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
