package Java_essential.inner_nested_classes;

import java.util.Scanner;

public class Distance {
    double distance;

    public Distance(double distance) {
        this.distance = distance;
    }

    void print() {
        System.out.println("Відстань = " + distance + ": ");
    }

    static class Converter {
        double convertCentimetersToMeters(double centimeters) {
            double distance = centimeters * 0.01;
            return distance;
        }

        double convertCentimetersToKilometers(double centimeters) {
            double distance = centimeters / 100000;
            return distance;
        }

        double convertCentimetersToMiles(double centimeters) {
            double distance = centimeters / 160934.4;
            return distance;
        }

        double convertMetersToCentimeters(double meters) {
            double distance = meters * 100;
            return distance;
        }

        double convertMetersToKilometers(double meters) {
            double distance = meters / 1000;
            return distance;
        }

        double convertMetersToMiles(double meters) {
            double distance = meters / 0.00062137;
            return distance;
        }

        double convertKilometersToMiles(double kilometers) {
            double distance = kilometers * 0.621371;
            return distance;
        }

        double convertKilometersToMeters(double kilometers) {
            double distance = kilometers * 1000;
            return distance;
        }

        double convertKilometersCentimeters(double kilometers) {
            double distance = kilometers * 100000;
            return distance;
        }
    }
}

class MainDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть одиниці вимірювання дістанції: см, м або км: ");
        String metering = sc.next();
        System.out.println("Введіть кількість заданих " + metering + ": ");
        double distance = sc.nextDouble();
        sc.close();
        Distance distance1 = new Distance(distance);
        Distance.Converter converter = new Distance.Converter();
        if (metering.equals("см")) {
            distance1.print();
            System.out.println("Сантиметрів у метрах " + converter.convertCentimetersToMeters(distance));
            System.out.println("Сантиметрів у кілометрах " + converter.convertCentimetersToKilometers(distance));
            System.out.println("Сантиметрів у мілях " + converter.convertCentimetersToMiles(distance));
        } else if (metering.equals("м")) {
            distance1.print();
            System.out.println("Метрів у сантиметрах " + converter.convertMetersToCentimeters(distance));
            System.out.println("Метрів у кілометрах " + converter.convertMetersToKilometers(distance));
            System.out.println("Метрів у мілях " + converter.convertMetersToMiles(distance));
        } else if (metering.equals("км")) {
            distance1.print();
            System.out.println("Кілометрів у сантіметрах " + converter.convertKilometersCentimeters(distance));
            System.out.println("Кілометрів у метрах " + converter.convertKilometersToMeters(distance));
            System.out.println("Кілометрів у мілях " + converter.convertKilometersToMiles(distance));
        }

    }
}
