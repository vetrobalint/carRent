package com.carrent.service;

import com.carrent.domain.Booking;
import com.carrent.repository.BookingRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class BookingService {
    private final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    BookingRepository bookingRepository;

    public void newBooking(Map<String, String> createBooking) throws ParseException {
        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(createBooking.get("startDate"));
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(createBooking.get("endDate"));
        long dateBeforeInMs = startDate.getTime();
        long dateAfterInMs = endDate.getTime();
        long timeDiff = Math.abs(dateAfterInMs - dateBeforeInMs);
        int days = (int) (timeDiff / (1000 * 60 * 60 * 24));

        int price = Integer.parseInt(createBooking.get("price"))*(days+1);
        Booking booking = new Booking(
                createBooking.get("name"),
                createBooking.get("email"),
                createBooking.get("address"),
                createBooking.get("phone"),
                (days+1),
                startDate,
                endDate,
                price,
                Integer.parseInt(createBooking.get("carId"))
        );
        bookingRepository.save(booking);
    }
}
