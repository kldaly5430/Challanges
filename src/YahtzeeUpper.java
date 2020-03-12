import java.util.Random;

// Description
// The game of Yahtzee is played by rolling five 6-sided dice, and scoring the results in a number of ways. You are given a Yahtzee dice roll, represented as a sorted list of 5
// integers, each of which is between 1 and 6 inclusive. Your task is to find the maximum possible score for this roll in the upper section of the Yahtzee score card. Here's 
// what that means.

// For the purpose of this challenge, the upper section of Yahtzee gives you six possible ways to score a roll. 1 times the number of 1's in the roll, 2 times the number of 2's,
// 3 times the number of 3's, and so on up to 6 times the number of 6's. For instance, consider the roll [2, 3, 5, 5, 6]. If you scored this as 1's, the score would be 0, since 
// there are no 1's in the roll. If you scored it as 2's, the score would be 2, since there's one 2 in the roll. Scoring the roll in each of the six ways gives you the six possible
// scores:

// 0 2 3 0 10 6
// The maximum here is 10 (2x5), so your result should be 10.

public class YahtzeeUpper {

	public static void main(String[] args) {
		
		int[] rolls = new int[5];
		int score;
		Random rand = new Random();
		
		for(int i = 0; i < 5; i++) {
			rolls[i] = rand.nextInt(6);
			rolls[i]++;
		}
		
		score = CalcScore(rolls);
		
		System.out.print("Yahtzee_Upper: [ ");
		for(int j = 0; j < rolls.length; j++) {
			System.out.print(rolls[j] + " ");
		}
		System.out.print("] => " + score);

	}
	
	static int CalcScore(int[] rolls) {
		
		int total = 0, temp = 0;
		
		for(int i = 1; i <= 6; i++) {
			temp = 0;
			for(int j = 0; j < 5; j++) {
				if(i == rolls[j]) {
					System.out.println(i);
					temp += rolls[j];
				}
			}
			if(temp > total) {
					total = 0;
					total = temp;
				}
		}
		
		return total;
	}

}
