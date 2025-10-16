package Java_advanced;

import java.util.Arrays;

public class Car implements Comparable {
    int speed;
    int price;
    String model;
    String color;

    Car(int speed, int price, String model, String color) {
        this.speed = speed;
        this.price = price;
        this.model = model;
        this.color = color;
    }


    public String toString() {
        return this.model + " " + this.color + " " + this.speed + " " + this.price;
    }


    @Override
    public int compareTo(Object o) {
        int temp = this.speed - ((Car)o).speed;
        if (temp == 0) {
            temp = this.price - ((Car)o).price;
        } if (temp == 0) {
            temp = this.model.compareTo(((Car)o).model);
        } if (temp == 0){
            temp = this.color.compareTo(((Car)o).color);
        }
        return temp;
    }
}
class CarMain{
    public static void main(String[] args) {
        Car car1 = new Car(100, 1000, "Toyota", "white");
        Car car2 = new Car(100, 1000, "Toyota", "blue");
        Car car3 = new Car(100, 1000, "Toyota", "black");
        Car[]cars = {car1, car2, car3};
        Arrays.sort(cars);
        for(Car temp : cars){
            System.out.println(temp);
        }
    }
}
