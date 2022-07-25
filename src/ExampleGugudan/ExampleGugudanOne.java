package ExampleGugudan;

import java.util.Scanner;

public class ExampleGugudanOne {
    public static void main(String[] args) {
        for(int j = 2 ; j <= 3 ; j++) {
            System.out.println("--------------");
            System.out.println(j + "단 정보");
            System.out.println("--------------");
            for (int i = 1; i <= 9; i++){
                System.out.println(j + " x " + i + " = " + j * i);
            }
        }
    }
}
