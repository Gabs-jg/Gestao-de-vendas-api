package com.gvendas.gestao_vendas.dto.sale;

import java.math.BigDecimal;

public class ItemSaleResponseDTO {

    private Long id;

    private Integer quantity;

    private BigDecimal sellingPrice;

    private Long idProduct;

    private String productDescription;

    public ItemSaleResponseDTO(Long id, Integer quantity, BigDecimal sellingPrice, Long idProduct, String productDescription) {
        this.id = id;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.idProduct = idProduct;
        this.productDescription = productDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
