package ExampleGugudan;

public class ExampleGugudanTwo {
    public static void main(String[] args) {
        final int num_4 = 4;
        final int num_5 = 5;
        int result;
        for(int i = 1; i<=9; i++) {
            result = num_4 * i;
            System.out.println(result);
        }
        System.out.println("------------");
        for(int i = 1; i<=9; i++) {
            result = num_5 * i;
            System.out.println(result);
        }
    }
}
