import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://centos7postgre:5432/mydbtest";
    static final String USER = "mydbuser";
    static final String PASS = "123456789";

    public static void main(String[] args) {
        System.out.println("HelloWorld JDBC");

        Connection connection;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

//        if (connection != null) {
//            System.out.println("You successfully connected to database now");
//        } else {
//            System.out.println("Failed to make connection to database");
//        }


    }
}
