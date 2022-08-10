package 입출력.a2007년_1924;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int day = sc.nextInt();

        LocalDate date = LocalDate.of(2007, month, day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();

        switch (dayOfWeekNumber){
            case 1 : System.out.println("MON"); break;
            case 2 : System.out.println("TUE"); break;
            case 3 : System.out.println("WED"); break;
            case 4 : System.out.println("THU"); break;
            case 5 : System.out.println("FRI"); break;
            case 6 : System.out.println("SAT"); break;
            case 7 : System.out.println("SUN"); break;
        }
    }
}
