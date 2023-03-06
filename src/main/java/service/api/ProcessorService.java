package service.api;

import entity.Processor;

public interface ProcessorService {
    void create(Processor processor);

    void read();

    void update();

    void delete();
}
