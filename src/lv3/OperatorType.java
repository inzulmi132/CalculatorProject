package lv3;

import java.util.function.BiFunction;

public enum OperatorType {
    Add('+'),
    Substract('-'),
    Multiply('*'),
    Divide('/'),
    Remaind('%'),
    ;
    private char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public void setoperator(char operator) {
        this.operator = operator;
    }
    public char getoperator() {
        return operator;
    }
}
