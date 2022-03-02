package fr.tpillon.calculator_td2.models.exceptions;

public class OperatorException extends Exception {
    public OperatorException(String message){
        super(message);
    }
    public OperatorException(String message, Throwable innerException){
        super(message, innerException);
    }
}
