package com.gvendas.gestao_vendas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

// Para poder reutilizar o endereço em outras entidades injentando-as, o jpa reconhece que faz parte de uma unica tabela no bd
@Embeddable
public class Address {

    @Column(name = "logradouro")
    private String publicPlace;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "bairro")
    private String neighborhood;

    @Column(name = "cep")
    private String postalCode;

    @Column(name = "cidade")
    private String city;

    @Column(name = "estado")
    private String state;

    public Address() {}

    public Address(String publicPlace, Integer number, String complement, String neighborhood, String postalCode, String city, String state) {
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Address address)) return false;
        return Objects.equals(publicPlace, address.publicPlace) && Objects.equals(number, address.number) && Objects.equals(complement, address.complement) && Objects.equals(neighborhood, address.neighborhood) && Objects.equals(postalCode, address.postalCode) && Objects.equals(city, address.city) && Objects.equals(state, address.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicPlace, number, complement, neighborhood, postalCode, city, state);
    }
}
