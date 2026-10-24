package com.gvendas.gestao_vendas.repositories;

import com.gvendas.gestao_vendas.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
