package springboot.security.hibernate.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	// http://localhost:8080/
	// http://user:user@localhost:8080/
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
}
