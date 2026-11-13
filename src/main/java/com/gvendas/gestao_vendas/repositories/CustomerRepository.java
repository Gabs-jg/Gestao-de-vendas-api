package com.gvendas.gestao_vendas.repositories;

import com.gvendas.gestao_vendas.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);

}
