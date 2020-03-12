import java.util.ArrayList;
import java.util.Scanner;

//Perform the Havel-Hakimi algorithm on a given sequence of answers. This algorithm will return true if the answers are consistent (i.e. it's possible that everyone is telling the truth) and false if the answers are inconsistent (i.e. someone must be lying):
//
// 1. Remove all 0's from the sequence (i.e. warmup1).
//
// 2. If the sequence is now empty (no elements left), stop and return true.
//
// 3. Sort the sequence in descending order (i.e. warmup2).
//
// 4. Remove the first answer (which is also the largest answer, or tied for the largest) from the sequence and call it N. The sequence is now 1 shorter than it was 
// after the previous step.
//
// 5. If N is greater than the length of this new sequence (i.e. warmup3), stop and return false.
//
// 6. Subtract 1 from each of the first N elements of the new sequence (i.e. warmup4).
//
// 7. Continue from step 1 using the sequence from the previous step.
//
// Eventually you'll either return true in step 2, or false in step 5.

public class HavelHakimi {

	public static void main(String[] args) {
		
		ArrayList<Integer> people = new ArrayList<Integer>();
		int numOfPeople = 0;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter integers of the number of people: ");
		numOfPeople = kb.nextInt();
		System.out.println("Enter the number of people each person saw: ");
		for(int i = 0; i < numOfPeople; i++) {
			people.add(kb.nextInt());
		}
		
		RemoveZero(people);
		
		if(people.size() < 0) {
			System.out.println("false");
		} 
		
		kb.close();
	}
	
	// Removes zeros from list and checks if the list is empty. If the list is not empty it sends it
	// to the SortPeople() method. 
	static void RemoveZero(ArrayList<Integer> people) {
		for(int i = 0; i < people.size(); i++) {
			if(people.get(i) == 0){
				people.remove(i);
			}
		}
		if(people.isEmpty()) {
			System.out.println("true");
		} else {
			SortPeople(people);
		}
	}
	
	// Sort list in descending order, then send list to CheckSize() method
	static void SortPeople(ArrayList<Integer> people) {
		for(int i = 0; i < people.size(); i++) {
			for(int j = 0; j < people.size()-i-1; j++) {
				if(people.get(j) < people.get(j+1)) {
					int temp = people.get(j);
					people.set(j, people.get(j+1));
					people.set(j+1, temp);
				}
			}
		}
		
		CheckSize(people);
	}
	
	// Check size method removes the first integer from the list. Then check if the integer is checked against the 
	// size of the list. IF the list is smaller return "false" else subtract 1 from remaining integers in the list
	// and repeat the program by removing zeros in the RemoveZero() method.
	static void CheckSize(ArrayList<Integer> people) {
		
		int firstPerson = people.get(0);
		people.remove(0);
		if(firstPerson > people.size()) {
			System.out.println("False");
		} else {
			for(int x = 0; x < people.size(); x++) {
				people.set(x, people.get(x)-1);
		}
			RemoveZero(people);
		
		}
	}
}
