package utn.emiliano.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import utn.emiliano.port.Serial;

/**
 * Created by francisco on 03/02/16.
 */
@SpringBootApplication
@ComponentScan(basePackages = "utn.emiliano")
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class);

        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.headless(false);
        ConfigurableApplicationContext ctx = builder.run(args);

        Serial ll = (Serial) ctx.getBean("serialPort");
        Thread tr = new Thread(ll);
        tr.start();

    }
}
