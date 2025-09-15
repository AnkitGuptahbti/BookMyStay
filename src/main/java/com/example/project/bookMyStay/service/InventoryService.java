package com.example.project.bookMyStay.service;

import com.example.project.bookMyStay.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);
    
}
