package service.api;

import entity.Laptop;

public interface LaptopService {
    void saveLaptop(Laptop laptop);

    void getAllLaptops();

    void getLaptopById(Long id);

    void updateLaptop(Laptop laptop);

    void deleteLaptop(Long lapId);

    void changeProcessor(Long lapId, Long newProcessor);
}
