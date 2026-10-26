package com.gvendas.gestao_vendas.controllers;

import com.gvendas.gestao_vendas.entities.Category;
import com.gvendas.gestao_vendas.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listAll() {
        List<Category> list = categoryService.listAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = categoryService.findById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<Category> save(@Valid @RequestBody Category category) {
        Category obj = categoryService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @Valid @RequestBody Category category) {
        Category categorySave = categoryService.update(id, category);
        return ResponseEntity.ok(categorySave);
    }
}
