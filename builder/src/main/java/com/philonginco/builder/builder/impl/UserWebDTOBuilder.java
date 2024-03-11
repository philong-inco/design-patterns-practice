package com.philonginco.builder.builder.impl;

import com.philonginco.builder.builder.UserDTOBuilder;
import com.philonginco.builder.dto.UserDTO;
import com.philonginco.builder.dto.impl.UserWebDTO;
import com.philonginco.builder.entity.Address;

import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder {

    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private String address;

    private UserDTO userDTO;

    @Override
    public UserDTOBuilder withId(Long id) {
        this.id = String.valueOf(id);
        return this;
    }

    @Override
    public UserDTOBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public UserDTOBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public UserDTOBuilder withBirthday(LocalDate birthday) {
        Period ageInYear = Period.between(birthday, LocalDate.now());
        this.age = Integer.toString(ageInYear.getYears());
        return this;
    }

    @Override
    public UserDTOBuilder withAddress(Address address) {
        this.address = address.getHouseNumber()
                + ", " + address.getNameStreet()
                + ", " + address.getNameCity()
                + " City";
        return this;
    }

    @Override
    public UserDTO build() {
        this.userDTO = new UserWebDTO(id, firstName + " " + lastName, address, age);
        return userDTO;
    }

    @Override
    public UserDTO getUserDTO() {
        return userDTO;
    }
}
