package br.com.alura.spring.data;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication  {



	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	
}