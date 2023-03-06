package dao.api;

import entity.WifiRouter;

import java.util.List;

public interface WifiRouterDAO {
    void saveWifiRouter(WifiRouter ram);
    List<WifiRouter> getAllWifiRouters();
    WifiRouter getWifiRouterById(Long id);
    void updateWifiRouter(WifiRouter wifiRouter, Long id);
    void deleteWifiRouter(Long id);
}
