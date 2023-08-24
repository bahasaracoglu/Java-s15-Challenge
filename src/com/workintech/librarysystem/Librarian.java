package com.workintech.librarysystem;

import java.time.LocalDate;
import java.util.List;

public class Librarian extends Person {

    private Database database;
    private String password;
    private MemberRecord memberRecord;

    public Librarian(String firstName, String lastName, String password, Database database, MemberRecord memberRecord) {
        super(firstName, lastName);
        this.password = password;
        this.database = database;
        this.memberRecord = memberRecord;
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
        return !(memberRecord.getMember(memberID) == null);
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
        database.returnBook(book);
        return returnBill(book);
    }

    public Bill returnBill(Book book) {

        Bill newBill = new Bill(book.getName(),memberRecord.getMember(book.getOwnerID()).getName(),
                book.getDateOfPurchase(), LocalDate.now(), book.getPrice());
        return newBill;
    }

    public Bill purchaseBill(Book book) {
        Bill newBill = new Bill(book.getName(), memberRecord.getMember(book.getOwnerID()).getName(),
                book.getDateOfPurchase(), book.getPrice());
        return newBill;
    }


}