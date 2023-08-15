package com.workintech.librarysystem;

import java.util.HashMap;
import java.util.HashSet;

public class Library {

    private HashMap<Long,Book> books = new HashMap<>();
    private HashSet<Reader> readers = new HashSet<>();

    public Library() {
    }

    public Library(HashMap<Long, Book> books, HashSet<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    public HashMap<Long,Book> getBooks() {
        return books;
    }

    public HashSet<Reader> getReaders() {
        return readers;
    }
    public void newBook(Book book){
        books.put(book.getBook_ID(), book);
    }
    public void lendBook(Book book){

        if(books.containsValue(book)) {
            book.setStatus("borrowed");
            books.remove(book);
            books.put(book.getBook_ID(),book);
        }
    }


}
