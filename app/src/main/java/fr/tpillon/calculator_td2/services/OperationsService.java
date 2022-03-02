package fr.tpillon.calculator_td2.services;

import androidx.annotation.NonNull;

import fr.tpillon.calculator_td2.models.OperationModel;
import fr.tpillon.calculator_td2.models.exceptions.DivideByZeroException;
import fr.tpillon.calculator_td2.models.exceptions.OperatorException;

public class OperationsService {
    public double compute(@NonNull OperationModel operation)
        throws DivideByZeroException, OperatorException {

        if(operation == null){
            throw new NullPointerException("operation can not be null");
        }

        int first = operation.getFirst();
        int second =  operation.getSecond();
        String operator = operation.getOperator();

        double result;
        switch (operator) {
            case "+":
                result = first+second;
                break;
            case "-":
                result = first-second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                try {
                    result = first / second;
                } catch( ArithmeticException ex) {
                    throw new DivideByZeroException("can not divide by zero", ex);
                }
                break;
            default:
                throw new OperatorException("operator invalid");
        }

        return result;
    }
}
