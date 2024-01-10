import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class RaidStolenPopup extends JFrame {
	
	public static String typeOfResourceStolen;
	public static int amountOfResourceStolen;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void createRaidStolenPopup(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RaidStolenPopup frame = new RaidStolenPopup();
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
	public RaidStolenPopup() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
			}
			
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleText = new JLabel("RAID LOSS", SwingConstants.CENTER);
		
		// Check if multiplying 1.4 here is good for other screens
		titleText.setForeground(new Color(0, 0, 0));
		titleText.setFont(new Font("Times New Roman", Font.BOLD, 35));
		titleText.setBounds(10, 11, 666, 63);
		contentPane.add(titleText);
		
		String myString = "Since you have lost against the " + PlayerObject.rivalVillageName + " village in this raid, the rival village has stolen approximately " + amountOfResourceStolen + " pieces of " + typeOfResourceStolen + " from your village. The villagers hope you can defend the village better next time!";
		JLabel descriptionText = new JLabel("");
		descriptionText.setForeground(new Color(0, 0, 0));
		descriptionText.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		descriptionText.setBounds(48, 70, 605, 315);
		descriptionText.setText("<html>" + myString + "</html>");
		contentPane.add(descriptionText);
		
		JButton continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		continueButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		continueButton.setBounds(283, 413, 113, 39);
		contentPane.add(continueButton);
	}

}
