import java.util.Random;
import javax.swing.JOptionPane;

public class Quota {

    public static int peopleLeftForFood;
    public static int peopleLeftForWood;
	public static int foodRequiredPerPerson;
	public static int woodRequiredPerPerson;
	public static Boolean showPopUp = false;
	public static Boolean showPopUp2 = false;

    public static void checkAndUpdateFoodResources() {
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
            int totalPeopleWithoutFood = (int) Math.ceil((PlayerObject.foodRequiredPerPerson - PlayerObject.food) / 3.0);

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
        PlayerObject.totalPeople = PlayerObject.totalPeople - peopleLeftForFood;
        if (showPopUp == true || showPopUp2 == true)
        {
        	QuotaPopOver.showPopUp(null);
        	showPopUp = false; 
        	showPopUp2 = false; 
        }
        
    }

    public static void checkAndUpdateMiningAndWoodResources() {
    	PlayerObject.woodRequiredPerPerson = 2 * PlayerObject.totalPeople;
        if (PlayerObject.miningAndWood >= PlayerObject.woodRequiredPerPerson) {
            System.out.println("Everyone has enough wood.");
            PlayerObject.reputation = PlayerObject.reputation + PlayerObject.totalPeople;
        } 
        else {
            System.out.println("Not enough wood for everyone!");
            int totalPeopleWithoutWood = (int) Math.ceil((PlayerObject.woodRequiredPerPerson - PlayerObject.miningAndWood) / 2.0);
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
        PlayerObject.totalPeople = PlayerObject.totalPeople - peopleLeftForWood;
        if (showPopUp == true || showPopUp2 == true)
        {
        	QuotaPopOver.showPopUp(null);
        	showPopUp = false; 
        	showPopUp2 = false; 
        }
        
    }

}


