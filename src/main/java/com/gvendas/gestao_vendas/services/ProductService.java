package com.gvendas.gestao_vendas.services;

import com.gvendas.gestao_vendas.entities.Product;
import com.gvendas.gestao_vendas.exceptions.CategoryNotFoundException;
import com.gvendas.gestao_vendas.exceptions.ProductDuplicateException;
import com.gvendas.gestao_vendas.exceptions.ResourceNotFoundException;
import com.gvendas.gestao_vendas.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    // TODO: Terminar método que busca todos os produtos de uma categoria, adicionar no endpoint de categoria
    public List<Product> listAllByCategory(Long idCategory) {
        return productRepository.findByCategoryId(idCategory);
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Product save(Product product) {
        validatesIfProductCategoryExists(product.getCategory().getId());
        validateDuplicateProduct(product);
        return productRepository.save(product);
    }

    public Product update(Long idCategory, Long idProduct, Product product) {
        Product productSave = findById(idProduct);
        validateDuplicateProduct(product);
        validatesIfProductCategoryExists(idCategory);
        BeanUtils.copyProperties(product, productSave, "id");
        return productRepository.save(productSave);
    }


    // TODO: Arrumar esse método
    private void validatesIfProductCategoryExists(Long idCategory) {
        if(idCategory == null) {
            throw new CategoryNotFoundException("Category cannot be null");
        }

        if(categoryService.findById(idCategory).getClass().equals(ResourceNotFoundException.class)){
            throw new CategoryNotFoundException(String.format("Code category %s does not exist", idCategory));
        }
    }

    private void validateDuplicateProduct(Product product) {
        Optional<Product> productByDescription = productRepository.findByCategoryIdAndDescription(product.getCategory().getId(), product.getDescription())
        if(productByDescription.isPresent() && !Objects.equals(productByDescription.get().getId(), product.getId())) {
            throw new ProductDuplicateException(String.format("O produto %s já está cadastrado", product.getDescription()));
        }
    }

}
