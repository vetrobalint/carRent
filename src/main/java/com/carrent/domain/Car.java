package com.carrent.domain;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gearshift", nullable = false)
    private String gearShift;

    @Column(name = "seats", nullable = false)
    private int seats;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "picture")
    private String picture;

    @Column(name = "available")
    private boolean available;

    public Car(){}

    public Car(int id, String name, String gearShift, int seats, int price, String picture, boolean available) {
        this.id = id;
        this.name = name;
        this.gearShift = gearShift;
        this.seats = seats;
        this.price = price;
        this.picture = picture;
        this.available = available;
    }

    public Car(String name, String gearShift, int seats, int price, String picture, boolean available) {
        this.name = name;
        this.gearShift = gearShift;
        this.seats = seats;
        this.price = price;
        this.picture = picture;
        this.available = available;
    }

    public Car(String name, String gearShift, int seats, int price) {
        this.name = name;
        this.gearShift = gearShift;
        this.seats = seats;
        this.price = price;
    }

    public Car(int id, String name, String gearShift, int seats, int price, boolean available) {
        this.id = id;
        this.name = name;
        this.gearShift = gearShift;
        this.seats = seats;
        this.price = price;
        this.available = available;
    }

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

    public String getGearShift() {
        return gearShift;
    }

    public void setGearShift(String gearShift) {
        this.gearShift = gearShift;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isAvailable() {return available;}

    public void setAvailable(boolean available) {this.available = available;}

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gearShift='" + gearShift + '\'' +
                ", seats=" + seats +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", available=" + available +
                '}';
    }
}
