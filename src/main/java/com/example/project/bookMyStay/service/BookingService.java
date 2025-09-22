package com.example.project.bookMyStay.service;

import java.util.List;

import com.example.project.bookMyStay.dto.BookingDto;
import com.example.project.bookMyStay.dto.BookingRequest;
import com.example.project.bookMyStay.dto.GuestDto;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
