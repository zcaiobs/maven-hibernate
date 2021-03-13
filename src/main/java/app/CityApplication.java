package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class, args); 
        System.out.println("App Started '-'");
    }
}
