package lv3;

import java.util.LinkedList;
import java.util.Queue;

import static lv3.OperatorType.*;

public class ArithmeticCalculator<T extends Number> {
    OperatorType operatorType;
    Queue<T> result_queue = new LinkedList<>();

    public void calculate(T n1, T n2) {
        // 정상적이지 않은 연산자인 경우 예외 처리
        if(operatorType == null) {
            System.out.println("정상적인 연산자가 아닙니다.");
            return;
        }

        // 0으로 나누는 경우 예외 처리
        if((this.operatorType == Divide || this.operatorType == Remaind) && n2.doubleValue() == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return;
        }

        double result = n1.doubleValue();
        switch (this.operatorType) {
            case Add:       result += n2.doubleValue(); break;
            case Substract: result -= n2.doubleValue(); break;
            case Multiply:  result *= n2.doubleValue(); break;
            case Divide:    result /= n2.doubleValue(); break;
            case Remaind:   result %= n2.doubleValue(); break;
        }
        System.out.println("연산 결과: " + result);

        // 연산 결과를 다시 제네릭으로 바꿔서 컬렉션에 저장
        result_queue.add((T)(Double)result);
    }

    public void display(T n) {
        // 컬렉션이 비었을 경우 예외 처리
        if(result_queue.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
            return;
        }

        // 스트림을 이용하여 컬렉션에서 입력받은 값보다 값들만 출력
        result_queue.stream()
                .filter(t -> t.doubleValue() > n.doubleValue())
                .forEach(t -> System.out.print(t + " "));
        System.out.println();
    }

    public void removeResult() {
        // 컬렉션이 비었을 경우 예외 처리
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
        // enum에 없는 연산자를 입력한 경우 null로 초기화
        this.operatorType = null;
    }
    public char getOperatorType() {
        return operatorType.getoperator();
    }
}