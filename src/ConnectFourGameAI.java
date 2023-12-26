

public class ConnectFourGameAI {
	public static int connectFourAIResponse(int[][] currentGameBoard) {
		
    	int randomColumn = Main.randomNumberInRange(0, 7);
    	while(currentGameBoard[0][randomColumn] != 0) {
    		randomColumn = Main.randomNumberInRange(0, 7);
    	}
    	return randomColumn;
	}
}
