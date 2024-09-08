package lv2;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String flag = "";
        while(!Objects.equals(flag, "exit")) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int n1 = sc.nextInt();
            if (n1 < 0) {
                System.out.println("0 또는 자연수만 입력 가능합니다.");
                continue;
            }
            System.out.print("두 번째 숫자를 입력하세요: ");
            int n2 = sc.nextInt();
            if (n2 < 0) {
                System.out.println("0 또는 자연수만 입력 가능합니다.");
                continue;
            }
            System.out.print("연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            sc.nextLine();

            if(operator != '+' && operator != '-' && operator != '*' && operator != '/' && operator != '%') {
                System.out.println("정상적인 연산자가 아닙니다.");
            }
            else if((operator == '/' || operator == '%') && n2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
            }
            else {
                System.out.println("연산 결과: " + calculator.calculate(n1, n2, operator));
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, delete 입력 시 계산 결과 삭제)");
            flag = sc.nextLine();
            if(flag.equals("delete")) {
                calculator.removeResult();
            }
        }
    }
}
