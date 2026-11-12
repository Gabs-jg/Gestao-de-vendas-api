package com.gvendas.gestao_vendas.controllers;

import com.gvendas.gestao_vendas.dto.category.CategoryResponseDTO;
import com.gvendas.gestao_vendas.entities.Category;
import com.gvendas.gestao_vendas.entities.Customer;
import com.gvendas.gestao_vendas.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> listAll() {
        List<CustomerResponseDTO> list = customerService.listAll()
                .stream()
                .map(customer -> CustomerResponseDTO.convertToCustomerDTO(customer))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> findById(@PathVariable Long id) {
        Customer obj = customerService.findById(id);
        CustomerResponseDTO customer = CustomerResponseDTO.convertToCustomerDTO(obj);
        return ResponseEntity.ok(customer);
    }
}
