package com.workintech.librarysystem;

import java.util.HashSet;

public class Author extends Person {

    private HashSet<Book> books = new HashSet<>();

    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Author(String firstName, String lastName, HashSet<Book> books) {
        super(firstName, lastName);
        this.books = books;

    }

    public void setBooks(HashSet<Book> books) {
        this.books = books;
    }

    public HashSet<Book> getBooks() {
        return books;
    }
    //newbook

//
    public void newBook(Book book) {

    books.add(book);

    }
    //showbook





}
