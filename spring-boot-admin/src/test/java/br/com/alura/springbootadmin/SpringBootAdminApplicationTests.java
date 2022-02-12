package br.com.alura.springbootadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;


@Configuration 
@EnableAutoConfiguration
@EnableAdminServer
class SpringBootAdminApplicationTests {

public static void main(String[] args) {
	SpringApplication.run(SpringBootAdminApplication.class, args);
}

}
