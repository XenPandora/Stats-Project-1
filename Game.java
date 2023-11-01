import java.util.Random;
public class Game 
{
	private Doors newGame;
	private int wins;
	
	public Game()
	{
		newGame = new Doors();
		wins = 0;
	}
	
	public void playGame(int plays, boolean doIChangeDoors)
	{
		Random rand = new Random();
		int x = 0;
		while(x<plays)
		{
			newGame.fillDoors();
			int	choice = rand.nextInt(3);
			if(newGame.getDoor(choice) == 1)
			{
				wins++;
			}
			else
			{
				if(doIChangeDoors)
				{
					choice = rand.nextInt(3);
					if(newGame.getDoor(choice) == 1)
					{
						wins++;
					}
				}
			}
			x++;
		}
		displayWins();
	}
	
	private void displayWins()
	{
		System.out.println("You won " +wins +" times");
		wins = 0;
	}
	
}
