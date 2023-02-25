import org.testng.Assert;
import org.testng.annotations.Test;
import persistance.Common;
import persistance.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * This sort of unit test are not recommended. Because this unit test wrote by directly connecting with the system database.
 * This is not a good practise and will be very harmful effects to the database.
 * But since this is not a production environment as well as this is only for the learning purpose. So we can use this just to test the crud operations methods.
 */
public class LaptopStoreTest extends DatabaseTableReadHelper {
    private final LaptopStore laptopStore = new LaptopStore();

    @Test
    public void testCreateLaptop() {
        final Laptop laptop = new Laptop("Dell", "D-501", "DELLAPTOPS2001");
        laptopStore.create(laptop);
        boolean isLaptopExists = false;
        try {
            ResultSet resultSet = readTable(DatabaseManager.getInstance().getConnection(), Common.LAPTOP_STORE_TABLE);
            resultSet.next();
            isLaptopExists = laptop.getBrandName().equals(resultSet.getString(2))
                    && laptop.getModelName().equals(resultSet.getString(3))
                    && laptop.getSerialNumber().equals(resultSet.getString(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(isLaptopExists);
    }

    @Test
    public void readLaptop() {
        List<Laptop> laptops = laptopStore.read();
        laptops.forEach(laptop -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("brand name :").append(laptop.getBrandName()).append(" model name :").append(laptop.getModelName()).append(" serial number :").append(laptop.getSerialNumber());
            System.out.println(stringBuilder);
        });
    }

    @Test
    public void updateLaptop() {
        final Laptop laptop = new Laptop("HP", "D-502", "DELLAPTOPS2001");
        laptopStore.update(laptop);
    }

    @Test
    public void deleteLaptop() {
        final Laptop laptop = new Laptop("HP", "D-502", "DELLAPTOPS2001");
        laptopStore.delete(laptop);
    }

}