public class Vegetables extends FoodItem{

    private int fiberContent;
    private String vitaminContent;
    private String tasteProfile;

    public Vegetables(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String expirationDate, String servingSize, double calories, int fiberContent, String vitaminContent, String tasteProfile){
        super(name, brand, idNumber, stockQuantity, price, weight, discount, expirationDate, servingSize, calories);

        this.fiberContent = fiberContent;
        this.vitaminContent = vitaminContent;
        this.tasteProfile = tasteProfile;
    }

    public int getFiberContent() {
        return fiberContent;
    }

    public String getVitaminContent() {
        return vitaminContent;
    }

    public String getTasteProfile() {
        return tasteProfile;
    }


    public void setFiberContent(int fiberContent) {
        this.fiberContent = fiberContent;
    }

    public void setVitaminContent(String vitaminContent) {
        this.vitaminContent = vitaminContent;
    }

    public void setTasteProfile(String tasteProfile) {
        this.tasteProfile = tasteProfile;
    }
}
