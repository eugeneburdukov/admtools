package logic;

import java.util.Scanner;

public class Menu extends DbConnection {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Queries queries = new Queries();

        System.out.println(queries.isConnected() + " What would you like to do now? \n");

        int choose;

        do {
            System.out.println("Please enter: 1 - Create all the required tables," +
                    " 2 - Insert data into all the tables," +
                    " 3 - Select from tables," +
                    " 4 - Record data into collections," +
                    " 0 - exit!");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    queries.createTableAuthors();
                    queries.createTableBooks();
                    break;
                case 2:
                    queries.insertIntoAuthors();
                    queries.insertIntoBooks();
                    break;
                case 3:
                    queries.getSelectFromAuthors();
                    queries.getSelectFromBooks();
                    break;
                case 4:
                    queries.getAuthorResult();
                    queries.getBookResult();
                    break;
                case 0:
                    System.out.println("See you next time");
                    break;
                default:
                    System.out.println("Make a choice!");
            }
        } while (choose != 0);
    }
}
