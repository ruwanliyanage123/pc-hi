import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProcessorDAO {

    public void create(Processor processor) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(processor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Processor> read() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Processor> laptops = entityManager.createNamedQuery("SELECT processor FROM Processor processor", Processor.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    public void update(Processor processor, Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Processor pro = entityManager.find(Processor.class, id);
        pro.setModelNumber(processor.getModelNumber());
        pro.setPrice(processor.getPrice());
        entityManager.merge(pro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Processor processor = entityManager.find(Processor.class, id);
        entityManager.remove(processor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
