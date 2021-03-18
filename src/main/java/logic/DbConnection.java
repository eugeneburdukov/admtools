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

        //mysql -h'avf01.mysql.tools' -u'avf01_library' -p'C96%6-Ljbk' avf01_library
        String serverName = ConnectionDetails.serverName;
        String databaseName = ConnectionDetails.databaseName;
        String ignoreSSL = ConnectionDetails.ignoreSSL;
        String url = "jdbc:mysql://" + serverName + "/" + databaseName + ignoreSSL;
        String username = ConnectionDetails.username;
        String password = ConnectionDetails.password;
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}