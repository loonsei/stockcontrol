// 22504421 Amy Johnson

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui {
	
	JFrame frame;
	VgMenu vgMenu;
	CustMenu custMenu;
	OrderMenu orderMenu;
	
	// gui constructor
	public Gui(VgMenu vg, CustMenu cust, OrderMenu order)
	{
		this.vgMenu = vg;
		this.custMenu = cust;
		this.orderMenu = order;
	}
	
	public void setupGui()
	{
		// create frame with title
		frame = new JFrame("VG Company Stock Control");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,500);
		
		// create variables for the main panels
		JPanel vgPanel = createVgPanel();
		JPanel custPanel = createCustPanel();
		JPanel orderPanel = createOrderPanel();
		
		// create tabbed pane with the main panels inside
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Video Games", vgPanel);
		tabs.addTab("Customers", custPanel);
		tabs.addTab("Orders", orderPanel);
		
		// add the tabs
		frame.add(tabs);
		frame.setVisible(true);
	}
	
	public JPanel createVgPanel() 
	{
		JPanel mainVgPanel = new JPanel();
		
		// stack the components inside the main panel on top of each other
		mainVgPanel.setLayout(new BoxLayout(mainVgPanel, BoxLayout.Y_AXIS));
		
		// assign variables to label and buttons, link buttons to inner classes
		JLabel titleVg = new JLabel ("Video Games Menu");
		
		JButton addVg = new JButton("Add a Video Game");
		addVg.addActionListener(new addVgListener());
		
		JButton delVg = new JButton("Delete a Video Game");
		delVg.addActionListener(new delVgListener());
		
		JButton viewAllVg = new JButton("View all Video Games");
		viewAllVg.addActionListener(new viewAllVgListener());
		
		// add the buttons
		mainVgPanel.add(titleVg);
		mainVgPanel.add(addVg);
		mainVgPanel.add(delVg);
		mainVgPanel.add(viewAllVg);
		// align them to centre of panel
		titleVg.setAlignmentX(Component.CENTER_ALIGNMENT);
		addVg.setAlignmentX(Component.CENTER_ALIGNMENT);
		delVg.setAlignmentX(Component.CENTER_ALIGNMENT);
		viewAllVg.setAlignmentX(Component.CENTER_ALIGNMENT);

		return mainVgPanel;
	}
	
	public JPanel createCustPanel() 
	{
		return new JPanel();
	}
	
	public JPanel createOrderPanel() 
	{
		return new JPanel();
	}
	
	// inner classes
	class addVgListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// user can input title within the dialog box
			String title = JOptionPane.showInputDialog("Enter game title: ");
			// exit if user leaves blank
			if (title == null) 
			{
				return;
			}
			
			// input ry as String first bc of showInput
			String ryAsString = JOptionPane.showInputDialog("Enter release year: ");
			if (ryAsString == null)
			{
				return;
			}
			// convert String into integer so it can be passed in vg constructor
			int ry = Integer.parseInt(ryAsString);
			
			String pub = JOptionPane.showInputDialog("Enter publisher: ");
			if (pub == null)
			{
				return;
			}
			
			String dev = JOptionPane.showInputDialog("Enter developer: ");
			if (dev == null)
			{
				return;
			}
			
			String plat = JOptionPane.showInputDialog("Enter platform: ");
			if (plat == null)
			{
				return;
			}
			
			// create new game from inputs and add to vgList
			Vg newGame = new Vg(title, ry, pub, dev, plat);
			VgMenu.vgList.add(newGame);
			// call writing to file method in vgMenu class
			vgMenu.saveVg();
			// message to tell user that game has been added
			JOptionPane.showMessageDialog(frame, title + " Added!");
		}
	}
	
	class delVgListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// user can input title within the dialog box, use to find title in list
			String findTitle = JOptionPane.showInputDialog("Enter the title of the game you want to delete: ");
			// exit if user leaves blank
			if (findTitle == null) 
			{
				return;
			}
			
			// input ry as String first bc of showInput, use to find ry in list
			String ryAsString = JOptionPane.showInputDialog("Enter the release year of the game you want to delete: ");
			if (ryAsString == null)
			{
				return;
			}
			// convert String into integer so it can be passed in vg constructor
			int findRy = Integer.parseInt(ryAsString);
			
			// search for game
			for (Vg g : VgMenu.vgList) 
			{
				if (g.getTitle().equalsIgnoreCase(findTitle) && g.getReleaseYear() == findRy) 
				{
					// remove game if user input matches
					VgMenu.vgList.remove(g);
					// remove from file
					vgMenu.saveVg();
					JOptionPane.showMessageDialog(frame, g.title + " deleted.");
				}
				else 
				{
					JOptionPane.showMessageDialog(frame, "Could not find that game.");
				}
			}
		}
	}
	
	class viewAllVgListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// create DefaultListModel to keep list updated constantly whilst gui is open
			// https://docs.oracle.com/javase/8/docs/api/javax/swing/DefaultListModel.html
			DefaultListModel<String> listModel = new DefaultListModel<>();
			
			// add each game in list to model
			for (Vg g : VgMenu.vgList) 
			{
				listModel.addElement(g.getTitle()+" - "+g.getReleaseYear());
			}
			
			// put model into list
			JList<String> vgJList = new JList<>(listModel);
			
			// add scrollpane so user can scroll through list
			JScrollPane scroll = new JScrollPane(vgJList);
			
			// display the list, add icon to avoid parameter error
			JOptionPane.showMessageDialog(frame, scroll, "Full List of Video Games", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}