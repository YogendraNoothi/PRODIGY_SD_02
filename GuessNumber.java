import java.util.Scanner;
import java.util.*;
import java.io.*;
public class GuessNumber
{
	public static void main(String args[])
	{
		Random r=new Random();
		Scanner s=new Scanner(System.in);
		int minVal=1;
		int maxVal=100;
		int totalRounds=3;
		int currentRound=1;
		int score=0;
		int targetNumber;
		System.out.println("Welcome to Game to guess number");
		System.out.println("Guess the number between 1 to 100 only");
		while(currentRound<=totalRounds)
		{
			targetNumber=r.nextInt(minVal,maxVal);
			int attempts=0;
			int maxAttempts=10;
			System.out.println("\nRound "+currentRound+" of "+totalRounds);
			while(true)
			{
				System.out.println("Guess the number: ");
				int guess=s.nextInt();
				attempts++;
				if(guess==targetNumber)
				{
					System.out.println("Congtratulations! you guessed the correct number in "+attempts+" attempts.");
					int roundScore=calculateRoundScore(attempts);
					score+=roundScore;
					System.out.println("Round Score: "+roundScore);
					break;
				}
				else if(guess<targetNumber)
				{
					System.out.println("Your guess is lower than target number.");
				}
				else
				{
					System.out.println("Your guess is higher than target number.");
				}
				if(attempts>=maxAttempts)
				{
					System.out.println("Sorry you have reached the maximum number of attempts.The correct number was: "+targetNumber);
					break;
				}
			}
			currentRound++;
		}
		System.out.println("\nGame Over!");
		System.out.println("Total Score "+score);
	}
	private static int calculateRoundScore(int attempts)
	{
		if(attempts<=3)
		{
			return 10;
		}
		else if(attempts<=6)
		{
			return 5;
		}
		else
		{
			return 1;
		}
	}
}
