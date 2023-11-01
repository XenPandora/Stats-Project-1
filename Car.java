
public class Car 
{
	private String type;
	private int year;
	private String color;
	private int miles;
	
	public Car(String t, int y, String c, int m)
	{
		type = t;
		year = y;
		color = c;
		miles = m;
	}
	
	//setter methods
	
	public void setType(String t)
	{
		type = t;
	}
	public void setYear(int y)
	{
		year = y;
	}
	public void setColor(String c)
	{
		color = c;
	}
	public void setMiles(int m)
	{
		miles = m;
	}
	
	//getter methods
	
	public String getType()
	{
		return type;
	}
	public int getYear()
	{
		return year;
	}
	public String getColor()
	{
		return color;
	}
	public int getMiles()
	{
		return miles;
	}
}
