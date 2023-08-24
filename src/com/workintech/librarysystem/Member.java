package com.workintech.librarysystem;

import java.time.LocalDate;

public class Member {

    private long memberID;
    private String type;
    private LocalDate dateOfMembership;
    private int maxBookLimit;
    private int numberOfBooksIssued;
    private String name;
    private String address;
    private String phoneNumber;

    public Member(long memberID, String type,  String name, String address, String phoneNumber) {
        this.memberID = memberID;
        this.type = type;
        this.dateOfMembership = LocalDate.now();
        maxBookLimit = 5;
        numberOfBooksIssued = 0;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }



    public long getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
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
                ", type='" + type + '\'' +
                ", dateOfMembership=" + dateOfMembership +
                ", maxBookLimit=" + maxBookLimit +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
