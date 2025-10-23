public class ElectronicsItem extends BoxStore{

    private String os;
    private String screenType;
    private String warrentyTime;
    private double modelNumber;

    public ElectronicsItem(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String os, String screenType, String warrentyTime, double modelNumber) {
        super(name, brand, idNumber, stockQuantity, price, weight, discount);

        this.os = os;
        this.screenType = screenType;
        this.warrentyTime = warrentyTime;
        this.modelNumber = modelNumber;
    }

    public String getOs() {
        return os;
    }

    public String getScreenType() {
        return screenType;
    }

    public String getWarrentyTime() {
        return warrentyTime;
    }

    public double getModelNumber() {
        return modelNumber;
    }


    public void setOs(String os) {
        this.os = os;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setWarrentyTime(String warrentyTime) {
        this.warrentyTime = warrentyTime;
    }

    public void setModelNumber(double modelNumber) {
        this.modelNumber = modelNumber;
    }
}
