package com.gvendas.gestao_vendas.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_cliente")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "telefone")
    private String telephone;

    @Column(name = "ativo")
    private Boolean active;

    @Embedded
    private Address address;

    public Customer() {}

    public Customer(String name, String telephone, Boolean active, Address address) {
        this.name = name;
        this.telephone = telephone;
        this.active = active;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(telephone, customer.telephone) && Objects.equals(active, customer.active) && Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, telephone, active, address);
    }
}
