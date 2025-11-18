package Java_advanced.Lambda_expressions;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 12, 8, 5, 3, 0, 7, 4, 9, 6);


        int square = list.stream().map(x -> x * x).reduce(0, (acum, integ) -> acum + integ);
        System.out.println(square);

    }
}
