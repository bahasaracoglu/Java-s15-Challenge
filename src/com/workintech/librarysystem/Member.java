package com.workintech.librarysystem;

import java.time.LocalDate;

public class Member {

    private long memberID;
    private LocalDate dateOfMembership;
    private int maxBookLimit;
    private int numberOfBooksIssued;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;

    public Member( String username,String password, String email, String address, String phoneNumber) {
        memberID = Database.getNextMemberId();
        this.dateOfMembership = LocalDate.now();
        maxBookLimit = 5;
        numberOfBooksIssued = 0;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }



    public long getMemberID() {
        return memberID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getNumberOfBooksIssued() {
        return numberOfBooksIssued;
    }

    public void incBookIssued() {
        this.numberOfBooksIssued += 1;
    }
    public void decBookIssued() {
        this.numberOfBooksIssued -= 1;
    }


    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", dateOfMembership=" + dateOfMembership +
                ", maxBookLimit=" + maxBookLimit +
                ", numberOfBooksIssued=" + numberOfBooksIssued +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
