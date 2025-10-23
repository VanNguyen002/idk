public class Fruit extends FoodItem{
    private double sugarContent;
    private double acidityLevel;
    private String harvestSeason;


    public Fruit(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String expirationDate, String servingSize, double calories, double sugarContent, double acidityLevel, String harvestSeason){
        super(name, brand, idNumber, stockQuantity, price, weight, discount, expirationDate, servingSize, calories);

        this.sugarContent = sugarContent;
        this.acidityLevel = acidityLevel;
        this.harvestSeason = harvestSeason;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public double getAcidityLevel() {
        return acidityLevel;
    }

    public String getHarvestSeason() {
        return harvestSeason;
    }


    public void setSugarContent(double sugarContent) {
        this.sugarContent = sugarContent;
    }

    public void setAcidityLevel(double acidityLevel) {
        this.acidityLevel = acidityLevel;
    }

    public void setHarvestSeason(String harvestSeason) {
        this.harvestSeason = harvestSeason;
    }
}

