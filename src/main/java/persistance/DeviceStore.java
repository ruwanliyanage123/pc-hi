package persistance;

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
    void update(T t);

    /**
     * Delete the given device from the database
     * @param t device
     */
    void delete(T t);
}
