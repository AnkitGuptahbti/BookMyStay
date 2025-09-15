package com.example.project.bookMyStay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.bookMyStay.entity.Inventory;
import com.example.project.bookMyStay.entity.Room;

public interface InvertoryRepository  extends JpaRepository<Inventory,Long>{

    void deleteByRoom(Room room);
    
}
