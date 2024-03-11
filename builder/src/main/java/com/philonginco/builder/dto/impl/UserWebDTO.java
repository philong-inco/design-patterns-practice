package com.philonginco.builder.dto.impl;

import com.philonginco.builder.dto.UserDTO;

public class UserWebDTO implements UserDTO {

    private String id;
    private String fullName;
    private String fullAddress;
    private String age;


    public UserWebDTO(String id, String fullName, String fullAddress, String age) {
        this.id = id;
        this.fullName = fullName;
        this.fullAddress = fullAddress;
        this.age = age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getFullAddress() {
        return fullAddress;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserWebDTO{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
