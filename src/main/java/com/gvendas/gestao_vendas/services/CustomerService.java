package com.gvendas.gestao_vendas.services;

import com.gvendas.gestao_vendas.entities.Customer;
import com.gvendas.gestao_vendas.exceptions.CustomerDuplicateException;
import com.gvendas.gestao_vendas.exceptions.ResourceNotFoundException;
import com.gvendas.gestao_vendas.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> listAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        Optional<Customer> obj = customerRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        // TODO: Tratar Not Found 404
    }

    public Customer save(Customer customer) {
        validateDuplicateCustomer(customer);
        return customerRepository.save(customer);
    }

    private void validateDuplicateCustomer(Customer customer) {
        Customer customerFound = customerRepository.findByName(customer.getName());
        if(customerFound != null && !Objects.equals(customerFound.getId(), customer.getId())) {
            throw new CustomerDuplicateException(String.format("The %s customer is already registered.", customer.getName().toUpperCase()));
        }
    }
}
