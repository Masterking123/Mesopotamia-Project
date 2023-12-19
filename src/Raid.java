import java.util.Random;

public class Raid {
	public static int raidDayCount = 0; 
	public static boolean raid = false;     
    static Random random = new Random();
    public static double minProbabilityOfRaid = 0;
    public static double maxProbabilityOfRaid = 0;
    
    
    public static boolean raidChance () {
		raid = false; 
		if (raidDayCount == 0) {
	        double raidChance = random.nextDouble();
			if(PlayerObject.food > 35) {
				minProbabilityOfRaid = 0.0;
				maxProbabilityOfRaid = 0.50;
				if (raidChance >= minProbabilityOfRaid && raidChance <= maxProbabilityOfRaid) {
					raid = true; 
					raidDayCount = 3; 
				}
			}else if (PlayerObject.food > 25) {
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
    
}
