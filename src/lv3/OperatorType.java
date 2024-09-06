package lv3;

public enum OperatorType {
    Add('+'),
    Substract('-'),
    Multiply('*'),
    Divide('/'),
    Remaind('%')
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
