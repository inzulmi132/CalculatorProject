package lv3;

import java.util.LinkedList;
import java.util.Queue;

import static lv3.OperatorType.*;

public class ArithmeticCalculator<T extends Number> {
    OperatorType operatorType;
    Queue<T> result_queue = new LinkedList<T>();

    public void calculate(T n1, T n2) {
        if((this.operatorType == Divide || this.operatorType == Remaind) && n2.doubleValue() == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return;
        }

        double result = n1.doubleValue();
        switch (operatorType) {
            case Add:       result += n2.doubleValue(); break;
            case Substract: result -= n2.doubleValue(); break;
            case Multiply:  result *= n2.doubleValue(); break;
            case Divide:    result /= n2.doubleValue(); break;
            case Remaind:   result %= n2.doubleValue(); break;
        }
        System.out.println("연산 결과: " +result);

        Double Result = result;
        result_queue.add((T)(Double)result);
    }

    public void display(T n) {
        if(result_queue.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
            return;
        }

        double d = n.doubleValue();
        result_queue.stream()
                .filter(t -> t.doubleValue() > d)
                .forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public void removeResult() {
        if(result_queue.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
            return;
        }
        System.out.println(result_queue.poll() + " 삭제 되었습니다.");
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