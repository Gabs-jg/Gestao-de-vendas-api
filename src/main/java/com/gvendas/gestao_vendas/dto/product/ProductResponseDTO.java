package com.gvendas.gestao_vendas.dto.product;

import com.gvendas.gestao_vendas.dto.category.CategoryResponseDTO;
import com.gvendas.gestao_vendas.entities.Product;

import java.math.BigDecimal;

public class ProductResponseDTO {

    private Long id;

    private String description;

    private Integer quantity;

    private BigDecimal cost_price;

    private BigDecimal selling_price;

    private String observation;

    private CategoryResponseDTO category;

    public ProductResponseDTO(Long id, String description, Integer quantity, BigDecimal cost_price, BigDecimal selling_price, String observation, CategoryResponseDTO category) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.cost_price = cost_price;
        this.selling_price = selling_price;
        this.observation = observation;
        this.category = category;
    }

    public static ProductResponseDTO convertToProductDto(Product product) {
        return new ProductResponseDTO(product.getId(), product.getDescription(), product.getQuantity(), product.getCost_price(), product.getSelling_price(), product.getObservation(), CategoryResponseDTO.convertToCategoryDTO(product.getCategory()));
    }

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

    public CategoryResponseDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDTO category) {
        this.category = category;
    }
}
