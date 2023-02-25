package persistance;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;

public class DatabaseManagerTest {

    @Test
    public void testDatabaseManagerSingletonPattern(){
        DatabaseManager databaseManager1 = DatabaseManager.getInstance();
        DatabaseManager databaseManager2 = DatabaseManager.getInstance();
        Assert.assertSame(databaseManager1, databaseManager2);
    }

    @Test
    public void verifySingletonConnection(){
        Connection connection1 = DatabaseManager.getInstance().getConnection();
        Connection connection2 = DatabaseManager.getInstance().getConnection();
        Assert.assertSame(connection1, connection2);
    }

    @Test
    public void testDataBaseConnection(){
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        Connection connection = databaseManager.getConnection();
        Assert.assertNotNull(connection);
    }
}