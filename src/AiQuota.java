import java.util.Random;

public class AiQuota {
	public static int AipeopleInFood;
	public static double Aifood;
	public static double AifoodNeeded;
	public static int AipercentFoodBoost;
	public static int AinumberFoodBoost;
	public static int AifoodRequiredPerPerson = 3;
	
	public static int AipeopleInMiningAndWood;
	public static double AiminingAndWood;
	public static double AiMiningAndWoodNeeded;
	public static int AiMiningAndWoodNeededRequiredPerPerson = 2;
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
	public static int AiPeople = 10;
	public static int Aireputation;
	
	public static int AImilitaryNum = 0; 
	public static int AIfarmerNum = 0; 
	public static int AIminerNum = 0; 
	public static int AIresearchNum = 0; 
	
	private static int movePeopleNum = 0;

	public static void aiFirstDayAllocation()
	{
		AipeopleInFood = 3;
		AipeopleInMiningAndWood = 3;
		AipeopleInMilitary = 3;
		AipeopleInResearch = 1;
		AiPeople = 0;
		AitotalPeople = AipeopleInFood + AipeopleInMiningAndWood + AipeopleInMilitary + AipeopleInResearch + AiPeople;
	}
	
	public static void meetAiQuotaFood() {
	    if (Aifood >= AifoodRequiredPerPerson * AitotalPeople) {
	        System.out.println("Everyone has enough food (AI).");
	    } else {
	        System.out.println("Not enough food for everyone (AI)!");
	        // Unallocate all people from their current roles
	        AipeopleInFood = 0;
	        AipeopleInMiningAndWood = 0;
	        AipeopleInMilitary = 0;
	        AipeopleInResearch = 0;

	        AifoodNeeded = AitotalPeople * AifoodRequiredPerPerson;

	        // Allocate people so they have enough food
	        while (Aifood < AifoodNeeded) {
	            if (AipeopleInFood < AitotalPeople) {
	                AipeopleInFood++;
	                Aifood += AifoodRequiredPerPerson;
	            } else {
	                break;
	            }
	        }

	        Random random = new Random();
	        int remainingPeople = AitotalPeople - AipeopleInFood;
	        while (remainingPeople > 0) {
	            int randomAllocation = random.nextInt(3); // Random allocation between 0 and 2

	            switch (randomAllocation) {
	                case 0:
	                    if (AipeopleInMiningAndWood < AitotalPeople) {
	                        AipeopleInMiningAndWood++;
	                    }
	                    break;
	                case 1:
	                    if (AipeopleInMilitary < AitotalPeople) {
	                        AipeopleInMilitary++;
	                    }
	                    break;
	                case 2:
	                    if (AipeopleInResearch < AitotalPeople) {
	                        AipeopleInResearch++;
	                    }
	                    break;
	            }
	            remainingPeople--;
	        }

	        // Display the allocations
	        System.out.println("Food Allocation: " + AipeopleInFood);
	        System.out.println("Mining/Wood Allocation: " + AipeopleInMiningAndWood);
	        System.out.println("Military Allocation: " + AipeopleInMilitary);
	        System.out.println("Research Allocation: " + AipeopleInResearch);
	    }
	}

public static void meetAiQuotaMiningAndWood() {
    if (AiminingAndWood >= AiMiningAndWoodNeededRequiredPerPerson * AitotalPeople) {
        System.out.println("Everyone has enough wood (AI).");
    } else {
        System.out.println("Not enough wood for everyone (AI)!");
        AipeopleInFood = 0;
        AipeopleInMiningAndWood = 0;
        AipeopleInMilitary = 0;
        AipeopleInResearch = 0;

        AiMiningAndWoodNeeded = AitotalPeople * AiMiningAndWoodNeededRequiredPerPerson;

        // Allocate people so they have enough food
        while (AiminingAndWood < AiMiningAndWoodNeeded) {
            if (AipeopleInMiningAndWood < AitotalPeople) {
            	AipeopleInMiningAndWood++;
                AiminingAndWood += AiMiningAndWoodNeededRequiredPerPerson;
            } else {
                break;
            }
        }

        // Allocate the rest of the people randomly
        Random random = new Random();
        int remainingPeople = AitotalPeople - AipeopleInMiningAndWood;
        while (remainingPeople > 0) {
            int randomAllocation = random.nextInt(3); // Random allocation between 0 and 2

            switch (randomAllocation) {
                case 0:
                    if (AipeopleInFood < AitotalPeople) {
                    	AipeopleInFood++;
                    }
                    break;
                case 1:
                    if (AipeopleInMilitary < AitotalPeople) {
                        AipeopleInMilitary++;
                    }
                    break;
                case 2:
                    if (AipeopleInResearch < AitotalPeople) {
                        AipeopleInResearch++;
                    }
                    break;
            }
            remainingPeople--;
        }

        // Display the allocations
        System.out.println("Food Allocation: " + AipeopleInFood);
        System.out.println("Mining/Wood Allocation: " + AipeopleInMiningAndWood);
        System.out.println("Military Allocation: " + AipeopleInMilitary);
        System.out.println("Research Allocation: " + AipeopleInResearch);
    }
}
}

