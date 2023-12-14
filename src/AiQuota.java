import java.util.Random;

public class AiQuota {
	public static double AifoodNeeded;
	public static int AifoodRequiredPerPerson = 3;
	
	public static double AiMiningAndWoodNeeded;
	public static int AiMiningAndWoodNeededRequiredPerPerson = 2; 
	
	private static int movePeopleNum = 0;

	public static void aiFirstDayAllocation()
	{
		AiEventResponse.AipeopleInFood = 3;
		AiEventResponse.AipeopleInMiningAndWood = 3;
		AiEventResponse.AipeopleInMilitary = 3;
		AiEventResponse.AipeopleInResearch = 1;
		AiEventResponse.AitotalPeople = 0;
		AiEventResponse.AitotalPeople = AiEventResponse.AipeopleInFood + AiEventResponse.AipeopleInMiningAndWood + AiEventResponse.AipeopleInMilitary + AiEventResponse.AipeopleInResearch + AiEventResponse.AitotalPeople;
	}
	
	public static void meetAiQuotaFood() {
	    if (AiEventResponse.Aifood >= AifoodRequiredPerPerson * AiEventResponse.AitotalPeople) {
	        System.out.println("Everyone has enough food (AI).");
	    } else {
	        System.out.println("Not enough food for everyone (AI)!");
	        // Unallocate all people from their current roles
	        AiEventResponse.AipeopleInFood = 0;
	        AiEventResponse.AipeopleInMiningAndWood = 0;
	        AiEventResponse.AipeopleInMilitary = 0;
	        AiEventResponse.AipeopleInResearch = 0;

	        AifoodNeeded = AiEventResponse.AitotalPeople * AifoodRequiredPerPerson;

	        // Allocate people so they have enough food
	        while (AiEventResponse.Aifood < AifoodNeeded) {
	            if (AiEventResponse.AipeopleInFood < AiEventResponse.AitotalPeople) {
	            	AiEventResponse.AipeopleInFood++;
	            	AiEventResponse.Aifood += AifoodRequiredPerPerson;
	            } else {
	                break;
	            }
	        }

	        Random random = new Random();
	        int remainingPeople = AiEventResponse.AitotalPeople - AiEventResponse.AipeopleInFood;
	        while (remainingPeople > 0) {
	            int randomAllocation = random.nextInt(3); // Random allocation between 0 and 2

	            switch (randomAllocation) {
	                case 0:
	                    if (AiEventResponse.AipeopleInMiningAndWood < AiEventResponse.AitotalPeople) {
	                    	AiEventResponse.AipeopleInMiningAndWood++;
	                    }
	                    break;
	                case 1:
	                    if (AiEventResponse.AipeopleInMilitary < AiEventResponse.AitotalPeople) {
	                    	AiEventResponse.AipeopleInMilitary++;
	                    }
	                    break;
	                case 2:
	                    if (AiEventResponse.AipeopleInResearch < AiEventResponse.AitotalPeople) {
	                    	AiEventResponse.AipeopleInResearch++;
	                    }
	                    break;
	            }
	            remainingPeople--;
	        }

	        // Display the allocations
	        System.out.println("Food Allocation: " + AiEventResponse.AipeopleInFood);
	        System.out.println("Mining/Wood Allocation: " + AiEventResponse.AipeopleInMiningAndWood);
	        System.out.println("Military Allocation: " + AiEventResponse.AipeopleInMilitary);
	        System.out.println("Research Allocation: " + AiEventResponse.AipeopleInResearch);
	    }
	}

public static void meetAiQuotaMiningAndWood() {
    if (AiEventResponse.AiminingAndWood >= AiMiningAndWoodNeededRequiredPerPerson * AiEventResponse.AitotalPeople) {
        System.out.println("Everyone has enough wood (AI).");
    } else {
        System.out.println("Not enough wood for everyone (AI)!");
        AiEventResponse.AipeopleInFood = 0;
        AiEventResponse.AipeopleInMiningAndWood = 0;
        AiEventResponse.AipeopleInMilitary = 0;
        AiEventResponse.AipeopleInResearch = 0;

        AiMiningAndWoodNeeded = AiEventResponse.AitotalPeople * AiMiningAndWoodNeededRequiredPerPerson;

        // Allocate people so they have enough food
        while (AiEventResponse.AiminingAndWood < AiMiningAndWoodNeeded) {
            if (AiEventResponse.AipeopleInMiningAndWood < AiEventResponse.AitotalPeople) {
            	AiEventResponse.AipeopleInMiningAndWood++;
            	AiEventResponse.AiminingAndWood += AiMiningAndWoodNeededRequiredPerPerson;
            } else {
                break;
            }
        }

        // Allocate the rest of the people randomly
        Random random = new Random();
        int remainingPeople = AiEventResponse.AitotalPeople - AiEventResponse.AipeopleInMiningAndWood;
        while (remainingPeople > 0) {
            int randomAllocation = random.nextInt(3); // Random allocation between 0 and 2

            switch (randomAllocation) {
                case 0:
                    if (AiEventResponse.AipeopleInFood < AiEventResponse.AitotalPeople) {
                    	AiEventResponse.AipeopleInFood++;
                    }
                    break;
                case 1:
                    if (AiEventResponse.AipeopleInMilitary < AiEventResponse.AitotalPeople) {
                    	AiEventResponse.AipeopleInMilitary++;
                    }
                    break;
                case 2:
                    if (AiEventResponse.AipeopleInResearch < AiEventResponse.AitotalPeople) {
                    	AiEventResponse.AipeopleInResearch++;
                    }
                    break;
            }
            remainingPeople--;
        }

        // Display the allocations
        System.out.println("Food Allocation: " + AiEventResponse.AipeopleInFood);
        System.out.println("Mining/Wood Allocation: " + AiEventResponse.AipeopleInMiningAndWood);
        System.out.println("Military Allocation: " + AiEventResponse.AipeopleInMilitary);
        System.out.println("Research Allocation: " + AiEventResponse.AipeopleInResearch);
    }
}
}

