public class Application {
    public static void main(String[] args) {
        Processor processor = new Processor("Intel7", 19500.5);
        Laptop laptop = new Laptop("Toshiba",processor,50000.0);
        new LaptopService().saveLaptop(laptop);
//        new LaptopService().read();
//        new LaptopService().update();
//        new LaptopService().delete();
    }
}
