package com.vuelos.good.exceptions;
import org.springframework.dao.DataAccessException;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String s) {
        super(s);//  Aquí se guarda el mensaje correctamente
    }
    public BadRequestException(String s, DataAccessException e) {
        super(s,e);//  Aquí se guarda el mensaje correctamente
    }
}
