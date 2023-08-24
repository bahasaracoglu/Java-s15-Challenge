package com.workintech.librarysystem;

import java.time.LocalDate;
import java.util.List;

public class Librarian extends Person {

    private Database database;
    private String password;


    public Librarian(String firstName, String lastName, String password, Database database) {
        super(firstName, lastName);
        this.password = password;
        this.database = database;

    }

    //test edilecek return her zaman false dönebilir!!
    public Boolean searchBook(long bookID) {

        List<Book> books = database.getBooks().values().stream().toList();
        for (Book book : books
        ) {
            if (book.getBook_ID() == (bookID) && book.getStatus().equals(Status.LOANABLE)) return true;
        }
        return false;

    }

    public Boolean verifyMember(Long memberID) {
        return !(database.getMember(memberID) == null);
    }

    public Bill issueBook(Book book, long memberId) {
        if (searchBook(book.getBook_ID())) {
            database.lendBook(book, memberId);

        }
        return purchaseBill(book);
    }

    public Book bringBooks(long id) {
        return database.getBooks().get(id);
    }

    public List<Book> bringBooks(String bookName) {
        return database.getBooks().values().stream()
                .filter(book -> book.getName() == bookName)
                .toList();
    }

    public List<Book> bringBookWithAuthorName(String authorName) {

        return database.getBooks().values().stream()
                .filter(book -> (book.getAuthor().getFirstName() + " "
                        + book.getAuthor().getLastName()).equals(authorName))
                .toList();
    }

    //Sistemde var olan bir kitabın bilgileri güncellenebilir.
    public void updateBook(Book book) {
        database.newBook(book);
    }

    public void removeBook(long bookID) {
        database.removeBook(bookID);
    }

    public List<Book> getBooksWithCategory(Category category) {
        return database.getBooks().values().stream()
                .filter(book -> book.getCategory().equals(category)).toList();
    }

    public List<Book> getBooksOfAuthor(Author author) {
        return database.getBooks().values().stream()
                .filter(book -> book.getAuthor().equals(author)).toList();
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