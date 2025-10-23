public class Laptop extends ElectronicsItem{
    private int ramSize;
    private int refreshRate;
    private String gpuModel;
    private String processorType;

    public Laptop(String name, String brand, int idNumber, int stockQuantity, double price, double weight, double discount, String os, String screenType, String warrentyTime, double modelNumber, int ramSize, int refreshRate, String gpuModel, String processorType){
        super(name, brand, idNumber, stockQuantity, price, weight, discount, os, screenType, warrentyTime, modelNumber);

        this.ramSize = ramSize;
        this.refreshRate = refreshRate;
        this.gpuModel = gpuModel;
        this.processorType = processorType;

    }

    public int getRamSize() {
        return ramSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public String getProcessorType() {
        return processorType;
    }


    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }
}
