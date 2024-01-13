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

public class NoPeopleLoseScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static String descriptionMessage = "Everyone in your village has left since you couldn't provide for their needs. Now you are the only one left in this village, you lost.";
	private static String titleMessage = "YOU HAVE LOST";
	/**
	 * Launch the application.
	 */
	public static void createNoPeopleLeftScreen(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NoPeopleLoseScreen frame = new NoPeopleLoseScreen();
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
	public NoPeopleLoseScreen() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Main.ASPECT_WIDTH/4, Main.ASPECT_HEIGHT/4, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel winLossLabel = new JLabel(titleMessage);
		winLossLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winLossLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		winLossLabel.setBounds(135, 11, 342, 85);
		contentPane.add(winLossLabel);
		
		JLabel summaryOfGameLabel = new JLabel("<html>" + descriptionMessage + "</html>");
		summaryOfGameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		summaryOfGameLabel.setBounds(67, 87, 473, 158);
		contentPane.add(summaryOfGameLabel);
		
		JButton endGameButton = new JButton("End Game!");
		endGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		endGameButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		endGameButton.setBounds(194, 341, 208, 40);
		contentPane.add(endGameButton);
	}
}
