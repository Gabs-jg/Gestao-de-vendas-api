package com.gvendas.gestao_vendas.dto.sale;

import java.time.LocalDate;
import java.util.List;

public class SaleResponseDTO {

    private Long id;

    private LocalDate date;

    private List<ItemSaleResponseDTO> itemSaleResponseDTO;

    public SaleResponseDTO(Long id, LocalDate date, List<ItemSaleResponseDTO> itemSaleResponseDTO) {
        this.id = id;
        this.date = date;
        this.itemSaleResponseDTO = itemSaleResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ItemSaleResponseDTO> getItemSaleResponseDTO() {
        return itemSaleResponseDTO;
    }

    public void setItemSaleResponseDTO(List<ItemSaleResponseDTO> itemSaleResponseDTO) {
        this.itemSaleResponseDTO = itemSaleResponseDTO;
    }
}
