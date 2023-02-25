public class Laptop implements Device {
    private String brandName;
    private String modelName;
    private String serialNumber;

    public Laptop(String brandName, String modelName, String serialNumber) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.serialNumber = serialNumber;
    }

    public Laptop() {
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void start() {
        System.out.println("Starting the" + serialNumber + " laptop...");
    }

    public void restart() {
        System.out.println("restarting the laptop...");
    }

    public void shutdown() {
        System.out.println("Shutting down the laptop...");
    }
}
