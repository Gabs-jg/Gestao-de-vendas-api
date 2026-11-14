package com.gvendas.gestao_vendas.dto.sale;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemSaleRequestDTO {

    private Long idProduct;
    private Integer quantity;
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
