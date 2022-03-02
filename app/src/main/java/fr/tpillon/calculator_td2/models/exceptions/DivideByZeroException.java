package fr.tpillon.calculator_td2.models.exceptions;

public class DivideByZeroException extends Exception {
    public DivideByZeroException(String message){
        super(message);
    }
    public DivideByZeroException(String message, Throwable innerException){
        super(message, innerException);
    }
}
