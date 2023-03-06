package service.api;

import entity.WifiRouter;

import java.util.List;

public interface WifiRouterService {
    void saveWifiRouter(WifiRouter wifiRouter);

    List<WifiRouter> getAllWifiRouters();

    WifiRouter getWifiRouterById(Long id);

    void updateWifiRouter(WifiRouter wifiRouter, Long id);

    void deleteWifiRouter(Long ramId);
}
