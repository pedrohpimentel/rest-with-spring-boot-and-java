package br.com.pedro.exception;

//Iremos atribuir à exceção um status code específico, no caso dessa exceção será um bad request.
public class UnsuportedMathOperationException extends RuntimeException {
    public UnsuportedMathOperationException(String msg) {
        super(msg);
    }
}
