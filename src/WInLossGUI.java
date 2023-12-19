import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class WInLossGUI extends JFrame {
	public static String playerVillageName;
	public static String playerName;
	public static int dayCounter = 1;
	static String winner;
	static String losser;
	 

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WInLossGUI frame = new WInLossGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	 public WInLossGUI() {
	        winlossgui();
	    }
	/**
	 * Create the frame.
	 */
	  public static void winlossgui() {
		  compare();
		  
	        JFrame frame = new JFrame("Quota Status");
	        JTextArea textArea = new JTextArea();
	        textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        textArea.setText(" Your village name, " + PlayerObject.playerVillageName + "\n" +
	                "- Your Village power " + PlayerObject.calculateVillagePower() + "\n" +
	                "- Rival Village power: " + AiEventResponse.calculateVillagePowerAi() + "\n" +
	                "- Winner of raid: " + winner);
	        
	        frame.getContentPane().add(textArea);
	        frame.setSize(600, 300);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Use appropriate close operation
	        frame.setVisible(true);
	    }
	  
	  
	  public static String compare() {
		    if(PlayerObject.calculateVillagePower() < AiEventResponse.calculateVillagePowerAi())
		    {
		    	winner  =  "Ai village won, and your village lost";		    
		    	}
		    else if(AiEventResponse.calculateVillagePowerAi() < PlayerObject.calculateVillagePower()) {
		    	winner = "Your village won, ai village lost";
		    }
		    else if(AiEventResponse.calculateVillagePowerAi() == PlayerObject.calculateVillagePower()) {
		    	Random random = new Random();
		    	boolean result = random.nextBoolean();
		    	if (result) {
		            winner = "Ai Village won, your village lost"; 
		        } else {
		        	winner = "Your village won, ai village lost";
		        }
		    }
		    return winner;
		    }
	  

}
