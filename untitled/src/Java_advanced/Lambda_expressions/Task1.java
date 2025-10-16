package Java_advanced.Lambda_expressions;

public class Task1 {
    public static void main(String[] args) {
        Operation calculator = (name -> System.out.println("Calculator operation " + name));
        calculator.operation("addition");
        calculator.operation("substraction");
        calculator.operation("multiply");
        calculator.operation("divide");
    }
}


@FunctionalInterface
interface Operation{
    void operation(String name);
}
