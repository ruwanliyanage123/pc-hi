import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistance.DeviceStore;

import java.util.List;

public class LaptopStore implements DeviceStore<Laptop> {
    private final Logger log = LoggerFactory.getLogger(LaptopStore.class);

    public void create(Laptop laptop) {

    }

    public List<Laptop> read() {
        return null;
    }

    public void update(Laptop laptop) {

    }

    public void delete(Laptop laptop) {

    }
}
