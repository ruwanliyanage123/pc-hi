import org.testng.annotations.Test;

/**
 * This sort of unit test are not recommended. Because this unit test wrote by directly connecting with the system database.
 * This is not a good practise and will be very harmful effects to the database.
 * But since this is not a production environment as well as this is only for the learning purpose. So we can use this just to test the crud operations methods.
 */
public class LaptopStoreTest{
    private final LaptopStore laptopStore = new LaptopStore();

    @Test
    public void testCreateLaptop() {}

    @Test
    public void readLaptop() {}

    @Test
    public void updateLaptop() {}

    @Test
    public void deleteLaptop() {}

}