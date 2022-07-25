package ExampleGugudan;

import java.util.Scanner;

public class ExampleGugudanMethod {
    public static int[] calculate(int times) {
        int[] result = new int[9];
        for(int i = 1; i <= result.length; i++) {
            result[i-1] = times * i;
        }
        return result;
    }

    public static void printArray(int[] result) {
        for(int i = 1; i <= result.length; i++) {
            System.out.println(result[i-1]);
        }
    }
}
