package JDBC_Hibernate.Intro;

import java.sql.*;

public class ExtraTask {

    private static final String URL = "jdbc:mysql://localhost:3306/testbase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

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
ResultSet resultSet = statement.executeQuery("SELECT * FROM testtable");
while (resultSet.next()) {
    System.out.println(resultSet.getString("name") + " " + resultSet.getString("surname") + " " +resultSet.getInt("age") );
}
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


}
