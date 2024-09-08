package lv3;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();
        String flag = "";

        while(!Objects.equals(flag, "exit")) {
            System.out.print("첫 번째 수를 입력하세요: ");
            Double n1 = sc.nextDouble();
            System.out.print("두 번째 수를 입력하세요: ");
            Double n2 = sc.nextDouble();
            System.out.print("연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            sc.nextLine();

            arithmeticCalculator.setOperatorType(operator);
            arithmeticCalculator.calculate(n1, n2);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.println("scan 입력 시 연산 결과를 스캔합니다.");
            System.out.println("delete 입력 시 가장 먼저 연산한 결과가 삭제됩니다.");
            flag = sc.nextLine();
            if(flag.equals("scan")) {
                System.out.print("출력 기준이 될 수를 입력하세요: ");
                arithmeticCalculator.display(sc.nextDouble());
            }
            if(flag.equals("delete")) {
                arithmeticCalculator.removeResult();
            }
        }
    }
}
