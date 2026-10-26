package com.gvendas.gestao_vendas.services;

import com.gvendas.gestao_vendas.entities.Category;
import com.gvendas.gestao_vendas.exceptions.CategoryDuplicateException;
import com.gvendas.gestao_vendas.exceptions.ResourceNotFoundException;
import com.gvendas.gestao_vendas.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        validateDuplicateCategory(category);
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category category) {
        Category categorySave = findById(id);
        validateDuplicateCategory(category);
        // copia as propriedades do segundo parâmetro para o primeiro e ignora os campos do terceiro.
        BeanUtils.copyProperties(category, categorySave, "id");
        return categoryRepository.save(categorySave);
    }

    // TODO: Conferir por que não lança exceção quando tenta deletar com id inexistente
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    private void validateDuplicateCategory(Category category) {
        Category categoryFound = categoryRepository.findByName(category.getName());
        if(categoryFound != null && !Objects.equals(categoryFound.getId(), category.getId())) {
            throw new CategoryDuplicateException(String.format("The %s category is already registered.", category.getName().toUpperCase()));
        }
    }

//    private Category validateCategory(Long id) {
//        Optional<Category> category = Optional.ofNullable((findById(id)));
//        return category.orElseThrow(() -> new EmptyResultDataAccessException(1));
//    }

}
