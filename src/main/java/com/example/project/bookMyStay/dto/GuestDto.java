package com.example.project.bookMyStay.dto;

import com.example.project.bookMyStay.entity.User;
import com.example.project.bookMyStay.entity.enums.Gender;

import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
