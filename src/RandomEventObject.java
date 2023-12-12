// DO WE NEED GETTERS AND SETTERS
// DO WE NEED HEADER COMMENTS
// DO WE NEED TO COMMENT ALL OUR CODE
// HOW SHOULD WE FORMAT THE OUTPUT FOR THE PERCENTAGES


import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random; 

class Tuple {
	public int startRange;    
    public int endRange;
    
	Tuple(int startRange, int endRange){
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
	public static HashMap<Tuple, String> percentageToEventName = new HashMap<Tuple, String>();
	public static HashMap<String, String> eventNameToDescription = new HashMap<String, String>();
	public static HashMap<String, int[]> eventNameToEffect = new HashMap<String, int[]>();
	
	public static int randomNumber(int startRange, int endRange) {
	      int random_int = (int)Math.floor(Math.random() * (endRange - startRange + 1) + startRange);
	      return random_int;
	}
	
	
	public static EventObject getRandomEvent(){
		populateHashMaps();
		
		String randomEventName = generateRandomEvent();
		String randomEventDescription = eventNameToDescription.get(randomEventName);
		EventObject newRandomEvent = new EventObject(randomEventName, randomEventDescription);
		
		return newRandomEvent;
		
		
	}
	
	public static String generateRandomEvent() {
		Random newRandomObject = new Random();
		int randomInt = newRandomObject.nextInt(100) + 1;
		
		 for (Entry<Tuple, String> eventNameToPercent : percentageToEventName.entrySet()) {
	            Tuple key = eventNameToPercent.getKey();
	            
	            if(key.startRange == randomInt || key.endRange == randomInt) {
	            	return eventNameToPercent.getValue();
	            }
	            
	            else if(key.startRange < randomInt && randomInt < key.endRange) {
	            	return eventNameToPercent.getValue();
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
		
		// These values have been converted to a range for dice rolls
		percentageToEventName.put(new Tuple(1, 15), "Heat Wave"); // 15%
		percentageToEventName.put(new Tuple(16, 20), "Tornado"); // 5%
		percentageToEventName.put(new Tuple(21, 25), "Drought"); // 5% 
		percentageToEventName.put(new Tuple(26, 33), "Wildfire"); // 8%
		percentageToEventName.put(new Tuple(34, 48), "Earthquake"); // 15%
		percentageToEventName.put(new Tuple(49, 56), "Neighbouring Village"); // 8%
		percentageToEventName.put(new Tuple(57, 61), "Struck Gold Mine"); // 5% 
		percentageToEventName.put(new Tuple(62, 74), "Bountiful Harvest"); // 13%
		percentageToEventName.put(new Tuple(75, 82), "Scientific breakthrough"); // 8%
		percentageToEventName.put(new Tuple(83, 100), "Inspiration"); // 18%
		
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
		eventNameToEffect.put("Heat Wave", new int[]{0, 0, -15, 0, -20, 0, 0, 0, 2});
		eventNameToEffect.put("Torando", new int[] {0, 0, 0, (-1 * randomNumber(10, 50)), 0, 0, 0, -1, 2});
		eventNameToEffect.put("Drought", new int[] {0, 0, -15, 0, -20, 0, 0, 2});
		eventNameToEffect.put("Wildfire", new int[] {0, 0, 0, -30, 0, 0, 0, 0});
		eventNameToEffect.put("Earthquake", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
		eventNameToEffect.put("Neighbouring Village", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
		eventNameToEffect.put("Struck Gold Mine", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
		eventNameToEffect.put("Bountiful Harvest", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
		eventNameToEffect.put("Scientific breakthrough", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
		eventNameToEffect.put("Inspiration", new int[] {0, 0, 0, 0, 0, 0, 0, 0});
	}
	
}
