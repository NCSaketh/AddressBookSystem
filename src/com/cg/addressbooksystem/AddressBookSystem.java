package com.cg.addressbooksystem;

import java.util.*;
import java.util.stream.Collectors;


public class AddressBookSystem {

    static boolean checkDuplicate(AddressBook adbook, Contact contact) {
        return (adbook.contact.stream().anyMatch(c -> c.equals(contact)));
    }

    static List<Contact> searchNameByCity(AddressBook adbook,String cityString)
    {
        return adbook.contact.stream().filter(c-> c.city.equals(cityString)).collect(Collectors.toList());
    }

    public static void main(String args[]) {
        System.out.println("Welcome to Address Book System");
        Scanner sc = new Scanner(System.in);

        ArrayList<AddressBook> adbook = new ArrayList<AddressBook>();

        int r = 0;
        while (r != 3) {
            System.out.println("1.CREATE AN ADDRESS BOOK");
            System.out.println("2.ACCESS AN ADDRESS BOOK");
            System.out.println("3.SEARCH PERSON IN A CITY ACROSS ALL ADDRESS BOOKS");
            System.out.println("4.EXIT APPLICATION");
            r = sc.nextInt();
            AddressBook book;
            switch (r) {
                case 1: {
                    System.out.println("Enter the name of the Address Book  to be created");
                    String n = sc.next();
                    int key = 0;
                    for (int i = 0; i < adbook.size(); i++) {
                        if (adbook.get(i).BookName.equalsIgnoreCase(n)) {
                            key = 1;
                            break;
                        }
                    }
                    if (key == 0) {
                        AddressBook b = new AddressBook();
                        b.BookName = n;
                        b.contact = new ArrayList<Contact>();
                        adbook.add(b);
                        break;
                    } else {
                        System.out.println("Provided Address Book Already Exists.");
                    }
                    break;
                }

                case 2: {
                    int key = 0;
                    System.out.println("Enter the address book name to be accessed");
                    String b = sc.next();
                    for (int j = 0; j < adbook.size(); j++) {
                        if (adbook.get(j).BookName.equalsIgnoreCase(b)) {
                            key = 1;

                            int num = 0;
                            while (num != 5) {
                                System.out.println("1.ADD A CONTACT DETAIL");
                                System.out.println("2.EDIT EXISTING CONTACT USING NAME");
                                System.out.println("3.VIEW CONTACT DETAILS USING NAME ");
                                System.out.println("4.DELETE THE CONTACT OF A PERSON");
                                System.out.println("5.EXIT");
                                num = sc.nextInt();
                                String name = new String();


                                if (num == 1) {
                                    Contact a = new Contact();
                                    a.addContact();
                                    if (checkDuplicate(adbook.get(j), a)) {
                                        System.out.println("Provided Contact Already Exists");
                                    } else {
                                        adbook.get(j).contact.add(a);
                                    }
                                } else if (num == 2) {
                                    System.out.println("Enter First Name");
                                    String fn = sc.next();
                                    System.out.println("Enter Last Name");
                                    String ln = sc.next();
                                    int k = 0, i = 0;
                                    for (i = 0; i < adbook.get(j).contact.size(); i++) {
                                        if (adbook.get(j).contact.get(i).first_name.equalsIgnoreCase(fn) && adbook.get(j).contact.get(i).last_name.equalsIgnoreCase(ln)) {
                                            k = 1;
                                            break;
                                        }
                                    }
                                    if (k == 0) {
                                        System.out.println("No such Contact found");
                                    } else {
                                        adbook.get(j).contact.get(i).editContact();
                                    }

                                } else if (num == 3) {
                                    System.out.println("Enter First Name");
                                    String fn = sc.next();
                                    System.out.println("Enter Last Name");
                                    String ln = sc.next();
                                    int k = 0, i = 0;
                                    for (i = 0; i < adbook.get(j).contact.size(); i++) {
                                        if (adbook.get(j).contact.get(i).first_name.equalsIgnoreCase(fn) && adbook.get(j).contact.get(i).last_name.equalsIgnoreCase(ln)) {
                                            k = 1;
                                            break;
                                        }
                                    }
                                    if (k == 0) {
                                        System.out.println("No such Contact found");
                                    } else {
                                        adbook.get(j).contact.get(i).viewContact();
                                    }

                                } else if (num == 4) {
                                    System.out.println("Enter the First Name");
                                    String fn = sc.next();
                                    System.out.println("Enter the Last Name");
                                    String ln = sc.next();
                                    int k = 0;
                                    for (int i = 0; i < adbook.get(j).contact.size(); i++) {
                                        if (adbook.get(j).contact.get(i).first_name.equalsIgnoreCase(fn) && adbook.get(j).contact.get(i).last_name.equalsIgnoreCase(ln)) {
                                            k = 1;
                                            adbook.get(j).contact.remove(i);
                                            System.out.println("Provided Contact has been Deleted");
                                            break;
                                        }
                                    }
                                    if (k == 0) {
                                        System.out.println("No such contact found!");

                                    }

                                } else if (num == 5) {
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    if (key == 0) {
                        System.out.println("This Address Book does not exist!");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the city ");
                    String city=sc.next();
                    List<Contact> snc=new ArrayList();
                    for(int k=0;k<adbook.size();k++)
                    {
                        snc.addAll(searchNameByCity(adbook.get(k),city));
                    }
                    if(snc.size()==0)
                    {
                        System.out.println("No Contacts Found");
                    }
                    else
                    {
                        for(int k=0;k<adbook.size();k++)
                        {
                            System.out.println(snc.get(k).first_name + " "+snc.get(k).last_name);
                        }
                    }
                }

            }
        }
    }
}