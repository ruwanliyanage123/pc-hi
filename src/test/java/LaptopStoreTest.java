import org.testng.annotations.Test;

/**
 * This sort of unit test are not recommended. Because this unit test wrote by directly connecting with the system database.
 * This is not a good practise and will be very harmful effects to the database.
 * But since this is not a production environment as well as this is only for the learning purpose. So we can use this just to test the crud operations methods.
 */
public class LaptopStoreTest{
    private final LaptopStore laptopStore = new LaptopStore();

    @Test
    public void testCreateLaptop() {
        laptopStore.create(new Laptop( "HP", "D-001", "DFGHJ1"));
    }

    @Test
    public void readLaptop() {
        laptopStore.read().forEach(laptop -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unique Id :").append(laptop.getLapId())
                    .append(" Brand name: ").append(laptop.getBrandName())
                    .append(" Model name: ").append(laptop.getModelName())
                    .append(" Serial number: ").append(laptop.getSerialNumber());
            System.out.println(stringBuilder);
        });
    }

    @Test
    public void updateLaptop() {
        laptopStore.update(new Laptop("Mac","M11", "MACI"), 4L);
    }

    @Test
    public void deleteLaptop() {
        laptopStore.delete(5L);
    }

}