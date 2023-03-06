package service.impl;

import dao.impl.ProcessorDAOImpl;
import entity.Processor;
import service.api.ProcessorService;

public class ProcessorServiceImpl implements ProcessorService {
    private ProcessorDAOImpl processorDAO = new ProcessorDAOImpl();

    public void create(Processor processor) {
        processorDAO.saveProcessor(processor);
    }

    public void read() {
        processorDAO.getAllProcessor().forEach(System.out::println);
    }

    public void update() {
        processorDAO.updateProcessor(new Processor("Intel7", 20000.50), 14L);
    }

    public void delete() {
        processorDAO.deleteProcessor(13L);
    }
}
