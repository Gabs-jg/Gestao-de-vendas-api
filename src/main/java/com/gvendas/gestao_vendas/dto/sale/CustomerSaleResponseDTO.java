package com.gvendas.gestao_vendas.dto.sale;

import java.util.List;

public class CustomerSaleResponseDTO {

    private String name;

    private List<SaleResponseDTO> saleResponseDTO;

    public CustomerSaleResponseDTO(String name, List<SaleResponseDTO> saleResponseDTO) {
        this.name = name;
        this.saleResponseDTO = saleResponseDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SaleResponseDTO> getSaleResponseDTO() {
        return saleResponseDTO;
    }

    public void setSaleResponseDTO(List<SaleResponseDTO> saleResponseDTO) {
        this.saleResponseDTO = saleResponseDTO;
    }
}
