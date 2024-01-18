import java.util.Random;

public class AiQuota {
	public static double AifoodNeeded;
	public static int AifoodRequiredPerPerson = 3;
	
	public static double AiMiningAndWoodNeeded;
	public static int AiMiningAndWoodNeededRequiredPerPerson = 2; 
	
	private static int movePeopleNum = 0;

	public static void aiFirstDayAllocation()//allocates people around for the Ai to make sure that it meets the quota the first day 
	{
		AiEventResponse.AipeopleInFood = 3;
		AiEventResponse.AipeopleInMiningAndWood = 3;
		AiEventResponse.AipeopleInMilitary = 3;
		AiEventResponse.AipeopleInResearch = 1;
		AiEventResponse.AitotalPeople = 0;
		AiEventResponse.AitotalPeople = AiEventResponse.AipeopleInFood + AiEventResponse.AipeopleInMiningAndWood + AiEventResponse.AipeopleInMilitary + AiEventResponse.AipeopleInResearch + AiEventResponse.AitotalPeople;
	}
	
	public static void AiQuotaFood() {// method which determines if the user meets the quota
	    if (AiEventResponse.Aifood >= AifoodRequiredPerPerson * AiEventResponse.AitotalPeople) {// if the user meets the quota
	        System.out.println("Everyone has enough food (AI).");// nothing happens and I display a print statement for testing that everyone for the AI village meets the quota
	      

	        System.out.println("Food Allocation: " + AiEventResponse.AipeopleInFood);
	        System.out.println("Mining/Wood Allocation: " + AiEventResponse.AipeopleInMiningAndWood);
	        System.out.println("Military Allocation: " + AiEventResponse.AipeopleInMilitary);
	        System.out.println("Research Allocation: " + AiEventResponse.AipeopleInResearch);
	        System.out.println("Total People AI: " + AiEventResponse.AitotalPeople);
	        
	    } else {// if the user does not meet the quota 
	        System.out.println("Not enough food for everyone (AI)!");
	        
	        // Unallocate all people from their current roles
	        AiEventResponse.AipeopleInFood = 0;
	        AiEventResponse.AipeopleInMiningAndWood = 0;
	        AiEventResponse.AipeopleInMilitary = 0;
	        AiEventResponse.AipeopleInResearch = 0;

	        AifoodNeeded = AiEventResponse.AitotalPeople * AifoodRequiredPerPerson;// calculate the amount of food needed to meet the quota

	        // Allocate people so they have enough food
	        while (AiEventResponse.Aifood < AifoodNeeded) {// if the Ai does not have enough food 
	            if (AiEventResponse.AipeopleInFood < AiEventResponse.AitotalPeople) {//If there is not enough people in food then it adds more
	            	AiEventResponse.AipeopleInFood++;
	            	AiEventResponse.Aifood += AifoodRequiredPerPerson;
	            } else {// if not then it break out of the loop of adding more people in food to meet the quota
	                break;
	            }
	        }

	        Random random = new Random();
	        int remainingPeople = AiEventResponse.AitotalPeople - AiEventResponse.AipeopleInFood;
	        while (remainingPeople > 0) {// if there are remaining people
	            int randomAllocation = random.nextInt(3); // Random allocation between 0 and 2

	            switch (randomAllocation) {
	                case 0:// if the random number equals 0
	                    if (AiEventResponse.AipeopleInMiningAndWood < AiEventResponse.AitotalPeople) {// check if there is less people in mining and wood than people total people 
	                    	AiEventResponse.AipeopleInMiningAndWood++;// add more people to mining and wood
	                    }
	                    break;
	                case 1:// if the random number equals 1
	                    if (AiEventResponse.AipeopleInMilitary < AiEventResponse.AitotalPeople) {// if there less people in military than the total amount of people
	                    	AiEventResponse.AipeopleInMilitary++;// I added more people in military
	                    }
	                    break;
	                case 2:// if the random number equals 2
	                    if (AiEventResponse.AipeopleInResearch < AiEventResponse.AitotalPeople) {// if there is people in research than the total amount of people 
	                    	AiEventResponse.AipeopleInResearch++;// add more people to research
	                    }
	                    break;
	            }
	            remainingPeople--;// decrease the amount of people needed to be allocated
	        }

	        // Display the allocations
	        System.out.println("Food Allocation: " + AiEventResponse.AipeopleInFood);
	        System.out.println("Mining/Wood Allocation: " + AiEventResponse.AipeopleInMiningAndWood);
	        System.out.println("Military Allocation: " + AiEventResponse.AipeopleInMilitary);
	        System.out.println("Research Allocation: " + AiEventResponse.AipeopleInResearch);
	        System.out.println("Total People AI: " + AiEventResponse.AitotalPeople);
	    }
	}

public static void AiQuotaMiningAndWood() {
	
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
        System.out.println("Total People AI: " + AiEventResponse.AitotalPeople);
    }
}
}

