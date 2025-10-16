package Java_essential.inner_nested_classes;

public enum Vehicles {
    VOLKSWAGEN(55555, "green"), VOLVO(77777, "blue"), VAUXHALL(99999, "red");
    double price;
    String color;

    Vehicles(double price, String color) {
        this.price = price;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "the vehicle " + super.toString()  + " in " + getColor() + " color" + " costs " + getPrice();
    }

}
class VehiclesMain{
    public static void main(String[] args) {
        Vehicles vehicles1 = Vehicles.VAUXHALL;
        System.out.println(vehicles1);
        Vehicles vehicles = Vehicles.VOLVO;
        System.out.println(vehicles);
        Vehicles vehicles2 = Vehicles.VOLKSWAGEN;
        System.out.println(vehicles2);
    }
}
