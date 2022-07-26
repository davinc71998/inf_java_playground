package ExampleCalender;
import java.util.Scanner;
import java.util.HashMap;

public class ExampleCalenderEight {
    private static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int changeWeekday(String weekday) {
        HashMap<String,Integer> weekdayMatching = new HashMap();
        weekdayMatching.put("SU", 0);
        weekdayMatching.put("MO", 1);
        weekdayMatching.put("TU", 2);
        weekdayMatching.put("WE", 3);
        weekdayMatching.put("TH", 4);
        weekdayMatching.put("FR", 5);
        weekdayMatching.put("SA", 6);
        return weekdayMatching.get(weekday);
    }

    public boolean checkLeapDays(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getMonthDays(int year, int month) {
        if (checkLeapDays(year)) {
            return leapDays[month - 1];
        } else {
            return days[month - 1];
        }
    }

    public void makeCalender(int day) {
        System.out.printf("%3s%2s%2s%2s%2s%2s%2s\n", "SU", "MO", "TU", "WE", "TH", "FR", "SA");
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

    public void makeReviseCalender(int year, int month, int day, int weekday) {
        System.out.printf("<< %d >>년 %d 월 달력\n", year, month );
        System.out.printf("%3s%3s%3s%3s%3s%3s%3s\n", "SU", "MO", "TU", "WE", "TH", "FR", "SA");
        System.out.printf("-------------------------\n");
        for(int i = 1; i <= (day+weekday); i++) {
            if(i <= weekday) {
                System.out.printf("%3S", " ");
                continue;
            }
            System.out.printf("%3d", (i - weekday));
            if(i % 7 == 0) {
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }

    public void printDays(int month, int day) {
        System.out.println(month + "월은 " + day + "일까지 있습니다.");
    }

    public static void main(String[] args) {
        String prompt = "> ";
        int year = 0;
        int month = 0;
        String weekday;
        ExampleCalenderEight cal = new ExampleCalenderEight();
        Scanner scanner = new Scanner(System.in);
        while(month != -1) {
            System.out.println("년 월을 입력하세요.");
            System.out.print(prompt);
            year = Integer.parseInt(scanner.next());
            month = Integer.parseInt(scanner.next());
            System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
            weekday = scanner.next();
            if(month >= 1 && month <= 12) {
                cal.makeReviseCalender(year, month, cal.getMonthDays(year,month), cal.changeWeekday(weekday));
                cal.printDays(month, cal.getMonthDays(year,month));
            } else {
                continue;
            }
        }
        System.out.println("Have a nice day!");
    }
}
