package com.workintech.librarysystem;

import java.time.LocalDate;

public class Book {

    private long book_ID;
    private Author author;
    private String name;
    private double price;
    private String status;
    private String edition;
    //private LocalDate date_of_purchase;

    public Book(long book_ID, Author author, String name, double price, String status, String edition) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        //this.date_of_purchase = date_of_purchase;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", edition='" + edition + '\'' +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
