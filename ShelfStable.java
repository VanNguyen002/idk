public class ShelfStable extends FoodItem{
    private double storageTemperature;
    private String packagingType;
    private String manufactureDate;

    public ShelfStable(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String expirationDate, String servingSize, double calories, double storageTemperature, String packagingType, String manufactureDate){
        super(name, brand, idNumber, stockQuantity, price, weight, discount, expirationDate, servingSize, calories);

        this.storageTemperature = storageTemperature;
        this.packagingType = packagingType;
        this.manufactureDate = manufactureDate;
    }

    public double getStorageTemperature() {
        return storageTemperature;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }


    public void setStorageTemperature(double storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
