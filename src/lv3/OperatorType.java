package lv3;

import java.util.function.BiFunction;

public enum OperatorType {
    Add('+', (n1, n2) -> n1 + n2),
    Substract('-', (n1, n2) -> n1-n2),
    Multiply('*', (n1, n2) -> n1*n2),
    Divide('/', (n1, n2) -> n1/n2),
    Remaind('%', (n1, n2) -> n1-n2),
    ;
    private char operator;
    private BiFunction<Double, Double, Double> calculate;

    OperatorType(char operator) {
        this.operator = operator;
        this.calculate = (n1, n2) -> n1*n2;
    }

    OperatorType(char operator, BiFunction<Double, Double, Double> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public void calculation(double d1, double d2) {
        if((this.operator == '/' || this.operator == '%') && d2 == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return;
        }
        double result = calculate.apply(d1, d2);
        System.out.println("연산 결과: " +result);
    }
    public void setoperator(char operator) {
        this.operator = operator;
    }
    public char getoperator() {
        return operator;
    }
}
