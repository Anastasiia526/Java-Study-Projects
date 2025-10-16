package Java_essential.arrays;

import java.util.ArrayList;
import java.util.ListIterator;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> animals = new ArrayList<>();
        animals.add(0, "lion");
        animals.add(1, "tiger");
        animals.add(2, "giraffe");
        animals.add(3, "elephant");
        animals.add(4, "begemoth");
        animals.add(5, "bear");
        animals.add(6, "camel");
        animals.add(7, "crocodile");
        ListIterator<String> listIterator = animals.listIterator();
        System.out.println("Список тварин в зоопарку: ");
        while (listIterator.hasNext()){
            String s = listIterator.next();
            System.out.print(s + ", ");
        }
    }
}
