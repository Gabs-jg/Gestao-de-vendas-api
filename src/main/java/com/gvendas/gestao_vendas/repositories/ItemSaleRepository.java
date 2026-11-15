package com.gvendas.gestao_vendas.repositories;

import com.gvendas.gestao_vendas.entities.ItemSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemSaleRepository extends JpaRepository<ItemSale, Long> {

    @Query("select new com.gvendas.gestao_vendas.entities.ItemSale("
            + " is.id, is.quantity, is.sellingPrice, is.product, is.sale)"
            + " from ItemSale is"
            + " where is.sale.id = :idSale")
    List<ItemSale> findBySaleId(Long idSale);

}
