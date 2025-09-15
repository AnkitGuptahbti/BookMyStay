package com.example.project.bookMyStay.dto;

import com.example.project.bookMyStay.entity.HotelContactInfo;

import lombok.Data;

@Data
public class HotelDto {
    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;
}
