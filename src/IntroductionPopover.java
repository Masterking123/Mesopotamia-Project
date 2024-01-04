import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class IntroductionPopover extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void createNewIntroductionPopover(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroductionPopover frame = new IntroductionPopover();
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
	public IntroductionPopover() {
		
		
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
		
		contentPane.setBorder(new EmptyBorder(5, 5, 700, 500));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("MESOPOTAMIA: DAWN OF CIVILIZATION");
		titleLabel.setForeground(new Color(255, 255, 255));
		int [] scaleTitleLabel = Main.scaledUIElements(83, 11, 515, 30, 1440, 900);
		int scaledFontSize = Main.scaledFontSize(25, 1440, 900);
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, scaledFontSize));
		titleLabel.setBounds(scaleTitleLabel[0], scaleTitleLabel[1], scaleTitleLabel[2], scaleTitleLabel[3]);
		contentPane.add(titleLabel);
		
		JButton continueBtn = new JButton("Continue");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		int scaledContinueButtonFontSize = Main.scaledFontSize(30, 1440, 900);
		continueBtn.setFont(new Font("Times New Roman", Font.BOLD, scaledContinueButtonFontSize));
		int[] scaledContinueButton = Main.scaledUIElements(264, 395, 160, 43, 1440, 900);
		continueBtn.setBounds(scaledContinueButton[0], scaledContinueButton[1], scaledContinueButton[2], scaledContinueButton[3]);
		contentPane.add(continueBtn);
		
		JTextPane introText = new JTextPane();
		introText.setForeground(new Color(255, 255, 255));
		int scaledContinueFont = Main.scaledFontSize(25, 1440, 900);
		introText.setFont(new Font("Times New Roman", Font.BOLD, scaledContinueFont));
		introText.setText("The goal of the game is to simulate the growth of an ancient civilization. We start the game off as the leader of a small village, there is a rival village that is growing at an alarming rate and they have hostile relations with our village. The village has agreed to conduct a final raid on the village and they have tasked you with prepping for the next 30 days to be ready for the attack. You must survive for the next 30 days and create a thriving village to win against the rival AI village. ");
		introText.setBounds(43, 80, 606, 323);

		introText.setOpaque(false);
		contentPane.add(introText);
		introText.setEnabled(false);
		titleLabel.setEnabled(false);
		
			}
}
