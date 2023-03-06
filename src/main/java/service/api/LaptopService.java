package service.api;

import entity.Laptop;
import entity.Ram;

public interface LaptopService {
    void saveLaptop(Laptop laptop);

    void getAllLaptops();

    Laptop getLaptopById(Long id);

    void updateLaptop(Laptop laptop);

    void deleteLaptop(Long lapId);

    void changeProcessor(Long lapId, Long newProcessor);

    void changeRam(Ram ram, Long lapId, Long ramId);
}
