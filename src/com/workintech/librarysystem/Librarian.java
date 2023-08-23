package com.workintech.librarysystem;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

public class Librarian extends Person {

    private Library library;
    private String password;

    private MemberRecord memberRecord;

    public Librarian(String firstName, String lastName, String password, Library library) {
        super(firstName, lastName);
        this.password = password;
        this.library = library;
    }

    //test edilecek return her zaman false dönebilir!!
    public Boolean searchBook(long bookID) {

        List<Book> books = library.getBooks().values().stream().toList();
        for (Book book : books
        ) {
            if (book.getBook_ID() == (bookID) && book.getStatus().equals(Status.LOANABLE)) return true;
        }
        return false;

    }

    public Boolean verifyMember(Long memberID) {
        return !(memberRecord.getMember(memberID) == null);
    }

    public void issueBook(Book book, long memberId) {
        if (searchBook(book.getBook_ID())) {
            library.lendBook(book, memberId);
        }
    }

    public Book bringBooks(long id) {
        return library.getBooks().get(id);
    }

    public List<Book> bringBooks(String bookName) {
        return library.getBooks().values().stream()
                .filter(book -> book.getName() == bookName)
                .toList();

    }

    public List<Book> bringBookWithAuthorName(String authorName) {

        return library.getBooks().values().stream()
                .filter(book -> (book.getAuthor().getFirstName() + " "
                        + book.getAuthor().getLastName()).equals(authorName))
                .toList();
    }

    //Sistemde var olan bir kitabın bilgileri güncellenebilir.
    public void updateBook(Book book) {
        library.newBook(book);
    }

    public void removeBook(long bookID) {
        library.removeBook(bookID);
    }

    public List<Book> getBooksWithCategory(Category category) {
        return library.getBooks().values().stream()
                .filter(book -> book.getCategory().equals(category)).toList();
    }

    public List<Book> getBooksOfAuthor(Author author) {
        return library.getBooks().values().stream()
                .filter(book -> book.getAuthor().equals(author)).toList();
    }
    public void returnBook(long bookID) {
        library.returnBook(1);
    }

}