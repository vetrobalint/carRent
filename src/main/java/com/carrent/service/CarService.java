package com.carrent.service;

import com.carrent.domain.Car;
import com.carrent.repository.BookingRepository;
import com.carrent.repository.CarRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarService {
    private final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    CarRepository carRepository;

    @Autowired
    BookingRepository bookingRepository;

    @NonNull
    public void editCar(Map<String, String> updateCar){
        int id = Integer.parseInt(updateCar.get("id"));
        String name;
        String gearShift;
        int seats;
        int price;
        boolean available;
        List<Integer> bookedCarsId = bookingRepository.carIds();

        if (updateCar.get("name").equals("")) {
            name = carRepository.findById(id).get().getName();
        } else {
            name = updateCar.get("name");
        }
        if (updateCar.get("gearShift").equals("")) {
            gearShift = carRepository.findById(id).get().getGearShift();
        } else {
            gearShift = updateCar.get("gearShift");
        }
        if (updateCar.get("seats").equals("")) {
            seats = carRepository.findById(id).get().getSeats();
        } else {
            seats = Integer.parseInt(updateCar.get("seats"));
        }
        if (updateCar.get("price").equals("")) {
            price = carRepository.findById(id).get().getPrice();
        } else {
            price = Integer.parseInt(updateCar.get("price"));
        }
        if (updateCar.get("available").equals("")) {
            available = carRepository.findById(id).get().isAvailable();
        } else {
            available = Boolean.parseBoolean(updateCar.get("available"));
        }

        for(Integer i : bookedCarsId){
            if(i == id){
                available = true;
            }
        }

        Car updatedCar = new Car(id, name, gearShift, seats, price, available);
        carRepository.save(updatedCar);
    }

    @NonNull
    public void newCar(Map<String, String> createCar){
        Car saveNewCar = new Car(
                createCar.get("name"),
                createCar.get("gearShift"),
                Integer.parseInt(createCar.get("seats")),
                Integer.parseInt(createCar.get("price")),
                createCar.get("picture"),
                Boolean.parseBoolean(createCar.get("available"))
        );
        carRepository.save(saveNewCar);
    }
}
