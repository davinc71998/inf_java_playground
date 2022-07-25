package ExampleGugudan;

public class HomeworkGugudanMethod {
    public static void calculate(int times) {
        for(int i = 2; i <= times; i++) {
            System.out.println(i + "단은");
            for(int j = 1; j <= i; j++){
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
    }

    public static void calculateDiffer(int times, int count) {
        for(int i = 2; i <= times; i++) {
            System.out.println(i + "단은");
            for(int j = 1; j <= count; j++){
                System.out.println(i + " x " + j + " = " + (i * j));
            }
        }
    }

    public static int[] judgeArg(String num) {
        int[] result;
        if(num.length() == 1) {
            result = new int[1];
            result[0] = Integer.parseInt(num);
        } else {
            String[] data = num.split(",");
            result = new int[2];
            result[0] = Integer.parseInt(data[0]);
            result[1] = Integer.parseInt(data[1]);
        }
        return result;
    }
}
