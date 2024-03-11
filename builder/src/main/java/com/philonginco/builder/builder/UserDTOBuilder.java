package com.philonginco.builder.builder;

import com.philonginco.builder.dto.UserDTO;
import com.philonginco.builder.entity.Address;

import java.time.LocalDate;

public interface UserDTOBuilder {

    UserDTOBuilder withId(Long id);

    UserDTOBuilder withFirstName(String firstName);

    UserDTOBuilder withLastName(String lastName);

    UserDTOBuilder withBirthday(LocalDate birthday);

    UserDTOBuilder withAddress(Address address);

    UserDTO build();

    UserDTO getUserDTO();

}
