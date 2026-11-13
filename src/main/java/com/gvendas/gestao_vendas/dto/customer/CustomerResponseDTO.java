package com.gvendas.gestao_vendas.dto.customer;

import com.gvendas.gestao_vendas.dto.address.AddressResponseDTO;
import com.gvendas.gestao_vendas.entities.Address;
import com.gvendas.gestao_vendas.entities.Customer;

public class CustomerResponseDTO {

    private Long id;

    private String name;

    private String telephone;

    private Boolean active;

    private AddressResponseDTO address;

    public CustomerResponseDTO(Long id, String name, String telephone, Boolean active, AddressResponseDTO address) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.active = active;
        this.address = address;
    }

    public static CustomerResponseDTO convertToCustomerDTO(Customer customer) {
        AddressResponseDTO address = new AddressResponseDTO(customer.getAddress().getPublicPlace(),
                customer.getAddress().getNumber(),
                customer.getAddress().getComplement(),
                customer.getAddress().getNeighborhood(),
                customer.getAddress().getPostalCode(),
                customer.getAddress().getCity(),
                customer.getAddress().getState());
        return new CustomerResponseDTO(customer.getId(), customer.getName(), customer.getTelephone(), customer.getActive(), address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public AddressResponseDTO getAddress() {
        return address;
    }

    public void setAddress(AddressResponseDTO address) {
        this.address = address;
    }
}
