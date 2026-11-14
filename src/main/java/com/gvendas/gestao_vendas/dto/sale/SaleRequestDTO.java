package com.gvendas.gestao_vendas.dto.sale;

import java.time.LocalDate;
import java.util.List;

public class SaleRequestDTO {

    private LocalDate date;
    private List<ItemSaleRequestDTO> itemSaleDTO;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ItemSaleRequestDTO> getItemSaleDTO() {
        return itemSaleDTO;
    }

    public void setItemSaleDTO(List<ItemSaleRequestDTO> itemSaleDTO) {
        this.itemSaleDTO = itemSaleDTO;
    }
}
