import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.String;
import java.util.Scanner;
import java.util.Date;


public class Menu {

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    private Map<String, ArrayList<MenuItem>> MenuItems = new HashMap<>();

    private Date timeOfCreated;

    public void setTimeCreated(Date aTime) {
        timeOfCreated = aTime;
    }

    public Date getTimeCreated() { return this.timeOfCreated; }

    public void viewMenu(){
        String isNewItem = " ";
        System.out.println("Menu");
        System.out.println("---");
        for(Map.Entry<String, ArrayList<MenuItem>> entry : MenuItems.entrySet()){
            System.out.println(entry.getKey());
            for(MenuItem item : entry.getValue()){
                if(item.getDateCreated().after(this.getTimeCreated())){
                    isNewItem = "(new)";
                }
                System.out.println("---");
                System.out.println(item.getName() + " - " + item.getDescription() + " - $" + item.getPrice() + " " + isNewItem);
            }
            System.out.println(" ");

        }
        System.out.println("Last update was " + dateFormat.format(getTimeCreated()));
        System.out.println(" ");


    }
    public void searchMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to look for?");
        String searchItem = scan.nextLine().toLowerCase();
        for(Map.Entry<String, ArrayList<MenuItem>> entry : MenuItems.entrySet()){
            for(MenuItem item: entry.getValue()){
                if(item.getName().toLowerCase().contains(searchItem)){
                    System.out.println(item.getName() + " - " + item.getDescription() + " - $" + item.getPrice());
                }
            }
        }
    }


    public void addItems(){
        Scanner scan = new Scanner(System.in);
        MenuItem item = new MenuItem();
        boolean notInt = true;
        int priceNum;

        System.out.println("What is the name of the item?");
        String name = scan.nextLine();
        item.setName(name);
        do {
            System.out.println("What is the price of the item?");
            String price = scan.nextLine();
                try {
                    priceNum = Integer.parseInt(price);
                    if (priceNum > 0) {
                        item.setPrice(priceNum);
                        notInt = false;

                    }
                } catch (NumberFormatException ex) {
                    System.out.println("You must input a number");
                }
            } while(notInt);


        System.out.println("What is the description?");
        String description = scan.nextLine();
        item.setDescription(description);

        System.out.println("What is the category of the item?");
        String category = scan.nextLine();
        item.setCategory(category);

        if(MenuItems.get(category) != null){
            ArrayList<MenuItem> existingCat = MenuItems.get(category);
            existingCat.add(item);
            MenuItems.put(category, existingCat);
        }
        else{
            ArrayList<MenuItem> newCat = new ArrayList<>();
            newCat.add(item);
            MenuItems.put(category, newCat);
        }

        Date itemCreated = new Date();
        item.setDateCreated(itemCreated);

    }

    public boolean deleteItem() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What would you like to delete?");
        String searchItem = scan.nextLine().toLowerCase();
        for (Map.Entry<String, ArrayList<MenuItem>> entry : MenuItems.entrySet()) {
            for (MenuItem item : entry.getValue()) {
                if (item.getName().toLowerCase().contains(searchItem)) {
                    entry.getValue().remove(item);
                    if(entry.getValue().isEmpty()) {
                        MenuItems.keySet().remove(entry.getKey());
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
