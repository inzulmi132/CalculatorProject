package lv3;

enum OperatorType {
    Plus('+'),
    Minus('-'),
    Multiply('*'),
    Divide('/'),
    Mod('%')
    ;
    private char type;

    OperatorType(char type) {
        this.type = type;
    }
    public void setType(char type) {
        this.type = type;
    }
    public char getType() {
        return type;
    }
}

public class ArithmeticCalculator {
}
