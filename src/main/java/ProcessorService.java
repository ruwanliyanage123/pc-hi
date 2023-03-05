public class ProcessorService {
    private ProcessorDAO processorDAO = new ProcessorDAO();
    public void create(Processor processor){
        processorDAO.saveProcessor(processor);
    }
    public void read(){
        processorDAO.getAllProcessor().forEach(System.out::println);
    }
    public void update(){
        processorDAO.updateProcessor(new Processor("Intel7",20000.50), 14L);
    }
    public void delete(){
        processorDAO.deleteProcessor(13L);
    }
}
