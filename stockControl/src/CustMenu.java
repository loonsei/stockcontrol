// 22504421 Amy Johnson 

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustMenu {
	
	Scanner scnr;
	
	static ArrayList<Customer> custList = new ArrayList<Customer>();
	
	public ArrayList<Customer> getCustList()
	{
		return custList;
	}
	
	// scanner constructor
	public CustMenu(Scanner scnr) 
	{
		this.scnr = scnr;
	}
	
	// method for writing video games to a file
	public void saveCustomer() 
	{
		FileWriter f;
		try 
		{
			// create text file
			f = new FileWriter("customer.text");
		}
		// catch any errors during writing
		catch (IOException e)
		{
			System.err.println(e);
			return;
		}
		try
		{
			// search through list and write all objects into string
			for (Customer c : custList) 
			{
				String line = "Customer ID: "+c.getCustID()+"\nName: "+c.getName()+"\nEmail: "+c.getEmail()+"\nPhone: "+c.getPhone()+"\n-------------------\n";
				f.write(line);
			}

			f.close();
			System.out.println("Saved to file.");
		}
		catch (IOException e)
		{
			System.err.println(e);
		}
	}
	
	public void custMenu() 
	{
		// array list to store objects that will be deleted 
		ArrayList<Customer> forDeletion = new ArrayList<Customer>();
		
		// null safety (asked Google Gemini)
		Customer newCust = null;
		
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
				System.out.println("Enter the customer's name: ");
				String name = scnr.nextLine();
				System.out.println("Enter their email address: ");
				String email = scnr.nextLine();
				System.out.println("Enter their phone number: ");
				String phone = scnr.nextLine();
				int custID = 0;
				
				// call constructor
				newCust = new Customer(custID, name, email, phone);
				System.out.println("You have entered the following: "+newCust.name+", "+newCust.email+", "+newCust.phone+".\n");
				System.out.println("The customer's ID is: "+newCust.custID+"");
				
				// add check to find if ID exists?
				
				// store object in list 
				custList.add(newCust);
				saveCustomer();

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
						
						for (Customer f : custList) 
						{
							if (f.getCustID() == findID)
							{
								foundID = true;
								System.out.println("Found! Showing details...\n");
								System.out.println("ID: "+f.custID+" \nName: "+f.name+" \nEmail: "+f.email+" \nPhone: "+f.phone+"");
								
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
				
				for (Customer i : custList) 
				{
					if (i.getCustID() == findIDForEdit)
					{
						feFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("ID: "+i.custID+" \nName: "+i.name+" \nEmail: "+i.email+" \nPhone: "+i.phone+"\n");
						// ask user which detail they want to edit 
						System.out.println("What detail would you like to change? Answer from the following: \n- ID\n- name\n- email\n- phone");
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
							System.out.println("ID changed.");
							
							break;
							
						case "name":
						case "Name":
						case "NAME":
							System.out.println("What do you want to change the name to? Currently: "+i.name+"");
							String editName = scnr.nextLine();
							i.setName(editName);
							System.out.println("Name changed.");
							
							break;
							
						case "email":
						case "Email":
						case "EMAIL":
							System.out.println("What do you want to change the email to? Currently: "+i.email+"");
							String editEmail = scnr.nextLine();
							i.setEmail(editEmail);
							System.out.println("Email changed.");
							
							break;
						
						case "phone":
						case "Phone":
						case "PHONE":
							System.out.println("What do you want to change the phone number to? Currently: "+i.phone+"");
							String editPhone = scnr.nextLine();
							i.setPhone(editPhone);
							System.out.println("Phone changed.");
							
							break;
							
						default:
							System.out.println("Invalid input.");
						}
						
						// break out of loop
						break;
					}	
				}
				
				// edit in file if customer is definitely found
				if (feFound) 
				{
					saveCustomer();
				}
				else
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
				
				for (Customer d : custList) 
				{
					if (d.getCustID() == findIDForDeletion && d.getName().equalsIgnoreCase(findNameForDeletion))
					{
						fdFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("ID: "+d.custID+" \nName: "+d.name+" \nEmail: "+d.email+" \nPhone: "+d.phone+"");
						System.out.println("\nDo you want to delete this item? Answer Y or N.");
						String userAnswer = scnr.nextLine();
						if (userAnswer.equalsIgnoreCase("Y")) 
						{
							// add to forDeletion array list 
							forDeletion.add(d);
							System.out.println("Item removed!");
						}
						else if (userAnswer.equalsIgnoreCase("N")) 
						{
							System.out.println("Returning to menu...");
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
				
				// remove from file if customer is definitely found
				if (fdFound) 
				{
					saveCustomer();
				}
				else
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
					for (Customer c : custList) 
					{
						System.out.println("ID: "+c.custID+" \nName: "+c.name+" \nEmail: "+c.email+" \nPhone: "+c.phone+"\n-------------------");
					}
				}
				
				break;
			
			case "f":
			case "F":
				// return to main menu
				System.out.println("Returning to main menu...\n");
				return;
	
			default:
				System.out.println("Invalid input, please try again.");
			
			}
		}
	}
}