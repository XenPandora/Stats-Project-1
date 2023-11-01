import java.util.Random;
public class Factory
{
	private String type;
	private int year;
	private String color;
	private int miles;
	
	public Factory()
	{
	}
	
	public String createCar()
	{
		Random rand = new Random();
		int t = rand.nextInt(5);
		if(t == 0 || t==1)
		{
			type = "Sedan";
		}
		else if(t == 2)
		{
			type = "SUV";
		}
		else if(t == 3)
		{
			type = "Truck";
		}
		else if(t == 4)
		{
			type = "Tank";
		}
		year = rand.nextInt(1973, 2024);;
		int c = rand.nextInt(5);
		if(c == 0 || c==1)
		{
			color = "Red";
		}
		else if(c == 2)
		{
			color = "Blue";
		}
		else if(c == 3)
		{
			color = "Black";
		}
		else if(c == 4)
		{
			color = "White";
		}
		miles = rand.nextInt(250001);
		Car car = new Car(type, year, color, miles);
		return car.getType() +", " +car.getYear() +", " +car.getColor() +", " +car.getMiles() +"\n";
	}
}
