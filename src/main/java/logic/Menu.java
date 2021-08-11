package logic;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu extends DbConnection {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Queries queries = new Queries();

        System.out.print(queries.isConnected() + " What would you like to do now? \n");

        int choose;

        do {
            System.out.println("""
                    \nPlease choose:\s
                     1 - Select data from Actor table,
                     2 - Select data from Actor table & insert to actors ArrayList,
                     3 - insert Johny Depp to Actor table,
                     4 - select the latest entry from Actor table,
                     5 - delete Johny Depp records from Actor
                     0 - exit!\n""");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    queries.getSelectFromActor();
                    break;
                case 2:
                    queries.getActorList();
                    break;
                case 3:
                    queries.insertValuesIntoActor();
                    break;
                case 4:
                    queries.getLastFromActor();
                    break;
                case 5:
                    queries.deleteFromActor();
                    break;
                case 0:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Make a choice!");
            }
        } while (choose != 0);
    }
}
