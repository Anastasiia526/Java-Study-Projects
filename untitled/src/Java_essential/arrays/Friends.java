package Java_essential.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Friends {
    public static void main(String[] args) {
        ArrayList<String> friends = new ArrayList<>();
        friends.add("Чендлер Мюріел Бінг");
        friends.add("Рейчел Карен Грін");
        friends.add("Росс Юстас Геллер");
        friends.add("Моніка Е. Геллер");
        friends.add("Джозеф Френсіс Трібіані-молодший");
        friends.add("Фібі Буффе");
        ListIterator<String> listIterator = friends.listIterator();
        System.out.println("Список друзів: ");
        while (listIterator.hasNext()){
            String s = listIterator.next();
            System.out.print(s + ", ");
        }
        Collections.sort(friends);
        System.out.println();
        System.out.println("Список друзів в алфавітному порядку: \n" + friends);
    }
}
