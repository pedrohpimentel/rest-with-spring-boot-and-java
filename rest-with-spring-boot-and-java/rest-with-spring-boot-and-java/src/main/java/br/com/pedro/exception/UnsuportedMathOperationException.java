package br.com.pedro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Iremos atribuir à exceção um status code específico, no caso dessa exceção será um bad request.
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuportedMathOperationException extends RuntimeException {
    public UnsuportedMathOperationException(String msg) {
        super(msg);
    }
}
