package com.projeto.projetoapi.services.exceptions;

public class EntityAlreadyExistException extends RuntimeException {

    public EntityAlreadyExistException(String msg){
        super(msg);
    }
}
