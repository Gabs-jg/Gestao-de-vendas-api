package com.gvendas.gestao_vendas.services;

import com.gvendas.gestao_vendas.dto.sale.ItemSaleResponseDTO;
import com.gvendas.gestao_vendas.dto.sale.SaleResponseDTO;
import com.gvendas.gestao_vendas.entities.ItemSale;
import com.gvendas.gestao_vendas.entities.Sale;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractSaleService {


    protected SaleResponseDTO createSaleResponseDTO(Sale sale, List<ItemSale> itemSaleList) {
        List<ItemSaleResponseDTO> itemsSaleResponseDTO =itemSaleList
                .stream().map(this::createItemsSaleResponseDTO).collect(Collectors.toList());

        return new SaleResponseDTO(sale.getId(), sale.getDate(), itemsSaleResponseDTO);
    }

    protected ItemSaleResponseDTO createItemsSaleResponseDTO(ItemSale itemSale) {
        return new ItemSaleResponseDTO(itemSale.getId(), itemSale.getQuantity(), itemSale.getSellingPrice(), itemSale.getProduct().getId(), itemSale.getProduct().getDescription());
    }

}
