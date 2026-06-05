package com.localservicefinder.servicefinder.controller;

import com.localservicefinder.servicefinder.entity.Booking;
import com.localservicefinder.servicefinder.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin("*")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/save")
    public Booking saveBooking(
            @RequestBody Booking booking){

        booking.setStatus("Pending");

        return bookingRepository.save(booking);
    }

    @GetMapping("/user/{userName}")
    public List<Booking> getBookings(
            @PathVariable String userName){

        return bookingRepository.findByUserName(userName);
    }

    @GetMapping("/worker/{workerName}")
    public List<Booking> getWorkerBookings(
            @PathVariable String workerName){

        return bookingRepository.findByWorkerName(workerName);
    }

    @PutMapping("/{id}/{status}")
    public Booking updateStatus(
            @PathVariable Long id,
            @PathVariable String status){

        Booking booking =
                bookingRepository.findById(id)
                        .orElse(null);

        if(booking != null){

            booking.setStatus(status);

            return bookingRepository.save(booking);
        }

        return null;
    }
}