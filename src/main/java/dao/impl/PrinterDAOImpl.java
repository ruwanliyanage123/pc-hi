package dao.impl;

import dao.api.PrinterDAO;
import entity.Printer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class PrinterDAOImpl implements PrinterDAO {
    @Override
    public void savePrinter(Printer printer) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(printer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void savePrinterList(Set<Printer> printers) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Printer printer:printers) {
            entityManager.merge(printer);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<Printer> getAllPrinters() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Printer> laptops = entityManager.createQuery("SELECT printer FROM Printer printer").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    @Override
    public Printer getPrinterById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Printer printer = entityManager.find(Printer.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return printer;
    }

    @Override
    public void updatePrinter(Printer printer) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Printer print = entityManager.find(Printer.class, printer.getPrinterId());
        print.setModelName(printer.getModelName());
        entityManager.merge(printer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deletePrinter(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Printer printer = entityManager.find(Printer.class, id);
        entityManager.remove(printer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
