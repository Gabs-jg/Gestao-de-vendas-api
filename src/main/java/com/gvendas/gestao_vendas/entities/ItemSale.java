package com.gvendas.gestao_vendas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_item_venda")
public class ItemSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "quantidade")
    private Integer quantity;

    @Column(name = "preco_vendido")
    private BigDecimal sellingPrice;

    @ManyToOne
    @JoinColumn(name = "codigo_produto", referencedColumnName = "codigo")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "codigo_venda", referencedColumnName = "codigo")
    private Sale sale;

    public ItemSale() {
    }

    public ItemSale(Integer quantity, BigDecimal sellingPrice, Product product, Sale sale) {
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.product = product;
        this.sale = sale;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemSale itemSale)) return false;
        return Objects.equals(id, itemSale.id) && Objects.equals(quantity, itemSale.quantity) && Objects.equals(sellingPrice, itemSale.sellingPrice) && Objects.equals(product, itemSale.product) && Objects.equals(sale, itemSale.sale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, sellingPrice, product, sale);
    }
}
