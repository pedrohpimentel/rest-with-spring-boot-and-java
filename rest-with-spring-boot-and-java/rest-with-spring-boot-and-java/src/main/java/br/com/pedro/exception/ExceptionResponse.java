package br.com.pedro.exception;

import java.util.Date;

public record ExceptionResponse(Date timeStemp, String msg, String details) {
    //Criamos a classe Record para passarmos os parâmetros "base" para uma formatação JSON.
}
