package persistance;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaptopDeviceQueryExecutorTest {
    @Test
    public void testLaptopDeviceTableCreation() {
        boolean isTableExists;
        LaptopDeviceQueryExecutor.getInstance();
        Connection connection = DatabaseManager.getInstance().getConnection();
        String query = "SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'laptop_store'";
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