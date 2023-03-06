package service.api;

import entity.Ram;

import java.util.List;

public interface RamService {
    void saveRam(Ram ram);

    void saveRamList(List<Ram> ramList);

    List<Ram> getAllRams();

    Ram getRamById(Long id);

    void updateRam(Ram ram);

    void deleteRam(Long ramId);
}
