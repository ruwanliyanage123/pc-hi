import java.util.List;

public interface DeviceStore<T> {
    /**
     * Add the device to the database
     * @param t device
     */
    void create(T t);

    /**
     * Get the all devices from the database
     */
    List<T> read();

    /**
     * Update the given device from the database
     * @param t device
     */
    void update(T t, Long id);

    /**
     * Delete the given device by id from the database
     * @param id device
     */
    void delete(Long id);
}
