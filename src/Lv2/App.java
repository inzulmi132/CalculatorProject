package Lv2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // flag를 이용하여 exit가 입력될 때까지 반복문 실행
        String flag = "";
        while(!Objects.equals(flag, "exit")) {
            System.out.print("첫 번째 수를 입력하세요: ");
            int n1 = sc.nextInt();
            if (n1 < 0) {
                System.out.println("0 또는 자연수만 입력 가능합니다.");
                continue;
            }
            System.out.print("연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            System.out.print("두 번째 수를 입력하세요: ");
            int n2 = sc.nextInt();
            if (n2 < 0) {
                System.out.println("0 또는 자연수만 입력 가능합니다.");
                continue;
            }
            sc.nextLine();

            if(operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                System.out.println("정상적인 연산자가 아닙니다.");
            }
            else if((operator == '/' || operator == '%') && n2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
            }
            else {
                // 연산은 calculator.java에게 넘기고, 그 결과 값을 바로 출력
                System.out.println("연산 결과: " + calculator.calculate(n1, n2, operator));
            }

            System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.println("delete 입력 시 가장 먼저 연산한 결과가 삭제됩니다.");
            flag = sc.nextLine();
            // delete를 입력하면 연산 결과를 저장한 컬렉션 필드의 가장 앞에 있는 값을 제거
            if(flag.equals("delete")) {
                calculator.removeResult();
            }
        }
    }
}
