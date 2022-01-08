package com.frontend.Services;

import com.frontend.Model.Booking;
import com.frontend.Repository.BookingProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingProxy proxy;

    public void saveBooking(Booking booking) {
        proxy.saveBooking(booking);
    }

    public void saveMeetingBooking(Booking booking, String listEmployee) {
        proxy.saveMeetingBooking(booking, listEmployee);
    }
}
