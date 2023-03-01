import org.testng.annotations.Test;

public class LapStoreServiceImplTest {
    LapStoreService lapStoreService = new LapStoreServiceImpl();

    @Test
    public void testCreate(){
        lapStoreService.createLaptop();
    }

    @Test
    public void testRead(){
        lapStoreService.readLaptop();
    }

    @Test
    public void testUpdate(){
        lapStoreService.updateLaptop();
    }

    @Test
    public void testDelete(){
        lapStoreService.deleteLaptop();
    }

}