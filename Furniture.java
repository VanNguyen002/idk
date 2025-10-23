/**
 * @author VanNguyen
 * Class: CSC 331 - 001
 * Date 10/14/2025
 * Purpose: Create a subclass of HouseholdItem for the Furniture
 */
public class Furniture extends HouseholdItem{
    private String furnitureType;
    private String dimension;

    public Furniture(String name, String brand, int idNumber, int stockQuantity,
                     double price, double weight, double discount,
                     String description, String roomType, boolean fragile,
                     String furnitureType, String dimension) {
        super(name, brand, idNumber, stockQuantity, price, weight, discount,
                description, roomType, fragile);
        this.furnitureType = furnitureType;
        this.dimension = dimension;


    }
    //Getters
    //Setters
    public String getFurnitureType() { return furnitureType; }
    public String getDimension() { return dimension; }
    public void setFurnitureType(String furnitureType) { this.furnitureType = furnitureType; }
    public void setDimension(String dimension) { this.dimension = dimension; }

}
