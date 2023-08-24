package com.workintech.main;

import com.workintech.librarysystem.Database;
import com.workintech.librarysystem.Member;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Database libraryDB = new Database();
        Member baha = new Member("baha","123456","baha@gmail.com","xyz","123465");
        libraryDB.addNewMember(baha);

        //libraryDB.getMembers().keySet().stream().toList().sort();

        Scanner scanner = new Scanner(System.in);
        Boolean isAppWorking = true;
        Member loggedInMember = null;
        while(isAppWorking) {
        System.out.println("Welcome to library. If you have an account please log in.");
        System.out.println("1-Sign in");
        System.out.println("2-Login");
        System.out.println("3-Exit");
        int input = scanner.nextInt();
        scanner.nextLine();
        switch (input) {
            //sign in
            case 1 :
                System.out.println("Enter username:");
                String username = scanner.nextLine();
                System.out.println("Username is: " + username);
                System.out.println("Enter email:");
                String email = scanner.nextLine();
                System.out.println("email is: " + email);
                System.out.println("Enter password:");
                String password = scanner.nextLine();
                System.out.println("password is: " + password);
                System.out.println("Enter address:");
                String address = scanner.nextLine();
                System.out.println("Enter phoneNumber:");
                String phoneNumber = scanner.nextLine();
                Member newMember = new Member(username,password,email,address,phoneNumber);
                libraryDB.addNewMember(newMember);
                System.out.println(libraryDB.getMembers());


            //login
            case 2 :
                System.out.println("Enter username:");
                username = scanner.nextLine();
                System.out.println("Username is: " + username);
                System.out.println("Enter password:");
                password = scanner.nextLine();
                System.out.println("password is: " + password);

                String finalUsername = username;
                String finalPassword = password;


            List<Member> foundUser = libraryDB.getMembers().values().stream()
                    .filter( m -> m.getUsername().equals(finalUsername) &&
                            m.getPassword().equals(finalPassword)).toList();


            if(foundUser.size()>0) {
                  System.out.println("user successfully logged in");
                  loggedInMember = foundUser.get(0);
                  transactions(loggedInMember);
                  scanner.nextLine();
              }
                break;
            case 3 :
                isAppWorking = false;
        }
    }
    }
    private static void transactions(Member loggedInMember) {
        System.out.println("you are in transactions");


    }

}
