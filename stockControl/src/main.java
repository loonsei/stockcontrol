import java.util.Scanner;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) 
	{
		Scanner scnr = new Scanner(System.in);
		
		// null safety (asked Google Gemini)
		vg newGame = null;
		
		// for storing objects in array list
		ArrayList<vg> vgList = new ArrayList<vg>();
		
		while (true) 
		{
			System.out.println("VG Company Stock Control. pick an option: ");
			System.out.println("a. Add a new video game. ");
			System.out.println("b. View the details of a video game. ");
			System.out.println("c. Edit the details of a video game. ");
			System.out.println("d. Delete a video game. ");
			System.out.println("e. Exit program. ");
			
			String menuSelect = scnr.nextLine();
			switch(menuSelect)
			{
			case "a":
			case "A":
				// asks for name, title, release date, publisher, developer and platform 
				System.out.println("Enter the title of the video game you want to add: ");
				String title = scnr.nextLine();
				System.out.println("Enter the release year of the video game: ");
				int releaseYear = scnr.nextInt();
				scnr.nextLine(); // throwaway nextLine bc of the nextInt
				System.out.println("Enter the publisher of the video game: ");
				String publish = scnr.nextLine();
				System.out.println("Enter the developer of the video game: ");
				String dev = scnr.nextLine();
				System.out.println("Enter the platform of the video game: ");
				String platform = scnr.nextLine();
				
				// call constructor
				newGame = new vg(title, releaseYear, publish, dev, platform);
				System.out.println("You have entered the following: "+newGame.title+", "+newGame.releaseYear+", "+newGame.publish+", "+newGame.dev+", "+newGame.platform+".");
				
				// store object in list 
				vgList.add(newGame);

				break;
	
			case "b":
			case "B":
				// asks user the title and release date to identify the game they are wanting to view 
				System.out.println("What is the title of the game you are wanting to view? ");
				String findTitle = scnr.nextLine();
				// System.out.println("What is the release year of the game you are wanting to view? ");
				// int findYear = scnr.nextInt();
				// find value in array list
				// && vgList.contains(findYear)
				for (newGame : vgList) 
				{
					if (newGame.getTitle().equalsIgnoreCase(findTitle))
					{
						// print the details of objects that have this these details
						System.out.println("found it, printing details...");
					}
					else 
					{
						System.out.println("Not found.");					
					}
					
				}
				
				// try and find way to loop this case if the user makes error
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
				System.out.println("Invalid input, please try again.");
			}
		}
	}
}