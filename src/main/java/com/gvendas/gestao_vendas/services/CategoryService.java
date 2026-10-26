package com.gvendas.gestao_vendas.services;

import com.gvendas.gestao_vendas.entities.Category;
import com.gvendas.gestao_vendas.exceptions.ResourceNotFoundException;
import com.gvendas.gestao_vendas.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("teste"));
        // TODO: Tratar Not Found 404
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        Category categorySave = findById(id);
        // copia as propriedades do segundo parâmetro para o primeiro e ignora os campos do terceiro.
        BeanUtils.copyProperties(category, categorySave, "id");
        return categoryRepository.save(categorySave);
    }

//    private Category validateCategory(Long id) {
//        Optional<Category> category = Optional.ofNullable((findById(id)));
//        return category.orElseThrow(() -> new EmptyResultDataAccessException(1));
//    }

}
