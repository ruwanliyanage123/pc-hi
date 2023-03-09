package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "router_id")
    private WifiRouter wifiRouter;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "laptop_printer", joinColumns = @JoinColumn(name = "lap_id"), inverseJoinColumns = @JoinColumn(name = "printer_id"))
    private Set<Printer> printers;

    public Laptop() {
    }

    public Laptop(String modelName, Double price) {
        this.modelName = modelName;
        this.price = price;
    }

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

    public Laptop(WifiRouter wifiRouter, Processor processor, List<Ram> ram, Set<Printer> printers, String modelName, Double price) {
        this.wifiRouter = wifiRouter;
        this.processor = processor;
        this.modelName = modelName;
        this.printers = printers;
        this.price = price;
        this.ram = ram;
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

    public Set<Printer> getPrinters() {
        return printers;
    }

    public void setPrinters(Set<Printer> printers) {
        this.printers = printers;
    }
}
