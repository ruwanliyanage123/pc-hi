import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
@NamedQueries({
        @NamedQuery(name = "Laptop.getAllLaptopDetails", query = "SELECT lap FROM Laptop lap"),
})
public class Laptop implements Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lapId;
    @Column(name = "brand_name")
    private String brandName;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "serial_number")
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

    public Long getLapId() {
        return lapId;
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
