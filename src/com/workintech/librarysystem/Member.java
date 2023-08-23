package com.workintech.librarysystem;

import java.time.LocalDate;

public class Member {

    private long memberID;
    private String type;
    private LocalDate dateOfMembership;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNumber;

    public Member(long memberID, String type,  String name, String address, String phoneNumber) {
        this.memberID = memberID;
        this.type = type;
        this.dateOfMembership = LocalDate.now();
        this.maxBookLimit = 5;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public long getMemberID() {
        return memberID;
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
