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
    public Boolean searchBook(String name) {

        List<Book> books = library.getBooks().values().stream().toList();
        for (Book book : books
        ) {
            if (book.getName().equals(name) && book.getStatus().equals(Status.LOANABLE)) return true;
        }
        return false;

    }

    public Boolean verifyMember(Long memberID) {
        return !(memberRecord.getMember(memberID) == null);
    }

    public void issueBook(Book book, long memberId) {
        if (searchBook(book.getName())) {
            library.lendBook(book, memberId);
        }
    }

    public Book bringBooks(long id) {
        return library.getBooks().get(id);
    }

    public void bringBooks(String bookName) {
        library.getBooks().values().stream()
                .filter(book -> book.getName() == bookName)
                .forEach(System.out::println);

    }

    public void bringBookWithAuthorName(String authorName){
        library.getBooks().values().stream()
                .filter(book -> (book.getAuthor().getFirstName() +" "
                        +book.getAuthor().getLastName()).equals(authorName))
                .forEach(System.out::println);

    }

}