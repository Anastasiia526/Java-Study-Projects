package Java_essential.inner_nested_classes;

import java.util.Scanner;

public class Calculator {
        private int a;
        private int b;

        public Calculator(int a, int b) {
            this.a = a;
            this.b = b;
        }

        class Arithmetic {
            void add(int a, int b) {
                System.out.println(a + " + " + b + " = " + (a + b));
            }

            void sub(int a, int b) {
                System.out.println(a + " - " + b + " = " + (a - b));
            }

            void mul(int a, int b) {
                System.out.println(a + " * " + b + " = " + (a * b));
            }

            void div(int a, int b) {
                try {
                    if (b == 0) {
                        System.out.println("На нуль ділити не можна!");
                        System.out.println(a + " / " + b + " = " + (a / b));
                    }
                } catch (ArithmeticException e) {
                    System.out.println("Виключення " + e.getMessage());
                }

            }
        }
    }
    class CalculatorMain {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введіть перше число: ");
            int firstNumber = sc.nextInt();
            System.out.println("Введіть друге число: ");
            int secondNumber = sc.nextInt();
            sc.close();
            Calculator calculator = new Calculator(firstNumber, secondNumber);
            Calculator.Arithmetic arithmetic = calculator.new Arithmetic();
            arithmetic.add(firstNumber, secondNumber);
            arithmetic.sub(firstNumber, secondNumber);
            arithmetic.mul(firstNumber, secondNumber);
            arithmetic.div(firstNumber, secondNumber);
        }
    }

