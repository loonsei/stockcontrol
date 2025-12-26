public class vg {
	
	String title;
	int releaseYear;
	String publish;
	String dev;
	String platform;
	
	
	// constructor
	public vg(String title, int releaseYear, String publish, String dev, String platform)
	{
		this.title = title;
		this.releaseYear = releaseYear;
		this.publish = publish;
		this.dev = dev;
		this.platform = platform;
	}
	
	/*public String toString() 
	{
		return title+" "+releaseYear+" "+publish+" "+dev+" "+platform;
	}*/

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
	
}