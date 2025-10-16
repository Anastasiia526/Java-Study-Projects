package Java_advanced.collection_Framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        addWord(myList);
        addWord(myList);
        addWord(myList);
        System.out.println("Подвоєні слова: ");
        doubleElements(myList);
    }

    public static void addWord(List<String> list) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введіть слово: ");
        String userWorld = null;
        try {
            userWorld = br.readLine();
        } catch (IOException e) {
            e.getStackTrace();
        }
        list.add(userWorld);
    }

    public static void doubleElements(List<String> list) {
        for (String temp : list) {
            System.out.print(temp + " " + temp + "\n");
        }
    }
}
