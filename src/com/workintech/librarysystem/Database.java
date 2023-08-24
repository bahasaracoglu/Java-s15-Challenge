package com.workintech.librarysystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Database {

    private static HashMap<Long, Book> books;

    private static LinkedHashMap<Long, Member> members;

    private static MemberRecord memberRecord;


    private Database(MemberRecord memberRecord) {
        this.books = new HashMap<>();
        this.members = memberRecord.getMembers();
    }

    public HashMap<Long, Book> getBooks() {
        return books;
    }

    public LinkedHashMap<Long, Member> getMembers() {
        return members;
    }

    public void newBook(Book book) {
        books.put(book.getBook_ID(), book);
    }

    public void removeBook(long bookdID) {
        books.remove(bookdID);
    }

    public void lendBook(Book book, long memberId) {

        //parametre olarak alının book'un statüsü değiştirilir

        if (books.containsValue(book) && memberRecord.getMember(memberId).getNumberOfBooksIssued() < 5) {

            book.setStatus(Status.BORROWED);
            book.setDateOfPurchase(LocalDate.now());
            book.setOwnerID(memberId);
            books.put(book.getBook_ID(), book);
            memberRecord.getMember(memberId).incBookIssued();
        }
    }

    public void returnBook(Book book) {


        book.setStatus(Status.LOANABLE);
        book.setOwnerID(0);
        books.put(book.getBook_ID(), book);


    }


}
