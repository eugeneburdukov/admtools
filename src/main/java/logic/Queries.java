package logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries extends DbConnection{

    public String isConnected() {
        Connection connection = getConnection();
        if (connection != null) {
            return "Connection to the " + ConnectionDetails.databaseName + " database is successfull!";
        }

        return "Connection Error! Please review login details!";
    }

    public void createTableCar() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE `CAR` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `auto` varchar(255) NOT NULL,\n" +
                    "  `serialnumber` varchar(255) NOT NULL,\n" +
                    "  `purchasedate` datetime DEFAULT NULL,\n" +
                    "  `repairs` set('True', 'False') NOT NULL DEFAULT 'False',\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            statement.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableDriver() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE `DRIVER` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `secondname` varchar(255) NOT NULL,\n" +
                    "  `gender` set('Male', 'Female') NOT NULL DEFAULT 'Male',\n" +
                    "  `ticket` varchar(255) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            statement.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTablePayment() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE `PAYMENT` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `parkingspacenumber` float(10,2) DEFAULT '0.00',\n" +
                    "  `startdate` datetime DEFAULT NULL,\n" +
                    "  `enddate` datetime DEFAULT NULL,\n" +
                    "  `daysleft` int(10) unsigned DEFAULT NULL,\n" +
                    "  `totalleft` int(10) unsigned DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            statement.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropTable() {
        try {
            Statement statement = connection.createStatement();
            String sql = "DROP TABLE testtable";
            statement.execute(sql);
            System.out.println(sql + ";");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}