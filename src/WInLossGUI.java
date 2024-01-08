import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


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
		  
	        JFrame frmWinlossStatus = new JFrame("Quota Status");
	        frmWinlossStatus.setTitle("Win/Loss Status");
	        frmWinlossStatus.getContentPane().setLayout(null);
	        JTextArea textArea = new JTextArea();
	        textArea.setEditable(false);
	        textArea.setBounds(28, 29, 605, 300);
	        textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        textArea.setText(" Your village name, " + PlayerObject.playerVillageName + "\n" +
	                "- Your Village power " + PlayerObject.calculateVillagePower() + "\n" +
	                "- Rival Village power: " + AiEventResponse.calculateVillagePowerAi() + "\n" +
	                "- Winner of raid: " + winner);
	        
	        frmWinlossStatus.getContentPane().add(textArea);
	        
	        JLabel lblNewLabel = new JLabel("Win/Loss Status");
	        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblNewLabel.setBounds(248, 10, 199, 23);
	        frmWinlossStatus.getContentPane().add(lblNewLabel);
	        frmWinlossStatus.setSize(669, 366);
	        frmWinlossStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Use appropriate close operation
	        frmWinlossStatus.setVisible(true);
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
