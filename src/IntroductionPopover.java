import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class IntroductionPopover extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	public void switchTabs(JPanel panel) { //method for switching tabs in display
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	public void switchButton(JButton buttonName, JPanel panel) { //when the tab buttons are pressed, switches tabs
		buttonName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTabs(panel); 
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public IntroductionPopover() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
          Image img = Toolkit.getDefaultToolkit().getImage(  
          IntroductionPopover.class.getResource("/images/Introduction.png"));  
          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
          };  
		
		contentPane.setBorder(new EmptyBorder(5, 5, 1000, 700));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("MESOPOTAMIA: DAWN OF CIVILIZATION");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		titleLabel.setBounds(133, 11, 722, 42);
		contentPane.add(titleLabel);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(250, 158, 538, 311);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelMain = new JPanel();
		layeredPane.add(panelMain, "name_917817333654630");
		panelMain.setLayout(null);
		
		JLabel mainGameLabel = new JLabel("Main Idea");
		mainGameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mainGameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		mainGameLabel.setBounds(177, 6, 170, 34);
		panelMain.add(mainGameLabel);
		
		JTextPane mainGameDisc = new JTextPane();
		mainGameDisc.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mainGameDisc.setText("The goal of the game is to simulate the growth of an ancient civilization. We start the game off as the leader of a small village, there is a rival village that is growing at an alarming rate and they have hostile relations with our village. The village has agreed to conduct a final raid on the village and they have tasked you with prepping for the next 30 days to be ready for the attack. You must survive for the next 30 days and create a thriving village to win against the rival AI village. ");
		mainGameDisc.setBounds(81, 70, 354, 224);
		panelMain.add(mainGameDisc);
		
		JPanel panelRep = new JPanel();
		layeredPane.add(panelRep, "name_917827582001041");
		
		JPanel panelConsEvents = new JPanel();
		layeredPane.add(panelConsEvents, "name_917802674356474");
		
		JPanel panelWin = new JPanel();
		layeredPane.add(panelWin, "name_936831211628478");
		
		JPanel panelConnect = new JPanel();
		layeredPane.add(panelConnect, "name_936837981510960");
		
		JPanel panelSkills = new JPanel();
		layeredPane.add(panelSkills, "name_917770200247221");
		
		JButton mainIdeaButton = new JButton("Main Idea");
		mainIdeaButton.setBounds(116, 78, 95, 29);
		contentPane.add(mainIdeaButton);
		
		JButton backToMainButton = new JButton("Back");
		backToMainButton.setBounds(10, 78, 66, 29);
		contentPane.add(backToMainButton);
		backToMainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuGUI.createMainMenu(null);
				//frame.setVisible(false);
			}
		});
		
		JButton reputationButton = new JButton("Reputation");
		reputationButton.setBounds(405, 78, 95, 29);
		contentPane.add(reputationButton);
		
		JButton consEventButton = new JButton("Events");
		consEventButton.setBounds(256, 78, 95, 29);
		contentPane.add(consEventButton);
		
		JButton treeTradeButton = new JButton("Research/Trading");
		treeTradeButton.setBounds(841, 78, 137, 29);
		contentPane.add(treeTradeButton);
		
		JButton winLossButton = new JButton("Win/Loss");
		winLossButton.setBounds(543, 78, 95, 29);
		contentPane.add(winLossButton);
		
		JButton connect4Button = new JButton("Connect 4");
		connect4Button.setBounds(693, 78, 95, 29);
		contentPane.add(connect4Button);
		switchButton(reputationButton, panelRep);
		panelRep.setLayout(null);
		
		JLabel repLabel = new JLabel("Reputation");
		repLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		repLabel.setBounds(182, 6, 170, 34);
		panelRep.add(repLabel);
		
		JTextPane repDisc = new JTextPane();
		repDisc.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		repDisc.setText("The reputation system plays an important role in how the villagers think of you as a leader. Reputation is based on how many people don’t starve and have enough fuel for their homes every single day. Once you surpass 60 reputation points you will receive a boost for farms and mining/wood supplies. A reputation of less than 20 will result in a loss from your farms and mining/wood supplies since all the workers are starting to not trust you.");
		repDisc.setBounds(86, 70, 354, 235);
		panelRep.add(repDisc);
		switchButton(consEventButton, panelConsEvents);
		panelConsEvents.setLayout(null);
		
		JLabel eventsLabel = new JLabel("Events");
		eventsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eventsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		eventsLabel.setBounds(135, 17, 243, 34);
		panelConsEvents.add(eventsLabel);
		
		JTextPane eventsDisc = new JTextPane();
		eventsDisc.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		eventsDisc.setText("Throughout the game, you will face a series of events that will randomly occur during the game, these events have a wide range of effects on your village that can be positive or negative. The enemy village will also have random events occurring which could be the cause of your rise or downfall.");
		eventsDisc.setBounds(122, 84, 275, 221);
		panelConsEvents.add(eventsDisc);
		switchButton(treeTradeButton, panelSkills);
		panelSkills.setLayout(null);
		
		JLabel skillsLabel = new JLabel("Research/Trading");
		skillsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		skillsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		skillsLabel.setBounds(135, 22, 243, 34);
		panelSkills.add(skillsLabel);
		
		JTextPane skillsDisc = new JTextPane();
		skillsDisc.setText("As you progress, spend your time and precious resources researching and unlocking new upgrades that will help your civilization thrive. For instance, better crops, more efficient mines, superior soldiers, and trading benefits. You can also choose to trade in your resources for other things your village is in need of to support your people. Trade for food, resources, research points, or Villagers but at a cost!");
		skillsDisc.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		skillsDisc.setBounds(81, 86, 378, 219);
		panelSkills.add(skillsDisc);
		switchButton(winLossButton, panelWin);
		panelWin.setLayout(null);
		
		JTextPane winLossDisc = new JTextPane();
		winLossDisc.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		winLossDisc.setText("At the end of the entire 30 days, the raid on the rival village will occur whether the player is ready for it or not. When the raid occurs, and your village has the higher combat power, they will come on top as the winner. If not you will be forgotten in history forever.");
		winLossDisc.setBounds(129, 73, 267, 232);
		panelWin.add(winLossDisc);
		
		JLabel winsLabel = new JLabel("Win/Loss");
		winsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		winsLabel.setBounds(141, 6, 243, 34);
		panelWin.add(winsLabel);
		switchButton(connect4Button, panelConnect);
		panelConnect.setLayout(null);
		
		JLabel connectLabel = new JLabel("Connect 4");
		connectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		connectLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		connectLabel.setBounds(139, 6, 243, 34);
		panelConnect.add(connectLabel);
		
		JTextPane connectDisc = new JTextPane();
		connectDisc.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		connectDisc.setText("Whenever a raid occurs, you must play a game of connect 4 with the enemy village to decide the winner. You will take turns dropping discs into the grid, starting in the middle or at the edge to stack their colored discs upwards, horizontally, or diagonally. Using strategy to outsmart the enemies.");
		connectDisc.setBounds(121, 70, 286, 235);
		panelConnect.add(connectDisc);
		switchButton(mainIdeaButton, panelMain);
		
		connectDisc.setEditable(false);
		winLossDisc.setEditable(false);
		skillsDisc.setEditable(false);
		eventsDisc.setEditable(false);
		repDisc.setEditable(false);
		mainGameDisc.setEditable(false);
		
		connectDisc.setHighlighter(null);
		winLossDisc.setHighlighter(null);
		skillsDisc.setHighlighter(null);
		eventsDisc.setHighlighter(null);
		repDisc.setHighlighter(null);
		mainGameDisc.setHighlighter(null);
		
		connectDisc.setCursor(null);
		winLossDisc.setCursor(null);
		skillsDisc.setCursor(null);
		eventsDisc.setCursor(null);
		repDisc.setCursor(null);
		mainGameDisc.setCursor(null);
		
		connectDisc.setFocusable(false);
		winLossDisc.setFocusable(false);
		skillsDisc.setFocusable(false);
		eventsDisc.setFocusable(false);
		repDisc.setFocusable(false);
		mainGameDisc.setFocusable(false);
		
		
		
			}
}
