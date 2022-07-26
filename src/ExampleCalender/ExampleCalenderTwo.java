package ExampleCalender;
import java.util.Scanner;

public class ExampleCalenderTwo {
    public static void main(String[] args) {
        System.out.println("두 수를 입력하세요.");
        int num1, num2;
        Scanner scanner = new Scanner(System.in);
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        System.out.println("두 수의 합은 " + (num1 + num2) + "입니다.");
        System.out.printf("두 수의 합은 %d 입니다.",num1 + num2);
        scanner.close();
    }
}
