

import java.util.ArrayList;

public class CarData 
{
	public static void main(String [] args) 
	{
		ArrayList<String> cars = new ArrayList<String>();
		
		/*
		 * this section was going to be for creating a csv,
		 * but when I tried importing FileWriter, eclipse stopped working
		 */
		
		System.out.println("Type, Year, Color, Miles");
		Factory factory = new Factory();
		for(int x = 0; x<1000; x++)
		{
			cars.add(factory.createCar());
		}
		System.out.println(cars);
		

		
		
	}
	
	

}
