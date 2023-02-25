import org.testng.Assert;
import org.testng.annotations.Test;
import persistance.Common;
import persistance.DatabaseManager;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}