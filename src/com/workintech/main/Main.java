package com.workintech.main;

import com.workintech.librarysystem.*;

public class Main {
    public static void main(String[] args) {

        Library mainLibrary = new Library();
        Librarian burcu = new Librarian("burcu", "calgin", "123", mainLibrary);

        Author gizem = new Author("gizem", "güzel");

        Member baha = new Member(1,null,"baha","xyz","123465");

        Book book1 = new Book(1, gizem, "book1", 12, Status.LOANABLE, "y");
        //gizem.newBook(book1);
        mainLibrary.newBook(book1);
        //mainLibrary.getBooks();
       // System.out.println(mainLibrary.getBooks());
        burcu.issueBook(book1,1);
        System.out.println(baha);
        System.out.println("all books "+ mainLibrary.getBooks());
        System.out.println("bringbook with id"+burcu.bringBooks(1));
        burcu.bringBooks("book1");
        burcu.bringBookWithAuthorName("gizem güzel");



        //System.out.println(gizem.getBooks());
        //gizem.whoYouAre();
        //System.out.println(gizem.whoYouAre());

    }
}