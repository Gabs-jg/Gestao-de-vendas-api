package com.gvendas.gestao_vendas.controllers;

import com.gvendas.gestao_vendas.dto.category.CategoryRequestDTO;
import com.gvendas.gestao_vendas.dto.category.CategoryResponseDTO;
import com.gvendas.gestao_vendas.entities.Category;
import com.gvendas.gestao_vendas.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> listAll() {
        List<CategoryResponseDTO> list = categoryService.listAll()
                .stream()
                .map(category -> CategoryResponseDTO.convertToCategoryDTO(category))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> findById(@PathVariable Long id) {
        Category obj = categoryService.findById(id);
        CategoryResponseDTO category = CategoryResponseDTO.convertToCategoryDTO(obj);
        return ResponseEntity.ok(category);
    }

    // TODO: Resolver status code 404 quando tenta cadastrar uma categoria existente
    @PostMapping
    public ResponseEntity<CategoryResponseDTO> save(@Valid @RequestBody CategoryRequestDTO categoryDto) {
        Category obj = categoryService.save(categoryDto.convertToEntity());
        CategoryResponseDTO category = CategoryResponseDTO.convertToCategoryDTO(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryRequestDTO categoryDto) {
        Category categorySave = categoryService.update(id, categoryDto.convertToEntity(id));
        CategoryResponseDTO objDto = CategoryResponseDTO.convertToCategoryDTO(categorySave);
        return ResponseEntity.ok(objDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
