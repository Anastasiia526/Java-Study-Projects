package Java_advanced.Annotations;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Головний клас програми.
 * Демонструє використання власної анотації {@link Operation}
 * для передачі параметрів у метод калькулятора та виконання дій через рефлексію.
 */

public class Task2 {
    public static void main(String[] args) {

        // Створюється об'єкт калькулятора
        Calculator calculator = new Calculator();

//Через рефлексію дізнаються всі методи класу
        Class<?> clazz = calculator.getClass();
        Method[] methods = clazz.getMethods();
        for (Method temp : methods) {

//            Перевірка чи має метод анотацію @link Operation
            if (temp.isAnnotationPresent(Operation.class)) {

                // Отримуємо анотацію
                Operation operation = temp.getAnnotation(Operation.class);

//                зчитуються параметри анотації
                int num1 = operation.num1();
                int num2 = operation.num2();
                try {

//                     Викликаємо метод через Reflection
                    temp.invoke(calculator, num1, num2);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
/**
 * Клас, що реалізує простий калькулятор.
 * Містить методи для базових арифметичних операцій.
 */
class Calculator {
    /**
     * Метод для додавання двох чисел.
     *
     * @param num1 перше число
     * @param num2 друге число
     */
    @Operation(num1 = 10, num2 = 5)
    public void add(int num1, int num2) {
        System.out.println("Addition operation = " + (num1 + num2));
    }
    /**
     * Метод для знаходження різниці двох чисел.
     *
     * @param a перше число
     * @param b друге число
     */
    @Operation(num1 = 10, num2 = 5)
    public void sub(int a, int b){
        System.out.println("Subtraction operation = " + (a - b));
    }
    /**
     * Метод для множення двох чисел.
     *
     * @param a перше число
     * @param b друге число
     */
    @Operation(num1 = 10, num2 = 5)
    public void mul(int a, int b){
        System.out.println("Multiply operation = " + (a * b));
    }

    /**
     * Метод для ділення двох чисел.
     *
     * @param a перше число
     * @param b друге число
     */
    @Operation(num1 = 10, num2 = 5)
    public void div(int a, int b){
        System.out.println("Division operation = " + (a / b));
    }
}
/**Анотація для передачі двох числових параметрів у метод калькулятора
 * @Documented - додає анотацію в JavaDoc
 * @Retention(RetentionPolicy.RUNTIME)} — зберігає анотацію під час виконання для роботи з Reflection
 * @Target(ElementType.METHOD) - дозволяє ставити анотацію лише на методи

 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Operation {
    //    Перше число для арифметичної операції
    int num1();
    //    Друге число для арифметичної операції
    int num2();
}
