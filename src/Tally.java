import java.util.Scanner;

//5 Friends (let's call them a, b, c, d and e) are playing a game and need to keep track of the scores. Each time someone scores a point, the letter of his name 
//is typed in lowercase. If someone loses a point, the letter of his name is typed in uppercase. Give the resulting score from highest to lowest.
//A series of characters indicating who scored a point. Examples:

//Input:
//abcde
//dbbaCEDbdAacCEAadcB

//The score of every player. Examples:
//
//Output:
//a:1, b:1, c:1, d:1, e:1
//b:2, d:2, a:1, c:0, e:-2

public class Tally {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		char[] player = new char[26];
		int[] score = new int[26];
		String initials;
		
		System.out.println("Enter a string of characters: ");
		initials = kb.nextLine();
		
		TallyInitials(initials, player, score);

		kb.close();
	}
	
	static void TallyInitials(String initials,char player[], int score[]) {
		for(int i = 0; i < initials.length(); i++) {
			char letter = initials.charAt(i);
			for(int x = 0; x < 25; x++) {
				if(player[x] == 0) {
					player[x] = Character.toLowerCase(letter);
					if(player[x] == letter) {
						score[x]++;
					} else if(Character.toUpperCase(player[x]) == letter) {
						score[x]--;
					}
					break;
				} else if(player[x] == letter) {
					score[x]++;
					break;
				} else if(Character.toUpperCase(player[x]) == letter) {
					score[x]--;
					break;
				}
			}
		}
		for(int y = 0; y < player.length-1; y++) {
			if(player[y] != 0) {
				System.out.println(player[y] + ": " + score[y]);
			}
		}
	}

}
