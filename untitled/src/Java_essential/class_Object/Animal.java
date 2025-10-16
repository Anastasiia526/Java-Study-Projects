package Java_essential.class_Object;

import  java.lang.Object;
public class Animal {
    private String name;
    private int age;
    private boolean tail;

    public Animal(String name, int age, boolean tail) {
        this.name = name;
        this.age = age;
        this.tail = tail;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isTail() {
        return tail;
    }
    public String tail(){
        String result = (isTail() == true) ? "так" : "ні";
        return result;
    }
    @Override
    public String toString() {
        return "Ім'я: "+ getName() + ", вік: "+getAge()+", хвіст: " + tail();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + (tail ? 1 : 0);
        result = 37 * result + Integer.hashCode(age);
        result = 37 * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        if (age != animal.age) return false;
        return true;
    }
}
class Main{
    public static void main(String[] args) {
        Animal animal1 = new Animal("Васька", 45, false);
        Animal animal3 = new Animal("Васька", 45, false);
        Animal animal2 = new Animal("Бусан", 3, true);
        System.out.println(animal1);
        System.out.println(animal1.equals(animal2));
        System.out.println(animal1.equals(animal3));
        System.out.println(animal1 + ", hashCode(): " + animal1.hashCode());
        System.out.println(animal3 + ", hashCode(): " + animal1.hashCode());
        System.out.println(animal2 + ", hashCode(): " + animal2.hashCode());
    }
}
