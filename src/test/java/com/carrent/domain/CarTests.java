package com.carrent.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CarTests {

    @Test
    public void carTestConstructors(){
        Car car = new Car();
        Car car2 = new Car(1,"Auto","Manual",5,1340,"picture",true);
        Car car3 = new Car("Car","Good",5,762432,"images",false);
        Car car4 = new Car("Type","Cool",4,5345);
        Car car5 = new Car(57,"SUV","Automatic",7,12678,true);

        assert(car2.getName().contains("Auto"));
        assert(car2.getPrice() == 1340);
        assert(!car3.isAvailable());
        assert(car3.getPicture().contains("images"));
        assert(car4.getName().contains("Type"));
        assert(car4.getSeats() == 4);
        assert(car5.getGearShift().contains("Automatic"));
        assert(car5.getId() == 57);
    }
}
