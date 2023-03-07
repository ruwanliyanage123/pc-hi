package service.api;

import entity.Laptop;
import entity.Ram;

import java.util.List;

public interface LaptopService {
    void saveLaptop(Laptop laptop);

    void saveLaptopList(List<Laptop> laptop);

    void getAllLaptops();

    Laptop getLaptopById(Long id);

    void updateLaptop(Laptop laptop);

    void deleteLaptop(Long lapId);
    void changeSSID(Long lapId);
    void changeProcessor(Long lapId, Long newProcessor);

    void changeRam(Ram ram, Long lapId, Long ramId);
}
