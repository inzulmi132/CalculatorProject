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
        if(result_queue.isEmpty()) {
            System.out.println("queue is empty");
            return;
        }
        System.out.println(result_queue.poll() + " 삭제");
    }
}