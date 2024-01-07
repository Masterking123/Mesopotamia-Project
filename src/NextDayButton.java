
public class NextDayButton {
	public static void nextDayButtonActivated() {
		// Generate values for the player
		PlayerObject.generateFood();
		PlayerObject.generateMilitary();
		PlayerObject.generateMiningAndWood();
		PlayerObject.generateResearch();
		
		rivalVillageAi.aiPeopleTrade();
		rivalVillageAi.aiPeopleAllocation();
		
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
		Quota.updatePeople();
		Quota.showingPopUp();

		
		System.out.println(PlayerObject.food + " " + PlayerObject.military + " " + PlayerObject.miningAndWood + " " + PlayerObject.research);
		
		// AI values calculated and applied
		
	}
}