package ExampleCalender;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//git account test
public class ExampleCalenderFileIO {
    private static final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    HashMap<String, Integer> recordCalender = new HashMap();
    ArrayList<String>[] informCalender = new ArrayList[100];

    public int zellerFormula(int year, int month) {
        if(month >= 1 && month <= 2) {
            year = year - 1;
            month = month + 12;
        }
        int q = 1;
        int k = year % 100;
        int j = year / 100;
        int h = ((q + ((13 * (month + 1)) / 5) + k + (k / 4) + (j / 4) - (2 * j)) % 7);
        h = h - 1;
        if(h == -1) {
            h = 6;
        }
        return h;
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
        System.out.printf("<< %d >>년 %d월 달력\n", year, month );
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

    public void initCalender() throws Exception{
        for(int i = 0; i < 100; i++) {
            informCalender[i] = new ArrayList<String>();
        }
        String lineData;
        String path = ExampleCalender.class.getResource("").getPath();
        File file = new File(path + "data.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        while ((lineData = buffer.readLine()) != null) {
            if(lineData.equals("")) {
                continue;
            }
            String[] fileData = lineData.split(",");
            if (!recordCalender.containsKey(fileData[0])) {
                recordCalender.put(fileData[0],recordCalender.size());
                informCalender[recordCalender.get(fileData[0])].add(fileData[1]);
            } else {
                informCalender[recordCalender.get(fileData[0])].add(fileData[1]);
            }
        }
    }

    public void registCalender(Scanner scanner) {
        String date;
        String information = "";
        String writeData;
        File file = new File("src/ExampleCalender/data.txt");
        System.out.println("날짜를 입력해주세요.");
        date = scanner.next();
        System.out.println("일정을 입력해주세요. (종료문자 ;)");
        while(!information.endsWith(";")) {
            String temp;
            temp =  scanner.nextLine();
            information += temp;
        }
        information = information.split(";")[0];
        if (!recordCalender.containsKey(date)) {
            recordCalender.put(date,recordCalender.size());
            informCalender[recordCalender.get(date)].add(information);
        } else {
            informCalender[recordCalender.get(date)].add(information);
        }
        writeData = (date + "," + information);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
            writer.write("\n");
            writer.write(writeData);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchCalender(Scanner scanner) {
        String date;
        System.out.println("날짜를 입력해주세요.");
        date = scanner.next();
        if (recordCalender.containsKey(date)) {
            for(int i = 0; i < informCalender[recordCalender.get(date)].size(); i++) {
                System.out.println(informCalender[recordCalender.get(date)].get(i));
            }
        } else {
            System.out.println("해당 날짜에 입력된 일정이 없습니다.");
        }
    }

    public void printCalender(Scanner scanner) {
        int year;
        int month;
        System.out.println("년 월을 입력하세요.");
        year = Integer.parseInt(scanner.next());
        month = Integer.parseInt(scanner.next());
        if(month >= 1 && month <= 12) {
            makeReviseCalender(year, month, getMonthDays(year,month), zellerFormula(year, month));
            printDays(month, getMonthDays(year,month));
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public static void main(String[] args) {
        String prompt = "> ";
        int year = 0;
        int month = 0;
        String command = "";
        String weekday;
        ExampleCalenderFileIO cal = new ExampleCalenderFileIO();
        Scanner scanner = new Scanner(System.in);
        try {
            cal.initCalender();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true) {
            System.out.println("명령 (1, 2, 3, q)");
            System.out.print(prompt + " ");
            command = scanner.next();
            if (command.equals("1")) {
                cal.registCalender(scanner);
            } else if (command.equals("2")) {
                cal.searchCalender(scanner);
            } else if (command.equals("3")) {
                cal.printCalender(scanner);
            } else if (command.equals("q")) {
                break;
            }
        }
        System.out.println("Have a nice day!");
    }
}
