package com.example.project.bookMyStay.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.bookMyStay.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
