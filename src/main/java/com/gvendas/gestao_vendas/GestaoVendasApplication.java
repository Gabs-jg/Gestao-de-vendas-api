package com.gvendas.gestao_vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.gvendas.gestao_vendas.entities"})
@EnableJpaRepositories(basePackages = {"com.gvendas.gestao_vendas.repositories"})
@ComponentScan(basePackages = {"com.gvendas.gestao_vendas.services", "com.gvendas.gestao_vendas.controllers", "com.gvendas.gestao_vendas.exceptions"})
@SpringBootApplication
public class GestaoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVendasApplication.class, args);
	}

}
