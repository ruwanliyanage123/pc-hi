package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "processor")
public class Processor {
    @Id
    @GeneratedValue
    @Column(name = "processor_id")
    private Long processorId;
    @Column(name = "model_number")
    private String modelNumber;
    @Column(name = "price")
    private Double price;

    public Processor(String modelNumber, Double price) {
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public Processor() {
    }

    public Long getProcessorId() {
        return processorId;
    }

    public void setProcessorId(Long processorId) {
        this.processorId = processorId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
