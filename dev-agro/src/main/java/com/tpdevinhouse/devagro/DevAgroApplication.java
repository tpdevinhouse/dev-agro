package com.tpdevinhouse.devagro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevAgroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevAgroApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Olá Mundo sou a API Dev-Agro";
	}

}
