// 22504421 Amy Johnson 

public class vg {
	
	String title;
	int releaseYear;
	String publish;
	String dev;
	String platform;
	double price;
	
	// constructor
	public vg(String title, int releaseYear, String publish, String dev, String platform, double price)
	{
		this.title = title;
		this.releaseYear = releaseYear;
		this.publish = publish;
		this.dev = dev;
		this.platform = platform;
		this.price = price;
	}

	// getters and setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getDev() {
		return dev;
	}

	public void setDev(String dev) {
		this.dev = dev;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
		
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}