package Lv3;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    private static final String OPERATION_REG = "[+\\-*/%]";
    private static final String DOUBLE_REG = "^[0-9]*.?[0-9]*$";
    private static final String INT_REG = "^[0-9]*$";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 제네릭 클래스인 arithmeticcalculator를 Double로 선언
//        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();
        ArithmeticCalculator<Integer> arithmeticCalculator = new ArithmeticCalculator<>();
        String flag = "";
        String input = "";

        while(!Objects.equals(flag, "exit")) {
            try {
                System.out.print("첫 번째 수를 입력하세요: ");
                input = sc.nextLine();
//                if(!Pattern.matches(DOUBLE_REG, input)) {
//                    throw new Exception("잘못된 입력입니다. 실수를 입력하세요.");
//                }
//                Double n1 = Double.valueOf(input);
                if(!Pattern.matches(INT_REG, input)) {
                    throw new Exception("잘못된 입력입니다. 정수를 입력하세요.");
                }
                Integer n1 = Integer.valueOf(input);

                System.out.print("연산 기호를 입력하세요: ");
                input = sc.nextLine();
                if(!Pattern.matches(OPERATION_REG, input)) {
                    throw new Exception("잘못된 입력입니다. 연산자를 입력하세요.");
                }
                char operator = input.charAt(0);

                System.out.print("두 번째 수를 입력하세요: ");
                input = sc.nextLine();
//                if(!Pattern.matches(DOUBLE_REG, input)) {
//                    throw new Exception("잘못된 입력입니다. 실수를 입력하세요.");
//                }
//                Double n2 = Double.valueOf(input);
                if(!Pattern.matches(INT_REG, input)) {
                    throw new Exception("잘못된 입력입니다. 정수를 입력하세요.");
                }
                Integer n2 = Integer.valueOf(input);

                if((operator == '/' || operator == '%') && n2 == 0) {
                    throw new Exception("0으로 나눌 수 없습니다.");
                }
                // arithmeticcalculator를 이용하여 연산자를 저장하고 연산
                arithmeticCalculator.setOperatorType(operator);
                arithmeticCalculator.calculate(n1, n2);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.println("scan 입력 시 연산 결과를 스캔합니다.");
            System.out.println("delete 입력 시 가장 먼저 연산한 결과가 삭제됩니다.");
            flag = sc.nextLine();
            // scan을 입력하면 기준이 되는 수보다 값이 큰 연산 결과들을 모두 출력
            if(flag.equals("scan")) {
                System.out.print("출력 기준이 될 수를 입력하세요: ");
//                arithmeticCalculator.display(sc.nextDouble());
                arithmeticCalculator.display(sc.nextInt());
                sc.nextLine();
            }
            // delete를 입력하면 연산 결과를 저장한 컬렉션 필드의 가장 앞에 있는 값을 제거
            if(flag.equals("delete")) {
                arithmeticCalculator.removeResult();
            }
        }
    }
}
