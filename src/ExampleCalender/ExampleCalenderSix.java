package ExampleCalender;
import java.util.Scanner;

public class ExampleCalenderSix {
    private static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMonthDays(int month) {
        return days[month - 1];
    }

    public void makeCalender(int day) {
        System.out.printf("%3s%2s%2s%2s%2s%2s%2s\n","일","월","화","수","목","금","토");
        System.out.printf("-------------------------\n");
        for(int i = 0; i < (day / 7); i++) {
            for(int j = 1; j <= 7; j++) {
                System.out.printf("%3d", j + (i * 7) );
            }
            System.out.print("\n");
        }
        for(int i = 1; i <= (day % 7); i++) {
            System.out.printf("%3d", i + 7 * (day / 7));
        }
        System.out.print("\n");
    }

    public void makeReviseCalender(int day) {
        System.out.printf("%3s%2s%2s%2s%2s%2s%2s\n","일","월","화","수","목","금","토");
        System.out.printf("-------------------------\n");
        for(int i = 1; i <= day; i++) {
            System.out.printf("%3d", i);
            if(i % 7 == 0) {
                System.out.print("\n");
            }
        }
    }

    public void printDays(int month,int day) {
        System.out.println(month + "월은 " + day + "일까지 있습니다.");
    }

    public static void main(String[] args) {
        String prompt = "> ";
        int month = 0;
        ExampleCalenderSix cal = new ExampleCalenderSix();
        Scanner scanner = new Scanner(System.in);
        while(month != -1) {
            System.out.println("월을 입력하세요.");
            System.out.print(prompt);
            month = scanner.nextInt();
            if(month >= 1 && month <= 12) {
                cal.makeReviseCalender(cal.getMonthDays(month));
                cal.printDays(month, cal.getMonthDays(month));
            } else {
                continue;
            }
        }
        System.out.println("Have a nice day!");
    }
}
