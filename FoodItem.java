public class FoodItem extends BoxStore {

    private String expirationDate;
    private String servingSize;
    private double calories;

    public FoodItem(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String expirationDate, String servingSize, double calories){
        super(name, brand, idNumber, stockQuantity, price, weight, discount);

        this.expirationDate = expirationDate;
        this.servingSize = servingSize;
        this.calories = calories;
    }



    public String getExpirationDate() {
        return expirationDate;
    }

    public String getServingSize() {
        return servingSize;
    }

    public double getCalories() {
        return calories;
    }


    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
