package com.example.project.bookMyStay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.bookMyStay.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}