import java.util.Random;

public class RivalVillageAI {

    public static void aiPeopleTrade() {
        Random random = new Random();// importing the random number generator 
        int randomNumber = random.nextInt(2) + 1; // Generate a random number between 1 and 2

        if (randomNumber == 1) {
            if (AiEventResponse.Aifood >= 0 || AiEventResponse.AiminingAndWood >= 0) {
                // If the condition is met, deduct 2 food and add 1 to the number of people
            	if (AiEventResponse.Aifood >= 2)
            	{
            		AiEventResponse.AitotalPeople += 1;
            		AiEventResponse.Aifood -= 2;
                    System.out.println("Food surplus converted into a person.");
            	}
            	
            	else if (AiEventResponse.AiminingAndWood >= 5)// if the user has more than 5 food, it trades 5 resources for 1 person
            	{
            		AiEventResponse.AitotalPeople += 1;
            		AiEventResponse.AiminingAndWood -= 5;
                    System.out.println("Resources surplus converted into a person.");
            	}
                
            }
        }
    }
    
    public static void aiPeopleAllocation() {
        Random random = new Random();// importing the random number generator 
        int randomNumber = random.nextInt(2) + 1; // Generate a random number between 1 and 2
        if (randomNumber == 1) {
        	AiEventResponse.AipeopleInFood += 1;
        	AiEventResponse.AipeopleInMiningAndWood += 1;
        }
    }


}
