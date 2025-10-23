/**
 * @author VanNguyen
 * Class: CSC 331 - 001
 * Date 10/14/2025
 * Purpose: Create a subclass of clothingItem for the Shirt
 */
public class Shirt extends ClothingItem {
    private String fit;
    private String style;

    public Shirt(String name, String brand, int idNumber, int stockQuantity,
                 double price, double weight, double discount,
                 String sizeLabel, String color, String genderCategory,
                 String fit, String style ) {
        super(name, brand, idNumber, stockQuantity, price, weight, discount,
                sizeLabel, color, genderCategory);
        this.fit = fit;
        this.style = style;
    }
    //Getter

    public String getFit() {
        return fit;
    }

    public String getStyle() {
        return style;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
