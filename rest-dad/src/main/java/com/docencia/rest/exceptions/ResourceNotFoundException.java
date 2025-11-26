package com.docencia.rest.exceptions;

import jdk.jfr.internal.Throttle;

public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }

    public ResourceNotFoundException(String mensaje, Throttle myException) {
        super(mensaje, myException);
    }
    
}
