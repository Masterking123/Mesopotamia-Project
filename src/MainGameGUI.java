import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;


public class MainGameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int military = 0; 
	public static int farmer = 0; 
	public static int miner = 0; 
	public static int research = 0; 
	public JButton addFarmerButton;
	public JButton minusFarmerButton;
	                                                    
	/**
	 * Launch the application.
	 */
	public static void showMainGameGUI(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGameGUI frame = new MainGameGUI();
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
	
	
	public MainGameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1650, 1080);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
          Image img = Toolkit.getDefaultToolkit().getImage(  
          MainGameGUI.class.getResource("/images/gameBackground.gif"));  
          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
          };  
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel researchCount = new JLabel("" + research);
		researchCount.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		researchCount.setBounds(1245, 527, 48, 31);
		contentPane.add(researchCount);
		
		JLabel minerCount = new JLabel("" + miner);
		minerCount.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		minerCount.setBounds(1134, 100, 48, 31);
		contentPane.add(minerCount);
		
		JLabel militaryCount = new JLabel("" + military);
		militaryCount.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		militaryCount.setBounds(589, 476, 48, 31);
		contentPane.add(militaryCount);
		
		JLabel farmerCount = new JLabel("" + farmer);
		farmerCount.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		farmerCount.setBounds(81, 262, 48, 31);
		contentPane.add(farmerCount);
		
		addFarmerButton = new JButton("+");
		addFarmerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmer = farmer + 1;
				farmerCount.setText("" + farmer);
			}
		});
		int [] scaledButtonaddFarmer = Main.scaledUIElements(257, 256, 59, 31, 1368, 912);
		addFarmerButton.setBounds(scaledButtonaddFarmer[0], scaledButtonaddFarmer[1], scaledButtonaddFarmer[2], scaledButtonaddFarmer[3]);
		addFarmerButton.setBackground(new Color(192, 192, 192));
		addFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addFarmerButton);
		
		minusFarmerButton = new JButton("-");
		minusFarmerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farmer = farmer - 1;
				farmerCount.setText("" + farmer);
			}
		});
		int [] scaledButtonminusFarmer = Main.scaledUIElements(326, 256, 59, 31, 1368, 912);
		minusFarmerButton.setBounds(scaledButtonminusFarmer[0], scaledButtonminusFarmer[1], scaledButtonminusFarmer[2], scaledButtonminusFarmer[3]);
		minusFarmerButton.setBackground(new Color(192, 192, 192));
		minusFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(minusFarmerButton);
		
		JLabel farmerLabel = new JLabel("Farmers");
		int [] scaledlabelFarmer = Main.scaledUIElements(109, 267, 172, 31, 1368, 912);
		farmerLabel.setBounds(scaledlabelFarmer[0], scaledlabelFarmer[1], scaledlabelFarmer[2], scaledlabelFarmer[3]);
		farmerLabel.setForeground(new Color(255, 255, 255));
		farmerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(farmerLabel);
		
		JLabel minerLabel = new JLabel("Miners");
		minerLabel.setBounds(1097, 129, 132, 44);
		minerLabel.setForeground(new Color(255, 255, 255));
		minerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(minerLabel);
		
		JLabel militaryLabel = new JLabel("Military");
		militaryLabel.setBounds(619, 474, 144, 44);
		militaryLabel.setForeground(new Color(255, 255, 255));
		militaryLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(militaryLabel);
		
		JButton addMilitaryButton = new JButton("+");
		addMilitaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				military = military + 1;
				militaryCount.setText("" + military);
			}
		});
		addMilitaryButton.setBounds(606, 529, 59, 37);
		addMilitaryButton.setBackground(new Color(192, 192, 192));
		addMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addMilitaryButton);
		
		JButton minusMilitaryButton = new JButton("-");
		minusMilitaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				military = military - 1;
				militaryCount.setText("" + military);
			}
		});
		minusMilitaryButton.setBounds(675, 529, 64, 37);
		minusMilitaryButton.setBackground(new Color(192, 192, 192));
		minusMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(minusMilitaryButton);
		
		JButton addMinerButton = new JButton("+");
		addMinerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miner = miner + 1;
				minerCount.setText("" + miner);
			}
		});
		addMinerButton.setBounds(1112, 184, 59, 37);
		addMinerButton.setBackground(new Color(192, 192, 192));
		addMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addMinerButton);
		
		JButton minusMinerButton = new JButton("-");
		minusMinerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miner = miner - 1;
				minerCount.setText("" + miner);
			}
		});
		minusMinerButton.setBounds(1112, 232, 59, 37);
		minusMinerButton.setBackground(new Color(192, 192, 192));
		minusMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(minusMinerButton);
		
		JButton nextDayButton = new JButton("Next Day");
		nextDayButton.setBounds(1080, 699, 132, 37);
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Main.randomPercentOccurance(30)) {
					EventObject generatedRandomEvent = RandomEventObject.getRandomEvent();
					RandomEventPopover.createNewRandomEventPopover(generatedRandomEvent.nameOfEvent, generatedRandomEvent.description);
				}
			}
		});
		nextDayButton.setBackground(new Color(192, 192, 192));
		nextDayButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		contentPane.add(nextDayButton);
		
		JLabel researchLabel = new JLabel("Research");
		researchLabel.setBounds(1097, 529, 153, 37);
		researchLabel.setForeground(new Color(255, 255, 255));
		researchLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(researchLabel);
		
		JButton addResearchButton = new JButton("+");
		addResearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				research = research + 1;
				researchCount.setText("" + research);
			}
		});
		addResearchButton.setBounds(1080, 557, 59, 37);
		addResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addResearchButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(addResearchButton);
		
		JButton minusResearchButton = new JButton("-");
		minusResearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				research = research - 1;
				researchCount.setText("" + research);
			}
		});
		minusResearchButton.setBounds(1153, 557, 59, 37);
		minusResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusResearchButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(minusResearchButton);
		
		JButton statsOpenButton = new JButton("Statistics");
		statsOpenButton.setBounds(426, 793, 161, 45);
		statsOpenButton.setBackground(new Color(192, 192, 192));
		statsOpenButton.setForeground(new Color(0, 0, 0));
		statsOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		statsOpenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		contentPane.add(statsOpenButton);
		
		JButton tradeOpenButton = new JButton("Trade");
		tradeOpenButton.setBounds(606, 795, 126, 44);
		tradeOpenButton.setBackground(new Color(192, 192, 192));
		tradeOpenButton.setForeground(new Color(0, 0, 0));
		tradeOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		contentPane.add(tradeOpenButton);
		
		JButton resarchOpenButton = new JButton("Research");
		resarchOpenButton.setBounds(744, 795, 236, 43);
		resarchOpenButton.setBackground(new Color(192, 192, 192));
		resarchOpenButton.setForeground(new Color(0, 0, 0));
		resarchOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		resarchOpenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResearchPopover.createResearchPopover();
			}
		});
		contentPane.add(resarchOpenButton);
		
	}
}
