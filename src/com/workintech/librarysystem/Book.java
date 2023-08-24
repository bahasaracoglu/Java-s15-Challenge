package com.workintech.librarysystem;

import java.time.LocalDate;

public class Book {

    private long book_ID;
    private Author author;
    private String name;
    private double price;
    private Status status;
    private Category category;
    private String edition;

    private LocalDate dateOfPurchase;
    private long ownerID;

    public Book(long book_ID, Author author, String name, double price,Category category, Status status, String edition) {
        this.book_ID = book_ID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.category = category;
        this.status = status;
        this.edition = edition;
        //this.date_of_purchase = date_of_purchase;
    }

    public long getBook_ID() {
        return book_ID;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getEdition() {
        return edition;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setBook_ID(long book_ID) {
        this.book_ID = book_ID;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_ID=" + book_ID +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", category=" + category +
                ", edition='" + edition + '\'' +
                ", ownerID=" + ownerID +
                '}';
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
