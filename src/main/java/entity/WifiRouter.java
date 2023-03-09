package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "wifi")
public class WifiRouter {
    @Id
    @GeneratedValue
    @Column(name = "router_id")
    private Long routerId;
    @Column(name = "ssid")
    private String ssid;
    @Column(name = "model_name")
    private String modelName;

    @OneToMany(mappedBy = "wifiRouter")
    private List<Laptop> laptops;

    public WifiRouter(String ssid, String modelName) {
        this.ssid = ssid;
        this.modelName = modelName;
    }

    public WifiRouter() {
    }

    public Long getRouterId() {
        return routerId;
    }

    public void setRouterId(Long routerId) {
        this.routerId = routerId;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
