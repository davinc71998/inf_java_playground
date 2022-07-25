package ExampleGugudan;

public class ExampleGugudanMain {
    public static void main(String[] args){
        for(int i = 2; i <= 9; i++) {
            int[] result = ExampleGugudanMethod.calculate(i);
            System.out.println(i + "단");
            ExampleGugudanMethod.printArray(result);
        }
    }
}
