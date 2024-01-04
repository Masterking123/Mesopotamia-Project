import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

// Special button class that stores a JButton along with an index to know which button is which
class ConnectFourButton extends JButton{
    public int index;
    ConnectFourButton()
    {
    	super();
    }
    ConnectFourButton(int index){
    	super();
    	this.index = index;
    	
    }
}



public class ConnectFourGame extends JFrame {
	public static String currentGameOutcome; // Outcome of the game 
	public static int[][] gameBoard = new int[6][7]; // gameBoard[row][cols]
	
	// Screen Size of the board
	private static final int ASPECT_WIDTH = 700;
	private static final int ASPECT_HEIGHT = 700;
	public static ConnectFourButton[] arrayOfButtons = new ConnectFourButton[7];
	public static int currentPlayer = 1; // 1 for player 1 (red), 2 for player 2 (blue)
	private static int indexForButtons;

    public ConnectFourGame() {
    	JPanel pane = new JPanel();
        setSize(ASPECT_WIDTH, ASPECT_HEIGHT);
        pane.setLayout(null);
        
        JLabel titleText = new JLabel("CONNECT FOUR RAID", SwingConstants.CENTER);
        titleText.setBounds(0, 0, 655, 40);
        titleText.setFont(new Font("Arial", Font.BOLD, 23));
        pane.add(titleText);
        
        ConnectFourButton dropButtonOne = new ConnectFourButton(0);
        arrayOfButtons[0] = dropButtonOne;
        
        ConnectFourButton dropButtonTwo = new ConnectFourButton(1);
        arrayOfButtons[1] = dropButtonTwo;
        
        ConnectFourButton dropButtonThree = new ConnectFourButton(2);
        arrayOfButtons[2] = dropButtonThree;
        
        ConnectFourButton dropButtonFour = new ConnectFourButton(3);
        arrayOfButtons[3] = dropButtonFour;
        
        ConnectFourButton dropButtonFive = new ConnectFourButton(4);
        arrayOfButtons[4] = dropButtonFive;
        
        ConnectFourButton dropButtonSix = new ConnectFourButton(5);
        arrayOfButtons[5] = dropButtonSix;

        ConnectFourButton dropButtonSeven = new ConnectFourButton(6);
        arrayOfButtons[6] = dropButtonSeven;

        for(int i = 0; i < 7; i++) {
        	ConnectFourButton currentButton = arrayOfButtons[i];
        	
        	currentButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			if(currentPlayer == 1) {
        				int checkWinThingy = dropInColumn(currentButton.index, 1);
    					repaint();
    					if(checkWin(checkWinThingy, currentButton.index, 1)) {
    						JOptionPane.showMessageDialog(null, "WINNER: PLAYER");
    						currentGameOutcome = "PLAYER";
    						setVisible(false);
    						MainGameGUI.frame.setAlwaysOnTop(true);
            				MainGameGUI.frame.setAlwaysOnTop(false);
            				MainGameGUI.frame.setEnabled(true);
    					}
    					if(gameBoard[0][currentButton.index] != 0) {
    						currentButton.setEnabled(false);
    					}
        				
        			}
        			int[] indexs = AIResponse();
        			if(checkWin(indexs[1], indexs[0], 2)) {
        				JOptionPane.showMessageDialog(null, "WINNER: AI");
        				currentGameOutcome = "AI";
        				setVisible(false);
        				
        				// FOR RAID STEALING RESOURCES
        				if(ConnectFourGame.currentGameOutcome == "AI") {
        					System.out.println("Food before raid" + PlayerObject.food);
        					Raid.stealResources();
        					System.out.println("Food after raid" + PlayerObject.food);
        				}
        				
        				MainGameGUI.frame.setAlwaysOnTop(true);
        				MainGameGUI.frame.setAlwaysOnTop(false);
        				MainGameGUI.frame.setEnabled(true);
        			}
        			
        			if(isDraw(gameBoard) == true) {
        				JOptionPane.showMessageDialog(null, "ITS A DRAW");
        				currentGameOutcome = "Draw";
        				setVisible(false);
        				MainGameGUI.frame.setAlwaysOnTop(true);
        				MainGameGUI.frame.setAlwaysOnTop(false);
        				MainGameGUI.frame.setEnabled(true);
        			}
        		}
        	});
        	currentButton.setText("DROP");
        	currentButton.setBounds((100 * i), 40, 89, 23);
        	pane.add(currentButton);
        }
        setContentPane(pane);
        setVisible(true);
      	setResizable(false);
        
    }

    // draw grid
    @Override
    public void paint(Graphics g) {
    	int colsIndex = 0;
    	int rowsIndex = 0;
    	super.paint(g);
    	int AdjustedHeight = ASPECT_HEIGHT - 100;
        for (int x = 0; x <= ASPECT_WIDTH; x += (ASPECT_WIDTH/7)) {
        	for (int y = 0; y <= AdjustedHeight; y += (AdjustedHeight/6)) {
        		g.setColor(Color.black);
        		g.drawRect(x, y+100, (ASPECT_WIDTH/7), (AdjustedHeight/6));
        		if(rowsIndex < 6 && colsIndex < 7 && gameBoard[rowsIndex][colsIndex] == 1) {
        			g.setColor(Color.red);
            		g.fillOval(x, y+100, (ASPECT_WIDTH/7), (AdjustedHeight/6));
        		}
        		else if(rowsIndex < 6 && colsIndex < 7 && gameBoard[rowsIndex][colsIndex] == 2) {
        			g.setColor(Color.blue);
            		g.fillOval(x, y+100, (ASPECT_WIDTH/7), (AdjustedHeight/6));
        		}
        		rowsIndex++;
        	}
        	colsIndex++;
        	rowsIndex = 0;
        }
    }
    
    // turnOrder would be 1 if its the player and 2 if its the AI
    // This drop function is 0-indexed
    public static int dropInColumn(int columnNumber, int turnOrder) {
    	for(int rowNumber = 0; rowNumber < 6; rowNumber++) {
    		if((rowNumber-1) >= 0 && gameBoard[rowNumber][columnNumber] == 1 || gameBoard[rowNumber][columnNumber] == 2) {
    			gameBoard[rowNumber-1][columnNumber] = turnOrder;
    			return rowNumber-1;
    		}
    		else if(gameBoard[rowNumber][columnNumber] == 0 && rowNumber == 5) {
    			gameBoard[rowNumber][columnNumber] = turnOrder;
    			return rowNumber;
    		}
    	}
		return 0;
    }
    
    
    public static int[] AIResponse() {
    	int resultMovedArray[][][] = ConnectFourGameAI.generatePossibleMoves(gameBoard);
    	
    	int AIMove = ConnectFourGameAI.connectFourAIResponse(gameBoard);
    	int index = dropInColumn(AIMove, 2);
    	
		if(gameBoard[0][AIMove] != 0) {
    		arrayOfButtons[AIMove].setEnabled(false);
    	}
		int result[] = new int[2];
		result[0] = AIMove;
		result[1] = index;
		
		return result;
    }
    
    //
    public static void CreateConnectFour(String args[]) {
    	currentGameOutcome = "";
    	ConnectFourGame application = new ConnectFourGame();
        application.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        gameBoard = new int[6][7];
    }
    
    // Debug Print Board Option
    public static void printGameBoard(int[][] currentGameBoard) {
    	for(int i = 0; i < 10; i++) {
    		System.out.println();
    	}
    	for(int i = 0; i < 6; i++) {
    		String row = "";
    		for(int j = 0; j < 7; j++) {
    			row += Integer.toString(currentGameBoard[i][j]) + " ";
    		}
    		System.out.println(row);
    		row = "";
    	}
    }
    
    public static boolean isDraw(int[][] currentGameBoard) {
    	boolean isDraw = true;
    	for(int i = 0; i < 7; i++) {
    		if(currentGameBoard[0][i] == 0) {
    			isDraw = false;
    			break;
    		}
    	}
    	return isDraw;
    }
  
    public static boolean checkWin(int startPosRow, int startPosCols, int turnOrder) {
    	int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    	
    	for(int currDir = 0; currDir < dirs.length; currDir++) {
    		int rowNumber = startPosRow;
    		int colNumber = startPosCols;
    		int numOfDirectionalValidDiscs = 0;
    		int numOfFlippedValidDiscs = 0;

    		
    		for(int i = 0; i < 4; i++) {
    			rowNumber += dirs[currDir][0];
    			colNumber += dirs[currDir][1];
    			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
    				if(gameBoard[rowNumber][colNumber] == turnOrder) {
    					numOfDirectionalValidDiscs += 1;
    				}
    				else {
    					break;
    				}
    			}
    		}
    		
    		rowNumber = startPosRow;
    		colNumber = startPosCols;
    		
    		for(int i = 0; i < 4; i++) {
    			rowNumber += dirs[currDir][0] * -1;
    			colNumber += dirs[currDir][1] * -1;
    			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
    				if(gameBoard[rowNumber][colNumber] == turnOrder) {
    					numOfFlippedValidDiscs += 1;
    				}
    				else {
    					break;
    				}
    			}
    		}
    		
    		if((numOfDirectionalValidDiscs + numOfFlippedValidDiscs) >= 3) {
        		return true;
        	}
    		
    	}
    	return false;
    }
}