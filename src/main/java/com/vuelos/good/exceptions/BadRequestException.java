package com.vuelos.good.exceptions;
import org.springframework.dao.DataAccessException;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String s) {
    }
    public BadRequestException(String s, DataAccessException e) {
    }
}
