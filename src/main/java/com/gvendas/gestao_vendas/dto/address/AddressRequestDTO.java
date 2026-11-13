package com.gvendas.gestao_vendas.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class AddressRequestDTO {

    @NotBlank(message = "Public Place")
    @Length(min = 3, max = 30, message = "Public Place")
    private String publicPlace;

    @NotNull(message = "Number")
    private Integer number;

    @Length(max = 30, message = "Complement")
    private String complement;

    @NotBlank(message = "Neighborhood")
    @Length(min = 3, max = 30, message = "Neighborhood")
    private String neighborhood;

    @NotBlank(message = "Postal Code")
    @Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "Postal Code")
    @Length(min = 3, max = 30, message = "Postal Code")
    private String postalCode;

    @NotBlank(message = "City")
    @Length(min = 3, max = 30, message = "City")
    private String city;

    @NotBlank(message = "State")
    @Length(min = 2, max = 30, message = "State")
    private String state;

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
}
