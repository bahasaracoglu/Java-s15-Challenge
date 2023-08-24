package com.workintech.librarysystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Database {

    private static HashMap<Long, Book> books;
    private static LinkedHashMap<Long, Member> members;
    private static int nextMemberId;


    public Database() {
        this.books = new HashMap<>();
        this.members = new LinkedHashMap();
        nextMemberId = 1;
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
        if ( getMember(memberId).getNumberOfBooksIssued() < 5) {
            book.setStatus(Status.BORROWED);
            book.setDateOfPurchase(LocalDate.now());
            book.setOwnerID(memberId);
            books.put(book.getBook_ID(), book);
            getMember(memberId).incBookIssued();
        }
    }

    public void returnBook(Book book) {
        book.setStatus(Status.LOANABLE);
        long memberID = book.getBook_ID();
        book.setOwnerID(0);
        getMember(memberID).decBookIssued();
        books.put(book.getBook_ID(), book);
    }

    //member

    public void addNewMember(Member member) {
        long memberId = nextMemberId;
        members.put(memberId, member);
        nextMemberId ++;
    }

    public void removeMember(Long id) {
        members.remove(id);
    }

    public Member getMember(Long id) {
        return members.get(id);

    }

    public static int getNextMemberId() {
        return nextMemberId;
    }


}
