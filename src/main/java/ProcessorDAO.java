import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProcessorDAO {

    public void saveProcessor(Processor processor) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(processor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Processor getProcessorById(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Processor processor = entityManager.find(Processor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return processor;
    }

    public List<Processor> getAllProcessor() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Processor> laptops = entityManager.createNamedQuery("SELECT processor FROM Processor processor", Processor.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return laptops;
    }

    public void updateProcessor(Processor processor, Long id) {
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

    public void deleteProcessor(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Processor processor = entityManager.find(Processor.class, id);
        entityManager.remove(processor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
