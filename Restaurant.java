import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by ethankulman on 3/12/17.
 */
public class Restaurant {

    public static void main(String[] args) {

        Menu newMenu = new Menu();
        boolean isTrue = true;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Press 0 to add an item " +
                    "| Press 1 to view the menu " +
                    "| Press anything else to end");
            String userInput = scan.next();
            try {
                int userInputInt = Integer.parseInt(userInput);
                if (userInputInt == 0) {
                    newMenu.addItems();
                } else if (userInputInt == 1) {
                    newMenu.viewMenu();
                }
            } catch (NumberFormatException ex) {
                isTrue = false;
            }
        }
        while (isTrue);
        System.out.print("Thanks for creating a menu");
    }
}
