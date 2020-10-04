

import java.util.*;
class Contact {
	Scanner sc=new Scanner(System.in);
	String first,last,address,String,city,state,zip,phno,email;
	public void addContact()
	{

		System.out.println("Enter First Name");
		this.first=sc.next();
		System.out.println("Enter Last Name");
		this.last=sc.next();
		System.out.println("Enter Address");
		this.address=sc.next();
		System.out.println("Enter city");
		this.city=sc.next();
		System.out.println("Enter state");
		this.state=sc.next();
		System.out.println("Enter zip code");
		this.zip=sc.next();
		System.out.println("Enter phone number");
		String phno=sc.next();
		System.out.println("Enter email");
		String email=sc.next();
	}
}
public class AddressBookSystem {

	public static void main(String args[])
	{
		ArrayList <Contact> c=new ArrayList<Contact>();
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
				Contact adding =new Contact();
				adding.addContact();
				
			}
		}
	}
}
