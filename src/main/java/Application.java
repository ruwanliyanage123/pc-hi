public class Application {
    public static void main(String[] args) {
        Processor processor = new Processor("Intel7", 19500.5);
        new ProcessorService().create(processor);
        Laptop laptop = new Laptop("Toshiba",processor,230000.50);
        new LaptopService().create(laptop);

//        new LaptopService().read();
//        new LaptopService().update();
//        new LaptopService().delete();
    }
}
