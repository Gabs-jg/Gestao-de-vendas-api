package com.gvendas.gestao_vendas.repositories;

import com.gvendas.gestao_vendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByCustomerId(Long idCustomer);

}
