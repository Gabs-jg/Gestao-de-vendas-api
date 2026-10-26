package com.gvendas.gestao_vendas.repositories;

import com.gvendas.gestao_vendas.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
