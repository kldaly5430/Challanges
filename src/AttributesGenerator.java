import java.util.Random;

//You're running a tabletop RPG, and your players are creating characters.
//
//Each character has six core attributes: strength, dexterity, constitution, intelligence, wisdom, and charisma.
//
//One way of generating values for these attributes is to roll four, 6-sided dice (d6) and sum the three highest rolls, discarding the lowest roll.
//
//Some players like to assign values to their attributes in the order they're rolled.
//
//To ensure generated characters don't put players at a disadvantage, the following requirements must be satisfied:
//
//The total of all character attributes must be at least 75.
//At least two of the attributes must be at least 15.

public class AttributesGenerator {

	public static void main(String[] args) {
		
		int[] attributes = new int[6];
		boolean passedRoll = false;
		
		while(!passedRoll) {
			for(int i = 0; i < 6; i++) {
				attributes[i] = RollAttribute();
			}
			
			if(ValidateAttributes(attributes)) {
				for(int j = 0; j < 6; j++)
					System.out.println(attributes[j]);
				
				passedRoll = true;
			}
			
			
		}
		
	}
	
	public static int RollAttribute() {
		int stat = 0, lowest;
		int[] rolls = new int[4];
		Random rand  = new Random();
				
		for(int x = 0; x < 4; x++) {
			rolls[x] = rand.nextInt(6)+1;
//			System.out.println(rolls[x]);
		}
		
		lowest = rolls[0];
		for(int y = 1; y < 4; y++) {
			if(rolls[y] < lowest) {
				stat += lowest;
				lowest = rolls[y];
			} else {
				stat += rolls[y];
			}
		}
		
		return stat;
	}
	
	public static boolean ValidateAttributes(int[] attribute) {
		int sum = 0, highCount = 0;
		
		for(int x = 0; x < 6; x++) {
			sum += attribute[x];
			if(attribute[x] >= 15)
				highCount++;
		}
		
		if(sum >= 75 && highCount >= 2) {
			return true;
		} else {
			return false;
		}
	}

}
