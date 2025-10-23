/**
 * @author VanNguyen
 * Class: CSC 331 - 001
 * Date 10/14/2025
 * Purpose: Create a subclass of HouseholdItem for the CleaningSupply
 */
public class CleaningSupply extends HouseholdItem {
    private String surfaceType;
    private boolean chemicalBased;
    //Constructor
    public CleaningSupply(String name, String brand, int idNumber, int stockQuantity,
                          double price, double weight, double discount,
                          String description, String roomType, boolean fragile,
                          String surfaceType, boolean chemicalBased){
        super(name, brand, idNumber, stockQuantity, price, weight, discount,
                description, roomType, fragile);
        this.surfaceType = surfaceType;
        this.chemicalBased = chemicalBased;

    }
    //Getters
    //Setters
    public String getSurfaceType() { return surfaceType; }
    public boolean isChemicalBased() { return chemicalBased; }
    public void setSurfaceType(String surfaceType) { this.surfaceType = surfaceType; }
    public void setChemicalBased(boolean chemicalBased) { this.chemicalBased = chemicalBased; }
}
