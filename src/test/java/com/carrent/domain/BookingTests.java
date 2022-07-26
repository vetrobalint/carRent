package com.carrent.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;


@SpringBootTest
public class BookingTests {

    @Test
    public void bookingTestConstructors(){
        Booking booking = new Booking();
        Booking booking2 = new Booking("Name","email","address","+3623452",3,new Date(2022-07-23),new Date(2022-07-25),78563,1);

        assert(booking2.getAddress().contains("address"));
        assert(booking2.getName().contains("Name"));
        assert(booking2.getDays() == 3);
        assert(booking2.getCarId() == 1);
    }
}
