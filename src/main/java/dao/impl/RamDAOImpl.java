package dao.impl;

import dao.api.RamDAO;
import entity.Ram;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RamDAOImpl implements RamDAO {
    @Override
    public void saveRam(Ram ram) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(ram);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void saveRamList(List<Ram> ramList) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Ram ram: ramList){
            entityManager.merge(ram);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<Ram> getAllRams() {
        List<Ram> ramList;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ramList = entityManager.createQuery("SELECT ram FROM Ram ram").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return ramList;
    }

    @Override
    public Ram getRamById(Long id) {
        Ram ram;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        ram = entityManager.find(Ram.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return ram;
    }

    @Override
    public void updateRam(Ram ram) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Ram updatedRam = entityManager.find(Ram.class, ram.getRamId());
        updatedRam.setModelName(ram.getModelName());
        updatedRam.setStorage(ram.getStorage());
        entityManager.merge(updatedRam);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public void deleteRam(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Ram ram = entityManager.find(Ram.class, id);
        entityManager.remove(ram);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
