package logic;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu extends DbConnection {
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Queries queries = new Queries();

        System.out.println(queries.isConnected() + " What would you like to do now? \n");

        int choose;

        do {
            System.out.println("""
                    Please enter:\s
                     1 - Create all the required tables,
                     2 - Insert data into all the tables,
                     3 - Select from tables,
                     4 - Record data into collections,
                     5 - JOIN tables,
                     6 - insert additional entries to books table,
                     0 - exit!""");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    queries.createTableAuthors();
                    queries.createTableBooks();
                    System.out.println();
                    break;
                case 2:
                    queries.insertIntoAuthors();
                    queries.insertIntoBooks();
                    System.out.println();
                    break;
                case 3:
                    queries.getSelectFromAuthors();
                    queries.getSelectFromBooks();
                    System.out.println();
                    break;
                case 4:
                    queries.getAuthorResult();
                    queries.getBookResult();
                    System.out.println();
                    break;
                case 5:
                    queries.getJoinTableResult();
                    System.out.println();
                    break;
                case 6:
                    queries.insertNewValuesIntoBooks();
                    System.out.println();
                    break;
                case 36:
                    queries.dropTable();
                    break;
                case 0:
                    System.out.println("See you next time!");
                    break;
                default:
                    System.out.println("Make a choice!");
            }
        } while (choose != 0);
    }
}
