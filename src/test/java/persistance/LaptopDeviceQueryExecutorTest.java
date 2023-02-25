package persistance;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This sort of unit test are not recommended. Because this unit test wrote by directly connecting with the system database.
 * This is not a good practise and will be very harmful effects to the database.
 * But since this is not a production environment as well as this is only for the learning purpose. So we can use this just to test the crud operations methods.
 */
public class LaptopDeviceQueryExecutorTest{
    @Test
    public void testLaptopDeviceTableCreation() {
        boolean isTableExists;
        LaptopDeviceQueryExecutor.getInstance();
        Connection connection = DatabaseManager.getInstance().getConnection();
        String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = '"+Common.LAPTOP_STORE_TABLE+"'";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            int count = resultSet.getInt(1);
            isTableExists = count > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(isTableExists);
    }
}