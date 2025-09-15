package com.example.project.bookMyStay.service;

import java.util.List;

import com.example.project.bookMyStay.dto.RoomDto;

public interface RoomService {
 
    RoomDto createNewRoom(Long hotelId, RoomDto roomDto);

    List<RoomDto> getAllRoomsInHotel(Long hotelId);

    RoomDto getRoomById(Long hotelId);

    void deleteRoomById(Long roomId);

}
