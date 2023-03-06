import entity.Laptop;
import entity.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Processor processor() {
        Processor processor = new Processor("i5-10210U", 500.0);
        return processor;
    }

    @Bean
    public Laptop getLaptop() {
        Laptop laptop = new Laptop("Dell Inspiron 15", 700.0);
        return laptop;
    }
}
