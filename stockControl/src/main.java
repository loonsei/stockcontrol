import java.util.Scanner;

public class main {

	public static void main(String[] args) 
	{
		while (true) 
		{
			System.out.println("VG Company Stock Control: pick an option: ");
			System.out.println("a. Add a new video game. ");
			System.out.println("b. View the details of a video game. ");
			System.out.println("c. Edit the details of a video game. ");
			System.out.println("d. Delete a video game. ");
			System.out.println("e. Exit program. ");
			
			Scanner scnr = new Scanner(System.in);
			String menuSelect = scnr.nextLine();
			
			switch(menuSelect)
			{
			case "a":
			case "A":
				// asks for name, title, release date, publisher, developer and platform 
				break;
	
			case "b":
			case "B":
				// displays details 
				break;
	
			case "c":
			case "C":
				// ask user what detail they want to change 
				System.out.println("What detail would you like to change? Select from the following: \ntitle\netc.");
				break;
	
			case "d":
			case "D":
				// ask for name and release date, delete object 
				break;
	
			case "e":
			case "E":
				// close/terminate the program
				System.out.println("Program terminated.");
				System.exit(0);
				break;
	
			default:
				System.out.println("Invalid input");
			}
		}
	}
}