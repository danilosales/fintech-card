package br.com.danilosales.credito.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FintechServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FintechServerApplication.class, args);
	}

}
