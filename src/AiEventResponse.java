
public class AiEventResponse {
	
	public static int AipeopleInFood;
	public static double Aifood;
	public static int AipercentFoodBoost;
	public static int AinumberFoodBoost;
	
	public static int AipeopleInMiningAndWood;
	public static double AiminingAndWood;
	public static int AipercentMiningAndWoodBoost; 
	public static int AinumberMiningAndWoodBoost;
	public static int AioneTimeMiningAndWoodBoost;
	
	public static int AipeopleInMilitary;
	public static double Aimilitary;
	public static int AipercentMilitaryBoost; 
	public static int AinumberMilitaryBoost;
	
	public static int AipeopleInResearch;
	public static double Airesearch;
	public static int AipercentResearchBoost;
	public static int AinumberResearchBoost;
	
	public static int AipercentDiscountOnSales;
	
	public static int AitotalPeople;
	public static int Aireputation;
	
	public static int AImilitaryNum = 0; 
	public static int AIfarmerNum = 0; 
	public static int AIminerNum = 0; 
	public static int AIresearchNum = 0; 
	
	private static int movePeopleNum = 0;
	
	public static void AIAllocatePeople(double peopleAmount, int addMore, int takeAway ) {
		movePeopleNum = (int) Math.round(AitotalPeople * peopleAmount);
		if(takeAway - movePeopleNum < 0 ) {
			addMore =+ takeAway;
			takeAway =- takeAway;
		}
		else {
			takeAway =- movePeopleNum;
			addMore =+ movePeopleNum;
		}
	}
	

	public static void generateAiEventResponse() {
		EventObject generatedRandomEvent = RandomEventObject.getRandomEvent();
		// This event impacts the boosts and drawbacks
		//add a event for new people
		if(generatedRandomEvent.nameOfEvent.equals("Heat Wave")) {
			AIAllocatePeople( 0.2, AIminerNum, AIresearchNum );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Tornado")) {
			AIAllocatePeople( 0.3, AIfarmerNum, AIminerNum );
			AIAllocatePeople( 0.1, AIfarmerNum, AIresearchNum );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Drought")) {
			AIAllocatePeople( 0.2, AIfarmerNum, AImilitaryNum );
			AIAllocatePeople( 0.1, AIfarmerNum, AIresearchNum );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Wildfire")) {
			AIAllocatePeople( 0.3, AIminerNum, AImilitaryNum );
			AIAllocatePeople( 0.1, AIfarmerNum, AIresearchNum );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Earthquake")) {
			AIAllocatePeople( 0.2, AImilitaryNum, AIfarmerNum  );
			AIAllocatePeople( 0.2, AImilitaryNum, AIresearchNum );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Neighbouring Village")) {
			//fill out when other values done
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Struck Gold Mine")) {
			AIAllocatePeople( 0.2, AIminerNum, AImilitaryNum );
			AIAllocatePeople( 0.3, AIminerNum, AIfarmerNum );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Bountiful Harvest")) {
			AIAllocatePeople( 0.2, AIfarmerNum, AIresearchNum );
			AIAllocatePeople( 0.3, AIfarmerNum, AIminerNum );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Scientific breakthrough")) {
			AIAllocatePeople( 0.3, AIresearchNum, AIfarmerNum );
			AIAllocatePeople( 0.2, AIresearchNum, AIminerNum );
		}
		else if (generatedRandomEvent.nameOfEvent.equals("Inspiration")) {	
		//nothing happens
		
		}
	
	
	}
}
