package demo.kanban.contract.moscow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by xchou on 4/12/16.
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application  {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
