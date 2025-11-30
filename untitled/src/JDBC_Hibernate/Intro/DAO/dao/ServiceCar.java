package JDBC_Hibernate.Intro.DAO.dao;

import JDBC_Hibernate.Intro.DAO.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceCar implements CarDAO {
    @Override
    public void add(Car car) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO car(model, modelYear) VALUES ( ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, car.getModel());
            pstmt.setInt(2, car.getModelYear());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                car.setIdCar(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car findById(int id) {
        try (Connection connection = getConnection();
             PreparedStatement prstm = connection.prepareStatement("SELECT id, model, modelYear FROM car WHERE id = ?")) {
            prstm.setInt(1, id);
            ResultSet rs = prstm.executeQuery();
            if (rs.next()) {

                Car car = new Car();
                car.setIdCar(rs.getInt(1));
                car.setModel(rs.getString(2));
                car.setModelYear(rs.getInt(3));
                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(int id, String model) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE car SET model = ? WHERE id = ?")) {

            pstmt.setInt(1, id);
            pstmt.setString(2, model);


            int updatedValues = pstmt.executeUpdate();
            System.out.println("Values updated: " + updatedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "DELETE FROM car WHERE id = ?")) {
            pstmt.setInt(1, id);
            int deletedValues = pstmt.executeUpdate();
            System.out.println("Values deleted: " + deletedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> findAll() {
       List<Car> carList = new ArrayList();
       try(Connection conn = getConnection();
           PreparedStatement pstmt = conn.prepareStatement(
                   "SELECT id, model, modelYear FROM car")) {
          ResultSet rs = pstmt.executeQuery();
          while (rs.next()) {

              Car car = new Car();
              car.setIdCar(rs.getInt(1));
              car.setModel(rs.getString(2));
              car.setModelYear(rs.getInt(3));
              carList.add(car);
          }

       } catch (SQLException e) {
           e.printStackTrace();
       }
       return carList;
    }

    private Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/car?useSSL=false";
            String user = "root";
            String password = "root";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
