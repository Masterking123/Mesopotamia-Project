import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConnectFourGame extends JFrame {
	public static int[][] gameBoard = new int[7][6];
	public static final int ASPECT_WIDTH = 700;
	public static final int ASPECT_HEIGHT = 700;
	public static JButton[] arrayOfButtons = new JButton[7];

    public ConnectFourGame() {
    	JPanel pane = new JPanel();
        setSize(ASPECT_WIDTH, ASPECT_HEIGHT);
        JButton[] arrayOfButtons = new JButton[7];
        pane.setLayout(null);
        
        JButton repaintButton = new JButton("Repaint");	
        repaintButton.setBounds(0, 0, 686, 23);
        repaintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
        pane.add(repaintButton);
        

        JButton dropButton = new JButton("New button");
        dropButton.setBounds(0, 40, 89, 23);
       
        dropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gameBoard[0][0] == 1 || gameBoard[0][0] == 2) {
					dropButton.setEnabled(false);
				}
				else {
					dropInColumn(1, 1);
					repaint();
				}
			}
		});
        arrayOfButtons[0] = dropButton;
        pane.add(dropButton);
        
        JButton dropButton2 = new JButton("New button");
        dropButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gameBoard[1][0] == 1 || gameBoard[1][0] == 2) {
					dropButton2.setEnabled(false);
				}
				else {
					dropInColumn(2, 1);
					repaint();
				}
			}
		});
        dropButton2.setBounds(100, 40, 89, 23);
        arrayOfButtons[0] = dropButton2;
        pane.add(dropButton2);
        
        
        
        setContentPane(pane);
        setVisible(true);
        setResizable(false);
    }

    // draw grid
    @Override
    public void paint(Graphics g) {
//    	for(int i = 0; i < 6; i++) {
//    		System.out.println((gameBoard[0][i] == 1) + " " + (gameBoard[0][i] == 2));
//    		if(gameBoard[0][i] == 1 || gameBoard[0][i] == 2) {
//    			arrayOfButtons[i+1].setEnabled(false);
//    		}
//    	}
    	
    	int xIndex = 0;
    	int yIndex = 0;
    	super.paint(g);
    	int AdjustedHeight = ASPECT_HEIGHT - 100;
        for (int x = 0; x <= ASPECT_WIDTH; x += (ASPECT_WIDTH/7)) {
        	for (int y = 0; y <= AdjustedHeight; y += (AdjustedHeight/6)) {
        		g.setColor(Color.black);
        		g.drawRect(x, y+100, (ASPECT_WIDTH/7), (AdjustedHeight/6));
        		if(xIndex < 7 && yIndex < 6 && gameBoard[xIndex][yIndex] == 1) {
        			g.setColor(Color.red);
            		g.fillOval(x, y+100, (ASPECT_WIDTH/7), (AdjustedHeight/6));
        		}
        		else if(xIndex < 7 && yIndex < 6 && gameBoard[xIndex][yIndex] == 2) {
        			g.setColor(Color.blue);
            		g.fillOval(x, y+100, (ASPECT_WIDTH/7), (AdjustedHeight/6));
        		}
        		yIndex++;
        	}
        	xIndex++;
        	yIndex = 0;
        }
    }
    
    // turnOrder would be 1 if its the player and 2 if its the AI
    public static void dropInColumn(int columnNumber, int turnOrder) {
    	int x = columnNumber - 1; // To account for the array being 0 index
    	for(int i = 0; i < 6; i++) {
    		int y = i;
    		
    		if(gameBoard[x][y] == 1 || gameBoard[x][y] == 2) {
    			gameBoard[x][y-1] = turnOrder;
    			return;
    		}
    		else if(gameBoard[x][y] == 0 && y == 5) {
    			gameBoard[x][y] = turnOrder;
    			return;
    		}
    	}
    }

    public static void main(String args[]) {
    	ConnectFourGame application = new ConnectFourGame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}