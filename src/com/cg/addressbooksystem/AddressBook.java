package com.cg.addressbooksystem;

import java.util.ArrayList;

class AddressBook {
    ArrayList<Contact> contact = new ArrayList<Contact>();

    public boolean checkDuplicate(Contact cnt) {
        return (contact.stream().anyMatch(contact -> contact.equals(cnt)));
    }


    public boolean nameChecking(String fn, String ln, int i) {
        int j = 0;
        for (i = 0; i < contact.size(); i++) {
            if (contact.get(i).first_name.equalsIgnoreCase(fn) && contact.get(i).last_name.equalsIgnoreCase(ln)) {
                j = 1;
                break;
            }
        }
        if (j == 0) {
            System.out.println("No Contact found");
        }
        return true;
    }

    public void addContact() {
        Contact a = new Contact();
        a.addContact();
        if (checkDuplicate(a))
            System.out.println("Duplicate Contact");
        else
            contact.add(a);
    }

    public void editContact(String fn, String ln, int i) {
        if (nameChecking(ln, fn, i)) ;
        contact.get(i).editContact();
    }

    public void viewContact(String fn, String ln, int i) {
        if (nameChecking(ln, fn, i)) ;
        contact.get(i).viewContact();
    }

    public void deleteContact(String fn, String ln, int i) {
        if (nameChecking(ln, fn, i)) ;
        contact.remove(i);
    }
}
