package Java_essential.arrays;

import java.util.ArrayList;
import java.util.ListIterator;

    public class Task3 {
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
            System.out.println("Список тварин в зоопарку: ");
            ListIterator<String> list = animals.listIterator();
            while (list.hasNext()){
                String s = list.next();
                System.out.print(s + ", ");
            }
            animals.remove(7);
            animals.remove(5);
            animals.remove(3);
            System.out.println();
            System.out.println("Список тварин в зоопарку після видалення за 7м, 5м та 3м індексами: ");
            ListIterator<String> list1 = animals.listIterator();
            while (list1.hasNext()){
                String s = list1.next();
                System.out.print(s + ", ");
            }
        }
    }

