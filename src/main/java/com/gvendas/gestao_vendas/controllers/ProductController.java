package com.gvendas.gestao_vendas.controllers;

import com.gvendas.gestao_vendas.entities.Product;
import com.gvendas.gestao_vendas.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listAll(@PathVariable Long idCategory) {
        List<Product> products = productService.listAll(idCategory);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long idCategory ,@PathVariable Long id) {
        Product product = productService.findById(id, idCategory);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        Product obj = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

}
