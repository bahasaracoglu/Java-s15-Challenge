package com.workintech.librarysystem;

import java.util.HashSet;

public class Library {

    private HashSet<Book> books = new HashSet<>();
    private HashSet<Reader> readers = new HashSet<>();

    public HashSet<Book> getBooks() {
        return books;
    }

    public HashSet<Reader> getReaders() {
        return readers;
    }
    public void newBook(Book book){
        books.add(book);
    }
    public void lendBook(Book book){

        if(books.contains(book)) {
            book.setStatus("borrowed");
            books.remove(book);
            books.add(book);
        }
    }


}
