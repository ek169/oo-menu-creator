import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Menu {

    private Map<String, ArrayList<MenuItem>> MenuItems = new HashMap<>();

    public void viewMenu(){
        System.out.println("Menu");
        System.out.println("---");
        for(Map.Entry<String, ArrayList<MenuItem>> entry : MenuItems.entrySet()){
            System.out.println(entry.getKey());
            for(MenuItem item : entry.getValue()){
                System.out.println("---");
                System.out.println(item.getName() + " - " + item.getDescription() + " - $" + item.getPrice());
            }
            System.out.println(" ");
        }
        System.out.println(" ");


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





    }
}
