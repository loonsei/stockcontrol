// 22504421 Amy Johnson 

import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
	
	public static void main(String[] args) 
	{
		Scanner scnr = new Scanner(System.in);
		
		VgMenu vgMenuLoader = new VgMenu(scnr);
		CustMenu custMenuLoader = new CustMenu(scnr);
		OrderMenu orderMenuLoader = new OrderMenu(scnr);
		
		// launch gui + pass in menu loaders so gui can access classes
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				Gui gooey = new Gui(vgMenuLoader, custMenuLoader, orderMenuLoader);
				gooey.setupGui();
			}
		});

		// pass menu loaders into mainMenu function so can access classes
		mainMenu(scnr, vgMenuLoader, custMenuLoader, orderMenuLoader);
		scnr.close();
	}
	
	public static void mainMenu(Scanner scnr, VgMenu vgMenuLoader, CustMenu custMenuLoader, OrderMenu orderMenuLoader) 
	{	
		while(true) 
		{
			// give user choice of accessing the vg menu, customer menu or order 
			System.out.println("VG Company Stock Control. Which menu would you like to access?");
			System.out.println("a. Video game menu. ");
			System.out.println("b. Customer menu. ");
			System.out.println("c. Order menu. ");
			System.out.println("d. Exit program. ");
			
			String userMenuChoice = scnr.nextLine();
			switch(userMenuChoice)
			{
			case "a":
			case "A":
				// call video game menu method
				vgMenuLoader.vgMenu();
				
				break;
				
			case "b":
			case "B":
				// call customer menu method
				custMenuLoader.custMenu();
				
				break;
				
			case "c":
			case "C":
				// call order menu method
				orderMenuLoader.orderMenu();
				
				break;
				
			case "d":
			case "D":
				// close/terminate the program
				System.out.println("\nProgram terminated.");
				System.exit(0);
				
				break;

			default:
				System.out.println("Invalid input, please try again.\n");
			}
		}
	}
}