import java.util.Scanner;

public class UPSCheck {

//	ex. 042100005264
//	The 12th digit (4 in this case) is a redundant check digit, used to catch errors. Using some simple calculations, a scanner can determine, given the first 
//	11 digits, what the check digit must be for a valid code. (Check digits have previously appeared in this subreddit: see Intermediate 30 and Easy 197.) 
//	UPC's check digit is calculated as follows (taken from Wikipedia):
//	1. Sum the digits at odd-numbered positions (1st, 3rd, 5th, ..., 11th). If you use 0-based indexing, this is the even-numbered positions (0th, 2nd, 4th, ... 10th).
//	2. Multiply the result from step 1 by 3.
//	3. Take the sum of digits at even-numbered positions (2nd, 4th, 6th, ..., 10th) in the original number, and add this sum to the result from step 2.
//	4. Find the result from step 3 modulo 10 (i.e. the remainder, when divided by 10) and call it M.
//	5. If M is 0, then the check digit is 0; otherwise the check digit is 10 - M.
	
	public static void main(String[] args) {
		
		String code;

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter 12 digit UPS Code: ");
		code = kb.nextLine();
		
		CheckDigit(code);
		
		kb.close();
	}
	
	public static void CheckDigit(String code) {
		int oddSum = 0;
		int sumProduct = 0;
		int evenSum = 0;
		int M;
		int digitCode[] = new int[12];

		if(code.length() > 12) {
			System.out.println("Invalid code");
			System.out.println(code.length());
		} else {
			for(int i = 0; i < code.length(); i++) {
				char temp = code.charAt(i);
				digitCode[i] = Character.getNumericValue(temp);
			}
			
			for(int j = 0; j < digitCode.length;j+=2) {
				oddSum += digitCode[j];
			}
			for(int j = 1; j < digitCode.length;j+=2) {
				evenSum += digitCode[j];
			}
			
			sumProduct = oddSum * 3;
			
			M = evenSum%10;
			if(M != 0) {
				M = 10 - M;
			}
			
			System.out.println(oddSum);
			System.out.println(sumProduct);;
			System.out.println(evenSum);
			System.out.println(M);
		}
		
	}

}
