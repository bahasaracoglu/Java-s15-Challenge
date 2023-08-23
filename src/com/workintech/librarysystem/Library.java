package com.workintech.librarysystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Library {

    private HashMap<Long,Book> books = new HashMap<>();

    private LinkedHashMap<Long,Member> members;

    private MemberRecord memberRecord = new MemberRecord();

    public Library() {
    }

    private Library(HashMap<Long, Book> books,  MemberRecord memberRecord) {
        this.books = books;
        this.memberRecord = memberRecord;
        this.members = memberRecord.getMembers();
    }

    public HashMap<Long,Book> getBooks() {
        return books;
    }

    public LinkedHashMap<Long, Member> getMembers() {
        return members;
    }

    public void newBook(Book book){
        books.put(book.getBook_ID(), book);
    }

    public void removeBook(long bookdID)
    {
        books.remove(bookdID);
    }

    public void lendBook(Book book, long memberId){

        //parametre olarak alının book'un statüsü değiştirilir

        if(books.containsValue(book)) {

            book.setStatus(Status.BORROWED);
            book.setOwnerID(memberId);
            books.put(book.getBook_ID(),book);

        }
    }

    public void returnBook (long bookID) {

      Book returnedBook = books.get(bookID);
      returnedBook.setStatus(Status.LOANABLE);
      returnedBook.setOwnerID(0);
      books.put(bookID,returnedBook);

    }


}
