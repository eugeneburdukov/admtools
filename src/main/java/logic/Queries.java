package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Queries extends DbConnection {

    public String isConnected() {
        Connection connection = getConnection();
        if (connection != null) {
            return "Connection to the '" + ConnectionDetails.serverName + "' host was successfull!";
        }

        return "Connection Error! Please review login details!";
    }

    public void createTableAuthors() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE `authors` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` varchar(45) NOT NULL,\n" +
                    "  `country` varchar(20) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4";
            statement.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTableBooks() {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE `books` (\n" +
                    "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                    "  `title` varchar(45) NOT NULL,\n" +
                    "  `author` int NOT NULL,\n" +
                    "  `notes` varchar(45) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  KEY `author_idx` (`author`),\n" +
                    "  CONSTRAINT `author` FOREIGN KEY (`author`) REFERENCES `authors` (`id`)\n" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4";
            statement.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoAuthors() {
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into authors(name, country) values\n" +
                    "('Schieldt','USA'),\n" +
                    "('PhenemoreCooper','USA'),\n" +
                    "('Shevchenko','Ukraine');";
            statement.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertIntoBooks() {
        try {
            Statement statement = connection.createStatement();
            String sql = "insert into books(title, author, notes) values\n" +
                    "('Java8',1,NULL),\n" +
                    "('LastofMohicans ',2,NULL),\n" +
                    "('Kobzar',3,NULL);";
            statement.executeUpdate(sql);
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getSelectFromAuthors() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select id, name, country from authors;";
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            while (result.next()) {
                String id = result.getString("id");
                String name = result.getString("name");
                String country = result.getString("country");
                System.out.println(id + ", " + name + ", " + country);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getSelectFromBooks() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select id, title, author, notes from books;";
            ResultSet result = statement.executeQuery(sql);
            System.out.println(sql);
            while (result.next()) {
                String id = result.getString("id");
                String title = result.getString("title");
                String author = result.getString("author");
                String notes = result.getString("notes");
                System.out.println(id + ", " + title + ", " + author + ", " + notes);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAuthorResult() {
        ArrayList<Author> authors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * FROM authors";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                authors.add(new Author(result.getInt(1), result.getString(2), result.getString(3)));
            }
            System.out.println(sql + ";");
            for (Author e : authors) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getBookResult() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String sql = "select * FROM books";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                books.add
                        (new Book(result.getInt(1), result.getString(2),
                                result.getString(3), result.getString(4)));
            }
            System.out.println(sql + ";");
            for (Book e : books) {
                System.out.println(e);
            }
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

    public void getTest() {
        ArrayList<Book> newBooks = new ArrayList<>();
        newBooks.add(new Book("Journey to the Center of the Earth", "Jules Verne", "new"));
        newBooks.add(new Book("1984", "George Orwell", "new"));
        newBooks.add(new Book("War & Peace", "Leo Tolstoy", "one of the greatest authors of all time"));
        newBooks.add(new Book("Sherlock Holmes","Arthur Conan Doyle","read"));

        System.out.println(newBooks);
    }

    public void dropTable() {
        try {
            Statement statement = connection.createStatement();
            String sqlBooks = "DROP TABLE books";
            String sqlAuthors = "DROP TABLE authors";
            statement.execute(sqlBooks);
            statement.execute(sqlAuthors);
            System.out.println(sqlBooks + ";\n" + sqlAuthors + "\nTables books and authors have been removed!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}