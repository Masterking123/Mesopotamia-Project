
public class PlayerObject {
	
	// Percentage is stored as a whole number, convert to decimal when calculating
	public static String playerName;
	public static String playerVillageName;
	public static String rivalVillageName;
	
	public static double food;
	public static int percentFoodBoost;
	public static int numberFoodBoost;
	
	public static double miningAndWood;
	public static int percentMiningAndWoodBoost; 
	public static int numberMiningAndWoodBoost;
	public static int oneTimeMiningAndWoodBoost;
	
	public static double military;
	public static int percentMilitaryBoost; 
	public static int numberMilitaryBoost;
	
	public static double research;
	public static int percentResearchBoost;
	public static int numberResearchBoost;
	
	public static int percentDiscountOnSales;
	
	public static int people;
	public static int reputation;
	
	public static void generateFood() {
		food += ((people * 10) * (1 + (double) (percentFoodBoost / 100))) + numberFoodBoost;
	}
	
	public static void generateMiningAndFood() {
		miningAndWood += ((people * 10) * (1 + (double) (percentMiningAndWoodBoost / 100))) + numberMiningAndWoodBoost + oneTimeMiningAndWoodBoost;
		oneTimeMiningAndWoodBoost = 0;
		
	}
	
	public static void generateMilitary() {
		military = people * (1 + (double) (percentFoodBoost / 100)) + numberMilitaryBoost; 
	}
	
	
	public static void generateResearch() {
		
		
	}

	
	
	
}
