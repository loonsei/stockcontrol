// 22504421 Amy Johnson 

import java.util.ArrayList;
import java.util.Scanner;

public class vgMenu {
	
	// for storing objects in array list
	static ArrayList<vg> vgList = new ArrayList<vg>();
	
	public static void vgMenu()
	{
		Scanner scnr = new Scanner(System.in);
		
		// array list to store objects that will be deleted 
		ArrayList<vg> forDeletion = new ArrayList<vg>();
		
		// null safety (asked Google Gemini)
		vg newGame = null;
		
		while (true) 
		{
			System.out.println("\nVideo game menu, pick an option: ");
			System.out.println("a. Add a new video game. ");
			System.out.println("b. View the details of a video game. ");
			System.out.println("c. Edit the details of a video game. ");
			System.out.println("d. Delete a video game. ");
			System.out.println("e. View all video games. ");
			System.out.println("f. Return to menu selection.");
			
			String menuSelect = scnr.nextLine();
			switch(menuSelect)
			{
			case "a":
			case "A":
				// asks for title, release date, publisher, developer and platform 
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
				System.out.println("You have entered the following: "+newGame.title+", "+newGame.releaseYear+", "+newGame.publish+", "+newGame.dev+", "+newGame.platform+", "+newGame.price+".");
				System.out.println("All video games are £10.");
				
				// store object in list 
				vgList.add(newGame);

				break;
	
			case "b":
			case "B":
				// asks user the vg title to identify the game they are wanting to view 
				System.out.println("What is the title of the game you are wanting to view? ");
				String findTitle = scnr.nextLine();
				// boolean check 
				boolean titleFound = false;
				// search through list
				for (vg g : vgList) 
				{
					// if user inputed title exists in list
					if (g.getTitle().equalsIgnoreCase(findTitle))
					{
						// print the details of objects that have this these details
						titleFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("Title: "+g.title+" \nRelease year: "+g.releaseYear+" \nPublisher: "+g.publish+" \nDeveloper: "+g.dev+" \nPlatform: "+g.platform+" \nPrice: "+g.price+"");
					}
					
				}
				
				// if title is not found in list
				if (!titleFound) 
				{
					System.out.println("Not found.");
				}
				
				// ? try and find way to loop this case if the user makes error
				break;
	
			case "c":
			case "C":
				// asks user the vg title to identify the game they are wanting to edit 
				System.out.println("What is the title of the game you are wanting to edit? ");
				String findTitleForEdit = scnr.nextLine();
				System.out.println("What is the release year of the game you are wanting to edit? ");
				int findRYForEdit = scnr.nextInt();
				scnr.nextLine(); // throwaway
				// boolean check 
				boolean feFound = false;		
				// search through list
				for (vg e : vgList) 
				{
					if (e.getTitle().equalsIgnoreCase(findTitleForEdit) && e.getReleaseYear() == findRYForEdit)
					{
						feFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("Title: "+e.title+" \nRelease year: "+e.releaseYear+" \nPublisher: "+e.publish+" \nDeveloper: "+e.dev+" \nPlatform: "+e.platform+" \nPrice: "+e.price+" \n");
						// ask user which detail they want to edit 
						System.out.println("What detail would you like to change? Answer from the following: \n- title\n- ry\n- pub\n- dev\n- plat\n- price\n");
						String userAnswer = scnr.nextLine();
						switch(userAnswer) 
						{
						case "title":
						case "Title":
						case "TITLE":
							System.out.println("What do you want to change the title to? Currently: "+e.title+"");
							String editTitle = scnr.nextLine();
							// sets title to new value
							e.setTitle(editTitle);
							System.out.println("Title changed.");
							
							break;
							
						case "ry":
						case "Ry":
						case "RY":
							System.out.println("What do you want to change the title to? Currently: "+e.releaseYear+"");
							int editRY = scnr.nextInt();
							scnr.nextLine(); // throwaway 
							e.setReleaseYear(editRY);
							System.out.println("Release year changed.");
							
							break;
							
						case "pub":
						case "Pub":
						case "PUB":
							System.out.println("What do you want to change the publisher to? Currently: "+e.publish+"");
							String editPub = scnr.nextLine();
							e.setPublish(editPub);
							System.out.println("Publisher changed.");
							
							break;
						
						case "dev":
						case "Dev":
						case "DEV":
							System.out.println("What do you want to change the developer to? Currently: "+e.dev+"");
							String editDev = scnr.nextLine();
							e.setDev(editDev);
							System.out.println("Developer changed.");
							
							break;
							
						case "plat":
						case "Plat":
						case "PLAT":
							System.out.println("What do you want to change the platform to? Currently: "+e.platform+"");
							String editPlat = scnr.nextLine();
							e.setPlatform(editPlat);
							System.out.println("Platform changed.");
							
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
					System.out.println("Couldn't find an item with those details.");
				}
				
				break;
	
			case "d":
			case "D":
				// ask for title and release date, delete object 
				System.out.println("What is the title of the item you would like to delete?");
				String findTitleForDeletion = scnr.nextLine();
				System.out.println("What is the release date of the item you would like to delete?");
				int findYearForDeletion = scnr.nextInt();
				scnr.nextLine(); // throwaway nextLine bc of the nextInt
				boolean fdFound = false;
				
				for (vg d : vgList) 
				{
					if (d.getTitle().equalsIgnoreCase(findTitleForDeletion) && d.getReleaseYear() == findYearForDeletion)
					{
						fdFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("Title: "+d.title+" \nRelease year: "+d.releaseYear+" \nPublisher: "+d.publish+" \nDeveloper: "+d.dev+" \nPlatform: "+d.platform+" \n");
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
				vgList.removeAll(forDeletion);
				
				if (!fdFound) 
				{
					System.out.println("Couldn't find an item with those details.");
				}
				
				break;
				
			case "e":
			case "E":
				// if arraylist is empty print message 
				// https://www.w3schools.com/java/ref_arraylist_isempty.asp 
				if (vgList.isEmpty()) 
				{
					System.out.println("No video games found in the list.");
				}
				else 
				{
					System.out.println("Full List of Video Games: \n");
					for (vg f : vgList) 
					{
						System.out.println("Title: "+f.title+" \nRelease year: "+f.releaseYear+" \nPublisher: "+f.publish+" \nDeveloper: "+f.dev+" \nPlatform: "+f.platform+" \nPrice: "+f.price+"");
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