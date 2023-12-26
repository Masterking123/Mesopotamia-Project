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
	public static int[][] gameBoard = new int[6][7]; // gameBoard[row][cols]
	public static final int ASPECT_WIDTH = 700;
	public static final int ASPECT_HEIGHT = 700;
	public static ConnectFourButton[] arrayOfButtons = new ConnectFourButton[7];
	public static int currentPlayer = 1; // 1 for player 1 (red), 2 for player 2 (blue)
	private static int indexForButtons;

    public ConnectFourGame() {
    	JPanel pane = new JPanel();
        setSize(ASPECT_WIDTH, ASPECT_HEIGHT);
        pane.setLayout(null);
        
        JButton repaintButton = new JButton("Repaint");	
        repaintButton.setBounds(0, 0, 686, 23);
        repaintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
        pane.add(repaintButton);
        
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
    						System.exit(0);
    					}
    					if(gameBoard[0][currentButton.index] != 0) {
    						currentButton.setEnabled(false);
    					}
        				
        			}
        			AIResponse();
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
    
    
    public static void AIResponse() {
    	int AIMove = ConnectFourGameAI.connectFourAIResponse(gameBoard);
    	int index = dropInColumn(AIMove, 2);
		if(checkWin(index, AIMove, 2)) {
			JOptionPane.showMessageDialog(null, "WINNER: AI");
			System.exit(0);
		}
		if(gameBoard[0][AIMove] != 0) {
    		arrayOfButtons[AIMove].setEnabled(false);
    	}
    }

    public static void main(String args[]) {
    	ConnectFourGame application = new ConnectFourGame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // Debug Print Board Option
    public static void printGameBoard() {
    	for(int i = 0; i < 10; i++) {
    		System.out.println();
    	}
    	for(int i = 0; i < 6; i++) {
    		String row = "";
    		for(int j = 0; j < 7; j++) {
    			row += Integer.toString(gameBoard[i][j]) + " ";
    		}
    		System.out.println(row);
    		row = "";
    	}
    }
  
    // KNOWN BUG: a row of AI TILES on the bottom row doesnt register as a win
    public static boolean checkWin(int startPosRow, int startPosCols, int turnOrder) {
    	int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    	
    	System.out.println("StartPos: " + startPosRow + " " + startPosCols);
    	for(int currDir = 0; currDir < dirs.length; currDir++) {
    		int rowNumber = startPosRow;
    		int colNumber = startPosCols;
    		int numberOfValidDiscs = 1; // Will be equal to one to account for the current position being valid for the connect 4

    		
    		for(int i = 0; i < 4; i++) {
    			rowNumber += dirs[currDir][0];
    			colNumber += dirs[currDir][1];
    			if(0 <= rowNumber && rowNumber < 6 && 0 <= colNumber && colNumber < 7) {
    				if(gameBoard[rowNumber][colNumber] == turnOrder) {
    					System.out.print("(" + rowNumber + " " + colNumber + ")" + " ");
    					numberOfValidDiscs += 1;
    					if(numberOfValidDiscs == 4) {
    						return true;
    					}
    				}
    				else {
    					break;
    				}
    			}
    		}
    	}
    	System.out.println("");
    	return false;
    }
}