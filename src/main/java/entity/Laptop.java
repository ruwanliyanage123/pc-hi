package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue
    @Column(name = "lap_id")
    private Long lapId;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "price")
    private Double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "processor_id")
    private Processor processor;
    @JoinColumn(name = "lap_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ram> ram = new ArrayList<>();

    public Laptop(Processor processor, List<Ram> ram, String modelName, Double price) {
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
}
