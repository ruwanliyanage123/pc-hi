import entity.Laptop;
import entity.Processor;
import entity.Ram;
import entity.WifiRouter;
import service.api.LaptopService;
import service.impl.LaptopServiceImpl;
import service.impl.WifiRouterServiceImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    private static LaptopService laptopService = new LaptopServiceImpl();

    public static void main(String[] args) {
        saveLaptop();
    }

    private static void saveLaptop() {
        Ram ram1 = new Ram("DDR8-01", 4);
        Ram ram2 = new Ram("DDR8-02", 8);
        List<Ram> ramList = Arrays.asList(ram1, ram2);
        Processor processor = new Processor("Intel i7 DDR8", 25000.0);
        WifiRouter wifiRouter = new WifiRouter("JWR","Huawei");
        Laptop lap = new Laptop(wifiRouter, processor, ramList, "Dell i7 -80 DDR8", 25000.0);
        laptopService.saveLaptop(lap);
    }

    private static void getLaptop(Long id) {
        Laptop laptop = laptopService.getLaptopById(id);
        System.out.println(laptop.getLapId() + " " + laptop.getModelName() + " " + laptop.getPrice());
        System.out.println(laptop.getProcessor().getProcessorId() + " " + laptop.getProcessor().getModelNumber() + " " + laptop.getProcessor().getPrice());

        List<Ram> list = laptop.getRam();
        for (Ram ram : list) {
            System.out.println(ram.getRamId() + " : " + ram.getModelName() + " : " + ram.getModelName());
        }
    }

    private static void delete(Long id) {
        laptopService.deleteLaptop(id);
    }

    private static void changeRam(Ram ram, Long lapId, Long ramId) {
        laptopService.changeRam(ram, lapId, ramId);
    }
}
