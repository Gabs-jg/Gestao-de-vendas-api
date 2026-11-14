package com.gvendas.gestao_vendas.repositories;

import com.gvendas.gestao_vendas.entities.ItemSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemSaleRepository extends JpaRepository<ItemSale, Long> {

    List<ItemSale> findBySaleId(Long idSale);

}
