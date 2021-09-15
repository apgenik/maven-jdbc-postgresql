import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static java.util.jar.Pack200.Packer.PASS;
import static org.postgresql.jdbc.EscapedFunctions.USER;

public class Main {

//    //  Database credentials
//    static final String DB_URL = "jdbc:postgresql://centos7postgre:5432/mydbtest";
//    static final String USER = "mydbuser";
//    static final String PASS = "123456789";

    public static void main(String[] args) {
//        System.out.println("HelloWorld JDBC");

        FileInputStream fileInputStream;
        Properties properties = new Properties();
        String db_url = null;
        String user = null;
        String pass = null;

        Connection connection;

        try {
            fileInputStream = new FileInputStream("src\\main\\resources\\config.properties");
            properties.load(fileInputStream);

            db_url = properties.getProperty("db.host");
            user = properties.getProperty("db.login");
            pass = properties.getProperty("db.password");
        }catch (IOException e){
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

        try {
            connection = DriverManager.getConnection(db_url, user, pass);

            Statement statement = connection.createStatement();
//            statement.execute("INSERT INTO users(name, lastname) VALUES ('Иван', 'Петров');");
//            statement.execute("INSERT INTO users(name, lastname) VALUES ('Сергей', 'Лопушков');");
            statement.addBatch("INSERT INTO users(name, lastname) VALUES ('Петр', 'Иванов');");
            statement.addBatch("INSERT INTO users(name, lastname) VALUES ('Илья', 'Муромец');");

            statement.executeBatch();
            statement.clearBatch();

            System.out.println(statement.isClosed());
            statement.close();
            System.out.println(statement.isClosed());

            connection.close();
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
