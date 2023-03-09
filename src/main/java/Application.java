import entity.Laptop;
import entity.Printer;
import entity.Processor;
import entity.Ram;
import entity.WifiRouter;
import service.api.LaptopService;
import service.api.PrinterService;
import service.impl.LaptopServiceImpl;
import service.impl.PrinterServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private static LaptopService laptopService = new LaptopServiceImpl();
    private static PrinterService printerService = new PrinterServiceImpl();

    public static void main(String[] args) {
        savePrinter();
    }

    private static void savePrinter() {
        Laptop laptop1 = new Laptop("Dell - 1234", 15000.0);
        Laptop laptop2 = new Laptop("Dell - 4567", 15000.0);
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        Printer printer = new Printer("print - 001", laptops);
        printerService.savePrinter(printer);
    }

    private static void saveLaptop() {
        Ram ram1 = new Ram("DDR8-01", 4);
        Ram ram2 = new Ram("DDR8-02", 8);
        List<Ram> ramList = Arrays.asList(ram1, ram2);
        Processor processor = new Processor("Intel i7 DDR8", 25000.0);
        WifiRouter wifiRouter = new WifiRouter("JWR", "Huawei");

        Printer printer1 = new Printer("print - 001");
        Printer printer2 = new Printer("print - 002");
        Set<Printer> printers = new HashSet<>();
        printers.add(printer1);
        printers.add(printer2);

        Laptop lap = new Laptop(wifiRouter, processor, ramList, printers, "Dell i7 -80 DDR8", 25000.0);
        laptopService.saveLaptop(lap);
    }

    private static void saveLaptopList() {
        Ram ram1 = new Ram("DDR8-01", 4);
        Ram ram2 = new Ram("DDR8-02", 8);
        List<Ram> ramList1 = Arrays.asList(ram1, ram2);

        Ram ram3 = new Ram("DDR8-03", 4);
        Ram ram4 = new Ram("DDR8-04", 8);
        List<Ram> ramList2 = Arrays.asList(ram3, ram4);

        Processor processor1 = new Processor("Intel i7 DDR8", 25000.0);
        Processor processor2 = new Processor("Intel i7 DDR8", 25000.0);

        WifiRouter wifiRouter = new WifiRouter("JWR", "Huawei");

        Laptop lap1 = new Laptop(wifiRouter, processor1, ramList1, "Dell i7 -81 DDR8", 25000.0);
        Laptop lap2 = new Laptop(wifiRouter, processor2, ramList2, "Dell i7 -82 DDR8", 25000.0);
        List<Laptop> list = Arrays.asList(lap1, lap2);
        laptopService.saveLaptopList(list);
    }

    private static void getLaptop(Long id) {
        Laptop laptop = laptopService.getLaptopById(id);
        System.out.println(laptop.getLapId() + " " + laptop.getModelName() + " " + laptop.getPrice());
        System.out.println(laptop.getProcessor().getProcessorId() + " " + laptop.getProcessor().getModelNumber() + " " + laptop.getProcessor().getPrice());
        System.out.println(laptop.getWifiRouter().getRouterId() + " " + laptop.getWifiRouter().getSsid() + " " + laptop.getWifiRouter().getModelName());
        List<Ram> list = laptop.getRam();
        for (Ram ram : list) {
            System.out.println(ram.getRamId() + " : " + ram.getModelName() + " : " + ram.getModelName());
        }
    }

    private static void changeSSID(Long lapId) {
        laptopService.changeSSID(lapId);
    }

    private static void delete(Long id) {
        laptopService.deleteLaptop(id);
    }

    private static void changeRam(Ram ram, Long lapId, Long ramId) {
        laptopService.changeRam(ram, lapId, ramId);
    }
}
