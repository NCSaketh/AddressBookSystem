package com.cg.addressbooksystem;

import java.util.*;

public class AddressBookSystem {

	public static void main(String args[])
	{
		ArrayList <Contact> contact =new ArrayList<Contact>();
		System.out.println("Welcome to Address Book System");
		Scanner sc=new Scanner(System.in);
		
		int num=0;
		while(num !=2)
		{
			System.out.println("1.ADD A CONTACT DETAIL");			
			System.out.println("2.EXIT");
			num=sc.nextInt();
			if(num==1)
			{
				Contact a =new Contact();
				a.addContact();
				contact.add(a);
			}
		}
	}
}
