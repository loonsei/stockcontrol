// 22504421 Amy Johnson 

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class custMenu {
	
	static ArrayList<customer> custList = new ArrayList<customer>();
	
	public ArrayList<customer> getCustList()
	{
		return custList;
	}
	
	public static void custMenu() 
	{
		Scanner scnr = new Scanner(System.in);
		
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
				// ask user the ID of the item they want to change 
				System.out.println("What is the ID of the customer you would like to edit?");
				int findIDForEdit = scnr.nextInt();
				scnr.nextLine(); // throwaway nextLine bc of the nextInt
				boolean feFound = false;
				
				for (customer i : custList) 
				{
					if (i.getCustID() == findIDForEdit)
					{
						feFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("ID: "+i.custID+" \nName: "+i.name+" \nEmail: "+i.email+" \nPhone: "+i.phone+"");
						// ask user which detail they want to edit 
						System.out.println("What detail would you like to change? Answer from the following: \n- ID\n- name\n- email\n- phone\n");
						String userAnswer = scnr.nextLine();
						switch(userAnswer) 
						{
						case "id":
						case "Id":
						case "ID":
							System.out.println("What do you want to change the ID to? Currently: "+i.custID+"");
							int editID = scnr.nextInt();
							scnr.nextLine(); // throwaway
							// sets ID to new value
							i.setCustID(editID);
							System.out.println("ID changed.\n");
							
							break;
							
						case "name":
						case "Name":
						case "NAME":
							System.out.println("What do you want to change the name to? Currently: "+i.name+"");
							String editName = scnr.nextLine();
							i.setName(editName);
							System.out.println("Name changed.\n");
							
							break;
							
						case "email":
						case "Email":
						case "EMAIL":
							System.out.println("What do you want to change the email to? Currently: "+i.email+"");
							String editEmail = scnr.nextLine();
							i.setEmail(editEmail);
							System.out.println("Email changed.\n");
							
							break;
						
						case "phone":
						case "Phone":
						case "PHONE":
							System.out.println("What do you want to change the phone number to? Currently: "+i.phone+"");
							String editPhone = scnr.nextLine();
							i.setPhone(editPhone);
							System.out.println("Phone changed.\n");
							
							break;
							
						default:
							System.out.println("Invalid input.");
						}
						
						// break out of loop
						break;
					}	
				}
				
				if (!feFound) 
				{
					System.out.println("Couldn't find a customer with those details.");
				}
				
				break;
				
			case "d":
			case "D":
				// ask for ID and name, delete object 
				System.out.println("What is the ID of the customer you would like to delete?");
				int findIDForDeletion = scnr.nextInt();
				scnr.nextLine(); // throwaway
				System.out.println("What is the name of the customer you would like to delete?");
				String findNameForDeletion = scnr.nextLine();
				boolean fdFound = false;
				
				for (customer d : custList) 
				{
					if (d.getCustID() == findIDForDeletion && d.getName().equalsIgnoreCase(findNameForDeletion))
					{
						fdFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("ID: "+d.custID+" \nName: "+d.name+" \nEmail: "+d.email+" \nPhone: "+d.phone+"\n");
						System.out.println("Do you want to delete this item? Answer Y or N.");
						String userAnswer = scnr.nextLine();
						if (userAnswer.equalsIgnoreCase("Y")) 
						{
							// add to forDeletion array list 
							forDeletion.add(d);
							System.out.println("Item removed!");
						}
						else if (userAnswer.equalsIgnoreCase("N")) 
						{
							System.out.println("Returning to main menu...");
						}
						else 
						{
							System.out.println("Invalid input.");
						}
					}
				}
				
				// delete all objects stored on deletion list 
				// https://www.w3schools.com/java/ref_arraylist_removeall.asp 
				custList.removeAll(forDeletion);
				
				if (!fdFound) 
				{
					System.out.println("Couldn't find a customer with those details.");
				}
				
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