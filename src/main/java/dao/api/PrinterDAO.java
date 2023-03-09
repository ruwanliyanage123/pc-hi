package dao.api;

import entity.Laptop;
import entity.Printer;

import java.util.List;
import java.util.Set;

public interface PrinterDAO {
    void savePrinter(Printer printer);
    void savePrinterList(Set<Printer> printers);
    List<Printer> getAllPrinters();
    Printer getPrinterById(Long id);
    void updatePrinter(Printer laptop);
    void deletePrinter(Long id);
}
