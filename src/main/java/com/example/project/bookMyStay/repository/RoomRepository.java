package com.example.project.bookMyStay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.bookMyStay.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {
    
}
