package Java_advanced.collection_Framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введіть число: ");
        int userNumber = 0;
        try {
            userNumber = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.getStackTrace();
        }
        List<Integer> myList = new LinkedList<>();
        System.out.println("Список чисел від " + userNumber + " до 0:");
        getIntegerList(myList, userNumber);
        System.out.println();
        System.out.println("Мінімальне число із введеного списку: " + getMinimum(myList));
    }
    public static void getIntegerList(List<Integer> list, int num){
        while (num >= 0){
            list.add(num);
            num--;
        }
        for(Integer temp : list){
            System.out.print(temp + " ");
        }
    }
    public static int getMinimum(List<Integer> list){
        Integer min = list.getFirst();
        for (int i = 0; i < list.size(); i++) {
            int currentNum = list.get(i);
            if(currentNum < i){
                min = currentNum;
            }
        }
        return min;
    }
}
