// 22504421 Amy Johnson 

import java.util.ArrayList;
import java.util.Scanner;

public class custMenu {
	
	public static void custMenu() 
	{
		Scanner scnr = new Scanner(System.in);
		
		ArrayList<customer> custList = new ArrayList<customer>();
		
		// array list to store objects that will be deleted 
		ArrayList<customer> forDeletion = new ArrayList<customer>();
		
		// null safety (asked Google Gemini)
		customer newCust = null;
		
		while (true) 
		{
			System.out.println("Customer menu, pick an option: ");
			System.out.println("a. Add a new customer. ");
			System.out.println("b. View a single customer. ");
			System.out.println("c. View all customers. ");
			System.out.println("d. Edit a customer's details. ");
			System.out.println("e. Delete a customer. ");
			
			String menuSelect = scnr.nextLine();
			switch(menuSelect)
			{
			case "a":
			case "A":
				// asks for name, email and phone 
				System.out.println("Enter your name: ");
				String name = scnr.nextLine();
				System.out.println("Enter your email address: ");
				String email = scnr.nextLine();
				System.out.println("Enter your phone number: ");
				String phone = scnr.nextLine();
				
				// call constructor
				newCust = new customer(name, email, phone);
				System.out.println("You have entered the following: "+newCust.name+", "+newCust.email+", "+newCust.phone+".\n");
				
				// store object in list 
				custList.add(newCust);

				break;
				
			case "b":
			case "B":
				
			case "c":
			case "C":
				
			case "d":
			case "D":
				
			case "e":
			case "E":
			
			
			
			
			}
			
			
		}
		// System.out.println("Enter your name: ");
		// String title = scnr.nextLine();
		// asks for name, email, phone no. 
		
		// assign random number for id
		
	}
	


}