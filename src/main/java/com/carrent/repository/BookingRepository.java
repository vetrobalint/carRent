package com.carrent.repository;

import com.carrent.domain.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

    @Query("SELECT booking.carId FROM Booking booking")
    List<Integer> carIds();

    List<Booking> findAll();
}
