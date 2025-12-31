			/*case "c":
			case "C":
				// ask user the title and the release date of the item they want to change 
				System.out.println("What is the title of the item you would like to change?");
				String findTitleForEdit = scnr.nextLine();
				System.out.println("What is the release date of the item you would like to change?");
				int findYearForEdit = scnr.nextInt();
				scnr.nextLine(); // throwaway nextLine bc of the nextInt
				boolean feFound = false;
				
				for (vg e : vgList) 
				{
					if (e.getTitle().equalsIgnoreCase(findTitleForEdit) && e.getReleaseYear() == findYearForEdit);
					{
						feFound = true;
						System.out.println("Found! Showing details...\n");
						System.out.println("Title: "+e.title+" \nRelease year: "+e.releaseYear+" \nPublisher: "+e.publish+" \nDeveloper: "+e.dev+" \nPlatform: "+e.platform+" \n");
						
						System.out.println("What detail would you like to change? Answer from the following: \n- title\n- ry\n- pub\n- dev\n- plat\n");
						String userAnswer = scnr.nextLine();
						switch(userAnswer) 
						{
						case "title":
						case "Title":
						case "TITLE":
							System.out.println("What do you want to change the title to? Currently: "+e.title+"");
							String editTitle = scnr.nextLine();
							e.setTitle(editTitle);
							System.out.println("Title changed.\n");
							
							break;
							
						case "ry":
						case "Ry":
						case "RY":
							System.out.println("What do you want to change the title to? Currently: "+e.releaseYear+"");
							int editRY = scnr.nextInt();
							scnr.nextLine(); // throwaway nextLine bc of the nextInt
							e.setReleaseYear(editRY);
							System.out.println("Release year changed.\n");
							
							break;
							
						case "pub":
						case "Pub":
						case "PUB":
							System.out.println("What do you want to change the publisher to? Currently: "+e.publish+"");
							String editPub = scnr.nextLine();
							e.setPublish(editPub);
							System.out.println("Publisher changed.\n");
							
							break;
						
						case "dev":
						case "Dev":
						case "DEV":
							System.out.println("What do you want to change the developer to? Currently: "+e.dev+"");
							String editDev = scnr.nextLine();
							e.setTitle(editDev);
							System.out.println("Developer changed.\n");
							
							break;
							
						case "plat":
						case "Plat":
						case "PLAT":
							System.out.println("What do you want to change the platform to? Currently: "+e.platform+"");
							String editPlat = scnr.nextLine();
							e.setTitle(editPlat);
							System.out.println("Platform changed.\n");
							
							break;
							
						default:
							System.out.println("Invalid input.");
						}
					}	
				}
				
				if (!feFound) 
				{
					System.out.println("Couldn't find an item with those details.");
				}
				
				break;*/