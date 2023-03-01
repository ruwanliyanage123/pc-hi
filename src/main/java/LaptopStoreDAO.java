import java.util.List;

public interface LaptopStoreDAO{
    /**
     * Add the device to the database
     * @param laptop device
     */
    void create(Laptop laptop);

    /**
     * Get the all devices from the database
     */
    List<Laptop> read();

    /**
     * Update the given device from the database
     * @param laptop device
     */
    void update(Laptop laptop, Long id);

    /**
     * Delete the given device by id from the database
     * @param id device
     */
    void delete(Long id);
}
