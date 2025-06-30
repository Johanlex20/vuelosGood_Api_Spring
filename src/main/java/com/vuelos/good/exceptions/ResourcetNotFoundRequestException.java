package com.vuelos.good.exceptions;

public class ResourcetNotFoundRequestException extends RuntimeException{
    public ResourcetNotFoundRequestException(String s) {
        super(s);//  Aquí se guarda el mensaje correctamente
    }
}
