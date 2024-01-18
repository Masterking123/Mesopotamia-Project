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
	
	public static void lastDayAllocation() { //on Day 30, the AI will equally assign everyone to each area of the game
											 //WHY: To give the AI a balanced score that is still beatable
		int lastDayPeoplePerPlace = AitotalPeople/4;
		AipeopleInMilitary = lastDayPeoplePerPlace;
		AipeopleInFood = lastDayPeoplePerPlace;
		AipeopleInMiningAndWood = lastDayPeoplePerPlace;
		AipeopleInResearch = lastDayPeoplePerPlace;
	}
	
	public static void generateFoodAI() { //generates food for the AI everyday
		Aifood += ((AipeopleInFood * 10) * (1 + (double) (AipercentFoodBoost / 100.0))) + AinumberFoodBoost;
	}
	
	public static void generateMiningAndWoodAI() { //generates resources for the AI everyday
		AiminingAndWood += ((AipeopleInMiningAndWood * 10) * (1 + (double) (AipercentMiningAndWoodBoost / 100.0))) + AinumberMiningAndWoodBoost + AioneTimeMiningAndWoodBoost;
		AioneTimeMiningAndWoodBoost = 0;
		
	}
	
	public static void generateMilitaryAI() { //calculates the power of the village
		Aimilitary = AipeopleInMilitary * (1 + (double) (AipercentFoodBoost / 100.0)) + AinumberMilitaryBoost; 
	}
	
	
	public static void generateResearchAI() { //generates research points for the AI
		Airesearch += AipeopleInResearch * (1 + (double) (AipercentResearchBoost / 100.0)) + AinumberResearchBoost;
		
	}
	
	public static void percentLossOnFood(int percentLoss) { //calculates any loss on food
		Aifood -= Aifood * ((double) (percentLoss / 100.0));
	}
	
	
	public static void percentLossOnMiningAndWood(int percentLoss) { //calculates any loss on MiningAndWood
		AiminingAndWood -= AiminingAndWood * ((double) (percentLoss / 100.0));
	}

	public static void percentLossOnPeople(int percentLoss) { //calculates any loss of people
		AitotalPeople -= (int) Math.floor(AitotalPeople * ((double) (percentLoss / 100.0)));
	}
	
	public static void AIAllocatePeople(double peopleAmount, int addMore, int takeAway ) { //method AI uses to allocate its people
		movePeopleNum = (int) Math.round(takeAway * peopleAmount); //takes a percentage of the people you want to move from a certain area and stores it in a variable
		takeAway =- movePeopleNum; //subtracts the percentage of people from that area you want to take people away from
		addMore =+ movePeopleNum;  //adds the amount you subtracted to the area you want to allocate people to
		
	}
	

	public static void generateAiEventResponse() { //depending on what event occurs in the AI village, it will wave a different response
		EventObject generatedRandomEvent = RandomEventObject.getRandomEvent(false); //generates a different random event for the AI
		// This event impacts the boosts and drawbacks
		//add a event for new people
		if(generatedRandomEvent.nameOfEvent.equals("Heat Wave")) { //if a heat wave occurs
			// Move people from Research to MiningAndWood at a 20% rate
			// Why: Because during a heat wave, we need more mining and wood to help people survive
			AIAllocatePeople( 0.2, AipeopleInMiningAndWood, AipeopleInResearch ); 
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Tornado")) { //if tornado occurs
			// Move people from MiningAndWood to food at a 30% rate
			// Why: Because during a tornado, we need more food to help people survive
			AIAllocatePeople( 0.3, AipeopleInFood, AipeopleInMiningAndWood );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Drought")) { //if drought occurs
			// Move people from Military to Food at a 20% rate
			// Why: Because during a drought, we need more food to help people survive
			AIAllocatePeople( 0.2, AipeopleInFood, AipeopleInMilitary );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Wildfire")) { //if wildfire occurs
			// Move people from Military to MiningAndWood at a 30% rate
			// Move people from Research to Food at a 10% rate
			// Why: Because during a wildfire, we need more of food and resources to help people survive
			AIAllocatePeople( 0.3, AipeopleInMiningAndWood, AipeopleInMilitary );
			AIAllocatePeople( 0.1, AipeopleInFood, AipeopleInResearch );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Earthquake")) { //if earthquake occurs
			// Move people from Food and Research to Military at a 20% rate each
			// Why: Because during a drought, we need more food to help people survive
			AIAllocatePeople( 0.2, AipeopleInMilitary, AipeopleInFood  );
			AIAllocatePeople( 0.2, AipeopleInMilitary, AipeopleInResearch );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Neighbouring Village")) { //if the event Neighbouring Village occurs
			AitotalPeople =+ 5; //increase population by 5
			AipeopleInFood = +5; //allocatae new people to food
			Aireputation =-2; //reduce the reputation by 2 points
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Struck Gold Mine")) { //if gold mine struck
			//Move people from Military to MiningAndWood at a 20% rate
			//Move people from Food to MiningAndWood at a 30% rate
			//Why: The event increases rates for MiningAndWood which will help the AI get more resources
			AIAllocatePeople( 0.2, AipeopleInMiningAndWood, AipeopleInMilitary );
			AIAllocatePeople( 0.3, AipeopleInMiningAndWood, AipeopleInFood );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Bountiful Harvest")) { //if Bountiful Harvest occurs
			//Move people from Research to Food at a 20% rate
			//Move people from MiningAndWood to Food at a 30% rate
			//Why: The event increases rates for Farming which will help the AI get more food
			AIAllocatePeople( 0.2, AipeopleInFood, AipeopleInResearch );
			AIAllocatePeople( 0.3, AipeopleInFood, AipeopleInMiningAndWood );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Scientific breakthrough")) { //if occurs
			//Move people from Food to Research at a 30% rate
			//Move people from MiningAndWood to Research at a 20% rate
			//Why: The event increases rates for research which will help the AI get more research points
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
