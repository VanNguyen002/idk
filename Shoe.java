/**
 * @author VanNguyen
 * Class: CSC 331 - 001
 * Date 10/14/2025
 * Purpose: Create a subclass of clothingItem for the Shoe
 */
public class Shoe extends ClothingItem {
    private String shoeType ;
    private double shoeSize ;
    private String shoeStyle;
    //Constructor
    public Shoe(String name, String brand, int idNumber, int stockQuantity,
                double price, double weight, double discount,
                String sizeLabel, String color, String genderCategory,
                String style, String shoeType, double shoeSize){
        super(name, brand, idNumber, stockQuantity, price, weight, discount, sizeLabel, color, genderCategory);
        this.shoeType = shoeType;
        this.shoeSize = shoeSize;
        this.shoeStyle = shoeStyle;

    }
    //getter


    public String getShoeType() {
        return shoeType;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public String getShoeStyle() {
        return shoeStyle;
    }
//Setters

    public void setShoeType(String shoeType) {
        this.shoeType = shoeType;
    }

    public void setShoeSize(double shoeSize) {
        this.shoeSize = shoeSize;
    }
    public void setShoeStyle(String shoeStyle) {
        this.shoeStyle = shoeStyle;
    }
}

