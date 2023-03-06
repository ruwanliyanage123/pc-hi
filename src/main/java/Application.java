import entity.Laptop;
import entity.Processor;
import entity.Ram;
import service.api.LaptopService;
import service.impl.LaptopServiceImpl;

import java.util.Arrays;
import java.util.List;

public class Application {
    private static LaptopService laptopService = new LaptopServiceImpl();
    public static void main(String[] args) {
        //saveLaptop();
        //getLaptop(189L);
        delete(189L);
    }

    private static void saveLaptop(){
        Ram ram1 = new Ram("DDR7-01",4);
        Ram ram2 = new Ram("DDR7-02",8);
        Ram ram3 = new Ram("DDR7-03",16);
        Ram ram4 = new Ram("DDR7-04",32);

        List<Ram> ramList = Arrays.asList(ram1, ram2, ram3, ram4);
        Processor processor = new Processor("Intel i7 DDR7", 25000.0);
        Laptop lap = new Laptop(processor, ramList, "Dell i7 -80 DDR7", 25000.0);
        laptopService.saveLaptop(lap);
    }

    private static void getLaptop(Long id){
        Laptop laptop = laptopService.getLaptopById(id);
        System.out.println(laptop.getLapId() + " " + laptop.getModelName() + " " + laptop.getPrice());
        System.out.println(laptop.getProcessor().getProcessorId() + " " + laptop.getProcessor().getModelNumber() + " " + laptop.getProcessor().getPrice());

        List<Ram> list = laptop.getRam();
        for (Ram ram:list) {
            System.out.println(ram.getRamId()+" : "+ ram.getModelName()+" : "+ram.getModelName());
        }
    }

    private static void delete(Long id){
        laptopService.deleteLaptop(id);
    }
}
