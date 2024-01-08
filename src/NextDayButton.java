import java.util.ArrayList;

public class NextDayButton {
	public static void nextDayButtonActivated() {
		System.out.println(PlayerObject.percentFoodBoost);
		
		
		// Generate values for the player
		PlayerObject.generateFood();
		PlayerObject.generateMilitary();
		PlayerObject.generateMiningAndWood();
		PlayerObject.generateResearch();
		
		// Generate values for the AI
		AiEventResponse.generateFoodAI();
		AiEventResponse.generateMilitaryAI();
		AiEventResponse.generateMiningAndWoodAI();
		AiEventResponse.generateResearchAI();;
		
		// Ai Village conducts Trades
//		rivalVillageAi.aiPeopleTrade();
//		rivalVillageAi.aiPeopleAllocation();
		
		
		
		// Active Random Events passage of Time For the player
		ArrayList<ActiveEvent> objectRemove = new ArrayList<ActiveEvent>();
		for(int i = 0; i < PlayerObject.activeEvents.size(); i++) {
			ActiveEvent currentObject = PlayerObject.activeEvents.get(i);
			currentObject.daysActive--;
			if(currentObject.daysActive == 0) {
				RandomEventObject.unapplyRandomEventEffect(currentObject.nameOfEvent, true);
				objectRemove.add(PlayerObject.activeEvents.get(i));
			}
		}
		
		// Remove all ended events for the active events for the Player
		String[] eventNamesToBeRemoves = new String[objectRemove.size()];
		for(int i = 0; i < objectRemove.size(); i++) {
			eventNamesToBeRemoves[i] = objectRemove.get(i).nameOfEvent;
			int indexToBeRemoved = PlayerObject.activeEvents.indexOf(objectRemove.get(i));
			PlayerObject.activeEvents.remove(indexToBeRemoved);
		}
		
		// Create a popup to show the events that have ended
		if(objectRemove.size() != 0) {
			RandomEventPopoverEnded.createRandomEventEndedPopover(eventNamesToBeRemoves);
			MainGameGUI.frame.setEnabled(false);
		}
		
		// Active Random Events passage of Time for the AI
		ArrayList<ActiveEvent> AIObjectRemove = new ArrayList<ActiveEvent>();
		for(int i = 0; i < AiEventResponse.AIactiveEvents.size(); i++) {
			ActiveEvent currentObject = AiEventResponse.AIactiveEvents.get(i);
			currentObject.daysActive--;
			if(currentObject.daysActive == 0) {
				RandomEventObject.unapplyRandomEventEffect(currentObject.nameOfEvent, false);
				objectRemove.add(AiEventResponse.AIactiveEvents.get(i));
			}
		}
		
		
		// Remove all ended events for the active events for the AI
		for(int i = 0; i < objectRemove.size(); i++) {
			int indexToBeRemoved = AiEventResponse.AIactiveEvents.indexOf(AIObjectRemove.get(i));
			AiEventResponse.AIactiveEvents.remove(indexToBeRemoved);
		}
		
		
		// New Random Event Occurring
		if (Main.randomPercentOccurance(30)) {
			MainGameGUI.frame.setEnabled(false);
			EventObject generatedRandomEvent = RandomEventObject.getRandomEvent(true);
			RandomEventPopover.createNewRandomEventPopover(generatedRandomEvent.nameOfEvent, generatedRandomEvent.description);
			AiEventResponse.generateAiEventResponse();
		}
		
		// Check if Quotas have been met
//		Quota.checkAndUpdateFoodResources();
//		Quota.checkAndUpdateMiningAndWoodResources();
//		Quota.updatePeople();
//		Quota.showingPopUp();

		
		System.out.println("PLAYER STATS " + PlayerObject.food + " " + PlayerObject.military + " " + PlayerObject.miningAndWood + " " + PlayerObject.research);
		System.out.println("AI STATS " + AiEventResponse.Aifood + " " + AiEventResponse.Aimilitary + " " + PlayerObject.miningAndWood + " " + PlayerObject.research);
		
		
	}
}