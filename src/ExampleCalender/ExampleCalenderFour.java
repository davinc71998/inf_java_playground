package ExampleCalender;
import java.util.Scanner;

public class ExampleCalenderFour {
    private static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMonthDays(int month) {
        return days[month - 1];
    }

    public void printDays(int month,int day) {
        System.out.println(month + "월은 " + day + "일까지 있습니다.");
    }

    public static void main(String[] args) {
        int count;
        int month;
        ExampleCalenderFour cal = new ExampleCalenderFour();
        System.out.println("반복횟수를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        System.out.println("월을 입력하세요.");
        for(int i = 0; i < count; i++) {
            month = scanner.nextInt();
            cal.printDays(month, cal.getMonthDays(month));
        }
    }
}
