package com.example.project.bookMyStay.service;


import org.springframework.data.domain.Page;

import com.example.project.bookMyStay.dto.HotelPriceDto;
import com.example.project.bookMyStay.dto.HotelSearchRequest;
import com.example.project.bookMyStay.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);
    
}
