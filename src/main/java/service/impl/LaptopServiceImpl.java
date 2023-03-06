package service.impl;

import dao.impl.LaptopDAOImpl;
import dao.impl.ProcessorDAOImpl;
import entity.Laptop;
import entity.Processor;
import service.api.LaptopService;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {
    private LaptopDAOImpl laptopDAO = new LaptopDAOImpl();
    private ProcessorDAOImpl processorDAO = new ProcessorDAOImpl();

    public void saveLaptop(Laptop laptop) {
        processorDAO.saveProcessor(laptop.getProcessor());
        laptopDAO.saveLaptop(laptop);
    }

    public void getAllLaptops() {
        List<Laptop> laptops = laptopDAO.getAllLaptops();
        laptops.forEach(h -> {
            System.out.println(h.getLapId() + " " + h.getModelName() + " ");
        });
        laptops.forEach(h -> {
            System.out.println(h.getProcessor().getProcessorId() + " " + h.getProcessor().getModelNumber() + " " + h.getProcessor().getPrice());
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

    public void deleteLaptop(Long lapId) {
        laptopDAO.deleteLaptop(lapId);
    }

    public void changeProcessor(Long lapId, Long newProcessor) {
        Laptop laptop = laptopDAO.getLaptopById(lapId);
        Processor processor = processorDAO.getProcessorById(newProcessor);
        laptop.setProcessor(processor);
        laptopDAO.updateLaptop(laptop);
    }
}
