package lv3;

import java.util.Objects;

public class ArithmeticCalculator<T> {
    OperatorType operatorType;

    public void setOperatorType(char type) {
        this.operatorType.setType(type);
    }
    public char getOperatorType() {
        return operatorType.getType();
    }

}