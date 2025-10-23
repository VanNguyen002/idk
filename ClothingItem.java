/**
 * Author: Van Nguyen
 * Class: CSC 331 - 003
 * Date:
 */
public class ClothingItem extends BoxStore{
    // Properties/Attributes
    private String sizeLabel;
    private String color;
    private String genderCategory;

    /**
     * Constructor for the attributes
     * @param sizeLabel (String)
     */
    public ClothingItem(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String sizeLabel, String color, String genderCategory) {
        super(name, brand, idNumber, stockQuantity, price, weight, discount);
        this. sizeLabel = sizeLabel;
        this. color = color;
        this. genderCategory = genderCategory;

    }

    // Getters/Accessors

    public String getSizeLabel() {
        return this.sizeLabel;
    }

    public String getColor() {
        return color;
    }

    public String getGenderCategory() {
        return genderCategory;
    }

    // Setters/Mutators

    public void setSizeLabel(String sizeLabel) {
        this.sizeLabel = sizeLabel;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGenderCategory(String genderCategory) {
        this.genderCategory = genderCategory;
    }
}
