package logic;

import java.util.Scanner;

public class Start extends DbConnection{
    public void go(){
        Scanner scanner = new Scanner(System.in);
        Queries queries = new Queries();

        System.out.println("Hello Sir! Please enter you name:");
        String userName = scanner.next();
        System.out.println("Dear " + userName + ", " + queries.isConnected());
        System.out.println("What would you like to do now?");

        int choose;

        do {
            System.out.println("\n" + userName + ", please enter: 1 - Create CAR, 2 - Create DRIVER, 0 - exit!");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    queries.createTableCar();
                    break;
                case 2:
                    queries.createTableDriver();
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
