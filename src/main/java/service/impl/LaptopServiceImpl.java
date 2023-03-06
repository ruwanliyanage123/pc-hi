package service.impl;

import dao.api.LaptopDAO;
import dao.api.ProcessorDAO;
import dao.api.RamDAO;
import dao.impl.LaptopDAOImpl;
import dao.impl.ProcessorDAOImpl;
import dao.impl.RamDAOImpl;
import entity.Laptop;
import entity.Processor;
import service.api.LaptopService;

import java.util.List;

public class LaptopServiceImpl implements LaptopService {
    private LaptopDAO laptopDAO = new LaptopDAOImpl();
    private ProcessorDAO processorDAO = new ProcessorDAOImpl();
    private RamDAO ramDAO = new RamDAOImpl();

    public void saveLaptop(Laptop laptop) {
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

    public Laptop getLaptopById(Long id) {
        return laptopDAO.getLaptopById(id);
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