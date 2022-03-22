package util;

import java.sql.*;

public class DatabaseConnection {
    private static final String url = "jdbc:mysql://localhost:3306/my_org";
    private static final String username = "root";
    private static final String password = "Chaitanya@137";
    private static Connection connection = null;

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        if (connection == null) {
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to database server "
                    + connection.getMetaData().getDatabaseProductName()
                    + " version: "
                    + connection.getMetaData().getDatabaseProductVersion());
        }

        return connection;

    }

}
