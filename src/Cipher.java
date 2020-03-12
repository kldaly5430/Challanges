import java.io.FileNotFoundException;
import java.util.Scanner;


// "The Alphabet Cipher", published by Lewis Carroll in 1868, describes a Vigenère cipher (thanks /u/Yadkee for the clarification) for passing secret messages. The cipher involves
// alphabet substitution using a shared keyword. Using the alphabet cipher to tranmit messages follows this procedure:
// You must make a substitution chart like this, where each row of the alphabet is rotated by one as each letter goes down the chart.

//All test cases will utilize this same substitution chart.

// Both people exchanging messages must agree on the secret keyword. To be effective, this keyword should not be written down anywhere, but memorized.

// To encode the message, first write it down.

// thepackagehasbeendelivered
// Then, write the keyword, (for example, snitch), repeated as many times as necessary.

// snitchsnitchsnitchsnitchsn
// thepackagehasbeendelivered

// Now you can look up the column S in the table and follow it down until it meets the T row. The value at the intersection is the letter L. All the letters would be thus encoded.
// snitchsnitchsnitchsnitchsn
// thepackagehasbeendelivered
// lumicjcnoxjhkomxpkwyqogywq
	
// ex. Input
// snitch thepackagehasbeendelivered

// ex. Output
// lumicjcnoxjhkomxpkwyqogywq

public class Cipher {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner kb = new Scanner(System.in);
		String message;
		
		System.out.println("Enter seed word, then enter your message with no spaces: ");
		message = kb.nextLine();
		
		System.out.println(Encrypt(message));
		
		kb.close();
	}

	static String Encrypt(String words) {
		
		String[] secret = words.split("\\s",0);
		String newMessage = "";

		int x = 0;
		for(int i = 0; i < secret[1].length(); i++)
			{
				if(x < secret[0].length()) {
					if((secret[1].charAt(i) + (secret[0].charAt(x)- 'a')) > 'z') {
						newMessage += (char)((secret[1].charAt(i) + (secret[0].charAt(x) - 'a')) - 26);
					} else {
						newMessage += (char)(secret[1].charAt(i) + (secret[0].charAt(x) - 'a'));
					}
					System.out.println(i);
					x++;
				} else {
					x = 0;
					i = i-1;
				}
			}
		
		return newMessage;
	}
}
