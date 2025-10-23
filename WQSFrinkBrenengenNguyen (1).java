import java.util.ArrayList;
import java.util.Scanner;

public class WQSFrinkBrenengenNguyen {

    public static void main(String[] args) {

        // FoodItem Objects
        ShelfStable ss1 = new ShelfStable("Heinz Baked Beans","Heinz", 5.99, 339, "Teal", 2026, "Can");
        Fruit fr1 = new Fruit("Coquita","Cavendish Banana", 0.98, 112, "Yellow", 2025, "Crescent");
        Vegetable vg1 = new Vegetable("Yukon Potato","Markus Farms", 1.08, 981, "Brown", 2018, "Underground");

        // ElectronicsItem Objects
        TV tv1 = new TV("TV", "Ruko", 999.99, 468, 60.5,  64, "4K");
        Laptop lt1 = new Laptop("Laptop", "PH", 1299.99, 463, 14.5, 256, "USB");
        Phone po1 = new Phone("Phone", "Pear", 899.99, 183, 8.0, 64, "Horizon");

        // ClothingItem Objects
        Outerwear ow1 = new Outerwear("Jacket", "Godal", 35.99, 562, "XL", "Leather");
        Shoe sh1 = new Shoe("Tennis Shoes", "Bounz", 25.99, 181, "10", "Platform");
        Shirt si1 = new Shirt("T-shirt", "Loft", 13.99, 862, "S", "Loose");

        // HouseholdItem objects
        CleaningSupply cs1 = new CleaningSupply("Hardwood Floor Cleaner", "Aunt Fannie's", 14.97, 201, "For wood floors", "Wood");
        Furniture fn1 = new Furniture("Corner Couch", "Ikeon", 499.99, 198, "Perfect for corners!", "Couch");

        // Inventory (polymorphism: one list, many subclasses)
        ArrayList<StoreItem> inventory = new ArrayList<>();
        inventory.add(ss1); inventory.add(fr1); inventory.add(vg1);
        inventory.add(tv1); inventory.add(lt1); inventory.add(po1);
        inventory.add(ow1); inventory.add(sh1); inventory.add(si1);
        inventory.add(cs1); inventory.add(fn1);

        // call the main menu to start interaction and give options for program
        userInt(inventory);
    }
    /**
     * Main menu, shows options and allows user to go there
     * @param inventory (the big list that holds all items information)
     */
    public static void userInt(ArrayList<StoreItem> inventory) {

        //prints a list of options and a place for the user to choose what number action they would like to do
        System.out.println("\nWelcome to Wilmington Quick Stop!");
        System.out.println("1 - Add item");
        System.out.println("2 - Display Inventory");
        System.out.println("3 - Sell item");
        System.out.println("0 - Exit");
        System.out.print("Choice: ");

        // Make a Scanner to read a number from user input.
        Scanner inp = new Scanner(System.in);
        int choice = inp.nextInt();     // read the number the user typed (like 1 or 2)
        inp.nextLine();                 // clear leftover newline

        // use if/else to branch based on the user's choice
        // choice 1 of addInventory(inventory) brings user to method that allows them to add items
        // userInt(inventory) returns the user to the main menu when they are done with adding items
        if (choice == 1) {addInventory(inventory); userInt(inventory);}

        // choice 2 of displayInventory(inventory) brings user to the method that displays the inventory
        //userInt(inventory) returns the user to the main menu when they are done with adding items
        else if (choice == 2) {displayInventory(inventory); userInt(inventory);}

        // choice 3 of sellInventory(inventory) brings user to the method to sell an item
        else if (choice == 3) {sellInventory(inventory);userInt(inventory);}

        //choice 0 when user chooses to exit the program
        //prints a goodbye message and then leaves the program
        else if (choice == 0) {
            System.out.println("Goodbye!");}

        //if the user puts in a number outside 0-3, print invalid message
        else {
            System.out.println("ERROR: INVALID INPUT! Please select a number from the menu");
            //returns the user to the main menu so they can put in a correct number
            userInt(inventory);
        }

    }

    /**
     * Option 1: This method lets the user add new or existing items to the store’s inventory list.
     * @param inventory (the big list that holds all items information)
     */
    private static void addInventory(ArrayList<StoreItem> inventory) {

        // Make a Scanner to read a number from user input.
        Scanner inp = new Scanner(System.in);
        // creates a parameter for the program to keep looping or stop (if 1 repeats, if not stops)
        int again = 1;

        // while the program is repeating until the user chooses to stop.
        while (again == 1) {

            // A message asking user to read the items listed
            String title = "\nWhat type of item would you like to add?";

            // Call CategoryOptions method to shows the category menu and returns the number they picked.
            // When the user enters a valid number, that method returns an integer
            // Store that integer inside a variable named catNum
            int catNum = CategoryOptions(inp, title);

            // This method looks through the inventory list, filters items by the selected category number (catNum),
            // then prints them with their current stock counts

            // Call showCategoryWithStock method to show current items with stock counts in that chosen category
            // This helps the user see stock in inventory before they add more
            showCategoryWithStock(inventory, catNum);

            // Provide user 2 options kind of adding (add to existing items or create brand-new item)
            System.out.println("\nOptions:");
            System.out.println("1) Add more of an existing item");
            System.out.println("2) Create a NEW item");
            System.out.print("Pick 1 or 2: ");

            // Make a Scanner to read a number from user input.
            int opt = inp.nextInt();    // read user option (should be 1 or 2)
            inp.nextLine();             // clear leftover newline

            // OPTION 1 -  add quantity to an existing item
            if (opt == 1) {

                // Call categoryStock method - bring a summary list of all items in the chosen category.
                // Each Row includes the first index, SKU number, and total stock count of each item.
                ArrayList<Row> rows = CategoryRow(inventory, catNum);

                // Ask for user input number of which row should we add stock to?
                System.out.print("Enter the row # to add: ");

                // Make a Scanner to read a number from user input.
                int row = inp.nextInt();    // read their row number
                inp.nextLine();             // clear newline

                // Validate that the row number is the one of the printed rows.
                if (row < 1 || row > rows.size()) {
                    System.out.println("Invalid row #."); // If row number of range, tell user of the invalid.

                // when user pick the row that happened in the printed rows
                } else {
                    // From the list called rows, get the item at the position that is one less than the number the user typed.
                    // Save that Row object into a variable named pickedRow.
                    Row pickedRow = rows.get(row - 1);  // Java lists start counting at 0,

                    // After program know which row the user picked, it looks inside the big inventory list (of StoreItems)
                    // Find the actual product in the inventory that matches the row the user chose, stores it in a variable named picked.
                    StoreItem picked = inventory.get(pickedRow.firstIndex);

                    // Ask user about the quantity they want to add
                    System.out.print("How many to add? ");

                    // Make a Scanner to read a number from user input.
                    int qty = inp.nextInt(); // Read the quantity the user wants to add.
                    inp.nextLine();          // Clear newline

                    // Validate the quantity (adding 0 or negative is not allowed).
                    if (qty <= 0) {
                        System.out.println("Quantity must be positive.");

                    // If the user entered a valid quantity
                    } else {
                        // Create a counter variable i that starts at 0
                        // The loop will run qty times, adding that copies of the selected item.
                        for (int i = 0; i < qty; i++) {
                            inventory.add(picked);  // add one copy of the chosen item each time the loop runs
                        }

                        // Tell the user what we added, including the SKU for clarity.
                        System.out.println("Added: " + picked.getBrand() + " (SKU " + picked.getSkuNumber() + ") x" + qty);
                    }
                }

            // OPTION 2 - create a brand-new item
            } else if (opt == 2) {

                // Call the createNewItem method to make a brand-new product
                // This method asks the user for details (like name, price, and type) based on the chosen category.
                // The new item it creates is then stored in a variable called created.
                StoreItem created = createNewItem(inp, catNum);

                // If the user selected a valid subtype and everything was entered, we get a non-null object.
                if (created != null) {  //(learned using null from outside source)

                    // Put that brand-new item into the inventory so it now shows up in displays and stock counts.
                    inventory.add(created);

                    // Display to user what we created following the Brand and SKU
                    System.out.println("Created new: " + created.getBrand() + " (SKU " + created.getSkuNumber() + ")");

                    // Call showCategoryWithStock method
                    // show existing items and new items with stock counts in that chosen category
                    showCategoryWithStock(inventory, catNum);
                }

            // Let user know when their input other than 1 or 2
            } else {
                System.out.println("Invalid option.");
            }

            // Ask if user want to continue (1) or stop (0)
            System.out.print("\nAdd more items? (1=Yes, 0=No): ");

            // Make a Scanner to read a number from user input.
            again = inp.nextInt();  // Read the user’s int input and store it in again.
            inp.nextLine();         // clear newline

            // Show the updated list of items in this category after any changes.
            showCategoryWithStock(inventory, catNum);   // Call showCategoryWithStock method
        }
    }

    /**
     * CategoryOptions method to show 1–4 category with a title
     * Uses a validation loop until the user enters a valid number.
     * When a valid choice is entered, it returns that number to the main program.
     * @param sc read user input from Scanner
     * @param title show as a title string
     * @return catNum (int)
     */
    private static int CategoryOptions(Scanner sc, String title) {
        // Creates a variable named catNum to store the user’s choice
        // It starts at 0 so the loop can begin (since 0 is not between 1 and 4)
        int catNum = 0;

        // keep looping as the user's choice is not between 1 and 4.
        while (catNum < 1 || catNum > 4) {
            System.out.println(title);
            System.out.println("1) Food");
            System.out.println("2) Electronics");
            System.out.println("3) Clothing");
            System.out.println("4) Household");
            System.out.print("Enter 1-4: ");

            // Make a Scanner to read a number from user input.
            catNum = sc.nextInt();  // read integer choice and save it in catNum
            sc.nextLine();          // clear leftover newline

            // If the user typed out range, show a message and loop again.
            if (catNum < 1 || catNum > 4)
                System.out.println("Please enter 1–4.");
        }

        // When the loop ends, the user has entered a valid number (1–4).
        // Return that number to the part of the program that called this method.
        return catNum;
    }


    // (showCategoryWithStock method with the help from outside source)
    /**
     * showCategoryWithStock displays all items in the selected category with a header and info with their stock count.
     * @param inventory (full list of StoreItem objects)
     * @param catNum (the Number CategoryOptions method return, representing which category to display)
     */
    private static void showCategoryWithStock(ArrayList<StoreItem> inventory, int catNum) {

        // Use label to hold the category title
        String label;

        // Set the label based on the category number the user chose.
        if (catNum == 1)      label = "Food";
        else if (catNum == 2) label = "Electronics";
        else if (catNum == 3) label = "Clothing";
        else                  label = "Household";

        // Print the header for the category number the user chose.
        System.out.println("\n[" + label + " Inventory]");

        // Table
        System.out.printf("%-3s%-20s%-17s%-10s%-10s%-8s%n",
                "#", "Name", "Brand", "Price", "SKU", "Stock");

        // Build a short summary list for this category.
        ArrayList<Row> rows = CategoryRow(inventory, catNum);

        // Print each row
        for (int i = 0; i < rows.size(); i++) {
            Row r = rows.get(i);
            StoreItem product = inventory.get(r.firstIndex);

            // Row#: Name, Brand, Price, SKU, Stock
            System.out.printf("%-3d%-20s%-17s$%-9.2f%-10d%-8d%n",
                    (i + 1),                 // row number
                    product.getName(),       // Name
                    product.getBrand(),      // Brand
                    product.getPrice(),      // Price
                    r.sku,                   // SKU
                    r.count                  // Stock
            );
        }

        // If nothing to show, return
        if (rows.isEmpty()) {
            System.out.println("(No items in this category.)");
            return;
        }
    }

    // Outside source (I'll look over again)
    private static ArrayList<Row> CategoryRow(ArrayList<StoreItem> inv, int catNum) {
        ArrayList<Row> rows = new ArrayList<>();      // this will store the table rows we print
        ArrayList<Integer> seen = new ArrayList<>();  // SKUs we already handled

        // Look through the entire inventory list from start to finish.
        for (int i = 0; i < inv.size(); i++) {
            StoreItem it = inv.get(i);               // Item at position i in the list

            if (!matchesCategory(it, catNum)) continue;

            int sku = it.getSkuNumber();             // Ask the item for its SKU code (unique ID)

            // If we already added a row for this SKU, skip—no need to duplicate rows.
            if (seen.contains(sku)) continue;

            // If we get here, this is the first time we've encountered this SKU (in this category).
            // We must count how many total copies of this SKU exist across the ENTIRE inventory list.
            int count = 0;                           // Start from 0
            for (int j = 0; j < inv.size(); j++) {   // Check every inventory slot
                if (inv.get(j).getSkuNumber() == sku) {
                    count++;                         // Add 1 each time we find the same SKU
                }
            }
            rows.add(new Row(i, sku, count));

            // Mark this SKU as "seen" so we don't create another row for it later.
            seen.add(sku);
        }

        // Return the list of summary rows back to whoever called us.
        return rows;                                // give back the list of rows
    }

    private static class Row {
        int firstIndex; // position in the inventory list where the first copy of this SKU appears
        int sku;        // the unique SKU code for the product
        int count;      // how many copies of this SKU are currently in inventory

        Row(int firstIndex, int sku, int count) { // Constructor to set up a Row quickly
            this.firstIndex = firstIndex;         // initialize the "firstIndex" field
            this.sku = sku;                       // initialize the "sku" field
            this.count = count;                   // initialize the "count" field
        }
    }

    private static boolean matchesCategory(StoreItem it, int catNum) {
        if (catNum == 1) return it instanceof FoodItem;
        if (catNum == 2) return it instanceof ElectronicsItem;
        if (catNum == 3) return it instanceof ClothingItem;
        return it instanceof HouseholdItem; // catNum == 4
    }

    // OPT 2: CREATE NEW ITEM (asks questions based on the chosen category and returns the new object)
    /**
     * Builds a brand-new item by asking the user for details.
     * @param sc  Scanner used for user input
     * @param cat Category number (1=Food, 2=Electronics, 3=Clothing, 4=Household)
     * @return the new StoreItem (or null if the user picked an invalid subtype)
     */
    private static StoreItem createNewItem(Scanner sc, int cat) {

        // CATEGORY 1: FOOD
        if (cat == 1) {
            System.out.println("\nNew Food subtype: 1) ShelfStable  2) Fruit  3) Vegetable");
            System.out.print("Pick 1-3: ");
            int t = sc.nextInt();
            sc.nextLine(); // clear newline

            // Shared Food fields
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Brand: ");
            String brand = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("SKU (int): ");
            int sku = sc.nextInt();
            sc.nextLine();

            System.out.print("Color: ");
            String color = sc.nextLine();

            System.out.print("Exp Year (int): ");
            int exp = sc.nextInt();
            sc.nextLine();

            // Subtype-specific fields + object creation
            if (t == 1) { // ShelfStable
                System.out.print("Container: ");
                String container = sc.nextLine();
                return new ShelfStable(name, brand, price, sku, color, exp, container);

            } else if (t == 2) { // Fruit
                System.out.print("Shape: ");
                String shape = sc.nextLine();
                return new Fruit(name, brand, price, sku, color, exp, shape);

            } else if (t == 3) { // Vegetable
                System.out.print("Growth Type: ");
                String growth = sc.nextLine();
                return new Vegetable(name, brand, price, sku, color, exp, growth);

            } else {
                System.out.println("Invalid subtype.");
                return null;
            }
        }

        // CATEGORY 2: ELECTRONICS
        else if (cat == 2) {
            System.out.println("\nNew Electronics subtype: 1) TV  2) Laptop  3) Phone");
            System.out.print("Pick 1-3: ");
            int t = sc.nextInt();
            sc.nextLine(); // clear newline

            // Shared Electronics fields
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Brand: ");
            String brand = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("SKU (int): ");
            int sku = sc.nextInt();
            sc.nextLine();

            System.out.print("Size (double): ");
            double size = sc.nextDouble();
            sc.nextLine();

            System.out.print("Storage (int): ");
            int storage = sc.nextInt();
            sc.nextLine();

            // Subtype-specific fields + object creation
            if (t == 1) { // TV
                System.out.print("Resolution: ");
                String res = sc.nextLine();
                // Constructor order: brand, price, sku, name, size, storage, res
                return new TV(name, brand, price, sku, size, storage, res);

            } else if (t == 2) { // Laptop
                System.out.print("Port Type: ");
                String port = sc.nextLine();
                return new Laptop(name, brand, price, sku, size, storage, port);

            } else if (t == 3) { // Phone
                System.out.print("Provider: ");
                String prov = sc.nextLine();
                return new Phone(name, brand, price, sku, size, storage, prov);

            } else {
                System.out.println("Invalid subtype.");
                return null;
            }
        }

        // CATEGORY 3: CLOTHING
        else if (cat == 3) {
            System.out.println("\nNew Clothing subtype: 1) Outerwear  2) Shoe  3) Shirt");
            System.out.print("Pick 1-3: ");
            int t = sc.nextInt();
            sc.nextLine(); // clear newline

            // Shared Clothing fields
            System.out.print("Brand: ");
            String brand = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("SKU (int): ");
            int sku = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Size Label: ");
            String sizeLabel = sc.nextLine();

            // Subtype-specific fields + object creation
            if (t == 1) { // Outerwear
                System.out.print("Material: ");
                String mat = sc.nextLine();
                return new Outerwear(name, brand, price, sku, sizeLabel, mat);

            } else if (t == 2) { // Shoe
                System.out.print("Style: ");
                String style = sc.nextLine();
                return new Shoe(name, brand, price, sku, sizeLabel, style);

            } else if (t == 3) { // Shirt
                System.out.print("Fit: ");
                String fit = sc.nextLine();
                return new Shirt(name, brand, price, sku, sizeLabel, fit);

            } else {
                System.out.println("Invalid subtype.");
                return null;
            }
        }

        // CATEGORY 4: HOUSEHOLD
        //
        else {
            System.out.println("\nNew Household subtype: 1) CleaningSupply  2) Furniture");
            System.out.print("Pick 1-2: ");
            int t = sc.nextInt();
            sc.nextLine(); // clear newline

            // Shared Household fields
            System.out.print("Brand: ");
            String brand = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("SKU (int): ");
            int sku = sc.nextInt();
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Description: ");
            String desc = sc.nextLine();

            // Subtype-specific fields + object creation
            if (t == 1) { // CleaningSupply
                System.out.print("Surface Type: ");
                String surf = sc.nextLine();
                return new CleaningSupply(name, brand, price, sku, desc, surf);

            } else if (t == 2) { // Furniture
                System.out.print("Furniture Type: ");
                String ftype = sc.nextLine();
                return new Furniture(name, brand, price, sku, desc, ftype);

            } else {
                System.out.println("Invalid subtype.");
                return null;
            }
        }
    }

    // (2) DISPLAY INVENTORY (ONE CATEGORY)
    private static void displayInventory(ArrayList<StoreItem> inventory) {
        Scanner sc = new Scanner(System.in);
        int cat = CategoryOptions(sc, "\nDisplay which category?");
        showCategoryWithStock(inventory, cat);
    }

    //(3)
    public static void sellInventory(ArrayList<StoreItem> inventory) {
        //so a user can input their choice
        Scanner inp = new Scanner(System.in);
        //prints out the options for the user to pick from
        System.out.println("What type of item would you like to buy?");
        System.out.println("1) Food");
        System.out.println("2) Electronics");
        System.out.println("3) Clothing");
        System.out.println("4) Household");
        System.out.print("Choice: ");
        //creates users choice, and clears line
        int choice = inp.nextInt();
        inp.nextLine();

        //if they want to buy a food item
        if(choice >= 1 && choice <= 4) {

            //shows a table of available items
            showCategoryWithStock(inventory, choice);
            if(choice == 1){
                System.out.printf("%s%n", "THESE ITEMS MAY NOT BE RETURNED");
            }
            else{
                System.out.printf("%s%n", "YOU WILL HAVE 30 DAYS TO RETURN THESE ITEMS WITH VALID PROOF OF PURCHASE");
            }

            //Calls the method that shows the inventory of items in a table
            ArrayList<Row> rows = CategoryRow(inventory, choice); //I changed the variable and Method name so I fixed this line

            //add chat HELP BEFORE TURNIGN IN
            if (rows.isEmpty()){    //firstIndexes to rows fixed
                System.out.println("The category you are trying to shop is empty");
                sellInventory(inventory);
                return;
            }

            shopping(inventory, rows, choice);

        }

        else {
            //prints an invalid message and prompts for new input
            System.out.println("ERROR: INVALID INPUT! Please select a number from the menu");
            //goes back to the top so they can retry
            sellInventory(inventory);
        }


    }

    private static final ArrayList<StoreItem> checkoutList = new ArrayList<>(); //fixed added this

    // fixed ArrayList<Integer> firstIndexes to ArrayList<Row> rows
    public static void shopping(ArrayList<StoreItem> inventory, ArrayList<Row> rows, int choice) {

        System.out.println("What object would you like to buy? Please enter the row #");
        //user input and clearing line
        Scanner inp = new Scanner(System.in);
        int item = inp.nextInt();
        inp.nextLine();

        //if their choice is in the options
        if (item > 0 && item <= rows.size()) {   //fixed  firstIndexes to rows
            int trueIndex = rows.get(item - 1).firstIndex;
            checkoutList.add(inventory.get(trueIndex));
            //goes to method to remove the item from available inventory
            removeInventory(inventory, trueIndex);
            //goes to method that questions to continue or stop shopping
            shoppingStatus(inventory);
        }
        //if the option they input is not in the list
        else {
            System.out.println("INVALID INPUT! Please select a valid option");
            item = inp.nextInt();
            inp.nextLine();
            shoppingStatus(inventory);
        }
    }

    public static void removeInventory(ArrayList<StoreItem> inventory, int rem) {
        if (rem >= 0 && rem < inventory.size()) {
            inventory.remove(rem);
        }
    }

    public static void shoppingStatus (ArrayList < StoreItem > inventory) {
        System.out.println("Press 1 to keep shopping OR Press 2 to go to checkout");
        Scanner inp = new Scanner(System.in);
        int ans = inp.nextInt();
        inp.nextLine();
        if (ans == 1) {
            sellInventory(inventory);
        } else if (ans == 2) {
            checkout(checkoutList, 2, inventory);
        } else {
            System.out.println("INVALID INPUT! Select 1 to keep shopping OR 2 to go to checkout");
            ans = inp.nextInt();
            inp.nextLine();
        }
    }
    public static void returnPolicy(ArrayList<StoreItem> inventory, int cat) {
        if(cat == 1){
            System.out.println("Food items may not be returned");
        }
        else{
            System.out.println("Non food items can be returned within 30 days with proof of purchase");
        }

    }

    public static void checkout(ArrayList<StoreItem> checkout, int cat, ArrayList<StoreItem> inventory) {

        double total = 0;
        double newTotalFd = 0;
        double newTotal = 0;

        //ADD CHAT GPT HERE
        ArrayList<StoreItem> food = new ArrayList<>();
        ArrayList<StoreItem> electronics = new ArrayList<>();
        ArrayList<StoreItem> clothing = new ArrayList<>();
        ArrayList<StoreItem> household = new ArrayList<>();

        for (StoreItem item : checkout) {
            if (item instanceof FoodItem) food.add(item);
            else if (item instanceof ElectronicsItem) electronics.add(item);
            else if (item instanceof ClothingItem) clothing.add(item);
            else if (item instanceof HouseholdItem) household.add(item);
        }


        if (!food.isEmpty()){
            System.out.println("----------Food Items----------");
            for (StoreItem purchase : food) {
                System.out.printf("%-10s $%.2f%n", purchase.getBrand(), purchase.getPrice());
                double taxes = 0.02;
                newTotalFd += purchase.getPrice() + (purchase.getPrice() * 0.02);
            }
        }


        if (!electronics.isEmpty()) {
            System.out.println("----------Electronics Items----------");
            for (StoreItem purchase : electronics) {
                System.out.printf("%-10s $%.2f%n", purchase.getBrand(), purchase.getPrice());
                double taxes = 0.0475;
                newTotalFd += purchase.getPrice() + (purchase.getPrice() * 0.0475);
            }
        }


        if (!clothing.isEmpty()) {
            System.out.println("----------Clothing Items----------");
            for (StoreItem purchase : clothing) {
                System.out.printf("%-10s $%.2f%n", purchase.getBrand(), purchase.getPrice());
                double taxes = 0.0475;
                newTotalFd += purchase.getPrice() + (purchase.getPrice() * 0.0475);
            }
        }

        if (!household.isEmpty()) {
            System.out.println("----------Household Items----------");
            for (StoreItem purchase : household) {
                System.out.printf("%-10s $%.2f%n", purchase.getBrand(), purchase.getPrice());
                double taxes = 0.0475;
                newTotalFd += purchase.getPrice() + (purchase.getPrice() * 0.0475);
            }
        }

        System.out.println("Would you like to continue to checkout?");
        System.out.println("1) Yes, continue to checkout");
        System.out.println("2) No, go back to shopping");
        Scanner scanner = new Scanner(System.in);
        int pick = scanner.nextInt();
        scanner.nextLine();


        if(pick == 1){
            total = newTotal + newTotalFd;
            System.out.println("--------------------");
            System.out.printf("%s $%.2f%n", "You owe:",  total);
        }

        else if(pick == 2) {
            sellInventory(inventory);
        }

        else {
            System.out.println("INVALID CHOICE! CHOOSE AGAIN");
            System.out.println("1) Proceed to checkout\n2) Keep shopping");
            pick = scanner.nextInt();
            scanner.nextLine();
            if (pick == 1) {
                total = newTotal + newTotalFd;
                System.out.println("--------------------");
                System.out.printf("%s $%.2f%n", "You owe:", total);
            } else if (pick == 2) {
                sellInventory(inventory);
            }
        }

        //used chat to get instanceof
        System.out.println("\nThe Return Policies For Your Items");
        for (StoreItem item : checkout) {
            if (item instanceof FoodItem) {
                returnPolicy(inventory, 1);
            }
            else if (item instanceof ElectronicsItem) {
                returnPolicy(inventory, 2);
            }
            else if (item instanceof ClothingItem) {
                returnPolicy(inventory, 3);
            }
            else if (item instanceof HouseholdItem) {
                returnPolicy(inventory, 4);
            }
        }


        System.out.println("\n---Complete Updated Inventory After Sales---");
        for (int i = 1; i <= 4; i++) {
            showCategoryWithStock(inventory, i);
        }


    }

}



