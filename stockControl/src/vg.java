
public class vg {
	
	String title;
	int releaseYear;
	String publish;
	String dev;
	String platform;
	
	
	// constructor
	vg(String title, int releaseYear, String publish, String dev, String platform)
	{
		this.title = title;
		this.releaseYear = releaseYear;
		this.publish = publish;
		this.dev = dev;
		this.platform = platform;
	}
	
	public String toString() {
		return title+" "+releaseYear+" "+publish+" "+dev+" "+platform;
	}
 

}