package Java_advanced.Annotations;

import java.lang.annotation.*;

public class Task3 {
    public static void main(String[] args) {
        Animal animal = new Animal("any animal");
        Cat cat = new Cat("Busan");
        Dog dog = new Dog("Bonny");
        animal.sound();
        cat.sound();
        dog.sound();
        checkAnnotation(animal);
        checkAnnotation(cat);
        checkAnnotation(dog);
    }

    public static void checkAnnotation(Object obj) {
        Class<?> clazz = obj.getClass();
        if (clazz.isAnnotationPresent(Info.class)) {
            Info info = clazz.getAnnotation(Info.class);
            System.out.println("Annotation name: " + info.name());
        }
    }
}

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Info {
    String name();
}

@Info(name = "All animals")
class Animal {
    private String name;


    public Animal(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void sound() {
        System.out.println(name + " make sound");
    }


    public void move() {
        System.out.println(name + " movies");
    }

}

@Info(name = "Home animal")
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(getName() + " says meows");
    }

    @Override
    public void move() {
        System.out.println(getName() + " climbs trees");
    }
}

@Info(name = "Home animal")
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println(getName() + " says woof");
    }

    @Override
    public void move() {
        System.out.println(getName() + " running");
    }
}
