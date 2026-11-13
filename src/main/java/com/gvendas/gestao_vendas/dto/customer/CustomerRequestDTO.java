package com.gvendas.gestao_vendas.dto.customer;

import com.gvendas.gestao_vendas.dto.address.AddressRequestDTO;
import com.gvendas.gestao_vendas.entities.Address;
import com.gvendas.gestao_vendas.entities.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;


public class CustomerRequestDTO {

    @NotBlank(message = "Name")
    @Length(min = 3, max=50, message = "Name")
    private String name;

    @NotBlank(message = "Telephone")
    @Pattern(regexp = "\\([\\d]{2}\\) [\\d]{5}[- ][\\d]{4}", message = "Telephone")
    private String telephone;

    @NotNull(message = "Active")
    private Boolean active;

    @NotNull(message = "Address")
    @Valid
    private AddressRequestDTO address;

    public Customer convertToEntity() {
        Address addressData = new Address(address.getPublicPlace(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getPostalCode(),
                address.getCity(),
                address.getState());
        return new Customer(name, telephone, active, addressData);
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

    public AddressRequestDTO getAddress() {
        return address;
    }

    public void setAddress(AddressRequestDTO address) {
        this.address = address;
    }
}
