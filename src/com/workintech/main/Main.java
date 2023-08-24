package com.workintech.main;

import com.workintech.librarysystem.*;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        //MemberRecord newRecord = new MemberRecord();
        Database mainDatabase = new Database();

        Librarian burcu = new Librarian("burcu", "calgin", "123", mainDatabase);

        Author gizem = new Author("gizem", "güzel");

        //Member baha = new Member(1,null,"baha","xyz","123465");
        //mainDatabase.addNewMember(baha);

        Book book1 = new Book(1, gizem, "book1", 12, Category.BIOGRAPHY, Status.LOANABLE, "y");
        //gizem.newBook(book1);
        mainDatabase.newBook(book1);
        //mainLibrary.getBooks();
       // System.out.println(mainLibrary.getBooks());
        burcu.issueBook(book1,1);
        System.out.println(burcu.returnBook(book1));
        //burcu.returnBook(book1);

//        System.out.println(baha);
//        System.out.println("all books "+ mainLibrary.getBooks());
//        System.out.println("bringbook with id"+burcu.bringBooks(1));
//        System.out.println(burcu.bringBooks("book1"));
//        System.out.println(burcu.bringBookWithAuthorName("gizem güzel"));
//        System.out.println(burcu.getBooksWithCategory(Category.BIOGRAPHY));
//        System.out.println(burcu.getBooksOfAuthor(gizem));
        //burcu.returnBook(1);
        //System.out.println(mainLibrary.getBooks());
        //System.out.println(gizem.getBooks());
        //gizem.whoYouAre();
        //System.out.println(gizem.whoYouAre());

    }
}