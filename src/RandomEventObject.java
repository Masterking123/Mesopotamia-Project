
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

public class RandomEventObject {
	// Initialize the HashMap with 2 types of data the HashMap will store, this will be the key value pair
	public static HashMap<Range, String> percentageToEventName = new HashMap<Range, String>();
	public static HashMap<String, String> eventNameToDescription = new HashMap<String, String>();
	
	public static int randomNumber(int startRange, int endRange) {
	      int random_int = (int)Math.floor(Math.random() * (endRange - startRange + 1) + startRange);
	      return random_int;
	}
	
	
	public static EventObject getRandomEvent(){
		populateHashMaps(); // Populate the HashMap with all the entries
		
		String randomEventName = generateRandomEvent(); // Generate a random event
		// Search for the randomEventName in the HashMap and gets its associated value in the key value pair
		String randomEventDescription = eventNameToDescription.get(randomEventName); 
		
		// Make a new object to return it for other parts of the code to use
		EventObject newRandomEvent = new EventObject(randomEventName, randomEventDescription);
		
		// Return the object
		return newRandomEvent;
		
		
	}
	
	public static String generateRandomEvent() {
		
		// Generate a random number
		Random newRandomObject = new Random();
		int randomInt = newRandomObject.nextInt(100) + 1;
		
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
			if(eventName == "Heat Wave") {
				
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
		
		// Format for percentages loss and gains and number loss and gains
		// [Military, Research, Farm Production, Farm Value, Mining/Wood Production, Mining/Wood Value, Reputation, Population Percent, DaysOfEvents]
//		eventNameToEffect.put("Heat Wave", new int[]{0, 0, -15, 0, -20, 0, 0, 0, 2});
//		eventNameToEffect.put("Torando", new int[] {0, 0, 0, (-1 * randomNumber(10, 50)), 0, 0, 0, -1, 2});
//		eventNameToEffect.put("Drought", new int[] {0, 0, -15, 0, -20, 0, 0, 2});
//		eventNameToEffect.put("Wildfire", new int[] {0, 0, 0, -30, 0, 0, 0, 0});
//		eventNameToEffect.put("Earthquake", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
//		eventNameToEffect.put("Neighbouring Village", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
//		eventNameToEffect.put("Struck Gold Mine", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
//		eventNameToEffect.put("Bountiful Harvest", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
//		eventNameToEffect.put("Scientific breakthrough", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
//		eventNameToEffect.put("Inspiration", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
	}
	
}
