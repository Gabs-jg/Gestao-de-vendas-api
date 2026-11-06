package com.gvendas.gestao_vendas.repositories;

import com.gvendas.gestao_vendas.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long idCategory);

    @Query("Select prod" +
            " from Product prod" +
            " where prod.id = :id" +
            " and prod.category.id = :idCategory")
    Optional<Product> findById(Long id, Long idCategory);

    Optional<Product> findByCategoryIdAndDescription(Long id, String description);

}
