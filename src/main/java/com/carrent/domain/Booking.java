package com.carrent.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "days", nullable = false)
    private int days;

    @Column(name = "startdate", nullable = false)
    private Date startDate;

    @Column(name = "enddate", nullable = false)
    private Date endDate;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "carid", nullable = false)
    private int carId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Booking() {}

    public Booking(String name, String email, String address, String phone, int days, Date startDate, Date endDate, int price, int carId) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.days = days;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.carId = carId;
    }
}
