package com.gvendas.gestao_vendas.dto.category;

import com.gvendas.gestao_vendas.entities.Category;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class CategoryRequestDTO {

    @NotBlank(message = "Name")
    @Length(min = 3, max = 50, message = "Name")
    private String name;

    public Category convertToEntity() {
        return new Category(name);
    }

    public Category convertToEntity(Long id) {
        return new Category(id, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
