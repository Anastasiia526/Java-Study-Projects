package Term_projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number without zero: ");
        try {
            int number = Integer.parseInt(br.readLine());
            System.out.println("Reverse of the entered number " + number + ": ");
            System.out.println(reverse(number));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int reverse(int number) {
        int result = 0;
        while (number> 0){
            int digit = number % 10;
            result = result * 10 + digit;
            number /= 10;
        }
        return result;
    }
}

