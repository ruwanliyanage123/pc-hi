package service.impl;

import dao.api.PrinterDAO;
import dao.impl.PrinterDAOImpl;
import entity.Printer;
import service.api.PrinterService;

import java.util.List;

public class PrinterServiceImpl implements PrinterService {
    PrinterDAO printerDAO = new PrinterDAOImpl();
    @Override
    public void savePrinter(Printer laptop) {
        printerDAO.savePrinter(laptop);
    }

    @Override
    public void getAllPrinters() {
        List<Printer> printers = printerDAO.getAllPrinters();
    }

    @Override
    public Printer getPrinterById(Long id) {
        return printerDAO.getPrinterById(id);
    }

    @Override
    public void updatePrinter(Printer laptop) {
        printerDAO.updatePrinter(laptop);
    }

    @Override
    public void deletePrinter(Long lapId) {
        printerDAO.deletePrinter(lapId);
    }
}
