import java.util.Random;
public class Doors 
{
	private int[] doors;
	public Doors()
	{
		doors = new int[3];
	}
	
	public void fillDoors()
	{
		Random rand = new Random();
		for(int x = 0; x<doors.length; x++)
		{
			doors[x] = 0;
		}
		int prize = rand.nextInt(3);
		doors[prize] = 1;
	}
	
	public int getDoor(int index)
	{
		return doors[index];
	}
}
