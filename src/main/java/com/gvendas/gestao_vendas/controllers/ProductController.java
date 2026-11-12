package com.gvendas.gestao_vendas.controllers;

import com.gvendas.gestao_vendas.dto.product.ProductRequestDTO;
import com.gvendas.gestao_vendas.dto.product.ProductResponseDTO;
import com.gvendas.gestao_vendas.entities.Product;
import com.gvendas.gestao_vendas.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> listAll() {
        List<ProductResponseDTO> products = productService.listAll()
                .stream()
                .map(product -> ProductResponseDTO.convertToProductDto(product))
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

//    @GetMapping("/{idCategory}")
//    public ResponseEntity<List<Product>> listAllByCategory(@PathVariable Long idCategory) {
//        List<Product> products = productService.listAllByCategory(idCategory);
//        return ResponseEntity.ok(products);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        ProductResponseDTO productDto = ProductResponseDTO.convertToProductDto(product);
        return ResponseEntity.ok(productDto);
    }

    // TODO: Verificar
    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody ProductRequestDTO product) {
        Product obj = productService.save(product.convertToEntity(1L)); // Número long provisório
        ProductResponseDTO productDto = ProductResponseDTO.convertToProductDto(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    // TODO: Verificar esse método
    @PutMapping("/{idProduct}")
    public ResponseEntity<ProductResponseDTO> update(@PathVariable Long idCategory, @PathVariable Long idProduct, @Valid @RequestBody ProductRequestDTO product) {
        Product obj = productService.update(idCategory, idProduct, product.convertToEntity(idCategory, idProduct));
        ProductResponseDTO productDto = ProductResponseDTO.convertToProductDto(obj);
        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Void> delete(@PathVariable Long idProduct) {
        productService.delete(idProduct);
        return ResponseEntity.noContent().build();
    }

}
