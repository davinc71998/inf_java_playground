package ExampleGugudan;
import java.util.Scanner;

public class HomeworkGugudanMain {
    public static void main(String[] args){
        String num;
        Scanner scanner = new Scanner(System.in);
        System.out.print("패턴을 입력하세요 : ");
        num = scanner.nextLine();
        int[] result = HomeworkGugudanMethod.judgeArg(num);
        if(result.length == 1) {
            HomeworkGugudanMethod.calculate(result[0]);
        } else {
            HomeworkGugudanMethod.calculateDiffer(result[0],result[1]);
        }
    }
}
