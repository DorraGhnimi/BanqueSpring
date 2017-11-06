package tn.mine.banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("spring-beans-config.xml")    //deployer avec xml file
public class BanqueSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueSpringApplication.class, args);
	}
}
