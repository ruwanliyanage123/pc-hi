import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @OneToOne
    @JoinColumn(name = "processor_id")
    private Processor processor;

    public Laptop(String modelName, Processor processor, Double price) {
        this.processor = processor;
        this.modelName = modelName;
        this.price = price;
    }

    public Laptop(){}

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
}
