package com.gvendas.gestao_vendas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "descricao")
    @NotBlank(message = "Description")
    @Length(min = 3, max=100, message = "Description")
    private String description;

    @Column(name = "quantidade")
    @NotNull(message = "Quantity")
    private Integer quantity;

    @Column(name = "preco_custo")
    @NotNull(message = "Cost price")
    private BigDecimal cost_price;

    @Column(name = "preco_venda")
    @NotNull(message = "Selling price")
    private BigDecimal selling_price;

    @Column(name = "observacao")
    @Length(max=500, message = "Observation")
    private String observation;

    @NotNull(message = "Category")
    @ManyToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost_price() {
        return cost_price;
    }

    public void setCost_price(BigDecimal cost_price) {
        this.cost_price = cost_price;
    }

    public BigDecimal getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(BigDecimal selling_price) {
        this.selling_price = selling_price;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id) && Objects.equals(description, product.description) && Objects.equals(quantity, product.quantity) && Objects.equals(cost_price, product.cost_price) && Objects.equals(selling_price, product.selling_price) && Objects.equals(observation, product.observation) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, quantity, cost_price, selling_price, observation, category);
    }
}
