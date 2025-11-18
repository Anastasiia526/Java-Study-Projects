package Java_advanced.Reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class InfoClass {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the class name:");
        try {
            String className = br.readLine();
            Class<?> cl = className.getClass();
            System.out.println("class package: " + cl);
            Constructor<?>[] constructors = cl.getConstructors();
            int i = 0;
            for (Constructor<?> temp : constructors) {
                System.out.println("Constructor " + ++i);
                Class<?>[] paramTypes = temp.getParameterTypes();
                System.out.println("Types of variables accepted by the constructor: ");
                for (Class<?> temp1 : paramTypes) {
                    System.out.print(temp1.getSimpleName() + " ");
                }
                System.out.println();
            }
            Method[] method = cl.getDeclaredMethods();
            System.out.println("Class methods:");
            for (Method temp : method) {
                System.out.println("method name: " + temp.getName() + " - method type: " + temp.getReturnType());
                Class<?>[] paramTypes = temp.getParameterTypes();
                for (Class<?> temp2 : paramTypes) {
                    System.out.println("Method type parameter:" + temp2.getName());
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
