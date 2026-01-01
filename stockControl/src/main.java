// 22504421 Amy Johnson 

import java.util.Scanner;

public class main {
	
	public static void mainMenu() 
	{
		Scanner scnr = new Scanner(System.in);
		
		// give user choice of accessing the vg menu or the customer menu
		
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
			vgMenu.vgMenu();
			
			break;
			
		case "b":
		case "B":
			// call video game menu method
			custMenu.custMenu();
			
			break;
			
		case "c":
		case "C":
			// call video game menu method
			vgMenu.vgMenu();
			
			break;
			
		case "d":
		case "D":
			// close/terminate the program
			System.out.println("Program terminated.");
			System.exit(0);
			
			break;

		default:
			System.out.println("Invalid input, please try again.\n");
		}
	}

	public static void main(String[] args) 
	{
		mainMenu();
	}
}