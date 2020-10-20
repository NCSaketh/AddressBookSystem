package com.cg.addressbooksystem;

import java.util.Scanner;

class Contact {
    Scanner sc = new Scanner(System.in);
    String first_name, last_name, address, String, city, state, zip, ph_no, email;

    public boolean equals(Contact cnt) {
        if (cnt.first_name.equalsIgnoreCase(this.first_name) && cnt.last_name.equalsIgnoreCase(this.last_name)) {
            return true;
        } else {
            return false;
        }
    }
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
        this.ph_no = sc.next();
        System.out.println("Enter email");
        this.email = sc.next();
    }
    public void editContact()
    {
        System.out.println("Enter Address");
        this.address=sc.next();
        System.out.println("Enter city");
        this.city=sc.next();
        System.out.println("Enter state");
        this.state=sc.next();
        System.out.println("Enter zip code");
        this.zip=sc.next();
        System.out.println("Enter phone number");
        this.ph_no=sc.next();
        System.out.println("Enter email");
        this.email=sc.next();
    }
    public void viewContact()
    {
        System.out.println("ADDRESS = "+this.address);
        System.out.println("CITY = "+this.city);
        System.out.println("STATE = "+this.state);
        System.out.println("ZIP = "+this.zip);
        System.out.println("PHONE NUMBER ="+this.ph_no);
        System.out.println("EMAIL ="+this.email);
    }
}
