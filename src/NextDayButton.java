
public class NextDayButton {
	public static void nextDayButtonActivated() {
		if(Main.randomPercentOccurance(30)) {
			MainGameGUI.frame.setEnabled(false);
			EventObject generatedRandomEvent = RandomEventObject.getRandomEvent();
			Quota.checkAndUpdateFoodResources();
			Quota.checkAndUpdateMiningAndWoodResources();
			RandomEventPopover.createNewRandomEventPopover(generatedRandomEvent.nameOfEvent, generatedRandomEvent.description);
		}
	}
}