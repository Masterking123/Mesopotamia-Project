import java.util.Random;
import javax.swing.JOptionPane;

public class Quota {

	public static int peopleLeftForFood;
	public static int peopleLeftForWood;
	public static int foodRequiredPerPerson;
	public static int woodRequiredPerPerson;
	public static Boolean notEnoughFood = false;
	public static Boolean notEnoughResources = false;
	public static int totalPeopleWithoutFood;
	public static int totalPeopleWithoutWood;
	public static int repLost;

	public static void overallQuota() {
		checkAndUpdate();
		if(notEnoughFood == true || notEnoughResources == true) {
			QuotaPopOver.showPopUp(null);		
		}
		System.out.println("TESTING DEALLOCATION: " + (peopleLeftForFood + peopleLeftForWood));
		PlayerObject.deallocationOfPeople(peopleLeftForFood + peopleLeftForWood); 
	}

//	public static void peopleDeallocation()
//	{
//
//	}
	//	public static void showingPopUp()
	//	{
	//		 if (showPopUp == true || showPopUp2 == true)
	//	        {
	//	        	QuotaPopOver.showPopUp(null);
	//	        	showPopUp = false; 
	//	        	showPopUp2 = false; 
	//	        }
	//		 else if (showPopUp == true || showPopUp2 == false)
	//	        {
	//	        	QuotaPopOver.showPopUp(null);
	//	        	showPopUp = false; 
	//	        }
	//		 else if (showPopUp == false || showPopUp2 == true)
	//	        {
	//	        	QuotaPopOver.showPopUp(null);
	//	        	showPopUp2 = false; 
	//	        }
	//	}

	public static void checkAndUpdate() {
		//    	showPopUp = false; 
		//    	showPopUp2 = false; 
		repLost = 0;
		System.out.println("The amount of ppl " + PlayerObject.totalPeople);
		PlayerObject.foodRequiredPerPerson = 3 * PlayerObject.totalPeople;
		System.out.println("foodRequiredPerPerson " + PlayerObject.foodRequiredPerPerson);
		System.out.println("food " + PlayerObject.food);
		PlayerObject.woodRequiredPerPerson = 2 * PlayerObject.totalPeople;
		if (PlayerObject.food >= PlayerObject.foodRequiredPerPerson) {
			System.out.println("Everyone has enough food.");
			PlayerObject.reputation = PlayerObject.reputation + PlayerObject.reputationEarnedPerPerson * PlayerObject.totalPeople;
		} 
		else {
			System.out.println("Not enough food for everyone!");
			//showPopUp = true;           
			totalPeopleWithoutFood = (int) Math.ceil((PlayerObject.foodRequiredPerPerson - (PlayerObject.food) * 3.0));

			for (int i = 0; i < totalPeopleWithoutFood; i++) {
				double chanceOfDeathOrLeaving = 0.25;
				Random random = new Random();
				if (random.nextDouble() < chanceOfDeathOrLeaving) {
					System.out.println("A person died/left due to lack of food.");
					peopleLeftForFood++; // Increment the count of people who left
					PlayerObject.reputation--;
					repLost --;
				}
			}
			notEnoughFood = true;
			
		}
		

		
		if (PlayerObject.miningAndWood >= PlayerObject.woodRequiredPerPerson) {
			System.out.println("Everyone has enough wood.");
			PlayerObject.reputation = PlayerObject.reputation + PlayerObject.reputationEarnedPerPerson * PlayerObject.totalPeople;
		} 
		else {
			System.out.println("Not enough wood for everyone!");
			totalPeopleWithoutWood = (int) Math.ceil((PlayerObject.woodRequiredPerPerson - PlayerObject.miningAndWood) / 2.0);
			//showPopUp2 = true;
			for (int i = 0; i < totalPeopleWithoutWood; i++) {
				double chanceOfDeathOrLeaving = 0.20;
				Random random = new Random();
				if (random.nextDouble() < chanceOfDeathOrLeaving) {
					System.out.println("A person died/left due to lack of wood.");
					peopleLeftForWood++; 
					PlayerObject.reputation--;
					repLost--;
				}
			}
			notEnoughResources = true;
		}
		PlayerObject.miningAndWood = PlayerObject.miningAndWood - (PlayerObject.totalPeople * 2);
		PlayerObject.food = PlayerObject.food - (PlayerObject.totalPeople * 2);
	}

}


