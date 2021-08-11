package logic;

import java.sql.*;

public class DbConnection {
    Connection connection;

    public Connection getConnection() {
        String driverName = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driverName); // here is the ClassNotFoundException
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String serverName = ConnectionDetails.SERVER_NAME;
        String databaseName = ConnectionDetails.DATABASE_NAME;
        String ignoreSSL = ConnectionDetails.VERIFY_SERVER_CERTIFICATE_FALSE_USE_SSL_TRUE;
        String url = "jdbc:mysql://" + serverName + "/" + databaseName + ignoreSSL;
        String username = ConnectionDetails.USERNAME;
        String password = ConnectionDetails.PASSWORD;
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}