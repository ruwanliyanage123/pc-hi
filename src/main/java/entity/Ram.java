package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ram")
public class Ram {
    @Id
    @GeneratedValue
    @Column(name = "ram_id")
    private Long ramId;
    @Column(name = "model_name")
    private String modelName;
    @Column(name = "storage")
    private int storage;

    public Ram(String modelName, int storage) {
        this.modelName = modelName;
        this.storage = storage;
    }

    public Ram() {
    }

    public Long getRamId() {
        return ramId;
    }

    public void setRamId(Long ramId) {
        this.ramId = ramId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
