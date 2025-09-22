package com.example.project.bookMyStay.service;

import com.example.project.bookMyStay.dto.HotelDto;
import com.example.project.bookMyStay.dto.HotelInfoDto;

public interface HotelService {
    
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long id);

    HotelInfoDto getHotelInfoById(Long hotelId);
}
