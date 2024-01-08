import java.util.Random;
import javax.swing.JOptionPane;

public class Quota {

    public static int peopleLeftForFood;
    public static int peopleLeftForWood;
	public static int foodRequiredPerPerson;
	public static int woodRequiredPerPerson;
    public static Boolean showPopUp = false;
	public static Boolean showPopUp2 = false;
	public static int totalPeopleWithoutFood;
	public static int totalPeopleWithoutWood;

	public static void updatePeople() {
	    PlayerObject.totalPeople -= (peopleLeftForFood + peopleLeftForWood);
	    // Reset counters after updating totalPeople

	}
	
	public static void showingPopUp()
	{
		 if (showPopUp == true || showPopUp2 == true)
	        {
	        	QuotaPopOver.showPopUp(null);
	        	showPopUp = false; 
	        	showPopUp2 = false; 
	        }
		 else if (showPopUp == true || showPopUp2 == false)
	        {
	        	QuotaPopOver.showPopUp(null);
	        	showPopUp = false; 
	        	showPopUp2 = false; 
	        }
		 else if (showPopUp == false || showPopUp2 == true)
	        {
	        	QuotaPopOver.showPopUp(null);
	        	showPopUp = false; 
	        	showPopUp2 = false; 
	        }
		 
		 else if (showPopUp == false || showPopUp2 == false)
	        {
	        	showPopUp = false; 
	        	showPopUp2 = false; 
	        }
	}

    public static void checkAndUpdateFoodResources() {
    	showPopUp = false; 
    	showPopUp2 = false; 
        PlayerObject.foodRequiredPerPerson = 3 * PlayerObject.totalPeople;
        System.out.println("foodRequiredPerPerson " + PlayerObject.foodRequiredPerPerson);
        System.out.println("food " + PlayerObject.food);
        if (PlayerObject.food >= PlayerObject.foodRequiredPerPerson) {
            System.out.println("Everyone has enough food.");
            PlayerObject.reputation = PlayerObject.reputation + PlayerObject.totalPeople;
           
        } 
        else {
            System.out.println("Not enough food for everyone!");
            showPopUp = true;           
            totalPeopleWithoutFood = (int) Math.ceil((PlayerObject.foodRequiredPerPerson - (PlayerObject.food) * 3.0));

            for (int i = 0; i < totalPeopleWithoutFood; i++) {
                double chanceOfDeathOrLeaving = 0.25;
                Random random = new Random();
                if (random.nextDouble() < chanceOfDeathOrLeaving) {
                    System.out.println("A person died/left due to lack of food.");
                    peopleLeftForFood++; // Increment the count of people who left
                    PlayerObject.reputation--;
                }
            }
        }
       
        
    }

    public static void checkAndUpdateMiningAndWoodResources() {
    	PlayerObject.woodRequiredPerPerson = 2 * PlayerObject.totalPeople;
    	showPopUp = false; 
    	showPopUp2 = false; 
        if (PlayerObject.miningAndWood >= PlayerObject.woodRequiredPerPerson) {
            System.out.println("Everyone has enough wood.");
            PlayerObject.reputation = PlayerObject.reputation + PlayerObject.totalPeople;
        } 
        else {
            System.out.println("Not enough wood for everyone!");
            totalPeopleWithoutWood = (int) Math.ceil((PlayerObject.woodRequiredPerPerson - PlayerObject.miningAndWood) / 2.0);
            showPopUp2 = true;
            for (int i = 0; i < totalPeopleWithoutWood; i++) {
                double chanceOfDeathOrLeaving = 0.20;
                Random random = new Random();
                if (random.nextDouble() < chanceOfDeathOrLeaving) {
                    System.out.println("A person died/left due to lack of wood.");
                    peopleLeftForWood++; 
                    PlayerObject.reputation--;
                }
            }
        }
        
    }

}


