package com.workintech.main;

import com.workintech.librarysystem.Author;
import com.workintech.librarysystem.Book;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

       Author gizem = new Author("gizem","güzel");

       Book book1 = new Book(1,gizem,"book1",12,"x","y");
       gizem.newBook(book1);

        System.out.println(gizem.getBooks());
        gizem.whoYouAre();
        System.out.println(gizem.whoYouAre());

    }
}