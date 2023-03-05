public class LaptopService {
    private LaptopDAO laptopDAO = new LaptopDAO();
    public static void main(String[] args) {

    }
    public void create(Laptop laptop){
        laptopDAO.create(laptop);
    }
    public void read(){
        laptopDAO.read().forEach(System.out::println);
    }
    public void update(){
        Processor processor = new Processor("Intel8", 19500.5);
        laptopDAO.update(new Laptop("HP",processor, 20000.50), 14L);
    }
    public void delete(){
        laptopDAO.delete(13L);
    }
}
