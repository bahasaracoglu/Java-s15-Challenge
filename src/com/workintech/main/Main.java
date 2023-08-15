package com.workintech.main;

import com.workintech.librarysystem.Author;
import com.workintech.librarysystem.Book;
import com.workintech.librarysystem.Librarian;
import com.workintech.librarysystem.Library;

public class Main {
    public static void main(String[] args) {

        Library mainLibrary = new Library();
        Librarian burcu = new Librarian("burcu", "calgin", "123", mainLibrary);

        Author gizem = new Author("gizem", "güzel");

        Book book1 = new Book(1, gizem, "book1", 12, "x", "y");
        //gizem.newBook(book1);
        mainLibrary.newBook(book1);
        mainLibrary.getBooks();
        System.out.println(mainLibrary.getBooks());


        //System.out.println(gizem.getBooks());
        //gizem.whoYouAre();
        //System.out.println(gizem.whoYouAre());

    }
}