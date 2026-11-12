package com.gvendas.gestao_vendas.dto.category;


import com.gvendas.gestao_vendas.entities.Category;

public class CategoryResponseDTO {
    private Long id;
    private String name;

    public CategoryResponseDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CategoryResponseDTO convertToCategoryDTO(Category category) {
        return new CategoryResponseDTO(category.getId(), category.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
