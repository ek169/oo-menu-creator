import java.util.Date;
import java.util.Scanner;


/**
 * Created by ethankulman on 3/12/17.
 */
public class Restaurant {

    public static void main(String[] args) {
        Menu newMenu = new Menu();
        boolean isTrue = true;
        Date lastItemAdded = new Date();
        Date updateTime = new Date();
        newMenu.setTimeCreated(updateTime);

        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Press 0 to add an item " +
                    "| Press 1 to view the menu " +
                    "| Press 2 to search for an item" +
                    "| Press 3 to delete an item" +
                    "| Press anything else to end");
            String userInput = scan.next();
            try {
                int userInputInt = Integer.parseInt(userInput);
                if (userInputInt == 0) {
                    newMenu.addItems();
                    lastItemAdded = new Date();
                } else if (userInputInt == 1) {
                    if(lastItemAdded.after(updateTime)) {
                        updateTime = new Date();
                        newMenu.setTimeCreated(updateTime);
                    }
                    newMenu.viewMenu();
                } else if (userInputInt == 2) {
                    newMenu.searchMenu();
                } else if(userInputInt == 3){
                    boolean isDeleted = newMenu.deleteItem();
                    if(isDeleted){
                        System.out.println("Item was deleted");
                        lastItemAdded = new Date();
                    }else {
                        System.out.println("No item was found");
                    }
                }
        } catch(NumberFormatException ex){
                isTrue = false;
            }
        }
        while (isTrue);
        System.out.print("Thanks for creating a menu");
    }
}
