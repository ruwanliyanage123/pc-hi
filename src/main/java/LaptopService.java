public class LaptopService {
    private LaptopDAO laptopDAO = new LaptopDAO();
    public static void main(String[] args) {
//       new LaptopService().create();
//        new LaptopService().read();
//        new LaptopService().update();
//        new LaptopService().delete();
    }
    public void create(){
        laptopDAO.create(new Laptop("LENOVO",230000.50));
    }
    public void read(){
        laptopDAO.read().forEach(System.out::println);
    }
    public void update(){
        laptopDAO.update(new Laptop("HP",20000.50), 14L);
    }
    public void delete(){
        laptopDAO.delete(13L);
    }
}
