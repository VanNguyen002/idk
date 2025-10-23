//Driver files
import java.util.Scanner;
/**
 * @Author VanNguyen
 * Date 10/22/2025
 * Purpose: This is the driver file, for super class and subclass for Wilmington Quick Shop,
 * The name of this file will be WQSLastName1LastName2
 * Each class from the bottom level of hierarchy and implement a solution to the following problem.
 * The solution will use Polymorphism, identify where it is in the program.
 *
 * 1st ask the user if they want to sell an item or add an item in the inventory
 */

/**
 * 1st I need to create array list to store everything on it!
 *
 */
public class Main {
    public static void main(String[] args) {
//Create an array of BoxStore Object
        BoxStore[] StoreItems = new BoxStore[11];
        //FoodItem - Fruits
        StoreItems[0] = new Fruit("Apple", "FoodLion", 1001, 1,
                5.00, 6.4, 0.00, "2025-10-28", "1 piece", 95, 10, 3.2, "Fall");
            // Vegetable
        StoreItems[1] = new Vegetables("Broccoli","FoodLion",1001,1,
                7.00,6.6, 0.10,"2025-10-28","1 each",20,10,
                "Vitamin C","bland");
            // SelfStable
        StoreItems[2] = new ShelfStable("Pasta","Nestle",1003,1,8.00,1.0,0.05,"2027-10-28",
                "2 OZ dry",50,72.0,"Cardboard box","2025-10-22");

        //Household Items - Furniture
        StoreItems[3] = new Furniture("Sofa","Costco",2001,1,890.96,250.10,0.10,"Leather Sofa","Living room",
                false,"Sofa","84x35x34 inches");
            //Cleaning Supply
        StoreItems[4] = new CleaningSupply("Glass cleaner","Walmart",2002,1,15.60,2.10,0,
                "Sparkle Clean","Car Windshield", false,"Glass", true);
        // ElectronicItems - TV
        StoreItems[5] = new TV("OLED C5", "LG", 3001, 15, 1799.99, 35.0, 0.12,
                "webOS", "OLED", "2 years", 20240701, 48.0, 65.0);
            //Phone
        StoreItems[6] = new Phone("iPhone 17", "Apple", 3002, 20, 999.99, 0.38, 0.05,
                "iOS 17", "OLED", "1 year", 20240901, 128, "A17 Pro", "48MP");
            //Laptop
        StoreItems[7] = new Laptop("MacBook Air", "Apple", 3003, 8, 1499.99, 2.7, 0.05,
                "macOS", "Retina", "1 year", 20241001, 8, 60, "Apple M5", "Apple M5");
        // Clothing Item
        StoreItems[8] =  new Outerwear("Winter Jacket", "North Peak", 4001, 25, 149.99, 2.5, 0.20,
                "L", "Black", "Unisex", "Polyester/Down", "Premium");
        StoreItems[9] = new Shoe("Running Shoes", "Nike", 4002, 40, 89.99, 1.2, 0.15,
                "US 10", "Black/Red", "Unisex", "Athletic", "Running", 10.0);
        StoreItems[10] = new Shirt("Polo Shirt", "CasaBlanca", 3002, 50, 34.99, 0.35, 0.10,
                "L", "White", "Men", "Slim", "Polo");

    Scanner input = new Scanner(System.in);
    boolean running = true;

        System.out.println("======================================");
        System.out.println(" Welcome to the Wilmington Work Shop");
        System.out.println("======================================");

        while (true) {
            System.out.println("1. Add an Item");
            System.out.println("2. Sell an Item");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.println("Enter Your Choice ");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            System.out.println("You choose 1");
        }
        else if (choice == 2) {
            System.out.println("You choose 2");
        }
        else if (choice == 3) {
            System.out.println("You choose 3");
        }
        else {
            System.out.println("Invalid option");
        }

        }

    }

}