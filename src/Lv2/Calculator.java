package Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private final Queue<Double> result_queue = new LinkedList<>();

    public double calculate(int n1, int n2, char operator) {
        double result = n1;
        switch (operator) {
            case '+': result += n2; break;
            case '-': result -= n2; break;
            case '*': result *= n2; break;
            // 0으로 나누는 경우는 이미 main 메서드에서 예외처리를 했기에 그냥 진행
            case '/': result /= n2; break;
            case '%': result %= n2; break;
        }
        // 연산 결과를 컬렉션에 저장
        result_queue.add(result);

        return result;
    }

    public void setResult_queue(double n) {
        result_queue.add(n);
    }
    public double getResult_queue() {
        if(result_queue.isEmpty())
        {
            System.out.println("저장된 연산 결과가 없습니다.");
            return 0;
        }
        return result_queue.peek();
    }
    public void removeResult() {
        // 컬렉션이 비었을 때 삭제를 시도하면 에러 문구 출력
        if(result_queue.isEmpty()) {
            System.out.println("저장된 연산 결과가 없습니다.");
            return;
        }
        // 컬렉션의 가장 앞에 있는 값을 삭제하고 삭제된 값 출력
        System.out.println(result_queue.poll() + " 삭제 되었습니다.");
    }
}