package service.impl;

import dao.api.WifiRouterDAO;
import dao.impl.WifiRouterDAOImpl;
import entity.WifiRouter;
import service.api.WifiRouterService;

import java.util.List;

public class WifiRouterServiceImpl implements WifiRouterService {
    private WifiRouterDAO wifiRouterDAO = new WifiRouterDAOImpl();
    @Override
    public void saveWifiRouter(WifiRouter wifiRouter) {
        wifiRouterDAO.saveWifiRouter(wifiRouter);
    }

    @Override
    public List<WifiRouter> getAllWifiRouters() {
        return wifiRouterDAO.getAllWifiRouters();
    }

    @Override
    public WifiRouter getWifiRouterById(Long id) {
        return wifiRouterDAO.getWifiRouterById(id);
    }

    @Override
    public void updateWifiRouter(WifiRouter wifiRouter, Long id) {
        wifiRouterDAO.updateWifiRouter(wifiRouter, id);
    }

    @Override
    public void deleteWifiRouter(Long ramId) {
        wifiRouterDAO.deleteWifiRouter(ramId);
    }
}
