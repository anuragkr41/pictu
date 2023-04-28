package com.pictu.core.exceptions;

import org.aspectj.bridge.IMessage;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }

    public ApiException(){
        super();
    }
}
