import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class LaptopStore implements DeviceStore<Laptop> {
    private final Logger log = LoggerFactory.getLogger(LaptopStore.class);

    public void create(Laptop laptop) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laptop_persist");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        log.info("Added a Laptop into laptop class");
    }

    public List<Laptop> read() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laptop_persist");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptops = entityManager.createNamedQuery("Laptop.getAllLaptopDetails", Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return laptops;
    }

    public void update(Laptop laptop, Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laptop_persist");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop selectedLap = entityManager.find(Laptop.class, id);
        selectedLap.setBrandName(laptop.getBrandName());
        selectedLap.setModelName(laptop.getModelName());
        selectedLap.setSerialNumber(laptop.getSerialNumber());
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public void delete(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laptop_persist");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("Laptop.deleteGivenLaptop");
        query.setParameter("id",id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
