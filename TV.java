public class TV extends ElectronicsItem{

    private double height;
    private double length;

    public TV(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String os, String screenType, String warrantyTime, double modelNumber, double height, double length){
        super(name, brand, idNumber, stockQuantity, price, weight, discount, os, screenType, warrantyTime, modelNumber);

        this.height = height;
        this.length = length;


    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
