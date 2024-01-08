import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JButton;

public class NewIntroductionPopover extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void createNewIntroductionPopover(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewIntroductionPopover frame = new NewIntroductionPopover();
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
	public NewIntroductionPopover() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
			}
			
		});
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
          Image img = Toolkit.getDefaultToolkit().getImage(  
          IntroductionPopover.class.getResource("/images/Introduction.png"));  
          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
          };  
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleText = new JLabel("MESOPOTAMIA: DAWN OF CIVILIZATION", SwingConstants.CENTER);

		titleText.setForeground(new Color(255, 255, 255));
		titleText.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titleText.setBounds(10, 11, 666, 63);
		contentPane.add(titleText);
		
		String myString = "Hello " + PlayerObject.playerName + ", welcome to your village called " + PlayerObject.playerVillageName + ", your goal is to be the leader of this small village. You have noticed that there is a rival village that is growing at an alarming rate and they have hostile relations with your village. The village has agreed to conduct a final raid on the village and they have tasked you with prepping for the next 30 days to be ready for the attack. Your mission is to survive the 30 days and create a village to win against the " + PlayerObject.rivalVillageName + " village";
		JLabel descriptionText = new JLabel("");
		descriptionText.setForeground(new Color(255,255,255));
		descriptionText.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		descriptionText.setBounds(48, 70, 605, 315);
		descriptionText.setOpaque(true);
		descriptionText.setBackground(new Color(0,0,0, 127));
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
