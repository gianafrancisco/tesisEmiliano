package utn.emiliano.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by francisco on 03/02/16.
 */
@SpringBootApplication
@ComponentScan(basePackages = "utn.emiliano")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
