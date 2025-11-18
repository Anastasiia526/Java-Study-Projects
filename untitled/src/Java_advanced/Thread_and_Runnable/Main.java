package Java_advanced.Thread_and_Runnable;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Car1 car1 = new Car1(parking);
        Car2 car2 = new Car2(parking);

        car1.start();
        car2.start();
    }
}

class Parking {
    boolean isFreePlace = true;

    synchronized public void print1() {
        for (int i = 0; i < 3; i++) {
            if(!isFreePlace){
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println("1");
            isFreePlace = false;
            notify();
        }
    }

    synchronized public void print2() {
        for (int i = 0; i < 3; i++) {
            if(isFreePlace){
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println("2");
            isFreePlace = true;
            notify();
        }
    }
}

class Car1 extends Thread {
    Parking parking;

    public Car1(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        parking.print1();

    }
}

class Car2 extends Thread {
    Parking parking;

    public Car2(Parking parking) {
        this.parking = parking;

    }

    @Override
    public void run() {
        parking.print2();
    }
}