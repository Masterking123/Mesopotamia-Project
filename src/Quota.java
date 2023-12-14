import java.util.Random;
import javax.swing.JOptionPane;

public class Quota {

    public static double food;
    public static int percentFoodBoost;
    public static int numberFoodBoost;

    public static double miningAndWood;
    public static int percentMiningAndWoodBoost;
    public static int numberMiningAndWoodBoost;
    public static int oneTimeMiningAndWoodBoost;

    public static int reputation;

    public static int foodRequiredPerPerson;
    public static int woodRequiredPerPerson;
    public static int totalPeople; 
    public static int peopleLeftForFood;
    public static int peopleLeftForWood;

    public static void checkAndUpdateFoodResources() {
        PlayerObject.foodRequiredPerPerson = 3 * PlayerObject.totalPeople;
        if (PlayerObject.food >= PlayerObject.foodRequiredPerPerson) {
            System.out.println("Everyone has enough food.");
        } 
        else {
            System.out.println("Not enough food for everyone!");
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
    }

    public static void checkAndUpdateMiningAndWoodResources() {
    	PlayerObject.woodRequiredPerPerson = 2 * PlayerObject.totalPeople;
        if (PlayerObject.miningAndWood >= PlayerObject.woodRequiredPerPerson) {
            System.out.println("Everyone has enough wood.");
        } 
        else {
            System.out.println("Not enough wood for everyone!");
            int totalPeopleWithoutWood = (int) Math.ceil((woodRequiredPerPerson - miningAndWood) / 2.0);

            for (int i = 0; i < totalPeopleWithoutWood; i++) {
                double chanceOfDeathOrLeaving = 0.20;
                Random random = new Random();
                if (random.nextDouble() < chanceOfDeathOrLeaving) {
                    System.out.println("A person died/left due to lack of wood.");
                    peopleLeftForWood++; // Increment the count of people who left
                    reputation--;
                }
            }
        }
        totalPeople = totalPeople - peopleLeftForFood;
    }
}


