package Java_advanced.Regular_expressions_and_Data_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TimeFromDate {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введіть дату у форматі yyyy-MM-dd: ");
        try {
            String date = br.readLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate userDate = LocalDate.parse(date, formatter);
            timePassed(userDate);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void timePassed(LocalDate date) {
        LocalDate dateToday = LocalDate.now();
        if (date.isAfter(dateToday)) {
            System.out.println("Введена дата із майбутнього");
            return;
        }
        Period period = Period.between(date, dateToday);
        System.out.printf("Минуло %d років, %d місяців, %d днів%n", period.getYears(), period.getMonths(), period.getDays());
    }
}