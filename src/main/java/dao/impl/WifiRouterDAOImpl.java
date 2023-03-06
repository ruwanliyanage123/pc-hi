package dao.impl;

import dao.api.WifiRouterDAO;
import entity.WifiRouter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class WifiRouterDAOImpl implements WifiRouterDAO {
    @Override
    public void saveWifiRouter(WifiRouter wifiRouter) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(wifiRouter);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<WifiRouter> getAllWifiRouters() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<WifiRouter> routerList = entityManager.createQuery("SELECT wifi FROM WifiRouter wifi").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return routerList;
    }

    @Override
    public WifiRouter getWifiRouterById(Long id) {
        WifiRouter wifiRouter;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        wifiRouter = entityManager.find(WifiRouter.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return wifiRouter;
    }

    @Override
    public void updateWifiRouter(WifiRouter wifiRouter, Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        WifiRouter updatedRouter = entityManager.find(WifiRouter.class, id);
        updatedRouter.setModelName(wifiRouter.getModelName());
        updatedRouter.setSsid(wifiRouter.getSsid());
        entityManager.merge(updatedRouter);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void deleteWifiRouter(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        WifiRouter wifiRouter = entityManager.find(WifiRouter.class, id);
        entityManager.remove(wifiRouter);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
