import java.util.ArrayList;
import java.util.HashMap;

public class ConnectFourGameAI {
	
	// A hashmap that designates types of moves given its score, this is helped to evaluate certain types of moves
	public static HashMap<String, Integer> AIPlanToScore = new HashMap<String, Integer>();
	
	// Main function that is called to output what column the AI should make a move
	public static int connectFourAIResponse(int[][] currentGameBoard) {
		// Create a Priority list to see what types of moves are better suited for the situation
		CreateAIPriorityList();
				
		// Generate all the potential moves and store it in a 2d array
		int[][][] allGeneratedMoves = generatePossibleMoves(currentGameBoard);
		
	
		int[] scoreOfMovesInPositions = new int[7];
		int placementOfMaxScoreMove = -1;
		
		// Evaluate each possible move that the AI can make (Iterate through all possible moves)
		for(int i = 0; i < allGeneratedMoves.length; i++) {
			
			// Find the exact row of where the new blue disc was placed for the evaluate function
			int rowOfMove = 0;
			for(int j = 0; j < 6; j++) {
				if(allGeneratedMoves[i][j][i] == 2) {
					rowOfMove = j;
					break;
				}
			}
			
			// Evaluate the current possibility 
			int currentMoveScore = evalulateGameBoard(allGeneratedMoves[i], rowOfMove, i);
			
			// Store the evaluation in an array
			scoreOfMovesInPositions[i] = currentMoveScore;
			
			// Debug
			System.out.println("Board " + (i+1) + " " + scoreOfMovesInPositions[i]);
		}
		
		
		// CHANGE THIS VALUE TO MAKE IT MORE OR LESS RANDOM
		if(Main.randomPercentOccurance(100)) {
			int maximumScoreInArray = -1;
			int numberOfMaxScore = 0;
			for(int i = 0; i < scoreOfMovesInPositions.length; i++) {
				if(scoreOfMovesInPositions[i] > maximumScoreInArray) {
					maximumScoreInArray = scoreOfMovesInPositions[i];
					numberOfMaxScore = 1;
				}
				else if(scoreOfMovesInPositions[i] == maximumScoreInArray) {
					numberOfMaxScore++;
				}
			}
			System.out.println(maximumScoreInArray);
			
			ArrayList<Integer> indexsOfMax = new ArrayList<Integer>();
			int numberOfSlots = 0;
			for(int i = 0; i < scoreOfMovesInPositions.length; i++) {
				if(scoreOfMovesInPositions[i] == maximumScoreInArray) {
					indexsOfMax.add(i);
				}
			}
			if(indexsOfMax.size() <= 1) {
				return indexsOfMax.get(0);
			}
			return indexsOfMax.get(Main.randomNumberInRange(0, indexsOfMax.size()));
		}
		else {
			return randomValidMove(scoreOfMovesInPositions);
		}
	}
	
	public static void CreateAIPriorityList() {
		AIPlanToScore.put("Winning Move", 10000);
		AIPlanToScore.put("Block Winning Move", 9000);
		AIPlanToScore.put("Connect 3", 500); // Ignore dead connect 3, (500 + 200)
		// Block connect 3
		AIPlanToScore.put("Connect 2", 100); // Ignore dead connect 2
		AIPlanToScore.put("Invalid Move", -1);
		AIPlanToScore.put("Position Edge", 20);
		AIPlanToScore.put("Position Center", 25);
		
	}
	
	public static int evalulateGameBoard(int[][] currentGameBoard, int rowOfMove, int colOfMove) {
		int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
		
		int scoreOfCurrentGameBoard = 0;
		
		if(currentGameBoard[0][0] == -1) {
			return AIPlanToScore.get("Invalid Move");
		}
		
		// Selection of Winning Move
		for(int currDir = 0; currDir < dirs.length; currDir++) {
    		int rowNumber = rowOfMove;
    		int colNumber = colOfMove;
    		int numOfDirectionalValidDiscs = 0;
    		
    		int numOfFlippedValidDiscs = 0;
    		for(int i = 0; i < 4; i++) {
    			rowNumber += dirs[currDir][0];
    			colNumber += dirs[currDir][1];
    			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
    				if(currentGameBoard[rowNumber][colNumber] == 2) {
    					numOfDirectionalValidDiscs += 1;
    				}
    				else {
    					break;
    				}
    			}
    		}
    		
    		rowNumber = rowOfMove;
    		colNumber = colOfMove;
    		
    		for(int i = 0; i < 4; i++) {
    			rowNumber += dirs[currDir][0] * -1;
    			colNumber += dirs[currDir][1] * -1;
    			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
    				if(currentGameBoard[rowNumber][colNumber] == 2) {
    					numOfFlippedValidDiscs += 1;
    				}
    				else {
    					break;
    				}
    			}
    		}
    		
    		if((numOfDirectionalValidDiscs + numOfFlippedValidDiscs) >= 3) {
    			scoreOfCurrentGameBoard += AIPlanToScore.get("Winning Move");
        	}
    	}
		
		
		// Blocking of Winning Move
		for(int currDir = 0; currDir < dirs.length; currDir++) {
    		int rowNumber = rowOfMove;
    		int colNumber = colOfMove;
    		int numOfDirectionalValidDiscs = 0;
    		
    		int numOfFlippedValidDiscs = 0;
    		for(int i = 0; i < 4; i++) {
    			rowNumber += dirs[currDir][0];
    			colNumber += dirs[currDir][1];
    			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
    				if(currentGameBoard[rowNumber][colNumber] == 1) {
    					numOfDirectionalValidDiscs += 1;
    				}
    				else {
    					break;
    				}
    			}
    		}
    		
    		rowNumber = rowOfMove;
    		colNumber = colOfMove;
    		
    		for(int i = 0; i < 4; i++) {
    			rowNumber += dirs[currDir][0] * -1;
    			colNumber += dirs[currDir][1] * -1;
    			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
    				if(currentGameBoard[rowNumber][colNumber] == 1) {
    					numOfFlippedValidDiscs += 1;
    				}
    				else {
    					break;
    				}
    			}
    		}
    		
    		if((numOfDirectionalValidDiscs + numOfFlippedValidDiscs) >= 3) {
    			scoreOfCurrentGameBoard += AIPlanToScore.get("Block Winning Move");
        	}
    	}
		
		
		// Checking for Connect 2s
		
		// Iterate through all the directions 
		for(int currDir = 0; currDir < dirs.length; currDir++) {
    		int rowNumber = rowOfMove;
    		int colNumber = colOfMove;
    		
    		rowNumber += dirs[currDir][0];
    		colNumber += dirs[currDir][1];
    		
    		// Check if the disc is within the bounds of the game
			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
				
				// If the disc is valid
				if(currentGameBoard[rowNumber][colNumber] == 2) {
					
					// Directional check going with the movement of the adjacent disc
					int movementInRow = rowNumber + dirs[currDir][0];
					int movementInCol = colNumber + dirs[currDir][1];
					if(0 <= movementInRow && movementInRow < 6 && 0 <= movementInCol && movementInCol < 7 && currentGameBoard[movementInRow][movementInCol] == 0) {
						movementInRow += dirs[currDir][0];
						movementInCol += dirs[currDir][1];
						
						if(0 <= movementInRow && movementInRow < 6 && 0 <= movementInCol && movementInCol < 7 && currentGameBoard[movementInRow][movementInCol] == 0) {
							scoreOfCurrentGameBoard += AIPlanToScore.get("Connect 2");
						}
					}
					
					
					
					// Directional Check For Flip Position
					int flippedRow = rowOfMove + dirs[currDir][0] * -1;
					int flippedCol = colOfMove + dirs[currDir][1] * -1;
										
					if(0 <= flippedRow && flippedRow < 6 && 0 <= flippedCol && flippedCol < 7 && currentGameBoard[flippedRow][flippedCol] == 0) {
						flippedRow += dirs[currDir][0] * -1;
						flippedRow += dirs[currDir][1] * -1;
						
						if(0 <= flippedRow && flippedRow < 6 && 0 <= flippedCol && flippedCol < 7 && currentGameBoard[flippedRow][flippedCol] == 0) {
//							System.out.println("Original Pos: " + rowOfMove + " " + colOfMove);
//							System.out.println("Direction: " + dirs[currDir][0] + " " + dirs[currDir][1]);
//							System.out.println("NewMoved Position: " + (rowOfMove + dirs[currDir][0]) + " " + (colOfMove + dirs[currDir][1]));
//							System.out.println("Value at Position:" + currentGameBoard[(rowOfMove + dirs[currDir][0])][(colOfMove + dirs[currDir][1])]);
//							System.out.println("Flip Move #2: " + flippedRow + " " + flippedCol);
							scoreOfCurrentGameBoard += AIPlanToScore.get("Connect 2");
						}
					}
				}
			}
		}
		
		// Connect 3 Code
		for(int currDir = 0; currDir < dirs.length; currDir++) {
    		int rowNumber = rowOfMove;
    		int colNumber = colOfMove;
    		
    		rowNumber += dirs[currDir][0];
    		colNumber += dirs[currDir][1];
    		
    		// Check if the disc is within the bounds of the game
			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
				
				// If the disc is valid
				if(currentGameBoard[rowNumber][colNumber] == 2) {
					
					// Directional check going with the movement of the adjacent disc
					int movementInRow = rowNumber + dirs[currDir][0];
					int movementInCol = colNumber + dirs[currDir][1];
					if(0 <= movementInRow && movementInRow < 6 && 0 <= movementInCol && movementInCol < 7 && currentGameBoard[movementInRow][movementInCol] == 2) {
						
						movementInRow = rowOfMove + dirs[currDir][0] * -1;
						movementInCol = colOfMove + dirs[currDir][1] * -1;
						if(0 <= movementInRow && movementInRow < 6 && 0 <= movementInCol && movementInCol < 7 && currentGameBoard[movementInRow][movementInCol] == 0) {
							System.out.println("Connect 3 FOUND");
							scoreOfCurrentGameBoard += AIPlanToScore.get("Connect 3");
							
						}
					}
					
					
			
				}
			}
		}
		
		if(colOfMove == 0 || colOfMove == 6 || colOfMove == 1 || colOfMove == 5) {
			scoreOfCurrentGameBoard += AIPlanToScore.get("Position Edge");
		}
		if(colOfMove > 1 && colOfMove < 5) {
			scoreOfCurrentGameBoard += AIPlanToScore.get("Position Center");
		}
		
		
		
		return scoreOfCurrentGameBoard;
		
		
	}
	
	public static int[][][] generatePossibleMoves(int[][] currentGameBoard){
		int[][][] allGeneratedMoves = new int[7][6][7]; // generatedBoard [boardNumber][rows][cols]
		
		for(int i = 0; i < 7; i++) {
			int columnNumber = i;
			int[][] movedGameBoard = new int[6][7];
			
			if(currentGameBoard[0][i] == 1 || currentGameBoard[0][i] == 2) {
				movedGameBoard[0][0] = -1;
				allGeneratedMoves[i] = movedGameBoard;
				continue;
			}
			
			for(int j = 0; j < currentGameBoard.length; j++) {
				for(int k = 0; k < currentGameBoard[0].length; k++) {
					movedGameBoard[j][k] = currentGameBoard[j][k];
				}
			}
			
			for(int rowNumber = 0; rowNumber < 6; rowNumber++) {
	    		if((rowNumber-1) >= 0 && movedGameBoard[rowNumber][columnNumber] == 1 || movedGameBoard[rowNumber][columnNumber] == 2) {
	    			movedGameBoard[rowNumber-1][columnNumber] = 2;
	    			break;
	    		}
	    		else if(movedGameBoard[rowNumber][columnNumber] == 0 && rowNumber == 5) {
	    			movedGameBoard[rowNumber][columnNumber] = 2;
	    			break;
	    		}
	    	}
			
			allGeneratedMoves[i] = movedGameBoard;
		}

		return allGeneratedMoves;
	}
	
	public static int randomValidMove(int[] arrayOfScores) {
		ArrayList<Integer> indexsOfValidMoves = new ArrayList<Integer>();
		for(int i = 0; i < arrayOfScores.length; i++) {
			if(arrayOfScores[i] != -1) {
				indexsOfValidMoves.add(i);
			}
		}
		if(indexsOfValidMoves.size() <= 1) {
			return indexsOfValidMoves.get(0);
		}
		return indexsOfValidMoves.get(Main.randomNumberInRange(0, indexsOfValidMoves.size()));
		
	}
	
}
