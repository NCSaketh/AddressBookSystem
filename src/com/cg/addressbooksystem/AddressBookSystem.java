package com.cg.addressbooksystem;

import java.util.*;

public class AddressBookSystem {

	public static void main(String args[])
	{
		ArrayList <Contact> contact =new ArrayList<Contact>();
		System.out.println("Welcome to Address Book System");
		Scanner sc=new Scanner(System.in);
		
		int num=0;
		while(num !=5)
		{
			System.out.println("1.ADD A CONTACT DETAIL");
			System.out.println("2.EDIT EXISTING CONTACT USING NAME");
			System.out.println("3.VIEW CONTACT DETAILS USING NAME ");
			System.out.println("4.DELETE THE CONTACT OF A PERSON");
			System.out.println("5.EXIT");
			num=sc.nextInt();
			if(num==1)
			{
				Contact a =new Contact();
				a.addContact();
				contact.add(a);
			}
			if(num==2)
			{
				System.out.println("Enter First Name");
				String fn=sc.next();
				System.out.println("Enter Last Name");
				String ln=sc.next();
				int i=0,j=0;
				for(i=0;i<contact.size();i++)
				{
					if(contact.get(i).first_name.equalsIgnoreCase(fn) && contact.get(i).last_name.equalsIgnoreCase(ln))
					{
						j=1;
						break;
					}
				}
				if(j==0)
				{
					System.out.println("No Contact found");
				}
				else
				{
					contact.get(i).editContact();
				}
			}
			if(num==3)
			{
				System.out.println("Enter First Name");
				String fn=sc.next();
				System.out.println("Enter Last Name");
				String ln=sc.next();
				int i=0,j=0;
				for(i=0;i<contact.size();i++)
				{
					if(contact.get(i).first_name.equalsIgnoreCase(fn) && contact.get(i).last_name.equalsIgnoreCase(ln))
					{
						j=1;
						break;
					}
				}
				if(j==0)
				{
					System.out.println("No Contact found");
				}
				else
				{
					contact.get(i).viewContact();
				}
			}

			if(num==4)
			{
				System.out.println("Enter the First Name");
				String fn=sc.next();
				System.out.println("Enter the Last Name");
				String ln=sc.next();
				int i=0,j=0;
				for(i=0;i<contact.size();i++)
				{
					if(contact.get(i).first_name.equalsIgnoreCase(fn) && contact.get(i).last_name.equalsIgnoreCase(ln))
					{
						j=1;
						contact.remove(i);
						System.out.println("Contact is Deleted");
						break;
					}
				}
				if(j==0)
				{
					System.out.println("No Contact found");

				}
			}
		}
	}
}
