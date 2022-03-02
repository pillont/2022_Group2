package fr.tpillon.calculator_td2.models;

public class OperationModel {
    private final int first;
    private final int second;
    private final String operator;

    public OperationModel(int f,int s,String o) {
        this.first = f;
        this.second = s;
        this.operator = o;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public String getOperator() {
        return operator;
    }
}
