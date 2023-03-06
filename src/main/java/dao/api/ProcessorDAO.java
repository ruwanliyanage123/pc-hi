package dao.api;

import entity.Processor;

import java.util.List;

public interface ProcessorDAO {
    void saveProcessor(Processor processor);

    Processor getProcessorById(Long id);

    List<Processor> getAllProcessor();

    void updateProcessor(Processor processor, Long id);

    void deleteProcessor(Long id);
}
