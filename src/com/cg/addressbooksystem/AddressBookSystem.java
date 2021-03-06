package com.cg.addressbooksystem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class AddressBookSystem {

    static boolean checkDuplicate(AddressBook adbook, Contact contact) {
        return (adbook.contact.stream().anyMatch(c -> c.equals(contact)));
    }

    static List<Contact> searchNameByCity(AddressBook adbook, String cityString) {
        return adbook.contact.stream().filter(c -> c.city.equals(cityString)).collect(Collectors.toList());
    }

    static List<Contact> searchNameByState(AddressBook adbook, String stateString) {
        return adbook.contact.stream().filter(c -> c.state.equals(stateString)).collect(Collectors.toList());
    }

    static void sortByName(AddressBook adbook) {
       adbook.contact.stream()
             .sorted((c1, c2) -> c1.first_name.concat(c1.last_name).compareTo(c2.first_name.concat(c2.last_name)))
             .forEach(System.out::println);
    }

    static void sortByCity(AddressBook adbook) {
        adbook.contact.stream().sorted((c1, c2) -> c1.city.compareTo(c2.city))
                .forEach(c -> System.out.println(c.first_name + ", " + c.last_name + "belongs to city " + c.city));

    }

    static void sortByState(AddressBook adbook) {
        adbook.contact.stream().sorted((c1, c2) -> c1.state.compareTo(c2.state))
                .forEach(c -> System.out.println(c.first_name + ", " + c.last_name + " belongs to state " + c.state));

    }

    static void sortByZip(AddressBook adbook) {
        adbook.contact.stream().sorted((c1, c2) -> c1.zip.compareTo(c2.zip))
                .forEach(c -> System.out.println(c.first_name + ", " + c.last_name + " belongs to zip " + c.zip));

    }


    public static void main(String args[]) {
        System.out.println("Welcome to Address Book System");
        Scanner sc = new Scanner(System.in);
        ArrayList<AddressBook> adbook = new ArrayList<AddressBook>();

        int r = 0;
        while (r != 9) {
            System.out.println("1.CREATE AN ADDRESS BOOK");
            System.out.println("2.ACCESS AN ADDRESS BOOK");
            System.out.println("3.SEARCH PERSON IN A CITY ACROSS ALL ADDRESS BOOKS");
            System.out.println("4.SEARCH PERSON IN A STATE ACROSS ALL ADDRESS BOOKS");
            System.out.println("5.READ DATA FROM THE FILE");
            System.out.println("6.READ DATA FROM THE CSV FILE");
            System.out.println("7.READ DATA FROM THE JSON FILE");
            System.out.println("8.EXIT APPLICATION");
            r = sc.nextInt();
            AddressBook book;
            switch (r) {
                case 1: {
                    adbook = createAddressBook(adbook);
                    break;
                }
                case 2: {
                    adbook = accessAddressBook(adbook);
                    break;
                }
                case 3: {
                    accessByCity(adbook);
                    break;
                }
                case 4: {
                    accessByState(adbook);
                    break;
                }

                case 5: {
                        try {
                            FileReader f=new FileReader("C:\\Users\\Nc Saketh\\eclipse-workspace\\AddressBookSystem\\Data.txt");
                            int i;
                            while((i=f.read())!=-1)
                                System.out.print((char)i);
                        }
                        catch(Exception e) {
                        }
                        break;
                }


                case 6 : {
                        String filename =  "C:\\Users\\Nc Saketh\\eclipse-workspace\\AddressBookSystem\\src\\DATA.csv";
                        File inputFile = new File(filename);
                        try (FileReader inputFileReader = new FileReader(inputFile);
                             CSVReader inputCSVReader = new CSVReader(inputFileReader)){
                            String[] rowData = null;
                            String[] header = inputCSVReader.readNext();
                            while((rowData = inputCSVReader.readNext()) != null) {
                                for(int i=0; i<rowData.length; i++) {
                                    System.out.print(header[i] + ": " + rowData[i] + " | ");
                                }
                                System.out.println();
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("Address Book read from CSV");
                }

                case 7 : {
                    String JSON_read_file = "C:\\Users\\Nc Saketh\\eclipse-workspace\\AddressBookSystem\\src\\DATAjson.txt";
                    Gson gson = new Gson();
                    BufferedReader br= null;
                    try {
                        br = new BufferedReader(new FileReader(JSON_read_file));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Contact[] userOBJ= gson.fromJson(br, Contact[].class);
                    List<Contact> contactList = Arrays.asList(userOBJ);
                    for (Contact c : contactList){
                        c.addContact();
                    }
                }

            }
        }
    }

    static ArrayList<AddressBook> createAddressBook(ArrayList<AddressBook> adbook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the Address Book  to be created");
        String n = sc.next();
        int key = 0;
        for (int i = 0; i < adbook.size(); i++)
        {
            if (adbook.get(i).BookName.equalsIgnoreCase(n))
            {
                key = 1;
                break;
            }
        }
        if (key == 0)
        {
            AddressBook b = new AddressBook();
            b.BookName = n;
            b.contact = new ArrayList<Contact>();
            adbook.add(b);
            return adbook;
        }
        else
        {
            System.out.println("Provided Address Book Already Exists.");
            return createAddressBook(adbook);
        }
    }

    static ArrayList<AddressBook> accessAddressBook(ArrayList<AddressBook> adbook) {
        Scanner sc = new Scanner(System.in);
        int key = 0;
        System.out.println("Enter the address book name to be accessed");
        String b = sc.next();
        for (int j = 0; j < adbook.size(); j++)
        {

            if (adbook.get(j).BookName.equalsIgnoreCase(b))
            {
                key = 1;
                int num = 0;
                while (num != 9) {
                    System.out.println("1.ADD A CONTACT DETAIL");
                    System.out.println("2.EDIT EXISTING CONTACT USING NAME");
                    System.out.println("3.VIEW CONTACT DETAILS USING NAME ");
                    System.out.println("4.DELETE THE CONTACT OF A PERSON");
                    System.out.println("5.SORT ENTRIES IN ADDRESS BOOK BASED ON NAME");
                    System.out.println("6.SORT ENTRIES IN ADDRESS BOOK BASED ON CITY");
                    System.out.println("7.SORT ENTRIES IN ADDRESS BOOK BASED ON STATE");
                    System.out.println("8.SORT ENTRIES IN ADDRESS BOOK BASED ON ZIP");
                    System.out.println("9.EXIT CURRENT ADDRESS BOOK");
                    num = sc.nextInt();
                    String name = new String();

                    if (num == 1)
                    {
                        Contact a = new Contact();
                        a.addContact();
                        if (checkDuplicate(adbook.get(j), a))
                        {
                            System.out.println("Provided Contact Already Exists");
                        } else {
                            adbook.get(j).contact.add(a);
                        }
                    }

                    else if (num == 2) {
                        System.out.println("Enter First Name");
                        String fn = sc.next();
                        System.out.println("Enter Last Name");
                        String ln = sc.next();
                        int k = 0, i = 0;
                        for (i = 0; i < adbook.get(j).contact.size(); i++)
                        {
                            if (adbook.get(j).contact.get(i).first_name.equalsIgnoreCase(fn) &&
                                    adbook.get(j).contact.get(i).last_name.equalsIgnoreCase(ln))
                            {
                                k = 1;
                                break;
                            }
                        }
                        if (k == 0) {
                            System.out.println("No such Contact found");
                        } else {
                            adbook.get(j).contact.get(i).editContact();
                        }
                    }

                    else if (num == 3) {
                        System.out.println("Enter First Name");
                        String fn = sc.next();
                        System.out.println("Enter Last Name");
                        String ln = sc.next();
                        int k = 0, i = 0;
                        for (i = 0; i < adbook.get(j).contact.size(); i++)
                        {
                            if (adbook.get(j).contact.get(i).first_name.equalsIgnoreCase(fn) &&
                                    adbook.get(j).contact.get(i).last_name.equalsIgnoreCase(ln))
                            {
                                k = 1;
                                break;
                            }
                        }
                        if (k == 0) {
                            System.out.println("No such Contact found");
                        } else {
                            adbook.get(j).contact.get(i).viewContact();
                        }
                    }

                    else if (num == 4) {
                        System.out.println("Enter the First Name");
                        String fn = sc.next();
                        System.out.println("Enter the Last Name");
                        String ln = sc.next();
                        int k = 0;
                        for (int i = 0; i < adbook.get(j).contact.size(); i++)
                        {
                            if (adbook.get(j).contact.get(i).first_name.equalsIgnoreCase(fn) &&
                                    adbook.get(j).contact.get(i).last_name.equalsIgnoreCase(ln)) {
                                k = 1;
                                adbook.get(j).contact.remove(i);
                                System.out.println("Provided Contact has been Deleted");
                                break;
                            }
                        }
                        if (k == 0) {
                            System.out.println("No such contact found!");
                        }
                    }

                    else if (num == 5) {
                        sortByName(adbook.get(j));
                        break;
                    }

                    else if (num == 6) {
                        sortByCity(adbook.get(j));
                        break;
                    }
                    else if (num == 7) {
                        sortByState(adbook.get(j));
                        break;
                    }
                    else if (num == 8) {
                        sortByZip(adbook.get(j));
                        break;
                    }


                }

            }
            writeInFile(adbook.get(j).contact);
            writeDataCSV(adbook.get(j).contact);
            writeDataJson(adbook.get(j).contact);

        }
        if (key == 0) {
            System.out.println("This Address Book does not exist!");
        }
        return adbook;
    }

    static void accessByCity(ArrayList<AddressBook> adbook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city ");
        String city = sc.next();
        List<Contact> snc = new ArrayList();
        for (int k = 0; k < adbook.size(); k++)
        {
            snc.addAll(searchNameByCity(adbook.get(k), city));
        }

        if (snc.size() == 0) {
            System.out.println("No Contacts Found");
        } else {
            for (int k = 0; k < adbook.size(); k++) {
                System.out.println(snc.get(k).first_name + " " + snc.get(k).last_name);
            }
            System.out.println("The number of persons living in city " + city + " are " + snc.size());
        }

    }

    static void accessByState(ArrayList<AddressBook> adbook) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the State ");
        String state = sc.next();
        List<Contact> sns = new ArrayList();
        for (int k = 0; k < adbook.size(); k++)
        {
            sns.addAll(searchNameByState(adbook.get(k), state));
        }

        if (sns.size() == 0) {
            System.out.println("No Contacts Found");
        } else {
            for (int k = 0; k < adbook.size(); k++) {
                System.out.println(sns.get(k).first_name + " " + sns.get(k).last_name);
            }
            System.out.println("The number of persons living in state " + state + " are " + sns.size());

        }

    }

    static boolean writeInFile(ArrayList<Contact> array)
    {
        StringBuffer string=new StringBuffer();
        array.stream().forEach(c ->
        {
            String concat=c.toString().concat("\n");
            string.append(concat);
        }
        );
        try
        {
            Path path=Paths.get("C:\\Users\\Nc Saketh\\eclipse-workspace\\AddressBookSystem\\Data.txt");
            Files.write(path,string.toString().getBytes());
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }



    static boolean writeDataCSV(ArrayList <Contact> arr)
    {
        String filename = "C:\\Users\\Nc Saketh\\eclipse-workspace\\AddressBookSystem\\src\\DATA.csv";
        File outputFile = new File(filename);
        try (FileWriter outputFileWriter = new FileWriter(outputFile);
             CSVWriter outputCSVWriter = new CSVWriter(outputFileWriter)){
            String[] header = {"First Name", "Last Name", "Address", "City", "State", "PhoneNumber", "Email", "Zip" };
            outputCSVWriter.writeNext(header);
            for(Contact contact : arr) {
                String[] rowData = {contact.first_name, contact.last_name,
                        contact.address, contact.city, contact.state,
                        contact.ph_no, contact.email,contact.zip};
                outputCSVWriter.writeNext(rowData);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        System.out.println("Address Book added to CSV");
        return true;
    }

    static boolean writeDataJson(ArrayList <Contact> arr) {
        try {
            String JSON_write_file ="C:\\Users\\Nc Saketh\\eclipse-workspace\\AddressBookSystem\\src\\DATAjson.txt";
            Gson gson = new Gson();
            String json = gson.toJson(arr);
            FileWriter Writer = new FileWriter(JSON_write_file);
            Writer.write(json);
            Writer.close();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

//    public void readJSON() throws FileNotFoundException {
//        String JSON_read_file = "C:\\Users\\Nc Saketh\\eclipse-workspace\\AddressBookSystem\\src\\DATAjson.json";
//        Gson gson = new Gson();
//        BufferedReader br= new BufferedReader(new FileReader(JSON_read_file));
//        Contact[] usrObj= gson.fromJson(br, Contact[].class);
//        List<Contact> contactList = Arrays.asList(usrObj);
//        for (Contact c : contactList){
//            c.addContact();
//        }
//    }



}