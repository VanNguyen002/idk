public class BoxStore {
    private String name;
    private String brand;
    private int idNumber;
    private int stockQuantity;
    private double price;
    private double weight;
    private double discount;

    public BoxStore(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount){
        this.name = name;
        this.brand = brand;
        this.idNumber = idNumber;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public double getDiscount() {
        return discount;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

