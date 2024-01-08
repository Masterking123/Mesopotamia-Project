	import java.awt.Font;
	
	import javax.swing.*;
import java.awt.BorderLayout;
	
	public class QuotaPopOver extends JFrame {
	
	    private static final long serialVersionUID = 1L;
	    private static JPanel contentPane;
	    private static Quota quota;
	
	    public QuotaPopOver() {
	        initialize();
	    }
	
	    private void initialize() {
	        JFrame frame = new JFrame("Quota Status");
	        JTextArea textArea = new JTextArea();
	        textArea.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        textArea.setText(PlayerObject.playerName + "! Your village, " + PlayerObject.playerVillageName + " had not meet the quota!\n" +
	        		"Your consequences are the following: \n" +
	        		"Food needed: " + Quota.foodRequiredPerPerson + "\n" +
	                "People left for food: " + Quota.peopleLeftForFood + "\n" +
	                "Current Reputation: " + PlayerObject.reputation + "\n" +
	                "Wood needed: " + Quota.woodRequiredPerPerson + "\n" +
	                "People left for wood: " + Quota.peopleLeftForWood + "\n" +
	                "Total amount of people: " + PlayerObject.totalPeople + "\n");
	
	        frame.getContentPane().add(textArea);
	        
	        JLabel quotaLabel = new JLabel("QUOTA");
	        quotaLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        quotaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
	        frame.getContentPane().add(quotaLabel, BorderLayout.NORTH);
	        frame.setSize(500, 280);
	        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Use appropriate close operation
	        frame.setVisible(true);
	    }
	
	    public static void showPopUp(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    QuotaPopOver frame = new QuotaPopOver();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
	}
