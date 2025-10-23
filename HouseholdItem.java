/**
 * @author VanNguyen
 * Class: CSC 331 - 001
 * Date 10/14/2025
 * Purpose: Create a Household Superclass
 */
public class HouseholdItem extends BoxStore {
    //Properties/Attributes
    private String description;
    private String roomType;
    private boolean fragile;

    public HouseholdItem(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String description, String roomType, boolean fragile) {
        super(name, brand, idNumber, stockQuantity, price, weight, discount);
        this.description = description;
        this.roomType = roomType;
        this.fragile = fragile;

    }
    //Getters/Accessors


    public String getDescription() {
        return description;
    }

    public String getRoomType() {
        return roomType;
    }
    public boolean isFragile() {
        return this.fragile;
    }
    //Setter
    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }
}

