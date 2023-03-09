package service.api;

import entity.Printer;

public interface PrinterService {
    void savePrinter(Printer laptop);

    void getAllPrinters();

    Printer getPrinterById(Long id);

    void updatePrinter(Printer laptop);

    void deletePrinter(Long lapId);

}
