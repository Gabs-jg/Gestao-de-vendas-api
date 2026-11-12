package com.gvendas.gestao_vendas.dto.product;

import com.gvendas.gestao_vendas.entities.Category;
import com.gvendas.gestao_vendas.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class ProductRequestDTO {

    @NotBlank(message = "Description")
    @Length(min = 3, max=100, message = "Description")
    private String description;

    @NotNull(message = "Quantity")
    private Integer quantity;

    @NotNull(message = "Cost price")
    private BigDecimal cost_price;

    @NotNull(message = "Selling price")
    private BigDecimal selling_price;

    @Length(max=500, message = "Observation")
    private String observation;

    public Product convertToEntity(Long idCategory) {
        return new Product(description, quantity, cost_price, selling_price, observation, new Category(idCategory));
    }

    public Product convertToEntity(Long idCategory, Long idProduct) {
        return new Product(idProduct, description, quantity, cost_price, selling_price, observation, new Category(idCategory));
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
}
