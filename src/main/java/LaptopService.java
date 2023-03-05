public class LaptopService {
    private LaptopDAO laptopDAO = new LaptopDAO();
    private ProcessorDAO processorDAO = new ProcessorDAO();
    public void saveLaptop(Laptop laptop){
        processorDAO.saveProcessor(laptop.getProcessor());
        laptopDAO.saveLaptop(laptop);
    }
    public void getAllLaptops(){
        laptopDAO.getAllLaptops().forEach(System.out::println);
    }
    public void updateLaptop(){
        Processor processor = new Processor("Intel8", 19500.5);
        laptopDAO.updateLaptop(new Laptop("HP",processor, 20000.50), 14L);
    }
    public void deleteLaptop(){
        laptopDAO.deleteLaptop(13L);
    }
}
