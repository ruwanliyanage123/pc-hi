package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "printer")
public class Printer {
    @Id
    @GeneratedValue
    @Column(name = "printer_id")
    private Long printerId;
    @Column(name = "model_name")
    private String modelName;
    @ManyToMany(mappedBy = "printers")
    private Set<Laptop> laptops;

    public Printer(String modelName) {
        this.modelName = modelName;
    }

    public Printer() {
    }

    public Printer(String modelName, Set<Laptop> laptops) {
        this.modelName = modelName;
        this.laptops = laptops;
    }
    public Long getPrinterId() {
        return printerId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
