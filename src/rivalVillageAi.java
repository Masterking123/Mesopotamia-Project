import java.util.Random;

public class rivalVillageAi {

    public static void aiPeopleTrade() {
        Random random = new Random();// importing the random number generator 
        int randomNumber = random.nextInt(2) + 1; // Generate a random number between 1 and 2

        if (randomNumber == 1) {
            while (PlayerObject.food >= 0 || PlayerObject.miningAndWood >= 0) {
                // If the condition is met, deduct 2 food and add 1 to the number of people
            	if (PlayerObject.food >= 2)
            	{
            		PlayerObject.totalPeople += 1;
                    PlayerObject.food -= 2;
                    System.out.println("Food surplus converted into a person.");
            	}
            	
            	else if (PlayerObject.miningAndWood >= 5)// if the user has more than 5 food, it trades 5 resources for 1 person
            	{
            		PlayerObject.totalPeople += 1;
                    PlayerObject.miningAndWood -= 5;
                    System.out.println("Resources surplus converted into a person.");
            	}
                
            }
        }
    }

}
