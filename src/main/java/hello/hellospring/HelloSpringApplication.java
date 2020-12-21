package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	// HelloSpringApplication를 실행하게 되며 내장된 tomcat이 함께 실행된다.
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
