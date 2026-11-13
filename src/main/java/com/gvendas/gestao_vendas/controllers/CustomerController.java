package com.gvendas.gestao_vendas.controllers;

import com.gvendas.gestao_vendas.dto.customer.CustomerRequestDTO;
import com.gvendas.gestao_vendas.dto.customer.CustomerResponseDTO;
import com.gvendas.gestao_vendas.entities.Customer;
import com.gvendas.gestao_vendas.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // TODO: Resolver erro 500 quando tenta cadastrar um cliente existente
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> save(@Valid @RequestBody CustomerRequestDTO customerDto) {
        Customer obj = customerService.save(customerDto.convertToEntity());
        CustomerResponseDTO customer = CustomerResponseDTO.convertToCustomerDTO(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
