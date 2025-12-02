package Term_projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateNumber {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the date in the format dd/MM/YYYY: ");
        try {
            String date = br.readLine();
            System.out.println("Date number = " + getDateNumber(date));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getDateNumber(String date) {
        int sum = 0;
        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        return sum;
    }
}
