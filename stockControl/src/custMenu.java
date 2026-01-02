// 22504421 Amy Johnson 

import java.util.ArrayList;
import java.util.InputMismatchException;
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
			System.out.println("\nCustomer menu, pick an option: ");
			System.out.println("a. Add a new customer. ");
			System.out.println("b. View a single customer. ");
			System.out.println("c. Edit a customer's details. ");
			System.out.println("d. Delete a customer. ");
			System.out.println("e. View all customers. ");
			System.out.println("f. Return to menu selection. ");
			
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
				int custID = 0;
				
				// call constructor
				newCust = new customer(custID, name, email, phone);
				System.out.println("You have entered the following: "+newCust.name+", "+newCust.email+", "+newCust.phone+".\n");
				System.out.println("Your ID is: "+newCust.custID+"");
				
				// add check to find if ID exists?
				
				// store object in list 
				custList.add(newCust);

				break;
				
			case "b":
			case "B":
				// asks user custid to identify the customer they are wanting to view
				System.out.println("What is the ID of the customer you are wanting to view? ");
				boolean foundID = false;
				boolean validInput = false;
				
				while(!validInput) 
				{
					// add try catch to protect against string input
					try 
					{
						int findID = scnr.nextInt();
						scnr.nextLine(); // throwaway
						validInput = true;
						
						for (customer f : custList) 
						{
							if (f.getCustID() == findID)
							{
								foundID = true;
								System.out.println("Found! Showing details...\n");
								System.out.println("ID: "+f.custID+" \nName: "+f.name+" \nEmail: "+f.email+" \nPhone: "+f.phone+" \n");
								
								break;
							}
						}
					}
					catch (InputMismatchException x) 
					{
						System.out.print("Input was not an integer, please enter again: \n");
						scnr.nextLine();
					}
				}
				
				// if title is not found in list
				if (!foundID) 
				{
					System.out.println("Not found.");
				}
				
				break; 
				
			case "c":
			case "C":

				break;
				
			case "d":
			case "D":
				
				break; 
				
			case "e":
			case "E":
				// if arraylist is empty print message 
				// https://www.w3schools.com/java/ref_arraylist_isempty.asp 
				if (custList.isEmpty()) 
				{
					System.out.println("No customers found in the list.");
				}
				else 
				{
					System.out.println("Full List of Customers: \n");
					for (customer c : custList) 
					{
						System.out.println("ID: "+c.custID+" \nName: "+c.name+" \nEmail: "+c.email+" \nPhone: "+c.phone+"");
					}
				}
				
				break;
			
			case "f":
			case "F":
				// call main menu method
				main.mainMenu();

				break;
	
			default:
				System.out.println("Invalid input, please try again.\n");
			
			}
		}
	}
}