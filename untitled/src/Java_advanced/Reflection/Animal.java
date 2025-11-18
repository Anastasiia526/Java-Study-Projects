package Java_advanced.Reflection;

import java.lang.reflect.Field;

public class Animal {
    private int weight = 60;
    public String breed = "Arab";
    protected boolean tail = true;
}

class Cat {
    public static void main(String[] args) {
        Class<?> cl = Animal.class;
        Animal animal = new Animal();
        try {
            Field field = cl.getField("breed");
            System.out.println("Old breed " + field.get(animal));
            field.set(animal, "Manx");
            System.out.println("New breed " + field.get(animal));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        Field[] fields = cl.getDeclaredFields();
        for (Field temp : fields) {
            temp.setAccessible(true);
            try {
                if (temp.getType() == int.class) {
                    System.out.println("Old weight " + temp.getInt(animal));
                    temp.set(animal, 15);
                    System.out.println("New weight " + temp.getInt(animal));
                }

                if (temp.getType() == boolean.class) {
                    System.out.println("Old tail " + temp.getBoolean(animal));
                    temp.set(animal, false);
                    System.out.println("New tail " + temp.getBoolean(animal));
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
