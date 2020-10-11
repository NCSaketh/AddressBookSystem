package com.cg.addressbooksystem;

import java.util.*;



public class AddressBookSystem {

    public static void main(String args[]) {
        System.out.println("Welcome to Address Book System");
        Scanner sc = new Scanner(System.in);

        HashMap<String, AddressBook> a = new HashMap<String, AddressBook>();


        int x = 0;
        System.out.println("Enter the number of the Address Books ");
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            System.out.println("Enter the name of the Address Book"+ ( i+1));
            String name = sc.next();
            AddressBook b = new AddressBook();
            a.put(name, b);
        }

        int num = 0;
        while (num != 5) {
            System.out.println("1.ADD A CONTACT DETAIL");
            System.out.println("2.EDIT EXISTING CONTACT USING NAME");
            System.out.println("3.VIEW CONTACT DETAILS USING NAME ");
            System.out.println("4.DELETE THE CONTACT OF A PERSON");
            System.out.println("5.EXIT");
            num = sc.nextInt();
            String name = new String();
            if (x != 5) {
                System.out.println("Exited out of the current Address Book. Now In which address book?");
                name = sc.next();
            }
            if (num == 1) {
                a.get(name).addContact();
            }
            if (num == 2) {
                System.out.println("Enter First Name");
                String fn = sc.next();
                System.out.println("Enter Last Name");
                String ln = sc.next();
                int i = 0;
                a.get(name).editContact(fn, ln, i);

            }
            if (num == 3) {
                System.out.println("Enter First Name");
                String fn = sc.next();
                System.out.println("Enter Last Name");
                String ln = sc.next();
                int i = 0;
                a.get(name).viewContact(fn, ln, i);

            }

            if (num == 4) {
                System.out.println("Enter the First Name");
                String fn = sc.next();
                System.out.println("Enter the Last Name");
                String ln = sc.next();
                int i = 0;
                a.get(name).deleteContact(fn, ln, i);

            }
        }
    }
}
