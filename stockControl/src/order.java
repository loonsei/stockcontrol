// 22504421 Amy Johnson

// Design a class for storing details about an order, where that order can consist of many products/services bought by one customer. 

public class order {

	int orderID;
	int grabCustID;
	int gamesBought;
	// could try and add prices of games to get total price for the whole order?
	double total;

	public order(int grabCustID, int gamesBought)
	{
		// generate random 6 digit number for ID, adds 100000 so ID can never be less than 6 digits
		this.orderID = (int)(Math.random() * 900000) + 100000;
		this.grabCustID = grabCustID;
		this.gamesBought = gamesBought;
		this.total = gamesBought * vg.getPrice();
	}
}