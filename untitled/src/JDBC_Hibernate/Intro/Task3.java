package JDBC_Hibernate.Intro;

import java.sql.*;

public class Task3 {
    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            statement = connection.createStatement();
            ResultSet resultSet1 = statement.executeQuery("SELECT FLName_employee, phone_employee, address FROM employee\n" +
                    "INNER JOIN personal_info\n" +
                    "ON employee.employee_id = personal_info.personal_info_id");
            while (resultSet1.next()) {
                String nameEmployee = resultSet1.getString("FLName_employee");
                String phoneEmployee = resultSet1.getString("phone_employee");
                String addressEmployee = resultSet1.getString("address");
                System.out.println("Name employee: " + nameEmployee + ", phone employee: " + phoneEmployee + ", address employee: " + addressEmployee);
            }
            System.out.println("----------------------------------------------");
            ResultSet resultSet2 = statement.executeQuery("Select FLName_employee, date_of_birth, phone_employee From personal_info\n" +
                    "inner join employee\n" +
                    "ON personal_info.personal_info_id = employee.employee_id\n" +
                    "where not marital_status = 'married'");
            System.out.println("Unmarried employee:");
            while (resultSet2.next()) {
                String nameEmployee = resultSet2.getString("FLName_employee");
                String  dateOfBirth = resultSet2.getString("date_of_birth");
                String phoneEmployee = resultSet2.getString("phone_employee");
                System.out.println("Name: " + nameEmployee + ", phone: " + phoneEmployee + ", date of birth: " + dateOfBirth);
            }
            System.out.println("----------------------------------------------");
            ResultSet resultSet3 = statement.executeQuery("SELECT FLName_employee, date_of_birth, phone_employee From personal_info\n" +
                    "INNER JOIN employee\n" +
                    "ON personal_info.personal_info_id = employee.employee_id\n" +
                    "INNER JOIN position_salary\n" +
                    "ON personal_info.personal_info_id = position_salary.position_id\n" +
                    "WHERE position_employee like 'manager'");
            System.out.println("Manager employee:");
            while (resultSet3.next()) {
                String nameEmployee = resultSet3.getString("FLName_employee");
                Date dateOfBirth = resultSet3.getDate("date_of_birth");
                String phoneEmployee = resultSet3.getString("phone_employee");
                System.out.println("Name: " + nameEmployee + ", phone: " + phoneEmployee + ", date of birth: " + dateOfBirth);
            }
            System.out.println("----------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
