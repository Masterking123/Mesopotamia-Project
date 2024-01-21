import java.util.ArrayList; // import the ArrayList class

public class PlayerObject {
	
	// Percentage is stored as a whole number, convert to decimal when calculating
	public static ArrayList<ActiveEvent> activeEvents = new ArrayList<ActiveEvent>();
	
	public static String playerName;
	public static String playerVillageName;
	public static String rivalVillageName;
	
	public static int peopleInFood;
	public static double food = 0;
	public static int percentFoodBoost = 0;
	public static int numberFoodBoost;
	
	public static int peopleInMiningAndWood;
	public static double miningAndWood = 0;
	public static int percentMiningAndWoodBoost = 0; 
	public static int numberMiningAndWoodBoost;
	public static int oneTimeMiningAndWoodBoost;
	
	public static int peopleInMilitary;
	public static double military;
	public static int percentMilitaryBoost = 0; 
	public static int numberMilitaryBoost;
	public static int combatPower;
	
	public static int peopleInResearch;
	public static double research = 50;
	public static int percentResearchBoost = 0;
	public static int numberResearchBoost;
	
	public static double percentDiscountOnSales;
	
	public static int totalPeople = 10;
	public static int unallocatedPeople = 10;
	
	public static int reputation = 50;
	public static int reputationEarnedPerDay = 1;
	
	public static int foodRequiredForVillage;
	public static int woodRequiredForVillage;
	
	public static String stateOfReputation = "neutral";
	
	static String[] researchApplied = new String[16];
	static Boolean militaryMissionStarted = false;
	
	public static void generateFood() {
		if((1 + (double) (percentFoodBoost / 100.0)) < 0) {
			return;
		}
		if(peopleInFood != 0) {
			food += ((peopleInFood * 10) * (1 + (double) (percentFoodBoost / 100.0))) + numberFoodBoost;
		}
	}
	
	public static void generateMiningAndWood() {
		if(peopleInMiningAndWood != 0) {
			miningAndWood += ((peopleInMiningAndWood * 10) * (1 + (double) (percentMiningAndWoodBoost / 100.0))) + numberMiningAndWoodBoost + oneTimeMiningAndWoodBoost;
			oneTimeMiningAndWoodBoost = 0;
		}
		
	}
	
	public static void generateMilitary() {
		if(peopleInMilitary != 0) {
			military = (peopleInMilitary * 2) * (1 + (double) (percentMilitaryBoost / 100.0)) + numberMilitaryBoost; 
		}
		else {
			military = 0;
		}
	}
	
	
	public static void generateResearch() {
		if(peopleInResearch != 0) {
			research += peopleInResearch * (1 + (double) (percentResearchBoost / 100.0)) + numberResearchBoost;
		}
		
	}
	
	public static void percentLossOnFood(int percentLoss) {
		food -= food * ((double) (percentLoss / 100.0));
	}
	
	public static void percentLossOnMiningAndWood(int percentLoss) {
		miningAndWood -= miningAndWood * ((double) (percentLoss / 100.0));
	}

	public static void percentLossOnPeople(int percentLoss) {
		totalPeople -= (int) Math.floor(totalPeople * ((double) (percentLoss / 100.0)));
	}
	
	public static double calculateVillagePower() {
		// Military value in player object is combat power
		double villagePower = military * 2.0 + (food - (totalPeople * 3.0)) + reputation / 2.0 + (miningAndWood * 1.25);
		return villagePower;
	}
	
	// Reputation Check 
	public static void reputationCheck() {
		if( PlayerObject.reputation > 60) {
			PlayerObject.percentFoodBoost = PlayerObject.percentFoodBoost + 5;
			PlayerObject.percentMiningAndWoodBoost =  PlayerObject.percentMiningAndWoodBoost + 5; 
			stateOfReputation = "higher";
		}
		else if(PlayerObject.reputation < 20) {
			PlayerObject.percentFoodBoost = PlayerObject.percentFoodBoost - 5;
			PlayerObject.percentMiningAndWoodBoost =  PlayerObject.percentMiningAndWoodBoost - 5;
			stateOfReputation = "lower";
		}
		else if (PlayerObject.reputation >= 20 && PlayerObject.reputation <= 60 && stateOfReputation.equals("higher")){
			PlayerObject.percentFoodBoost -= 5;
			PlayerObject.percentMiningAndWoodBoost -= 5;
			stateOfReputation = "neutral";
		}
		else if (PlayerObject.reputation >= 20 && PlayerObject.reputation <= 60 && stateOfReputation.equals("lower")) {
			PlayerObject.percentFoodBoost += 5;
			PlayerObject.percentMiningAndWoodBoost += 5;
			stateOfReputation = "neutral";
		}
	}
	
	
	// When a event such as quota loses people, use this method 
	public static void deallocationOfPeople(int numberOfPeopleToRemove) {
		
		// Stores all the numbers in an array
		int[] numOfPeopleInLocations = {unallocatedPeople, peopleInFood, peopleInMiningAndWood, peopleInMilitary, peopleInResearch};
		
		// Decrease the total amount of people based on the people deallocated
		PlayerObject.totalPeople -= numberOfPeopleToRemove;
		
		// Loops through the number of people to remove one by one 
		while(numberOfPeopleToRemove != 0) {
			// If the entire array is all zeros break out of the loop
			if(checkIfArrayHasAllZeros(numOfPeopleInLocations) == true) {
				break;
			}
			// Generate a random number, check if doesnt have a 0, then subtract one 
			int randomIndex = Main.randomNumberInRange(0, 5);
			if(numOfPeopleInLocations[randomIndex] != 0) {
				numOfPeopleInLocations[randomIndex]--;
				numberOfPeopleToRemove--;
				lowerPeopleVariables(randomIndex);
			}
		}
				
		// Update all the counter labels
		MainGameGUI.unalloPeopleCounter.setText("" + PlayerObject.unallocatedPeople);
		MainGameGUI.researchCount.setText("" + PlayerObject.peopleInResearch);
		MainGameGUI.farmerCount.setText("" + PlayerObject.peopleInFood);
		MainGameGUI.militaryCount.setText("" + PlayerObject.peopleInMilitary);
		MainGameGUI.minerCount.setText("" + PlayerObject.peopleInMiningAndWood);
		
	}
	
	// Checks if a given array has all zeros
	public static boolean checkIfArrayHasAllZeros(int[] array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	// Lowers the variables by 1 since you can't subtract from an array and it affects the original variable
	public static void lowerPeopleVariables(int index) {
		 if(index == 0) {
			 unallocatedPeople--;
		 }
		 else if(index == 1) {
			 peopleInFood--;
		 }
		 else if(index == 2) {
			 peopleInMiningAndWood--;
		 }
		 else if(index == 3) {
			 peopleInMilitary--;
		 }
		 else if(index == 4) {
			 peopleInResearch--;
		 }
	}
	
	
	
}
