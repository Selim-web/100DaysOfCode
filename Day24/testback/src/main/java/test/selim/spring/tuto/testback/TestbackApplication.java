package test.selim.spring.tuto.testback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestbackApplication.class, args);
        /*for(int i = 1; i < 100; i++){
            System.out.println("("+i+","+i+",'room',"+i+"),");
        }*/
    }

}
