import java.util.Random;
import javax.swing.JOptionPane;

public class Quota {
    public static String playerName;
    public static String playerVillageName;
    public static String rivalVillageName;

    public static double food;
    public static int percentFoodBoost;
    public static int numberFoodBoost;

    public static double miningAndWood;
    public static int percentMiningAndWoodBoost;
    public static int numberMiningAndWoodBoost;
    public static int oneTimeMiningAndWoodBoost;

    public static int people;
    public static int reputation;


    public static void checkAndUpdateFoodResources() {
        int foodRequiredPerPerson = 3 * people; 
        if (food >= foodRequiredPerPerson) {
   
            System.out.println("Everyone has enough food.");
        } 
        else {

            System.out.println("Not enough food for everyone!");
            int peopleWithoutFood = (int) Math.ceil((foodRequiredPerPerson - food) / 3.0);

            for (int i = 0; i < peopleWithoutFood; i++) {
                double chanceOfDeathOrLeaving = 0.25; 
                Random random = new Random();
                if (random.nextDouble() < chanceOfDeathOrLeaving) {

                    System.out.println("A person died/left due to lack of food.");
                    people--;
                    reputation--;
                }
            }
        }
    }
    
    static void quotaPopUp() {
        JOptionPane.showMessageDialog(null, "");
    }

   
    public static void checkAndUpdateMiningAndWoodResources() {
        int woodRequiredPerPerson = 2 * people; 
        if (miningAndWood >= woodRequiredPerPerson) {
            
            System.out.println("Everyone has enough wood.");
        } else {
           
            System.out.println("Not enough wood for everyone!");
            int peopleWithoutWood = (int) Math.ceil((woodRequiredPerPerson - miningAndWood) / 2.0);

           
            for (int i = 0; i < peopleWithoutWood; i++) {
                double chanceOfDeathOrLeaving = 0.20; 
                Random random = new Random();
                if (random.nextDouble() < chanceOfDeathOrLeaving) {
                    
                    System.out.println("A person died/left due to lack of wood.");
                    people--;
                    reputation--;
                }
            }
        }
    }
}

