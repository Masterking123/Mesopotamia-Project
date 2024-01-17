import java.util.ArrayList;

public class AiEventResponse {
	
	public static ArrayList<ActiveEvent> AIactiveEvents = new ArrayList<ActiveEvent>(); 
	
	public static int AipeopleInFood;
	public static double Aifood = 0;
	public static int AipercentFoodBoost;
	public static int AinumberFoodBoost;
	
	public static int AipeopleInMiningAndWood;
	public static double AiminingAndWood = 0;
	public static int AipercentMiningAndWoodBoost; 
	public static int AinumberMiningAndWoodBoost;
	public static int AioneTimeMiningAndWoodBoost;
	
	public static int AipeopleInMilitary;
	public static double Aimilitary;
	public static int AipercentMilitaryBoost; 
	public static int AinumberMilitaryBoost;
	
	public static int AipeopleInResearch;
	public static double Airesearch = 0;
	public static int AipercentResearchBoost;
	public static int AinumberResearchBoost;
	
	public static int AipercentDiscountOnSales;
	
	public static int AitotalPeople = 10;
	public static int Aireputation = 50;
	
	private static int movePeopleNum = 0;
	
	public static void lastDayAllocation() {
		int lastDayPeoplePerPlace = AitotalPeople/4;
		AipeopleInMilitary = lastDayPeoplePerPlace;
		AipeopleInFood = lastDayPeoplePerPlace;
		AipeopleInMiningAndWood = lastDayPeoplePerPlace;
		AipeopleInResearch = lastDayPeoplePerPlace;
	}
	
	public static void generateFoodAI() {
		Aifood += ((AipeopleInFood * 10) * (1 + (double) (AipercentFoodBoost / 100.0))) + AinumberFoodBoost;
	}
	
	public static void generateMiningAndWoodAI() {
		AiminingAndWood += ((AipeopleInMiningAndWood * 10) * (1 + (double) (AipercentMiningAndWoodBoost / 100.0))) + AinumberMiningAndWoodBoost + AioneTimeMiningAndWoodBoost;
		AioneTimeMiningAndWoodBoost = 0;
		
	}
	
	public static void generateMilitaryAI() {
		Aimilitary = AipeopleInMilitary * (1 + (double) (AipercentFoodBoost / 100.0)) + AinumberMilitaryBoost; 
	}
	
	
	public static void generateResearchAI() {
		Airesearch += AipeopleInResearch * (1 + (double) (AipercentResearchBoost / 100.0)) + AinumberResearchBoost;
		
	}
	
	public static void percentLossOnFood(int percentLoss) {
		Aifood -= Aifood * ((double) (percentLoss / 100.0));
	}
	
	
	public static void percentLossOnMiningAndWood(int percentLoss) {
		AiminingAndWood -= AiminingAndWood * ((double) (percentLoss / 100.0));
	}

	public static void percentLossOnPeople(int percentLoss) {
		AitotalPeople -= (int) Math.floor(AitotalPeople * ((double) (percentLoss / 100.0)));
	}
	
	public static void AIAllocatePeople(double peopleAmount, int addMore, int takeAway ) { //method ai uses to allocate its people
		movePeopleNum = (int) Math.round(takeAway * peopleAmount); //takes a percentage of the people you want to move from a certain area and stores it in a variable
		takeAway =- movePeopleNum;
		addMore =+ movePeopleNum;
		
	}
	

	public static void generateAiEventResponse() { //depending on what event occurs in the ai village, it will wave a different response
		EventObject generatedRandomEvent = RandomEventObject.getRandomEvent(false); //generates a different random event for the ai
		// This event impacts the boosts and drawbacks
		//add a event for new people
		if(generatedRandomEvent.nameOfEvent.equals("Heat Wave")) { //if a heat wave occurs
			// Move people from Research to MiningAndWood at a 20% rate
			// Why: Because during a heat wave, we need more mining and wood to help people survive
			AIAllocatePeople( 0.2, AipeopleInMiningAndWood, AipeopleInResearch ); 
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Tornado")) {
			AIAllocatePeople( 0.3, AipeopleInFood, AipeopleInMiningAndWood );
			AIAllocatePeople( 0.1, AipeopleInFood, AipeopleInResearch );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Drought")) {
			AIAllocatePeople( 0.2, AipeopleInFood, AipeopleInMilitary );
			AIAllocatePeople( 0.1, AipeopleInFood, AipeopleInResearch );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Wildfire")) {
			AIAllocatePeople( 0.3, AipeopleInMiningAndWood, AipeopleInMilitary );
			AIAllocatePeople( 0.1, AipeopleInFood, AipeopleInResearch );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Earthquake")) {
			AIAllocatePeople( 0.2, AipeopleInMilitary, AipeopleInFood  );
			AIAllocatePeople( 0.2, AipeopleInMilitary, AipeopleInResearch );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Neighbouring Village")) {
			//fill out when other values done
			AitotalPeople =+ 5;
			AipeopleInFood = +5;
			Aireputation =-2;
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Struck Gold Mine")) {
			AIAllocatePeople( 0.2, AipeopleInMiningAndWood, AipeopleInMilitary );
			AIAllocatePeople( 0.3, AipeopleInMiningAndWood, AipeopleInFood );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Bountiful Harvest")) {
			AIAllocatePeople( 0.2, AipeopleInFood, AipeopleInResearch );
			AIAllocatePeople( 0.3, AipeopleInFood, AipeopleInMiningAndWood );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Scientific breakthrough")) {
			AIAllocatePeople( 0.3, AipeopleInResearch, AipeopleInFood );
			AIAllocatePeople( 0.2, AipeopleInResearch, AipeopleInMiningAndWood );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Inspiration")) {	
		//nothing happens
		
		}
	
	
	}
	
	public static double calculateVillagePowerAi() {
		double villagePower = Aimilitary * 2.0 + (Aifood - (AitotalPeople * 3.0)) + Aireputation / 2.0 + (AiminingAndWood * 1.25);
		return villagePower;
	}
}
