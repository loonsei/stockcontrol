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
		
		// add title and the buttons
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
		JPanel mainCustPanel = new JPanel();
		
		// stack the components inside the main panel on top of each other
		mainCustPanel.setLayout(new BoxLayout(mainCustPanel, BoxLayout.Y_AXIS));
		
		// assign variables to label and buttons, link buttons to inner classes
		JLabel titleCust = new JLabel ("Customers Menu");
		
		JButton addCust = new JButton("Add a Customer");
		addCust.addActionListener(new addCustListener());
		
		JButton delCust = new JButton("Delete a Customer");
		delCust.addActionListener(new delCustListener());
		
		JButton viewAllCust = new JButton("View all Customers");
		viewAllCust.addActionListener(new viewAllCustListener());
		
		// add title and the buttons
		mainCustPanel.add(titleCust);
		mainCustPanel.add(addCust);
		mainCustPanel.add(delCust);
		mainCustPanel.add(viewAllCust);
		// align them to centre of panel
		titleCust.setAlignmentX(Component.CENTER_ALIGNMENT);
		addCust.setAlignmentX(Component.CENTER_ALIGNMENT);
		delCust.setAlignmentX(Component.CENTER_ALIGNMENT);
		viewAllCust.setAlignmentX(Component.CENTER_ALIGNMENT);

		return mainCustPanel;
	}
	
	public JPanel createOrderPanel() 
	{
		JPanel mainOrderPanel = new JPanel();
		
		// stack the components inside the main panel on top of each other
		mainOrderPanel.setLayout(new BoxLayout(mainOrderPanel, BoxLayout.Y_AXIS));
		
		// assign variables to label and buttons, link buttons to inner classes
		JLabel titleOrder = new JLabel ("Orders Menu");
		
		JButton addOrder = new JButton("Add an Order");
		addOrder.addActionListener(new addOrderListener());
		
		JButton delOrder = new JButton("Delete an Order");
		delOrder.addActionListener(new delOrderListener());
		
		JButton viewAllOrder = new JButton("View all Orders");
		viewAllOrder.addActionListener(new viewAllOrderListener());
		
		// add title and the buttons
		mainOrderPanel.add(titleOrder);
		mainOrderPanel.add(addOrder);
		mainOrderPanel.add(delOrder);
		mainOrderPanel.add(viewAllOrder);
		// align them to centre of panel
		titleOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		addOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		delOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
		viewAllOrder.setAlignmentX(Component.CENTER_ALIGNMENT);

		return mainOrderPanel;
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
			// convert String into integer
			int findRy = Integer.parseInt(ryAsString);
			
			// boolean check
			boolean fdFound = false;
			
			// search for game
			for (Vg g : VgMenu.vgList) 
			{
				if (g.getTitle().equalsIgnoreCase(findTitle) && g.getReleaseYear() == findRy) 
				{
					// remove game if user input matches
					VgMenu.vgList.remove(g);
					// remove from file
					vgMenu.saveVg();
					JOptionPane.showMessageDialog(frame, g.getTitle() + " deleted.");
					
					fdFound = true;
					
					// stop looping through list
					break;
				}
			}
			
			if (!fdFound) 
			{
				JOptionPane.showMessageDialog(frame, "Could not find that game.");
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
	
	class addCustListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// user can input name within the dialog box
			String name = JOptionPane.showInputDialog("Enter customer name: ");
			// exit if user leaves blank
			if (name == null) 
			{
				return;
			}
			
			String email = JOptionPane.showInputDialog("Enter customer's email: ");
			if (email == null)
			{
				return;
			}
			
			String phone = JOptionPane.showInputDialog("Enter customer's phone number: ");
			if (phone == null)
			{
				return;
			}
			
			// for generating their id
			int custID = (int)(Math.random() * 900000) + 100000;
			
			// create new customer from inputs and add to custList
			Customer newCust = new Customer(custID, name, email, phone);
			CustMenu.custList.add(newCust);
			// call writing to file method in custMenu class
			custMenu.saveCustomer();
			// message to tell user that customer has been added
			JOptionPane.showMessageDialog(frame, name + " Added!");
		}
	}
	
	class delCustListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// input id as String first bc of showInput, use to find id in list
			String custIDAsString = JOptionPane.showInputDialog("Enter the ID of the customer you want to delete: ");
			if (custIDAsString == null)
			{
				return;
			}
			// convert String into integer
			int findCustID = Integer.parseInt(custIDAsString);
			
			String findName = JOptionPane.showInputDialog("Enter the name of the customer you want to delete: ");
			if (findName == null) 
			{
				return;
			}
			
			// boolean check
			boolean fdFound = false;
			
			// search for customer
			for (Customer c : CustMenu.custList) 
			{
				if (c.getCustID() == findCustID && c.getName().equalsIgnoreCase(findName)) 
				{
					// remove customer if user input matches
					CustMenu.custList.remove(c);
					// remove from file
					custMenu.saveCustomer();
					JOptionPane.showMessageDialog(frame, c.getName() + " deleted.");
					
					fdFound = true;
					
					// stop looping through list
					break;
				}
			}
			
			if (!fdFound) 
			{
				JOptionPane.showMessageDialog(frame, "Could not find that game.");
			}
		}
	}
	
	class viewAllCustListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// create DefaultListModel to keep list updated constantly whilst gui is open
			// https://docs.oracle.com/javase/8/docs/api/javax/swing/DefaultListModel.html
			DefaultListModel<String> listModel = new DefaultListModel<>();
			
			// add each cust in list to model
			for (Customer c : CustMenu.custList) 
			{
				listModel.addElement(c.getName()+" - "+c.getCustID());
			}
			
			// put model into list
			JList<String> custJList = new JList<>(listModel);
			
			// add scrollpane so user can scroll through list
			JScrollPane scroll = new JScrollPane(custJList);
			
			// display the list, add icon to avoid parameter error
			JOptionPane.showMessageDialog(frame, scroll, "Full List of Customers", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	class addOrderListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// ask for id of customer who is making the order
			String custIDAsString = JOptionPane.showInputDialog("Enter the ID of the customer making the order: ");
			if (custIDAsString == null)
			{
				return;
			}
			// convert String into integer so ID can be found
			int findCustID = Integer.parseInt(custIDAsString);
			
			// find matching customer obj
			Customer custFound = null;
			for (Customer c : CustMenu.custList) 
			{
				if(c.getCustID() == findCustID) 
				{
					custFound = c;
					// stop looping
					break;
				}
			}
			
			// if customer obj not found
			if (custFound == null) 
			{
				JOptionPane.showMessageDialog(frame, "Customer ID not found.");
				return;
			}
			
			// ask user how many games are being bought as int
			String gbAsString = JOptionPane.showInputDialog("Number of games bought (integer): ");
			if (gbAsString == null)
			{
				return;
			}
			// convert String into integer so it can be passed into order constructor
			int gamesBought = Integer.parseInt(gbAsString);
			
			// create new order from inputs and add to orderList
			Order newOrder = new Order(custFound, gamesBought);
			OrderMenu.orderList.add(newOrder);
			// call writing to file method in orderMenu class
			orderMenu.saveOrder();
			// message to tell user that order has been added
			JOptionPane.showMessageDialog(frame, "Order: " + newOrder.getOrderID() + " Added!");
		}
	}
	
	class delOrderListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// ask for orderID as String
			String orderIDAsString = JOptionPane.showInputDialog("Enter the ID of the order you want to delete: ");
			if (orderIDAsString == null) 
			{
				return;
			}
			// convert
			int findOrderID = Integer.parseInt(orderIDAsString);

			// boolean check
			boolean fdFound = false;
			
			// search for order
			for (Order o : OrderMenu.orderList) 
			{
				if (o.getOrderID() == findOrderID) 
				{
					// remove game if user input matches
					OrderMenu.orderList.remove(o);
					// remove from file
					orderMenu.saveOrder();
					JOptionPane.showMessageDialog(frame, o.getOrderID() + " deleted.");
					
					fdFound = true;
					
					// stop looping through list
					break;
				}
			}
			
			if (!fdFound) 
			{
				JOptionPane.showMessageDialog(frame, "Could not find that order.");
			}
		}
	}
	
	class viewAllOrderListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a) 
		{
			// create DefaultListModel to keep list updated constantly whilst gui is open
			// https://docs.oracle.com/javase/8/docs/api/javax/swing/DefaultListModel.html
			DefaultListModel<String> listModel = new DefaultListModel<>();
			
			// add each order in list to model
			for (Order o : OrderMenu.orderList) 
			{
				listModel.addElement(o.getOrderID()+" | No. of games: "+o.getGamesBought()+" | £"+o.getTotal());
			}
			
			// put model into list
			JList<String> orderJList = new JList<>(listModel);
			
			// add scrollpane so user can scroll through list
			JScrollPane scroll = new JScrollPane(orderJList);
			
			// display the list, add icon to avoid parameter error
			JOptionPane.showMessageDialog(frame, scroll, "Full List of Orders", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}