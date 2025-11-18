package Java_essential.inner_nested_classes;

public class Vehicle {
    void print(){
        System.out.println("The vehicle is moving");
    }
    class Wheel{
        void print(){
            System.out.println("The wheel is moving");
        }
    }
    class Door{void print(){
        System.out.println("The door isn't moving");
    }}
}
    class Main{
        public static void main(String[] args) {
            Vehicle vehicle = new Vehicle();
            vehicle.print();
            Vehicle.Wheel wheel = vehicle.new Wheel();
            wheel.print();
            Vehicle.Door door = vehicle.new Door();
            door.print();
        }
    }

