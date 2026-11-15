package com.gvendas.gestao_vendas.dto.sale;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class SaleRequestDTO {

    @NotNull(message = "Date")
    private LocalDate date;

    @NotNull(message = "ItemsSale")
    @Valid
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
