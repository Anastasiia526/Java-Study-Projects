package JDBC_Hibernate.Intro.DAO;

import JDBC_Hibernate.Intro.DAO.dao.ServiceCar;
import JDBC_Hibernate.Intro.DAO.entity.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServiceCar serviceCar = new ServiceCar();
        Car car = new Car();
        car.setModel("BMW");
        car.setModelYear(2000);
        car.setModel("KIA");
        car.setModelYear(2002);
//        serviceCar.add(car);
//        serviceCar.findById(2);
//        System.out.println(car.getIdCar() + " " + car.getModel() + " " + car.getModelYear());

//        serviceCar.update(2,"AUDI");
//        serviceCar.deleteById(2);
        List<Car> carList = serviceCar.findAll();
        for(Car car1 : carList){
            System.out.println(car1.getModel() + "  " + car1.getModelYear());
        }

    }
}
