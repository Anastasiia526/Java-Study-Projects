package Java_advanced.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Car {
    private int speed;
    public String model;
    protected double cost;

    public Car() {
    }

    public Car(double cost) {
        this.cost = cost;
    }

    public Car(int speed, String model, double cost) {
        this.speed = speed;
        this.model = model;
        this.cost = cost;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", model='" + model + '\'' +
                ", cost=" + cost +
                '}';
    }

}

class CarMain {
    public static void main(String[] args) {
        Car car = new Car();
        Class<?> cl = car.getClass();
        int mods = cl.getModifiers();
        if (Modifier.isPublic(mods)) {
            System.out.println("Class Cat public");
        }
        if (Modifier.isStatic(mods)) {
            System.out.println("Class Cat static");
        }
        if (Modifier.isPrivate(mods)) {
            System.out.println("Class Cat private");
        }
        Field[] fields = cl.getDeclaredFields();
        for (Field temp : fields) {
            System.out.println("class field types: " + temp.getType());
        }
        System.out.println("----------------");
        int i = 0;
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        for (Constructor<?> temp : constructors) {
            System.out.println("Constructor " + ++i);
            Class<?>[] paramTypes = temp.getParameterTypes();
            if (paramTypes.length == 0) {
                System.out.println("Parameterless constructor");
            } else {
                System.out.println("Constructor variable type parameters: ");
                for (Class<?> tmp : paramTypes) {
                    System.out.println(tmp.getSimpleName());
                }
            }

        }
        System.out.println("----------------");
        Method[] methods = cl.getDeclaredMethods();
        for (Method tmp : methods) {
            System.out.println("Method name " + tmp.getName() + " - type of value being returned - " + tmp.getReturnType().getSimpleName());
            Class<?>[] parameterTypes = tmp.getParameterTypes();
            for (Class<?> temp2 : parameterTypes) {
                System.out.println("Type of method parameter being accepted - " + temp2.getName());
            }
        }
    }
}