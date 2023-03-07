package dao.api;

import entity.Laptop;

import java.util.List;

public interface LaptopDAO {
    void saveLaptop(Laptop laptop);
    void saveLaptopList(List<Laptop> laptop);
    List<Laptop> getAllLaptops();
    Laptop getLaptopById(Long id);
    void updateLaptop(Laptop laptop);
    void deleteLaptop(Long id);
}
