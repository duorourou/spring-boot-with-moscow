package demo.kanban.contract.moscow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by xchou on 4/12/16.
 */
@SpringBootApplication
@EnableMongoRepositories
public class Application  {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
