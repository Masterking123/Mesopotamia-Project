
public class PlayerObject {
	
	// Percentage is stored as a whole number, convert to decimal when calculating
	
	public static String activeEvents[];
	public static String daysForActiveEvents[];
	
	public static String playerName;
	public static String playerVillageName;
	public static String rivalVillageName;
	
	public static int peopleInFood;
	public static double food = 0;
	public static int percentFoodBoost;
	public static int numberFoodBoost;
	
	public static int peopleInMiningAndWood;
	public static double miningAndWood = 0;
	public static int percentMiningAndWoodBoost; 
	public static int numberMiningAndWoodBoost;
	public static int oneTimeMiningAndWoodBoost;
	
	public static int peopleInMilitary;
	public static double military;
	public static int percentMilitaryBoost; 
	public static int numberMilitaryBoost;
	
	public static int peopleInResearch;
	public static double research = 50;
	public static int percentResearchBoost;
	public static int numberResearchBoost;
	
	public static int percentDiscountOnSales;
	
	public static int totalPeople = 10;
	public static int reputation = 50;
	public static int foodRequiredPerPerson;
	public static int woodRequiredPerPerson;
	
	static String[] researchApplied = new String[16];
	
	public static void generateFood() {
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
			military = peopleInMilitary * (1 + (double) (percentFoodBoost / 100.0)) + numberMilitaryBoost; 
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
		double villagePower = military * 2.0 + (food - (totalPeople * 3.0)) + reputation / 2.0 + (miningAndWood * 1.25);
		return villagePower;
	}
	
	
	
}
