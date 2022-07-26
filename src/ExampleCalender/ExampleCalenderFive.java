package ExampleCalender;
import java.util.Scanner;

public class ExampleCalenderFive {
    private static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMonthDays(int month) {
        return days[month - 1];
    }

    public void printDays(int month,int day) {
        System.out.println(month + "월은 " + day + "일까지 있습니다.");
    }

    public static void main(String[] args) {
        String prompt = "> ";
        int month = 0;
        ExampleCalenderFive cal = new ExampleCalenderFive();
        Scanner scanner = new Scanner(System.in);
        while(month != -1) {
            System.out.println("월을 입력하세요.");
            System.out.print(prompt);
            month = scanner.nextInt();
            if(month >= 1 && month <= 12) {
                cal.printDays(month, cal.getMonthDays(month));
            } else {
                continue;
            }
        }
        System.out.println("Have a nice day!");
    }
}
