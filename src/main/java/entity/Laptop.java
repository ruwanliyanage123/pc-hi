package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "lap_id")
    private Long lapId;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "price")
    private Double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "processor_id")
    private Processor processor;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "lap_id")
    private List<Ram> ram = new ArrayList<>();
    @ManyToOne()
    @JoinColumn(name="router_id")
    private WifiRouter wifiRouter;

    public Laptop(Processor processor, List<Ram> ram, String modelName, Double price) {
        this.processor = processor;
        this.modelName = modelName;
        this.price = price;
        this.ram = ram;
    }

    public Laptop(WifiRouter wifiRouter, Processor processor, List<Ram> ram, String modelName, Double price) {
        this.wifiRouter = wifiRouter;
        this.processor = processor;
        this.modelName = modelName;
        this.price = price;
        this.ram = ram;
    }

    public Laptop() {
    }

    public Long getLapId() {
        return lapId;
    }

    public void setLapId(Long lapId) {
        this.lapId = lapId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public List<Ram> getRam() {
        return ram;
    }

    public void setRam(List<Ram> ram) {
        this.ram = ram;
    }

    public void addRam(Ram ram) {
        if (ram != null) this.ram.add(ram);
    }

    public WifiRouter getWifiRouter() {
        return wifiRouter;
    }

    public void setWifiRouter(WifiRouter wifiRouter) {
        this.wifiRouter = wifiRouter;
    }
}
