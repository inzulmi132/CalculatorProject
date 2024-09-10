package Lv3;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 제네릭 클래스인 arithmeticcalculator를 Double로 선언
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();
        String flag = "";

        while(!Objects.equals(flag, "exit")) {
            System.out.print("첫 번째 수를 입력하세요: ");
            Double n1 = sc.nextDouble();
            System.out.print("연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            System.out.print("두 번째 수를 입력하세요: ");
            Double n2 = sc.nextDouble();
            sc.nextLine();

            // arithmeticcalculator를 이용하여 연산자를 저장하고 연산
            arithmeticCalculator.setOperatorType(operator);
            arithmeticCalculator.calculate(n1, n2);

            System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.println("scan 입력 시 연산 결과를 스캔합니다.");
            System.out.println("delete 입력 시 가장 먼저 연산한 결과가 삭제됩니다.");
            flag = sc.nextLine();
            // scan을 입력하면 기준이 되는 수보다 값이 큰 연산 결과들을 모두 출력
            if(flag.equals("scan")) {
                System.out.print("출력 기준이 될 수를 입력하세요: ");
                arithmeticCalculator.display(sc.nextDouble());
            }
            // delete를 입력하면 연산 결과를 저장한 컬렉션 필드의 가장 앞에 있는 값을 제거
            if(flag.equals("delete")) {
                arithmeticCalculator.removeResult();
            }
        }
    }
}
