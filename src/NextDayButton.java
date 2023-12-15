
public class NextDayButton {
	public static void nextDayButtonActivated() {
		
		// Update values of the people in each area
		PlayerObject.peopleInFood = MainGameGUI.farmer;
		PlayerObject.peopleInMilitary = MainGameGUI.military;
		PlayerObject.peopleInMiningAndWood = MainGameGUI.miner;
		PlayerObject.peopleInResearch = MainGameGUI.research;
		
		// Generate values for the player
		PlayerObject.generateFood();
		PlayerObject.generateMilitary();
		PlayerObject.generateMiningAndWood();
		PlayerObject.generateResearch();
		
		
		
		
		// Random Event Occurring
		if (Main.randomPercentOccurance(30)) {
			MainGameGUI.frame.setEnabled(false);
			EventObject generatedRandomEvent = RandomEventObject.getRandomEvent();
			RandomEventPopover.createNewRandomEventPopover(generatedRandomEvent.nameOfEvent, generatedRandomEvent.description);
			AiEventResponse.generateAiEventResponse();
		}
		
		// Check if Quotas have been met
		Quota.checkAndUpdateFoodResources();
		Quota.checkAndUpdateMiningAndWoodResources();
		
		System.out.println(PlayerObject.food + " " + PlayerObject.military + " " + PlayerObject.miningAndWood + " " + PlayerObject.research);
		
		// AI values calculated and applied
		
	}
}