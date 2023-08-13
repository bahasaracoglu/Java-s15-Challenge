package com.workintech.librarysystem;

public class Librarian extends Person {

    private  String password;
    public Librarian(String firstName, String lastName, String password) {
        super(firstName, lastName);
        this.password=password;
    }

}
