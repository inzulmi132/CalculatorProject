package lv3;

public class ArithmeticCalculator<T extends Number> {
    OperatorType operatorType;

    public void calculator(T n1, T n2) {
        double d1 = n1.doubleValue();
        double d2 = n2.doubleValue();
        this.operatorType.calculation(d1, d2);
    }

    public void setOperatorType(char type) {
        for(OperatorType op : OperatorType.values()) {
            if(op.getoperator() == type) {
                this.operatorType = op;
                return;
            }
        }
    }
    public char getOperatorType() {
        return operatorType.getoperator();
    }
}