// 22504421 Amy Johnson 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderMenu {
	
	Scanner scnr;
	
	// array list for orders
	static ArrayList<Order> orderList = new ArrayList<Order>();
	
	// scanner constructor
	public OrderMenu(Scanner scnr) 
	{
		this.scnr = scnr;
		// load data from order.txt file in as soon as the order menu is loaded
		loadOrder();
	}
	
	// method for writing orders to a file
	public void saveOrder() 
	{
		FileWriter f;
		try 
		{
			// create text file
			f = new FileWriter("order.txt");
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
			for (Order o : orderList) 
			{
				String line = o.getOrderID()+","+o.cust.getCustID()+","+o.getGamesBought()+","+o.getTotal()+"\n";
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
	
	public void loadOrder() 
	{
		// clear orderList to avoid duplicates when going between menus
		orderList.clear();
		
		// reference arraylist
		ArrayList<Customer> custList = CustMenu.custList;
		BufferedReader r;
		try 
		{
			r = new BufferedReader(new FileReader("order.txt"));
			String line;
			
			// check if null, if not null read the next line
			while((line = r.readLine()) != null) 
			{
				// create a string array for each value in order object, separating them by the commas
				// https://www.geeksforgeeks.org/java/split-string-java-examples/
				String[] index = line.split(",");
				// convert back into int
				int orderID = Integer.parseInt(index[0]);
				int findCustID = Integer.parseInt(index[1]);
				int gamesBought = Integer.parseInt(index[2]);
				
				for (Customer c : custList) 
				{
					if(c.getCustID() == findCustID) 
					{
						// import order if customer id exists
						// create object from array and add to orderList
						Order savedOrder = new Order(c, gamesBought);
						// keep orderID from the text file
						savedOrder.setOrderID(orderID);
						orderList.add(savedOrder);
						// stop looking once found
						break;
					}
					
				}
			}
			r.close();
			System.out.println("Imported existing order data.\n");
		}
		catch (IOException e) 
		{
			System.err.println(e);
			return;
		}
	}
	
	public void orderMenu() 
	{	
		// import custList so it can be referenced
		ArrayList<Customer> custList = CustMenu.custList;
		
		// array list to store objects that will be deleted 
		ArrayList<Order> forDeletion = new ArrayList<Order>();
		
		// null safety 
		Order newOrder = null;
		
		while (true) 
		{
			System.out.println("\nOrder menu, pick an option: ");
			System.out.println("a. Add a new order. ");
			System.out.println("b. View a single order. ");
			System.out.println("c. Edit an order's details. ");
			System.out.println("d. Delete an order. ");
			System.out.println("e. View all orders. ");
			System.out.println("f. Return to menu selection. ");
			
			String menuSelect = scnr.nextLine();
			switch(menuSelect)
			{
			case "a":
			case "A":
				// asks for the customer ID
				System.out.println("Enter the ID of the customer who is making the order: ");
				int grabCustID = scnr.nextInt();
				scnr.nextLine();
				
				boolean foundCustID = false;
				
				for (Customer c : custList)
				{
					if (c.getCustID() == grabCustID)
					{
						foundCustID = true;
						System.out.println("Customer found. Their name: "+c.getName()+"\n");
						// ask user how many games the customer is buying
						System.out.println("Enter the amount of games being bought: ");
						int gamesBought = scnr.nextInt();
						scnr.nextLine(); // throwaway
						
						// call constructor
						// c becomes parameter for cust object
						newOrder = new Order(c, gamesBought);
						System.out.println("Order ID: "+newOrder.orderID+", Customer ID: "+newOrder.cust.getCustID()+".\nGames bought: "+newOrder.gamesBought+", Total price: "+newOrder.total+".");
						
						// store object in list 
						orderList.add(newOrder);
						saveOrder();
					}
				}
				
				if (!foundCustID) 
				{
					System.out.println("Could not find that customer.");
				}

				break;
				
			case "b":
			case "B":
				// asks user orderID to identify the order they are wanting to view
				System.out.println("What is the ID of the order you are wanting to view? ");
				boolean foundOrderID = false;
				boolean validInput = false;
				
				while(!validInput) 
				{
					// add try catch to protect against string input
					try 
					{
						int findOrderID = scnr.nextInt();
						scnr.nextLine(); // throwaway
						validInput = true;
						
						for (Order f : orderList) 
						{
							if (f.getOrderID() == findOrderID)
							{
								foundOrderID = true;
								System.out.println("Found! Showing details...\n");
								System.out.println("Order ID: "+f.orderID+", Customer ID: "+f.cust.getCustID()+".\nGames bought: "+f.gamesBought+", Total price: "+f.total+".");
								
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
				if (!foundOrderID) 
				{
					System.out.println("Not found.");
				}
				
				break; 
				
			case "c":
			case "C":
				// ask user the ID of the order they want to change 
				System.out.println("What is the ID of the order you would like to edit?");
				int findOrderIDFE = scnr.nextInt();
				scnr.nextLine(); // throwaway 
				boolean feFound = false;
				
				for (Order i : orderList) 
				{
					if (i.getOrderID() == findOrderIDFE)
					{
						feFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("Order ID: "+i.orderID+", Customer ID: "+i.cust.getCustID()+".\nGames bought: "+i.gamesBought+", Total price: "+i.total+".\n");
						// ask user which detail they want to edit 
						System.out.println("What detail would you like to change? Answer from the following: \n- ID\n- Customer\n- games\n");
						String userAnswer = scnr.nextLine();
						switch(userAnswer) 
						{
						case "id":
						case "Id":
						case "ID":
							System.out.println("What do you want to change the order ID to? Currently: "+i.orderID+"");
							int editID = scnr.nextInt();
							scnr.nextLine(); // throwaway
							// sets ID to new value
							i.setOrderID(editID);
							System.out.println("Order ID changed.");
							
							break;
							
						case "customer":
						case "Customer":
						case "CUSTOMER":
							// asks for another customer ID
							System.out.println("Enter another ID of the customer you want the order to belong to: ");
							int grabCustID2 = scnr.nextInt();
							scnr.nextLine();
							
							boolean foundCustID2 = false;
							
							for (Customer otherCust : custList)
							{
								if (otherCust.getCustID() == grabCustID2)
								{
									foundCustID2 = true;
									i.cust = otherCust;
									System.out.println("Customer changed, name: " + otherCust.getName());
									
									break;
								}
							}
							
							if (!foundCustID2) 
							{
								System.out.println("Could not find a customer with those details.");
							}
							
							break;
						
						case "games":
						case "Games":
						case "GAMES":
							System.out.println("What do you want to change the amount of games bought to? Currently: "+i.gamesBought+"");
							int editGB = scnr.nextInt();
							scnr.nextLine(); // throwaway
							// sets games bought to new value
							i.setGamesBought(editGB);
							System.out.println("Amount of games bought changed.");
							
							break;
							
						default:
							System.out.println("Invalid input.");
						}
						
						break;
					}
				}
					
				// edit in file if order is definitely found
				if (feFound) 
				{
					saveOrder();
				}
				else
				{
					System.out.println("Couldn't find an order with those details.");
				}
				
				break;
			
			case "d":
			case "D":
				// ask for ID and name, delete object 
				System.out.println("What is the ID of the order you would like to delete?");
				int findIDFD = scnr.nextInt();
				scnr.nextLine(); // throwaway
				boolean fdFound = false;
				
				for (Order d : orderList) 
				{
					if (d.getOrderID() == findIDFD)
					{
						fdFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("Order ID: "+d.orderID+", Customer ID: "+d.cust.getCustID()+".\nGames bought: "+d.gamesBought+", Total price: "+d.total+"");
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
				orderList.removeAll(forDeletion);
				
				// edit in file if order is definitely found
				if (fdFound) 
				{
					saveOrder();
				}
				else
				{
					System.out.println("Couldn't find an order with those details.");
				}
				
				break;
				
			case "e":
			case "E":
				// if arraylist is empty print message 
				// https://www.w3schools.com/java/ref_arraylist_isempty.asp 
				if (orderList.isEmpty()) 
				{
					System.out.println("No customers found in the list.");
				}
				else 
				{
					System.out.println("Full List of Orders: \n");
					for (Order o : orderList) 
					{
						System.out.println("Order ID: "+o.orderID+", Customer ID: "+o.cust.getCustID()+".\nGames bought: "+o.gamesBought+", Total price: "+o.total+"\n-------------------");
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