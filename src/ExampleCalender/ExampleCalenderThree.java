package ExampleCalender;
import java.util.Scanner;

public class ExampleCalenderThree {
    private static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int getMaxDays(int month) {
        return days[month - 1];
    }

    public static void main(String[] args) {
        int choice;
        ExampleCalenderThree cal = new ExampleCalenderThree();
        Scanner scanner = new Scanner(System.in);
        System.out.println("달을 입력하세요.");
        choice = scanner.nextInt();
        System.out.printf("%d월은 %d일 까지 있습니다.\n", choice, cal.getMaxDays(choice));
        scanner.close();
    }
}
