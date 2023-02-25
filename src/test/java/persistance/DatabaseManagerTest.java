package persistance;

import database.DatabaseManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;

/**
 * This sort of unit test are not recommended. Because this unit test wrote by directly connecting with the system database.
 * This is not a good practise and will be very harmful effects to the database.
 * But since this is not a production environment as well as this is only for the learning purpose. So we can use this just to test the crud operations methods.
 */
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