package persistance;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;

public class DatabaseManagerTest {

    @Test
    public void testDataBaseConnection(){
        DatabaseManager databaseManager = new DatabaseManager();
        Connection connection = databaseManager.getConnection();
        Assert.assertNotNull(connection);
    }
}