
// Import statement for the hash map
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random; 

// Hash maps can use custom classes as types of data to store
class Range {
	// Usage of a Range class to create a object to hold a range 
	public int startRange;    
    public int endRange;
    
    Range(int startRange, int endRange){
		this.startRange = startRange;
		this.endRange = endRange;
	}
}

class EventObject{
	public String description = "";
	public String nameOfEvent = "";
	
	EventObject(String randomNameOfEvent, String randomDescription){
		nameOfEvent = randomNameOfEvent;
		description = randomDescription;
	}
}

class ActiveEvent {
	public String nameOfEvent = "";
	public int daysActive;
	
	ActiveEvent(String randomNameOfEvent, int newDaysActive){
		nameOfEvent = randomNameOfEvent;
		daysActive = newDaysActive;
	}
}

public class RandomEventObject {
	// Initialize the HashMap with 2 types of data the HashMap will store, this will be the key value pair
	public static HashMap<Range, String> percentageToEventName = new HashMap<Range, String>();
	public static HashMap<String, String> eventNameToDescription = new HashMap<String, String>();
	
	public static int randomNumber(int startRange, int endRange) {
	      int random_int = (int)Math.floor(Math.random() * (endRange - startRange + 1) + startRange);
	      return random_int;
	}
	
	
	public static EventObject getRandomEvent(boolean forPlayer){
		populateHashMaps(); // Populate the HashMap with all the entries
		
		String randomEventName = generateRandomEvent(); // Generate a random event
		
		// Search for the randomEventName in the HashMap and gets its associated value in the key value pair
		String randomEventDescription = eventNameToDescription.get(randomEventName); 
		
		// Apply the random event to the player
		
		applyRandomEventEffect(randomEventName, forPlayer);
		
		// Make a new object to return it for other parts of the code to use
		EventObject newRandomEvent = new EventObject(randomEventName, randomEventDescription);
		
		// Return the object
		return newRandomEvent;
		
		
	}
	
	public static String generateRandomEvent() {
		
		// Generate a random number
		Random newRandomObject = new Random();
		int randomInt = newRandomObject.nextInt(100) + 1;
		
		// For Debug Purposes to force a random event
		// randomInt = 49;
		
		// For each entry with the type of Tuple and String in the in the hash map
		 for (Entry<Range, String> nameAndPercentPair : percentageToEventName.entrySet()) {
			 
			 	// Gets the key, which would be a range of the start and end range
			 	Range key = nameAndPercentPair.getKey();
	            
	            // If the start or end range is equal to the random int
	            if(key.startRange == randomInt || key.endRange == randomInt) {
	            	return nameAndPercentPair.getValue(); // get the value associated with that key
	            }
	            
	            // If the random int is in range of the start and end range
	            else if(key.startRange < randomInt && randomInt < key.endRange) {
	            	return nameAndPercentPair.getValue(); // get the value associated with that key
	            }

	        }
		return "";
	}
	
	public static void applyRandomEventEffect(String eventName, Boolean applicationToPlayer) {
		if(applicationToPlayer == true) {
			switch (eventName) {
				case "Heat Wave":
					PlayerObject.percentFoodBoost -= 15;
					PlayerObject.percentMiningAndWoodBoost -= 20;
					PlayerObject.activeEvents.add(new ActiveEvent(eventName, 2));
					break;
				case "Tornado":
					// Picks a number from 10 - 50 since the range in exclusive to the final number and decreases that much food
					PlayerObject.percentLossOnFood(Main.randomNumberInRange(10, (50 + 1)));
					if(Main.randomPercentOccurance(30)) {
						PlayerObject.percentLossOnPeople(1);
					}
					PlayerObject.percentFoodBoost -= 10;
					PlayerObject.activeEvents.add(new ActiveEvent(eventName, 2));				
					break;
				case "Drought":
					PlayerObject.percentFoodBoost -= 20;
					PlayerObject.reputation -= 1;
					PlayerObject.activeEvents.add(new ActiveEvent(eventName, 2));
					break;
				case "Wildfire":
					PlayerObject.percentMiningAndWoodBoost -= 30;
					if(Main.randomPercentOccurance(30)) {
						// End range is exclusive in the function, need to add 1
						PlayerObject.percentLossOnMiningAndWood(Main.randomNumberInRange(5, (11 + 1)));
					}
					PlayerObject.activeEvents.add(new ActiveEvent(eventName, 1));
					break;
				case "Earthquake":
					// This separates the food loss and the mining loss since they end on different amount of days
					PlayerObject.percentFoodBoost -= 20;
					PlayerObject.percentMiningAndWoodBoost -= 30;
					PlayerObject.activeEvents.add(new ActiveEvent(eventName + " Food", 2));
					PlayerObject.activeEvents.add(new ActiveEvent(eventName + " Mining/Wood", 3));
					break;
				case "Neighbouring Village":
					// THIS WILL BE DONE IN THE RandomEventPopover.java
					break;
				case "Struck Gold Mine":
					System.out.println("Struck a GOLD MINE");
					PlayerObject.percentMiningAndWoodBoost += 20;
					PlayerObject.reputation += 2;
					PlayerObject.activeEvents.add(new ActiveEvent(eventName, 3));
					break;
				case "Bountiful Harvest":
					PlayerObject.percentFoodBoost += 20;
					PlayerObject.reputation += 1;
					PlayerObject.activeEvents.add(new ActiveEvent(eventName, 3));
					break;
				case "Scientific breakthrough":
					PlayerObject.percentResearchBoost = 100; // This is to double the percentage research boost, so its 1 to 2
					PlayerObject.activeEvents.add(new ActiveEvent(eventName, 2));
					break;
				case "Inspiration":
					PlayerObject.reputationEarnedPerDay = 2;
					PlayerObject.activeEvents.add(new ActiveEvent(eventName, 2));
					break;
			}
		}
		else {
			switch (eventName) {
			case "Heat Wave":
				AiEventResponse.AipercentFoodBoost -= 15;
				AiEventResponse.AipercentMiningAndWoodBoost -= 20;
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName, 2));
				break;
			case "Tornado":
				// Picks a number from 10 - 50 since the range in exclusive to the final number and decreases that much food
				AiEventResponse.percentLossOnFood(Main.randomNumberInRange(10, (50 + 1)));
				if(Main.randomPercentOccurance(30)) {
					AiEventResponse.percentLossOnPeople(1);
				}
				AiEventResponse.AipercentFoodBoost -= 10;
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName, 2));				
				break;
			case "Drought":
				AiEventResponse.AipercentFoodBoost -= 20;
				AiEventResponse.Aireputation -= 1;
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName, 2));
				break;
			case "Wildfire":
				AiEventResponse.AipercentMiningAndWoodBoost -= 30;
				if(Main.randomPercentOccurance(30)) {
					// End range is exclusive in the function, need to add 1
					AiEventResponse.percentLossOnMiningAndWood(Main.randomNumberInRange(5, (11 + 1)));
				}
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName, 1));
				break;
			case "Earthquake":
				// This separates the food loss and the mining loss since they end on different amount of days
				AiEventResponse.AipercentFoodBoost -= 20;
				AiEventResponse.AipercentMiningAndWoodBoost -= 30;
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName + " Food", 2));
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName + " Mining/Wood", 3));
				break;
			case "Neighbouring Village":
				AiEventResponse.Aireputation -= 2;
				AiEventResponse.AitotalPeople += 5;
				break;
			case "Struck Gold Mine":
				System.out.println("Struck a GOLD MINE");
				AiEventResponse.AipercentMiningAndWoodBoost += 20;
				AiEventResponse.Aireputation += 2;
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName, 3));
				break;
			case "Bountiful Harvest":
				AiEventResponse.AipercentFoodBoost += 20;
				AiEventResponse.Aireputation += 1;
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName, 3));
				break;
			case "Scientific breakthrough":
				AiEventResponse.AipercentResearchBoost = 100; // This is to double the percentage research boost, so its 1 to 2
				AiEventResponse.AIactiveEvents.add(new ActiveEvent(eventName, 2));
				break;
			case "Inspiration":
				// TO DO
				break;
		}
		}
		
	}
	
	public static void unapplyRandomEventEffect(String eventName, Boolean applicationToPlayer) {
		if(applicationToPlayer == true) {
			switch (eventName) {
				case "Heat Wave":
					PlayerObject.percentFoodBoost += 15;
					PlayerObject.percentMiningAndWoodBoost += 20;
					break;
				case "Tornado":
					PlayerObject.percentFoodBoost += 10;				
					break;
				case "Drought":
					PlayerObject.percentFoodBoost += 20;
					break;
				case "Wildfire":
					PlayerObject.percentMiningAndWoodBoost += 30;
					break;
				case "Earthquake Food":
					PlayerObject.percentFoodBoost += 20;
					break;
				case "Earthquake Mining/Wood":
					PlayerObject.percentMiningAndWoodBoost += 30;
					break;
				case "Neighbouring Village":
					break;
				case "Struck Gold Mine":
					PlayerObject.miningAndWood -= 20;
					break;
				case "Bountiful Harvest":
					PlayerObject.percentFoodBoost -= 20;
					break;
				case "Scientific breakthrough":
					PlayerObject.percentResearchBoost = 0;
				case "Inspiration":
					PlayerObject.reputationEarnedPerDay = 1;
					break;

			}
		}
		else{
			switch (eventName) {
				case "Heat Wave":
					AiEventResponse.AipercentFoodBoost += 15;
					AiEventResponse.AipercentMiningAndWoodBoost += 20;
					break;
				case "Tornado":
					AiEventResponse.AipercentFoodBoost += 10;				
					break;
				case "Drought":
					AiEventResponse.AipercentFoodBoost += 20;
					break;
				case "Wildfire":
					AiEventResponse.AipercentMiningAndWoodBoost += 30;
					break;
				case "Earthquake Food":
					AiEventResponse.AipercentFoodBoost += 20;
					break;
				case "Earthquake Mining/Wood":
					AiEventResponse.AipercentMiningAndWoodBoost += 30;
					break;
				case "Neighbouring Village":
					break;
				case "Struck Gold Mine":
					AiEventResponse.AiminingAndWood -= 20;
					break;
				case "Bountiful Harvest":
					AiEventResponse.AipercentFoodBoost -= 20;
					break;
				case "Scientific breakthrough":
					AiEventResponse.AipercentResearchBoost = 0;
				case "Inspiration":
					break; // AI ignores this

			}
		}
	}
	
	
	
	
	public static void populateHashMaps() {
		
		// You can input data into the hash map in key value pairs
		// nameOfHashMap.put(key, value);
		
		percentageToEventName.put(new Range(1, 15), "Heat Wave"); // 15%
		percentageToEventName.put(new Range(16, 20), "Tornado"); // 5%
		percentageToEventName.put(new Range(21, 25), "Drought"); // 5% 
		percentageToEventName.put(new Range(26, 33), "Wildfire"); // 8%
		percentageToEventName.put(new Range(34, 48), "Earthquake"); // 15%
		percentageToEventName.put(new Range(49, 56), "Neighbouring Village"); // 8%
		percentageToEventName.put(new Range(57, 61), "Struck Gold Mine"); // 5% 
		percentageToEventName.put(new Range(62, 74), "Bountiful Harvest"); // 13%
		percentageToEventName.put(new Range(75, 82), "Scientific breakthrough"); // 8%
		percentageToEventName.put(new Range(83, 100), "Inspiration"); // 18%
		
		eventNameToDescription.put("Heat Wave", "A heatwave has occurred in your village, reducing the energy of your workers.");
		eventNameToDescription.put("Tornado", "The Tornado has come across your land and has a variety of effects like killing some of your people and the storage house of food has been broken, resulting in some food being spoiled/ destroyed.");
		eventNameToDescription.put("Drought", "A prolonged drought has hit your village, leaving your land parched and arid.");
		eventNameToDescription.put("Wildfire", "A devastating wildfire is sweeping through your village, threatening lives, property, and resources.");
		eventNameToDescription.put("Earthquake", "An earthquake has shaken your village, causing fear and instability.");
		eventNameToDescription.put("Neighbouring Village", "Refugees from a neighboring village seek shelter and assistance in your village.");
		eventNameToDescription.put("Struck Gold Mine", "Your villagers found a new deposit of resources in the mine. They are eager to continue mining to bring profit to the village.");
		eventNameToDescription.put("Bountiful Harvest", "A passing by travelling merchant decided to give your village some free fertilizer for your crops. This enhanced the growth rate of your crops for the upcoming days");
		eventNameToDescription.put("Scientific breakthrough", "Your research team has made a breakthrough in their experimentation and can efficiently create brand new results");
		eventNameToDescription.put("Inspiration", "You assembled your town to give a speech to the people. The speech was successful at inspiring the town folk.");
		

	}
	
}
