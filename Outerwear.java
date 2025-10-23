/**
 * @author VanNguyen
 * Class: CSC 331 - 001
 * Date 10/14/2025
 * Purpose: Create a subclass of clothingItem for the OuterWear
 */
public class Outerwear extends ClothingItem {
    //properties/Attribute
    private String material;
    private String qualityType;
    //Constructor
    /**
     * Constructor for the attribution
     * @param material (String)
     */
    public Outerwear(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String sizeLabel, String color, String genderCategory, String material, String qualityType) {
        super(name, brand, idNumber, stockQuantity, price, weight, discount, sizeLabel, color, genderCategory);
        this.material = material;
        this.qualityType = qualityType;

    }
    //Getters/Accessories

    public String getMaterial() {
        return material;
    }

    public String getQualityType() {
        return qualityType;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setQualityType(String qualityType) {
        this.qualityType = qualityType;
    }
}

