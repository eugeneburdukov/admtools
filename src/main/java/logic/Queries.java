package logic;

import java.sql.*;
import java.util.ArrayList;

public class Queries extends DbConnection {

    public String isConnected() {
        Connection connection = getConnection();
        if (connection != null) {
            return "Connection to the '" + ConnectionDetails.SERVER_NAME + "' host was successfull!";
        }

        return "Connection Error! Please review login details!";
    }

    public void getSelectFromActor() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select ActorID, Name, Midlename, Surname, YearOfBirth, CountryKey from Actor;";
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            while (result.next()) {
                String ActorID = result.getString("ActorID");
                String Name = result.getString("Name");
                String MiddleName = result.getString("Midlename");
                String Surname = result.getString("Surname");
                String YearOfBirth = result.getString("YearOfBirth");
                String CountryKey = result.getString("CountryKey");
                System.out.println(ActorID + ", " + Name + ", " + MiddleName + ", " + Surname + ", " + YearOfBirth + ", "
                        + CountryKey);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getActorList() {
        ArrayList<Actor> actors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from Actor";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                actors.add(new Actor(result.getString(1), result.getString(2),
                        result.getString(3), result.getString(4),
                        result.getInt(5), result.getInt(6)));
            }
            System.out.println(sql + ";");
            for (Actor e : actors) {
                System.out.println(e);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertValuesIntoActor() {
        ArrayList<Actor> newActors = new ArrayList<>();
        newActors.add(new Actor(null, "Johnny", "Christopher", "Depp", 1963,
                150));

        String sql = "insert into Actor(ActorID, Name, MidleName, Surname, YearOfBirth, CountryKey)"
                + " values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (Actor e : newActors) {
                preparedStatement.setString(1, e.ActorID);
                preparedStatement.setString(2, e.Name);
                preparedStatement.setString(3, e.MiddleName);
                preparedStatement.setString(4, e.Surname);
                preparedStatement.setInt(5, e.YearOfBirth);
                preparedStatement.setInt(6, e.CountryKey);
                preparedStatement.execute();
            }
            System.out.println("Additional Records have been successfully inserted, it might be checked by option 4");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getLastFromActor() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select ActorID, Name, Midlename, Surname, YearOfBirth, CountryKey from Actor order by ActorID" +
                    " desc limit 1;";
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            while (result.next()) {
                String ActorID = result.getString("ActorID");
                String Name = result.getString("Name");
                String MiddleName = result.getString("Midlename");
                String Surname = result.getString("Surname");
                String YearOfBirth = result.getString("YearOfBirth");
                String CountryKey = result.getString("CountryKey");
                System.out.println(ActorID + ", " + Name + ", " + MiddleName + ", " + Surname + ", " + YearOfBirth + ", "
                        + CountryKey);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFromActor() {
        try {
            Statement statement = connection.createStatement();
            String sql = "delete from Actor where Name = 'Johnny' and Surname = 'Depp';";
            System.out.println(sql);
            statement.executeUpdate(sql);
            System.out.println("Johnny Depp records do not exist any more, it might be checked by option 1");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getJoinTableResult() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select books.title, authors.name " +
                    "from authors join books on books.author = authors.id where authors.country = 'UKRAINE'";
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql + ";");
            while (result.next()) {
                String title = result.getString("title");
                String name = result.getString("name");

                System.out.println(" | " + title + " | " + name + " | ");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}