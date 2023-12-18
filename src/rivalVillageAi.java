


import java.util.Random;

public class rivalVillageAi {

    public void handleFoodBonus(int food) {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 1; 

        if (randomNumber == 1) {
            if (food >= 2) {
                System.out.println("Food bonus converted into a person.");
            } 
        }
    }
}
