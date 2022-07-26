package com.carrent.repository;

import com.carrent.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface CarRepository extends JpaRepository<Car, Integer> {

//    @Query("SELECT car FROM Car car, Booking WHERE Car.id=Booking.carId AND Booking.startDate NOT BETWEEN ?1 AND ?2 AND Booking.endDate NOT BETWEEN ?1 AND ?2")
//    List<Car> search(Date startDate, Date endDate) throws Exception;

    @Query("SELECT car FROM Car car WHERE car.available=true")
    List<Car> isAvailable();

}
