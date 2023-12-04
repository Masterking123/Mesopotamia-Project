
public class PlayerObject {
	
	// Percentage is stored as a whole number, convert to decimal when calculating
	public static String playerName;
	public static String playerVillageName;
	public static String rivalVillageName;
	
	public static int peopleInFood;
	public static double food;
	public static int percentFoodBoost;
	public static int numberFoodBoost;
	
	public static int peopleInMiningAndWood;
	public static double miningAndWood;
	public static int percentMiningAndWoodBoost; 
	public static int numberMiningAndWoodBoost;
	public static int oneTimeMiningAndWoodBoost;
	
	public static int peopleInMilitary;
	public static double military;
	public static int percentMilitaryBoost; 
	public static int numberMilitaryBoost;
	
	public static int peopleInResearch;
	public static double research;
	public static int percentResearchBoost;
	public static int numberResearchBoost;
	
	public static int percentDiscountOnSales;
	
	public static int totalPeople;
	public static int reputation;
	
	public static void generateFood() {
		food += ((peopleInFood * 10) * (1 + (double) (percentFoodBoost / 100.0))) + numberFoodBoost;
	}
	
	public static void generateMiningAndFood() {
		miningAndWood += ((peopleInMiningAndWood * 10) * (1 + (double) (percentMiningAndWoodBoost / 100.0))) + numberMiningAndWoodBoost + oneTimeMiningAndWoodBoost;
		oneTimeMiningAndWoodBoost = 0;
		
	}
	
	public static void generateMilitary() {
		military = peopleInMilitary * (1 + (double) (percentFoodBoost / 100.0)) + numberMilitaryBoost; 
	}
	
	
	public static void generateResearch() {
		research += peopleInResearch * (1 + (double) (percentResearchBoost / 100.0)) + numberResearchBoost;
		
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

	

	
	
	
}
