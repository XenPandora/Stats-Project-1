import java.util.ArrayList;
import java.util.Random;

public class HandEvaluator 
{
	ArrayList<Card> deck;
	ArrayList<Card> hand;
	
	public HandEvaluator()
	{
		deck = new ArrayList<>();
		hand = new ArrayList<>();
	}
	
	public void makeHand(int times)
	{
		int trial = 0;
		while(trial < times) 
		{
			makeDeck();
			for(int x = 0; x < 5; x++)
			{
				hand.add(draw());
			}
			order(hand);
			printHand();
			evaluateHand(hand);
			hand.clear();
			trial++;
		}
		
	}
	
	//helper method to make a deck
	//resets every time before a new hand is created
	private void makeDeck()
	{
		for(int x = 1; x < 14; x++)
		{
			Card card = new Card("spade", x);
			deck.add(card);
		}
		for(int x = 1; x < 14; x++)
		{
			Card card = new Card("club", x);
			deck.add(card);
		}
		for(int x = 1; x < 14; x++)
		{
			Card card = new Card("diamond", x);
			deck.add(card);
		}
		for(int x = 1; x < 14; x++)
		{
			Card card = new Card("heart", x);
			deck.add(card);
		}
	}
	
	//helper method to get a random card
	private Card draw()
	{
		Card drawnCard = generateRandomCard();
		for(int x = 0; x < hand.size(); x++)
		{
			if(drawnCard.getSuit().equals(hand.get(x).getSuit()) && drawnCard.getValue() == hand.get(x).getValue())
			{
				drawnCard = generateRandomCard();
			}
		}
		deck.remove(drawnCard);
		return drawnCard;
	}

	private Card generateRandomCard() 
	{
		Random rand = new Random();
		String suit = "";
		int i = rand.nextInt(4);
		if(i == 0)
		{
			suit = "spade";
		}
		else if(i == 1)
		{
			suit = "club";
		}
		else if(i == 2)
		{
			suit = "diamond";
		}
		else
		{
			suit = "heart";
		}
		int value = rand.nextInt(1, 14);
		Card card = new Card(suit, value);
		return card;
	}
	
	//helper method to order the cards from least to greatest
	//uses bubble sort
		private void order(ArrayList<Card> cards)
		{
			int swapNum = 1;
			while(swapNum > 0)
			{
				swapNum = 0;
				for(int x = 0; x<hand.size()-1; x++)
				{
					if(hand.get(x).getValue() > hand.get(x+1).getValue())
					{
						Card temp = hand.get(x);
						hand.set(x, hand.get(x+1));
						hand.set(x+1, temp);
						swapNum++;
					}
				}
			}
		}
		
		//helper method to evaluate the value of your hand;
		private void evaluateHand(ArrayList<Card> hand)
		{
			String evaluation = "You got nothing";
			if(hand.get(0).getValue() == 1)
			{
				evaluation = "You got a High Card";
			}
			for(int x = 0; x < hand.size()-1; x++)
			{
				if(hand.get(x).getValue() == hand.get(x+1).getValue())
				{
					evaluation = "You got a Pair";
					if(x+2 < hand.size() && hand.get(x+1).getValue() == hand.get(x+2).getValue())
					{
						evaluation = "You got a Three of a Kind";
						if(x+3 < hand.size() && hand.get(x+2).getValue() == hand.get(x+3).getValue())
						{
							evaluation = "You got a Four of a Kind";
						}
						if(x+3 < hand.size() && x+4 < hand.size() && hand.get(x+3).getValue() == hand.get(x+4).getValue())
						{
							evaluation = "You got a Two Pair";
						}
					}
					if(x+2 < hand.size() && x+3 < hand.size() && hand.get(x+2).getValue() == hand.get(x+3).getValue())
					{
						evaluation = "You got a Two Pair";
						if(x+3 < hand.size() && x+4 < hand.size() && hand.get(x+3).getValue() == hand.get(x+4).getValue())
						{
							evaluation = "You got a Full House";
						}
					}
				}
			}
			if(hand.get(0).getValue() == hand.get(1).getValue()-1 && hand.get(1).getValue() == hand.get(2).getValue()-1 && hand.get(2).getValue() == hand.get(3).getValue()-1 && hand.get(3).getValue() == hand.get(4).getValue()-1)
			{
				evaluation = "You got a Straight";
				if(hand.get(0).getSuit().equals(hand.get(1).getSuit()) && hand.get(1).getSuit().equals(hand.get(2).getSuit()) && hand.get(2).getSuit().equals(hand.get(3).getSuit()) && hand.get(3).getSuit().equals(hand.get(4).getSuit()))
				{
					evaluation = "You got a Straight Flush";
				}
			}
			if(hand.get(0).getSuit().equals(hand.get(1).getSuit()) && hand.get(1).getSuit().equals(hand.get(2).getSuit()) && hand.get(2).getSuit().equals(hand.get(3).getSuit()) && hand.get(3).getSuit().equals(hand.get(4).getSuit()))
			{
				evaluation = "You got a Flush";
				if(hand.get(0).getValue() == hand.get(1).getValue()-1 && hand.get(1).getValue() == hand.get(2).getValue()-1 && hand.get(2).getValue() == hand.get(3).getValue()-1 && hand.get(3).getValue() == hand.get(4).getValue()-1)
				{
					evaluation = "You got a Straight Flush";
				}
				if(hand.get(0).getValue() == 1 && hand.get(1).getValue() == 10 && hand.get(2).getValue() == 11 && hand.get(3).getValue() == 12 && hand.get(4).getValue() == 13)
				{
					evaluation = "At this point go all in because you just got a Royal Flush";
				}
			}
			System.out.println(evaluation);
			System.out.println("\n");
			
		}
		
		
	//prints out the contents of the hand
	private void printHand()
	{
		for(int x = 0; x<hand.size(); x++)
		{
			System.out.print("Suit: " +hand.get(x).getSuit() +" | Value " +hand.get(x).getValue() + " || ");
		}
		System.out.println("\n");
	}
}
