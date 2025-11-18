package Java_advanced.collection_Framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtraTask {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> myList = new ArrayList<>();

        String input = null;
        System.out.println("Введіть рядки, для завершення напишіть end: ");
        while (true) {
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.getStackTrace();
                System.out.println("Помилка при введенні рядків");
            }
            myList.add(input);
            if (input.equalsIgnoreCase("end")) {
                break;
            }
        }

        myList.removeLast();
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

