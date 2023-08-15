package com.workintech.librarysystem;

import java.util.HashSet;

public class Librarian extends Person {

    private Library library;
    private  String password;
    public Librarian(String firstName, String lastName, String password, Library library) {
        super(firstName, lastName);
        this.password=password;
        this.library=library;
    }

    public Boolean searchBook(String name) {

     HashSet<Book> books = (HashSet<Book>) library.getBooks().values();
        for (Book book: books
             ) {
           if(book.getName().equals(name)) return true;

        }

        return null;

    }

}
