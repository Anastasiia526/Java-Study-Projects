package Java_essential.arrays;

import java.util.ArrayList;
import java.util.ListIterator;

public class Task4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(12);
        list.add(8);
        list.add(4);
        list.add(7);
        list.add(23);
        ListIterator<Integer> listIterator = list.listIterator();
        System.out.println("Список чисел збільшених на 1: ");
        while (listIterator.hasNext()){
            int i = listIterator.next();
            System.out.print(i + 1 + ", ");
        }
    }
}
