package ExampleGugudan;

import java.util.Scanner;

public class ExampleGugudanArray {
    public static void main(String[] args) {
        int num;
        int[] result;
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : ");
        num = scanner.nextInt();
        for(int i = 1; i <= result.length; i++) {
            result[i-1] = num * i;
        }
        for(int number : result) {
            System.out.println(number);
        }  */
        //Combination
        for(int i = 2; i <= 9; i++) {
            result = new int[9];
            for(int j = 1; j <= result.length; j++) {
                result[j-1] = i * j;
            }
            System.out.println(i + "단의 결과 ");
            for(int number : result) {
                System.out.println(number);
            }
        }
    }
}
