import java.util.Random;
import javax.swing.JOptionPane;

public class Quota {

	public static int peopleLeftForFood;
	public static int peopleLeftForWood;
	public static Boolean notEnoughFood = false;
	public static Boolean notEnoughResources = false;
	public static int totalPeopleWithoutFood;
	public static int totalPeopleWithoutWood;
	public static int repLost;

	public static void overallQuota() {
		notEnoughFood = false;
		notEnoughResources = false;
		peopleLeftForFood = 0;
		peopleLeftForWood = 0;
		totalPeopleWithoutFood = 0;
		totalPeopleWithoutWood = 0;
		
		checkAndUpdate();
		System.out.println("People Left " + (peopleLeftForFood + peopleLeftForWood));
		PlayerObject.deallocationOfPeople((peopleLeftForFood + peopleLeftForWood)); 
		System.out.println("TOTAL PEOPLE " + (PlayerObject.totalPeople));
		if (PlayerObject.totalPeople <= 0)
		{
			MainGameGUI.frame.setVisible(false);
			NoPeopleLoseScreen.createNoPeopleLeftScreen(null);
		}
		else if(notEnoughFood == true || notEnoughResources == true) {
			QuotaPopOver.showPopUp(null);		
		}
		
		System.out.println("TESTING DEALLOCATION: " + (peopleLeftForFood + peopleLeftForWood));
		
		
	}

	public static void checkAndUpdate() {
		repLost = 0;
		PlayerObject.foodRequiredForVillage = 3 * PlayerObject.totalPeople;
		PlayerObject.woodRequiredForVillage = 2 * PlayerObject.totalPeople;
		
		if (PlayerObject.food >= PlayerObject.foodRequiredForVillage && PlayerObject.miningAndWood >= PlayerObject.woodRequiredForVillage) {
			PlayerObject.reputation += PlayerObject.reputationEarnedPerDay;
		} 
		else {
			System.out.println("Not enough food for everyone!");
			totalPeopleWithoutFood = PlayerObject.totalPeople - (int) Math.floor((PlayerObject.food / 3.0));

			// Subtract the reputation from all the people who are starving
			PlayerObject.reputation -= totalPeopleWithoutFood;
			repLost -= totalPeopleWithoutFood;
			
			for (int i = 0; i < totalPeopleWithoutFood; i++) {
				if(Main.randomPercentOccurance(25) == true){
					peopleLeftForFood++; // Increment the count of people who left
				}
			}
			notEnoughFood = true;
			
		}


		
		if (!(PlayerObject.miningAndWood >= PlayerObject.woodRequiredForVillage)) {
			totalPeopleWithoutWood = PlayerObject.totalPeople - (int) Math.floor((PlayerObject.miningAndWood / 2.0));
			// Subtract the reputation from all the people without fuel
			PlayerObject.reputation -= totalPeopleWithoutWood;
			repLost -= totalPeopleWithoutWood;
			
			
			for (int i = 0; i < totalPeopleWithoutWood; i++) {
				if(Main.randomPercentOccurance(20)) {					
					peopleLeftForWood++; 
				}
			}
			notEnoughResources = true;
		}
		
		PlayerObject.miningAndWood -= (PlayerObject.totalPeople * 2);
		PlayerObject.food -= (PlayerObject.totalPeople * 3);
		
		if(PlayerObject.food <= 0) {
			PlayerObject.food = 0;
		}
		if(PlayerObject.miningAndWood <= 0) {
			PlayerObject.miningAndWood = 0;
		}
	}

}


