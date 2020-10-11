package com.cg.addressbooksystem;

import java.util.Scanner;

class Contact {
    Scanner sc = new Scanner(System.in);
    String first_name, last_name, address, String, city, state, zip, ph_no, email;

    public void addContact() {

        System.out.println("Enter First Name");
        this.first_name = sc.next();
        System.out.println("Enter Last Name");
        this.last_name = sc.next();
        System.out.println("Enter Address");
        this.address = sc.next();
        System.out.println("Enter city");
        this.city = sc.next();
        System.out.println("Enter state");
        this.state = sc.next();
        System.out.println("Enter zip code");
        this.zip = sc.next();
        System.out.println("Enter phone number");
        String ph_no = sc.next();
        System.out.println("Enter email");
        String email = sc.next();
    }
}
