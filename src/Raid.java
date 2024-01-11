import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Raid {
	public static int raidDayCount = 0; 
	public static boolean raid = false;     
    static Random random = new Random();
    public static double minProbabilityOfRaid = 0;
    public static double maxProbabilityOfRaid = 0;
    public static double minSteal = 10; 
    public static double maxSteal = 15;    
    public static boolean win = true; 
    private static final DecimalFormat df = new DecimalFormat("0.00");

    
    
    public static boolean raidChance () {
		raid = false; 
		if (raidDayCount == 0) {
	        double raidChance = random.nextDouble();
			if(PlayerObject.food > 35 || PlayerObject.miningAndWood > 45) {
				minProbabilityOfRaid = 0.0;
				maxProbabilityOfRaid = 0.50;
				if (raidChance >= minProbabilityOfRaid && raidChance <= maxProbabilityOfRaid) {
					raid = true; 
					raidDayCount = 3; 
				}
			}else if (PlayerObject.food > 25 || PlayerObject.miningAndWood > 25) {
				minProbabilityOfRaid = 0.30;
				maxProbabilityOfRaid = 0.40;
				if (raidChance >= minProbabilityOfRaid && raidChance <= maxProbabilityOfRaid) {
					raid = true;
					raidDayCount = 3; 
				}
			} else {
				minProbabilityOfRaid = 0.10;
				maxProbabilityOfRaid = 0.15;
				if (raidChance >= minProbabilityOfRaid && raidChance <= maxProbabilityOfRaid) {
					raid = true;
					raidDayCount = 3; 
				}
			}
		}
		System.out.println(raidDayCount);
		System.out.println(raid);
		return raid;
	}
    
    public static void stealResources() {
    	 minSteal = Math.max(0, minSteal);
         maxSteal = Math.min(100, maxSteal);
        double percentageToSteal = minSteal + (maxSteal - minSteal) * random.nextDouble();

    	if (PlayerObject.food > PlayerObject.miningAndWood) { //when food is highest resource 
    		System.out.println("Total Resources: " + PlayerObject.food);
    		int amountToSteal = (int) (PlayerObject.food * (percentageToSteal / 100));
            int remainingResources = (int) (PlayerObject.food - amountToSteal);
            PlayerObject.food = remainingResources; 
            
            RaidStolenPopup.typeOfResourceStolen = "food";
            RaidStolenPopup.amountOfResourceStolen = amountToSteal;
            
            //Just here to testing 
            System.out.println("Percentage to Steal: " + percentageToSteal + "%");
            System.out.println("Amount Stolen: " + amountToSteal);
            System.out.println("Remaining Resources: " + remainingResources);
    	}
    	else if (PlayerObject.miningAndWood > PlayerObject.food){
    		System.out.println("Total Resources: " + PlayerObject.miningAndWood);
    		int amountToSteal = (int) (PlayerObject.miningAndWood * (percentageToSteal / 100));
            int remainingResources = (int) (PlayerObject.miningAndWood - amountToSteal);
            PlayerObject.miningAndWood = remainingResources; 
            
            RaidStolenPopup.typeOfResourceStolen = "mining/wood";
            RaidStolenPopup.amountOfResourceStolen = amountToSteal;
            
            //Just here to testing 
            System.out.println("Percentage to Steal: " + percentageToSteal + "%");
            System.out.println("Amount Stolen: " + amountToSteal);
            System.out.println("Remaining Resources: " + remainingResources);
    		
    	}

    	
    }
    
}