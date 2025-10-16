package Java_essential.inner_nested_classes;

public enum Animals {
    CAT(3), DOG(7), PARROT(6),  KANGAROO(12);
    int age;
    Animals(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + " age " + age;
    }
}
class AnimalsMain{
    public static void main(String[] args) {
        for(Animals animals : Animals.values()){
            System.out.println(animals);
        }
    }
}
