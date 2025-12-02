package Term_projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDigitsOfNumber {
    public static int sumOfDigitsOfNumber(int number){
        number = Math.abs(number);
        int sum = 0;
        while (number>0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number: ");
        try {
            int number = Integer.parseInt(br.readLine());
            System.out.println("Sum of the digits of the entered number " + number + ": ");
            System.out.println(sumOfDigitsOfNumber(number));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
