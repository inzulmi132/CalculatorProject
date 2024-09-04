package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Calculator {

    private Queue<Double> result_queue = new LinkedList<Double>();

    public double calculate(int n1, int n2, char operator) {
        double result = n1;
        switch (operator) {
            case '+': result += n2; break;
            case '-': result -= n2; break;
            case '*': result *= n2; break;
            case '/': result /= n2; break;
            case '%': result %= n2; break;
            default:
                System.out.println("정상적인 연산자가 아닙니다.");
        }
        result_queue.add(result);

        return result;
    }

    public void setResult_queue(double n1) {
        result_queue.add(n1);
    }
    public double getResult_queue() {
        if(result_queue.isEmpty())
        {
            System.out.println("queue is empty");
            return 0;
        }
        return result_queue.peek();
    }
    public void removeResult() {
        result_queue.poll();
    }
}