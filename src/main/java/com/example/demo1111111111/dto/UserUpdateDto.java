package com.example.demo1111111111.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserUpdateDto {
    private long id;
    public String firstName;
    public String lastName;
}
