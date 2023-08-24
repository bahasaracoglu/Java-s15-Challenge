package com.workintech.librarysystem;

import java.time.LocalDate;
import java.util.List;

public abstract class LibraryMember {
    protected Database database;


    public Boolean searchBook(long bookID) {
        List<Book> books = database.getBooks().values().stream().toList();
        for (Book book : books
        ) {
            if (book.getBook_ID() == (bookID) && book.getStatus().equals(Status.LOANABLE)) return true;
        }
        return false;
    }


    public Bill issueBook(Book book, long memberId) {
        if (searchBook(book.getBook_ID())) {
            database.lendBook(book, memberId);
        }
        return purchaseBill(book);
    }

    public Bill returnBook(Book book) {
        Bill returnBill = returnBill(book);
        database.returnBook(book);
        return returnBill;
    }

    public Bill returnBill(Book book) {
        Bill newBill = new Bill(book.getName(),database.getMember(book.getOwnerID()).getUsername(),
                book.getDateOfPurchase(), LocalDate.now(), book.getPrice());
        return newBill;
    }

    public Bill purchaseBill(Book book) {
        Bill newBill = new Bill(book.getName(), database.getMember(book.getOwnerID()).getUsername(),
                book.getDateOfPurchase(), book.getPrice());
        return newBill;
    }
}
