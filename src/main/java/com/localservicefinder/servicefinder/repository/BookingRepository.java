package com.localservicefinder.servicefinder.repository;

import com.localservicefinder.servicefinder.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository
        extends JpaRepository<Booking, Long> {

    List<Booking> findByUserName(String userName);

    List<Booking> findByWorkerName(String workerName);

}