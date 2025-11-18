package Java_essential.generics;

import java.util.ArrayList;
import java.util.List;

public class MyDictionary<TKey, TValue> {
    private static class Pair<TKey, TValue> {
        private TKey key;
        private TValue value;

        public Pair(TKey key, TValue value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    private List<Pair<TKey, TValue>> myList = new ArrayList<>();
    public void add(TKey key, TValue value){
        myList.add(new Pair<>(key, value));
    }
    public int size(){
        return myList.size();
    }

    public TKey getKey(int index){
        return myList.get(index).key;
    }
    public TValue getValue(int index){
        return myList.get(index).value;

    }
    @Override
    public String toString() {
        return myList.toString();
    }
}
class MyUserClass{
    public static void main(String[] args) {
        MyDictionary<String, Integer> myDictionary = new MyDictionary<>();
        myDictionary.add("sun", 17);
        myDictionary.add("summer", 18);
        myDictionary.add("sky", 19);
        myDictionary.add("star", 20);
        System.out.println(myDictionary);
        System.out.println("Total number of pairs of elements =" + myDictionary.size());
        System.out.println("key index 1 = " + myDictionary.getKey(1));
        System.out.println("value index 0 = " + myDictionary.getValue(0));

    }

}