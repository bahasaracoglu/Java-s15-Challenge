package com.workintech.librarysystem;

import java.util.HashSet;

public class Reader extends Person {


    private HashSet<Book> books = new HashSet<>();
    public Reader(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Reader(String firstName, String lastName, HashSet<Book> books) {
        super(firstName, lastName);
        this.books = books;
    }

}
