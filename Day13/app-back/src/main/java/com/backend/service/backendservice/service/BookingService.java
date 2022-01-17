package com.backend.service.backendservice.service;

import java.time.LocalDate;
import java.util.*;

import com.backend.service.backendservice.model.Booking;
import com.backend.service.backendservice.repository.BookingRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    public List<Map<String, String>> selectRoomBooked(String id, LocalDate today) {
        return bookingRepo.selectRoomBooked(Integer.parseInt(id), today);
    }

    public int selectMaxId() {
        return bookingRepo.selectMaxId();
    }

}
