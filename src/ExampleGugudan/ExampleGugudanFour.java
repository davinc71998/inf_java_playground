package ExampleGugudan;

import java.util.Scanner;
public class ExampleGugudanFour {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");
        number = scanner.nextInt();
        if (number >= 2 && number <= 9) {
            System.out.println(number + "단의 구구단 출력");
            System.out.println("---------------");
            for(int i = 1; i <= 9; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
        } else {
            System.out.println("2와 9사이의 숫자가 아닙니다.");
        }
    }
}
