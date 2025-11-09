package JDBC_Hibernate.Intro;

import java.sql.*;

public class ExtraTask {

    private static final String URL = "jdbc:mysql://localhost:3306/testbase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        registeredDriver();

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.execute("INSERT INTO testtable(name, surname) VALUES ('petro', 'olexandrovich')");
            statement.execute("SELECT * FROM testtable");
            statement.execute("UPDATE testtable SET age = 25 WHERE name = 'petro'");
            statement.execute("SELECT * FROM testtable");
//            statement.execute("DELETE FROM testtable WHERE name = 'petro'");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void registeredDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
