package lab8;

import java.net.URL;
import java.sql.*;

public class BazaDate {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/lab8";
    private static final String USER = "root";
    private static final String PASSWORD = "0305";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
