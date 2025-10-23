public class Phone extends ElectronicsItem{
    private int storageCapacity;
    private String chipset;
    private String cameraResolution;

    public Phone(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String os, String screenType, String warrentyTime, double modelNumber, int storageCapacity, String chipset, String cameraResolution){
        super(name, brand, idNumber, stockQuantity, price, weight, discount, os, screenType, warrentyTime, modelNumber);

        this.storageCapacity = storageCapacity;
        this.chipset = chipset;
        this.cameraResolution = cameraResolution;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getChipset() {
        return chipset;
    }

    public String getCameraResolution() {
        return cameraResolution;
    }


    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public void setCameraResolution(String cameraResolution) {
        this.cameraResolution = cameraResolution;
    }
}
