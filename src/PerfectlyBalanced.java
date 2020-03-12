import java.util.Scanner;

//Given a string containing only the characters x and y, find whether there are the same number of xs and ys.
//balanced("xxxyyy") => true
//balanced("yyyxxx") => true
//balanced("xxxyyyy") => false
//balanced("yyxyxxyxxyyyyxxxyxyx") => true
//balanced("xyxxxxyyyxyxxyxxyy") => false
//balanced("") => true
//balanced("x") => false

public class PerfectlyBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value;
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the letter x and y: ");
		value = kb.next();
		
		CheckBalance(value);
		
		kb.close();
	}
	
	public static void CheckBalance(String balance) {
		int countOne = 0, countTwo = 0;
		
		for(int i = 0; i < balance.length(); i++) {
			char letter = balance.charAt(i);
			if(letter == 'x') {
				countOne++;
			} else {
				countTwo++;
			}
		}
		if(countOne == countTwo) {
			System.out.println(balance + " => true");
		} else {
			System.out.println(balance + " => false");
		}
	}

}
