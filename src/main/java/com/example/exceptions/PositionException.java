package com.example.exceptions;

public class PositionException extends Exception{

    public PositionException(){

    }

    public PositionException(String mensaje){super(mensaje);}

    public PositionException(String mensaje, Throwable cause){super(mensaje, cause);}

    public PositionException(Throwable cuase){super(cuase);}
}
