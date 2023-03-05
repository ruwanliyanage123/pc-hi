import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LaptopDAO {

    public void saveLaptop(Laptop laptop) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(laptop);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Laptop> getAllLaptops() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Laptop> laptops = entityManager.createNamedQuery("Laptop.getAllLaptopDetails", Laptop.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    public Laptop getLaptopById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Laptop laptop = entityManager.find(Laptop.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptop;
    }

    public void updateLaptop(Laptop laptop, Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop lap = entityManager.find(Laptop.class, id);
        lap.setModelName(laptop.getModelName());
        lap.setPrice(laptop.getPrice());
        entityManager.merge(lap);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteLaptop(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Laptop lap = entityManager.find(Laptop.class, id);
        entityManager.remove(lap);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
