import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

@ContextConfiguration(classes = {AppConfig.class})
public class LapStoreServiceImplTest {

    @Autowired
    LapStoreService lapStoreService;

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