package Java_advanced.Regular_expressions_and_Data_API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogin {
    public static void main(String[] args) {
        boolean isLogin = isCorrectLogin();
        System.out.println("Login  entered correctly? " + isLogin);
        boolean isPassword = isCorrectPassword();
        System.out.println("Password entered correctly? " + isPassword);

    }

    public static String addUserLogin() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your login: ");
        String userLogin = null;

        try {
            userLogin = br.readLine();

        } catch (IOException e) {
            System.out.println("Помилка при введенні");
        }
        return userLogin;
    }
    public static String addUserPassword() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your password: ");
        String password = null;
        try {
            password = br.readLine();
        } catch (IOException e) {
            System.out.println("Помилка при введенні");
        }
        return password;
    }

    public static boolean isCorrectLogin() {
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9]).{3,16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(addUserLogin());
        return matcher.find();
    }
    public static boolean isCorrectPassword() {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*]0-9])(?=.*[!@#$%^&*]).{5,16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(addUserPassword());
        return matcher.find();
    }
}
