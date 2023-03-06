package dao.api;

import entity.Laptop;
import entity.Ram;

import java.util.List;

public interface RamDAO {
    void saveRam(Ram ram);
    void saveRamList(List<Ram> ram);
    List<Ram> getAllRams();
    Ram getRamById(Long id);
    void updateRam(Ram ram);
    void deleteRam(Long id);
}
