package lv1;

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // flag에 exit가 입력될 때까지 반복문 실행
        for(String flag = ""; !Objects.equals(flag, "exit"); flag = sc.nextLine()) {
            System.out.print("첫 번째 수를 입력하세요: ");
            int n1 = sc.nextInt();
            // 음수가 입력되면 반복문 스킵
            if (n1 < 0) {
                System.out.println("0 또는 자연수만 입력 가능합니다.\n");
                continue;
            }
            System.out.print("연산자를 입력하세요: ");
            char operator = sc.next().charAt(0);
            System.out.print("두 번째 수를 입력하세요: ");
            int n2 = sc.nextInt();
            if (n2 < 0) {
                System.out.println("0 또는 자연수만 입력 가능합니다.\n");
                continue;
            }
            sc.nextLine();

            double result = n1;
            switch (operator) {
                case '+': result += n2; System.out.println("연산 결과: " + result); break;
                case '-': result -= n2; System.out.println("연산 결과: " + result); break;
                case '*': result *= n2; System.out.println("연산 결과: " + result); break;
                // 나누기 연산자의 경우 2번째 수가 0이면 불가능함을 출력
                case '/':
                    if (n2 == 0) {System.out.println("0으로 나눌 수 없습니다."); break;}
                    result /= n2; System.out.println("연산 결과: " + result); break;
                case '%':
                    if (n2 == 0) {System.out.println("0으로 나눌 수 없습니다."); break;}
                    result %= n2; System.out.println("연산 결과: " + result); break;
                default:
                    // 지정된 연산자를 입력하지 않은 경우 연산하지 않고 오류 문구 출력
                    System.out.println("정상적인 연산자가 아닙니다.");
            }
            System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료)");
        }
    }
}
