package JDBC_Hibernate.Intro.DAO.dao;

import JDBC_Hibernate.Intro.DAO.entity.Car;

import java.util.List;

public interface CarDAO {
    void add(Car car);

    Car findById(int id);

    void update(int id, String model);

    void deleteById(int id);

    List<Car> findAll();

}
