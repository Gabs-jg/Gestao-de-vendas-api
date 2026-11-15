package com.gvendas.gestao_vendas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name= "tb_venda")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long id;

    @Column(name = "data")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente", referencedColumnName = "codigo")
    private Customer customer;

    public Sale() {
    }

    public Sale(LocalDate date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }

    public Sale(Long id ,LocalDate date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sale sale)) return false;
        return Objects.equals(id, sale.id) && Objects.equals(date, sale.date) && Objects.equals(customer, sale.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, customer);
    }
}
