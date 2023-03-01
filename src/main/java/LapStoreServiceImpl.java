import org.springframework.beans.factory.annotation.Autowired;

public class LapStoreServiceImpl implements LapStoreService{
    @Autowired
    private LaptopStoreDAO laptopStore;

    public void createLaptop() {
        laptopStore.create(new Laptop( "HP", "D-001", "DFGHJ1"));
    }

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

    public void updateLaptop() {
        laptopStore.update(new Laptop("Mac","M11", "MACI"), 1L);
    }


    public void deleteLaptop() {
        laptopStore.delete(5L);
    }
}
