// 22504421 Amy Johnson 

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class orderMenu {
	
	// array list for orders
	static ArrayList<order> orderList = new ArrayList<order>();
	
	public static void orderMenu() 
	{	
		Scanner scnr = new Scanner(System.in);
		
		// import custList so it can be referenced
		ArrayList<customer> custList = custMenu.custList;
		
		// array list to store objects that will be deleted 
		ArrayList<order> forDeletion = new ArrayList<order>();
		
		// null safety 
		order newOrder = null;
		
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
				
				boolean foundID = false;
				
				for (customer c : custList)
				{
					if (c.getCustID() == grabCustID)
					{
						foundID = true;
						System.out.println("Customer found.");
						// ask user how many games the customer is buying
						System.out.println("Enter the amount of games being bought: ");
						int gamesBought = scnr.nextInt();
						scnr.nextLine(); // throwaway
						
						// call constructor
						newOrder = new order(grabCustID, gamesBought);
						System.out.println("Order ID: "+newOrder.orderID+", Customer ID: "+newOrder.grabCustID+".\nGames bought: "+newOrder.gamesBought+", Total price: "+newOrder.total+".");
						
						// store object in list 
						orderList.add(newOrder);
					}
				}
				
				if (!foundID) 
				{
					System.out.println("Could not find that customer.");
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