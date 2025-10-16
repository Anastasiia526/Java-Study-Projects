package Java_advanced.Serialization_XML_and_JSON;

import java.io.*;

public class Animal implements Serializable {
    private String species;
    private int weight;
    private float height;

    public Animal(String species, int weight, float height) {
        this.species = species;
        this.weight = weight;
        this.height = height;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
class Main1{
    public static void main(String[] args) {
        Animal animal = new Animal("Giraffe", 100, 2.7f);
        File file = new File("src/main/java/serialization/file2.txt");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(animal);
            System.out.println("Об'єкт классу " + Animal.class + " записано у " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
