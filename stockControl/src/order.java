// 22504421 Amy Johnson

// Design a class for storing details about an order, where that order can consist of many products/services bought by one customer. 

import java.util.ArrayList;

public class order {

	int orderID;
	customer custID;
	// array list to store the games bought 
	ArrayList<vg> gamesBought;
	// price paid by customer
	// could try and add prices of games to get total price for the whole order?
	double amount;
	
	// generate random 6 digit number for ID, adds 100000 so ID can never be less than 6 digits
	int num = (int)(Math.random() * 900000) + 100000;

	public order(int orderID, customer custID, double amount)
	{
		this.orderID = num;
		this.custID = custID;
		this.gamesBought = new ArrayList<vg>();
		this.amount = amount;
	}
	
	// method to add bought games to the array list
	public void addGameBought(vg newGame) 
	{
		gamesBought.add(newGame);
	}
	
	public void totalPrice() 
	{
		double total = 0;
		for (vg p : gamesBought) 
		{
			total += p.getPrice();
		}
		System.out.println("Total order price: " + total);
	}
}