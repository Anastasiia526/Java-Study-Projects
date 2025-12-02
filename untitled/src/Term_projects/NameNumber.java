package Term_projects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NameNumber {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name: ");
        String name = null;
        try {
            name = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Sum of the numbers of the entered name by alphabetical order: " + sum(name));
}

public static int sum(String name) {
    int sum = 0;
    for (char c : name.toUpperCase().toCharArray()) {
        if (c >= 'A' && c <= 'Z') {
            sum += (c - 'A' + 1);
        }
    }
    return sum;
}
}
