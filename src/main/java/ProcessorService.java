public class ProcessorService {
    private ProcessorDAO processorDAO = new ProcessorDAO();
    public void create(Processor processor){
        processorDAO.create(processor);
    }
    public void read(){
        processorDAO.read().forEach(System.out::println);
    }
    public void update(){
        processorDAO.update(new Processor("Intel7",20000.50), 14L);
    }
    public void delete(){
        processorDAO.delete(13L);
    }
}
