package com.philonginco.builder;

import com.philonginco.builder.builder.UserDTOBuilder;
import com.philonginco.builder.builder.impl.UserAppDTOBuilder;
import com.philonginco.builder.builder.impl.UserWebDTOBuilder;
import com.philonginco.builder.dto.UserDTO;
import com.philonginco.builder.entity.Address;
import com.philonginco.builder.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BuilderApplication {

    private User user;

    @PostConstruct
    public void createUser() {
        user = new User();
        user.setId(1L);
        user.setFirstName("Long");
        user.setLasttName("Nguyen Vinh");
        user.setBirthday(LocalDate.of(1997, 10, 22));

        Address address = new Address();
        address.setId(1L);
        address.setHouseNumber("30");
        address.setNameStreet("Ngoc Thuy");
        address.setNameCity("Ha Noi");
        address.setState("Viet Nam");
        address.setZipcode("100000");

        user.setAddress(address);
    }

    public static void main(String[] args) {
        SpringApplication.run(BuilderApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return runner -> {
            convertToUserWeb(user);
            convertToUserApp(user);
        };
    }

    private void convertToUserWeb(User theUser) {
        UserDTOBuilder builder = new UserWebDTOBuilder();
        UserDTO userDTO = directBuilder(builder, theUser);
        System.out.println("UserDTOWeb not contains state and zipcode");
        System.out.println(userDTO.toString());
    }

    private void convertToUserApp(User theUser) {
        UserDTOBuilder builder = new UserAppDTOBuilder();
        UserDTO userDTO = directBuilder(builder, theUser);
        System.out.println("UserDTOWeb have state and zipcode");
        System.out.println(userDTO.toString());
    }

    public UserDTO directBuilder(UserDTOBuilder builder, User theUser) {
        return  builder.withId(theUser.getId())
                .withFirstName(theUser.getFirstName())
                .withLastName(theUser.getLasttName())
                .withAddress(theUser.getAddress())
                .withBirthday(theUser.getBirthday())
                .build();

    }


}
