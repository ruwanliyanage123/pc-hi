import java.util.List;

public class LaptopService {
    private LaptopDAO laptopDAO = new LaptopDAO();
    private ProcessorDAO processorDAO = new ProcessorDAO();

    public void saveLaptop(Laptop laptop) {
        processorDAO.saveProcessor(laptop.getProcessor());
        laptopDAO.saveLaptop(laptop);
    }

    public void getAllLaptops() {
        List<Laptop> laptops = laptopDAO.getAllLaptops();
        laptops.forEach(h->{
            System.out.println(h.getLapId()+" "+ h.getModelName()+" ");
        });
        laptops.forEach(h->{
            System.out.println(h.getProcessor().getProcessorId()+" "+ h.getProcessor().getModelNumber()+" "+h.getProcessor().getPrice());
        });
    }

    public void getLaptopById(Long id) {
        Laptop laptop = laptopDAO.getLaptopById(id);
        System.out.println(laptop.getLapId() + " " + laptop.getModelName() + " " + laptop.getPrice());
        System.out.println(laptop.getProcessor().getProcessorId() + " " + laptop.getProcessor().getModelNumber() + " " + laptop.getProcessor().getPrice());
    }

    public void updateLaptop(Laptop laptop) {
        laptopDAO.updateLaptop(laptop);
    }

    public void deleteLaptop() {
        laptopDAO.deleteLaptop(13L);
    }

    public void changeProcessor(Long lapId, Long newProcessor){
        Laptop laptop = laptopDAO.getLaptopById(lapId);
        Processor processor = processorDAO.getProcessorById(newProcessor);
        laptop.setProcessor(processor);
        laptopDAO.updateLaptop(laptop);
    }
}
