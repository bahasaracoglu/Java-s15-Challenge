package com.workintech.librarysystem;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Bill {
    private String bookName;
    private String ownerName;
    private LocalDate borrowedDate;
    private LocalDate deliveryDate;
    private double price;

    public Bill(String bookName, String ownerName, LocalDate borrowedDate, LocalDate deliveryDate, double price) {
        this.bookName = bookName;
        this.ownerName = ownerName;
        this.borrowedDate = borrowedDate;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateFine(LocalDate borrowedDate, LocalDate deliveryDate) {

        double fine = 0;

        long daysBetween = DAYS.between(borrowedDate, deliveryDate);

        if (daysBetween>30) {
          fine = (daysBetween - 30)*0.2;
        }
        return fine;

    }


}
