import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class FinalRaidWinLoss extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String winMessage = "The time limit for the final raid has ended. You and your village named " + PlayerObject.playerVillageName  + " charges towards the " + PlayerObject.rivalVillageName + " village in hopes of taking them down. In a long and tiresome battle, you finally deliver the last blow to the village leader and successfully win the raid. Congratulations on beating the game!";
	private static String loseMessage = "The time limit for the final raid has ended. You and your village named " + PlayerObject.playerVillageName  + " charges towards the " + PlayerObject.rivalVillageName + " village in hopes of taking them down. In a long and tiresome battle and your troops are starting to falter. Unfortunately the opposing village was too strong and now you are the only one left in the village. You surrender and are taken prisoner by the " + PlayerObject.rivalVillageName + " village. You lose the game.";
	private static boolean playerWon;
	/**
	 * Launch the application.
	 */
	public static void createWinLossPopup(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalRaidWinLoss frame = new FinalRaidWinLoss();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FinalRaidWinLoss() {
		
		int playerVillagePower = (int) Math.round(PlayerObject.calculateVillagePower());
		int AIVillagePower = (int) Math.round(AiEventResponse.calculateVillagePowerAi());
		String descriptionMessage;
		String titleMessage;
		
		System.out.println(playerVillagePower + " " +  AIVillagePower);
		if(playerVillagePower >= AIVillagePower) {
			playerWon = true;
			descriptionMessage = winMessage;
			titleMessage = "YOU HAVE WON";
		}
		else {
			playerWon = false;
			titleMessage = "YOU HAVE LOST";
			descriptionMessage = loseMessage;
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Main.ASPECT_WIDTH/4, Main.ASPECT_HEIGHT/4, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel winLossLabel = new JLabel(titleMessage);
		winLossLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winLossLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		winLossLabel.setBounds(169, 11, 342, 85);
		contentPane.add(winLossLabel);
		
		JLabel summaryOfGameLabel = new JLabel("<html>" + descriptionMessage + "</html>");
		summaryOfGameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		summaryOfGameLabel.setBounds(20, 77, 656, 158);
		contentPane.add(summaryOfGameLabel);
		
		JLabel playerScoreLabel = new JLabel("Player Score");
		playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		playerScoreLabel.setBounds(30, 235, 162, 85);
		contentPane.add(playerScoreLabel);
		
		JLabel rivalVillageScoreLabel = new JLabel("Rival Village Score");
		rivalVillageScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rivalVillageScoreLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		rivalVillageScoreLabel.setBounds(455, 235, 221, 85);
		contentPane.add(rivalVillageScoreLabel);
		
		JLabel playerScoreValueLabel = new JLabel(Integer.toString(playerVillagePower));
		playerScoreValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerScoreValueLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		playerScoreValueLabel.setBounds(20, 293, 162, 40);
		contentPane.add(playerScoreValueLabel);
		
		JLabel rivalVillageScoreValueLabel = new JLabel(Integer.toString(AIVillagePower));
		rivalVillageScoreValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rivalVillageScoreValueLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		rivalVillageScoreValueLabel.setBounds(492, 293, 162, 40);
		contentPane.add(rivalVillageScoreValueLabel);
		
		JButton endGameButton = new JButton("End Game!");
		endGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		endGameButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		endGameButton.setBounds(240, 412, 208, 40);
		contentPane.add(endGameButton);
	}
}
