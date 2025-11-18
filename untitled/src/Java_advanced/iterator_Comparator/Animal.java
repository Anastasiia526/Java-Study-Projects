package Java_advanced.iterator_Comparator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Animal {
    private String breed;
    private int age;
    private boolean tail;

    public Animal(String breed, int age, boolean tail) {
        this.breed = breed;
        this.age = age;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Animal {" + this.breed + " " + this.age + " " + this.tail + '}';
    }
}
class AnimalMail{
    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Scottish", 3, true));
        list.add(new Animal("Oriental", 3, true));
        list.add(new Animal("Manx", 1, false));
        list.add(new Animal("Cymric", 11, false));
        list.add(new Animal("Labrador", 5, true));
        list.add(new Animal("Australian Shepherd", 3, false));
        list.add(new Animal("Boston Terrier", 5, false));
        list.add(new Animal("Retriever", 5, true));
        list.add(new Animal("Chihuahua", 6, true));
        list.add(new Animal("Dalmatian", 4, true));
        Iterator<Animal> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
