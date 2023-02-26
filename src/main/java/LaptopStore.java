import org.hibernate.annotations.NamedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        //Query query = entityManager.createQuery("UPDATE Laptop lap SET lap.brand_name = :brand, lap.model_name = :model, lap.serial_number = :serial  WHERE lap.lapId= :id");
        //note: if we added @namedQuery in the enity class, that will take priority than here. another thing is seems this cannot understand the underscore brand_name, and need to give as brandName.
        Query query = entityManager.createQuery("UPDATE Laptop lap SET lap.brandName = :brand, lap.modelName = :model, lap.serialNumber = :serial  WHERE lap.lapId= :id");
        query.setParameter("id", id);
        query.setParameter("model", laptop.getModelName());
        query.setParameter("brand", laptop.getBrandName());
        query.setParameter("serial", laptop.getSerialNumber());
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public void delete(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("laptop_persist");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("Laptop.deleteGivenLaptop");
        query.setParameter("id", id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
