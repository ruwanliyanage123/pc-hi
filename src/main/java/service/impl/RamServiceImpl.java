package service.impl;

import dao.api.RamDAO;
import dao.impl.RamDAOImpl;
import entity.Ram;
import service.api.RamService;

import java.util.List;

public class RamServiceImpl implements RamService {
    private RamDAO ramDAO = new RamDAOImpl();

    public void saveRam(Ram ram) {
        ramDAO.saveRam(ram);
    }

    public void saveRamList(List<Ram> ramList){
        ramDAO.saveRamList(ramList);
    }

    public List<Ram> getAllRams() {
        return ramDAO.getAllRams();
    }

    @Override
    public Ram getRamById(Long id) {
        return ramDAO.getRamById(id);
    }

    public void updateRam(Ram ram) {
        ramDAO.updateRam(ram);
    }

    @Override
    public void deleteRam(Long ramId) {
        ramDAO.deleteRam(ramId);
    }
}
