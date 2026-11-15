package com.gvendas.gestao_vendas.dto.sale;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemSaleRequestDTO {

    @NotNull(message = "Id product")
    private Long idProduct;

    @NotNull(message = "Quantity")
    @Min(value = 1, message = "Quantity")
    private Integer quantity;

    @NotNull(message = "sellingPrice")
    private BigDecimal sellingPrice;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
