package logic;

import java.sql.Connection;
import java.sql.ResultSet;
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

    public void insertIntoTableCar() {
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into CAR(id, auto, serialnumber, purchasedate, repairs) values\n" +
                    "('01','BMV','','2020-11-24','True'),\n" +
                    "('02','Maserati','','2005-03-22','False'),\n" +
                    "('03','Lexus','','1995-03-25','True'),\n" +
                    "('04','Dacia','','1987-09-03','True'),\n" +
                    "('05','Mitsubishi','','1992-12-02','True'),\n" +
                    "('06','Cadillac','','2001-07-30','False'),\n" +
                    "('07','Jeep','','2012-12-17','False'),\n" +
                    "('08','Mercedes-Benz','','1972-04-10','False'),\n" +
                    "('09','Volvo','','1999-01-11','False'),\n" +
                    "('10','Volkswagen','','2008-09-06','False'),\n" +
                    "('11','Audi','','2021-01-16','True'),\n" +
                    "('12','Mazda','','1995-03-08','False');";
            statement.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getSelectFromCAR() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select id, auto, serialnumber, purchasedate, repairs from CAR;";
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            while (result.next()) {
                String id = result.getString("id");
                String auto = result.getString("auto");
                String serialnumber = result.getString("serialnumber");
                String purchasedate = result.getString("purchasedate");
                String repairs = result.getString("repairs");
                System.out.println(id + ", " + auto + ", '" + serialnumber + "', " + purchasedate + ", " + repairs);

            }
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