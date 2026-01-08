// 22504421 Amy Johnson

public class Order {

	int orderID;
	// so each Order has a Customer connected to it
	Customer cust;
	int gamesBought;
	// could try and add prices of games to get total price for the whole Order?
	double total;

	public Order(Customer cust, int gamesBought)
	{
		// generate random 6 digit number for ID, adds 100000 so ID can never be less than 6 digits
		this.orderID = (int)(Math.random() * 900000) + 100000;
		this.cust = cust;
		this.gamesBought = gamesBought;
		this.total = gamesBought * Vg.getPrice();
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public int getGamesBought() {
		return gamesBought;
	}

	public void setGamesBought(int gamesBought) {
		this.gamesBought = gamesBought;
		// keep the total updated as it relies on games bought
		this.total = gamesBought * Vg.getPrice();
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}