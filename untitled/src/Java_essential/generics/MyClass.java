package Java_essential.generics;

public class MyClass<T> {
    private T type;

    private MyClass(T type) {
        this.type = type;
    }

    public static <T> MyClass<T> factoryMethod(T t) {
        return new MyClass<>(t);
    }

    @Override
    public String toString() {
        return "{type=" + type +'}';
    }
}
class MyClassMain{
    public static void main(String[] args) {
        MyClass<String> myClass = MyClass.factoryMethod("Hello");
        System.out.println(myClass);
        MyClass<Integer> myClass1 = MyClass.factoryMethod(23);
        System.out.println(myClass1);
    }
}
