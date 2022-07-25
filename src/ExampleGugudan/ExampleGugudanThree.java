package ExampleGugudan;

public class ExampleGugudanThree {
    public static void main(String[] args) {
        final int number_6 = 6;
        final int number_7 = 7;
        int count = 1;
        while(count < 10) {
            System.out.println(number_6 * count);
            count++;
        }
        System.out.println("---------");
        for(int i = 1; i <= 9; i++) {
            System.out.println(number_7 * i);
        }
    }
}
