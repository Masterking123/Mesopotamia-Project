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
import javax.swing.JTextPane;


public class MainGameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int military = 0; 
	public static int farmer = 0; 
	public static int miner = 0; 
	public static int research = 0; 
	public static int dayCounter = 1; 
	public static int peopleCount = 10; 
	public JButton addFarmerButton;
	public JButton minusFarmerButton;
	                                                    
	/**
	 * Launch the application.
	 */
	public static MainGameGUI frame;
	
	public static void showMainGameGUI(String[] args) {
		frame = new MainGameGUI();
		frame.setVisible(true);
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
		
		JLabel unalloPeopleLabel = new JLabel("Unallocated People:");
		unalloPeopleLabel.setForeground(new Color(255, 255, 255));
		int scaledPeopleLabelFont = Main.scaledFontSize(30, 1368, 912);
		unalloPeopleLabel.setFont(new Font("Sitka Text", Font.BOLD, scaledPeopleLabelFont));
		int [] scaledpeopleLabel= Main.scaledUIElements(529, 160, 357, 44, 1368, 912);
		unalloPeopleLabel.setBounds(scaledpeopleLabel[0], scaledpeopleLabel[1], scaledpeopleLabel[2], scaledpeopleLabel[3]);
		contentPane.add(unalloPeopleLabel);
		
		JLabel unalloPeopleCounter = new JLabel("" + peopleCount);
		unalloPeopleCounter.setForeground(new Color(0, 0, 0));
		int scaledunPeopleCounterFont = Main.scaledFontSize(30, 1368, 912);
		unalloPeopleCounter.setFont(new Font("Trebuchet MS", Font.BOLD, scaledunPeopleCounterFont));
		int [] scaledpeopleCounter= Main.scaledUIElements(760, 156, 64, 44, 1368, 912);
		unalloPeopleCounter.setBounds(scaledpeopleCounter[0], scaledpeopleCounter[1], scaledpeopleCounter[2], scaledpeopleCounter[3]);
		contentPane.add(unalloPeopleCounter);
		
		JLabel researchCount = new JLabel("" + research);
		int scaledResearchCountFont = Main.scaledFontSize(25, 1368, 912);
		researchCount.setFont(new Font("Trebuchet MS", Font.BOLD, scaledResearchCountFont));
		int [] researchCountLabel= Main.scaledUIElements(1245, 527, 48, 31, 1368, 912);
		researchCount.setBounds(researchCountLabel[0], researchCountLabel[1], researchCountLabel[2], researchCountLabel[3]);
		contentPane.add(researchCount);
		
		JLabel minerCount = new JLabel("" + miner);
		int scaledMinerCountFont = Main.scaledFontSize(25, 1368, 912);
		minerCount.setFont(new Font("Trebuchet MS", Font.BOLD, scaledMinerCountFont));
		int [] minerCountLabel= Main.scaledUIElements(1134, 100, 48, 31, 1368, 912);
		minerCount.setBounds(minerCountLabel[0], minerCountLabel[1], minerCountLabel[2], minerCountLabel[3]);
		contentPane.add(minerCount);
		
		JLabel dayCountLabel = new JLabel("Days:");
		dayCountLabel.setForeground(new Color(255, 255, 255));
		int scaledDayCountLabelFont = Main.scaledFontSize(30, 1368, 912);
		dayCountLabel.setFont(new Font("Sitka Text", Font.BOLD, scaledDayCountLabelFont));
		int [] dayCountLabel1= Main.scaledUIElements(607, 337, 132, 29, 1368, 912);
		dayCountLabel.setBounds(dayCountLabel1[0], dayCountLabel1[1], dayCountLabel1[2], dayCountLabel1[3]);
		contentPane.add(dayCountLabel);
		
		JLabel dayCounterLabel = new JLabel("1");
		int scaledDayCounterFont = Main.scaledFontSize(25, 1368, 912);
		dayCounterLabel.setFont(new Font("Trebuchet MS", Font.BOLD, scaledDayCounterFont));
		int [] dayCounterLabel1= Main.scaledUIElements(694, 331, 48, 31, 1368, 912);
		dayCounterLabel.setBounds(dayCounterLabel1[0], dayCounterLabel1[1], dayCounterLabel1[2], dayCounterLabel1[3]);
		contentPane.add(dayCounterLabel);
		
		JLabel militaryCount = new JLabel("" + military);
		int scaledMilitaryCountFont = Main.scaledFontSize(25, 1368, 912);
		militaryCount.setFont(new Font("Trebuchet MS", Font.BOLD, scaledMilitaryCountFont));
		int [] militaryCountLabel= Main.scaledUIElements(589, 476, 48, 31, 1368, 912);
		militaryCount.setBounds(militaryCountLabel[0], militaryCountLabel[1], militaryCountLabel[2], militaryCountLabel[3]);
		contentPane.add(militaryCount);
		
		JLabel farmerCount = new JLabel("" + farmer);
		int scaledfarmerCountFont = Main.scaledFontSize(25, 1368, 912);
		farmerCount.setFont(new Font("Trebuchet MS", Font.BOLD, scaledfarmerCountFont));
		int [] farmerCountLabel= Main.scaledUIElements(81, 262, 48, 31, 1368, 912);
		farmerCount.setBounds(farmerCountLabel[0], farmerCountLabel[1], farmerCountLabel[2], farmerCountLabel[3]);
		contentPane.add(farmerCount);
		
		addFarmerButton = new JButton("+");
		addFarmerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (peopleCount > 0) {
					farmer = farmer + 1;
					farmerCount.setText("" + farmer);
					peopleCount = peopleCount - 1; 
					unalloPeopleCounter.setText("" + peopleCount);
				}
			}
		});
		int [] scaledButtonaddFarmer = Main.scaledUIElements(257, 256, 59, 31, 1368, 912);
		addFarmerButton.setBounds(scaledButtonaddFarmer[0], scaledButtonaddFarmer[1], scaledButtonaddFarmer[2], scaledButtonaddFarmer[3]);
		addFarmerButton.setBackground(new Color(192, 192, 192));
		int scaledAddFarmerFont = Main.scaledFontSize(40, 1368, 912);
		addFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, scaledAddFarmerFont));
		contentPane.add(addFarmerButton);
		
		minusFarmerButton = new JButton("-");
		minusFarmerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (farmer > 0) {
					farmer = farmer - 1;
					peopleCount = peopleCount + 1; 
				}
				farmerCount.setText("" + farmer);
				unalloPeopleCounter.setText("" + peopleCount);
			}
		});
		int [] scaledButtonminusFarmer = Main.scaledUIElements(326, 256, 59, 31, 1368, 912);
		minusFarmerButton.setBounds(scaledButtonminusFarmer[0], scaledButtonminusFarmer[1], scaledButtonminusFarmer[2], scaledButtonminusFarmer[3]);
		minusFarmerButton.setBackground(new Color(192, 192, 192));
		int scaledMinusFarmerFont = Main.scaledFontSize(40, 1368, 912);
		minusFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, scaledMinusFarmerFont));
		contentPane.add(minusFarmerButton);
		
		JLabel farmerLabel = new JLabel("Farmers");
		int [] scaledlabelFarmer = Main.scaledUIElements(109, 267, 172, 31, 1368, 912);
		farmerLabel.setBounds(scaledlabelFarmer[0], scaledlabelFarmer[1], scaledlabelFarmer[2], scaledlabelFarmer[3]);
		farmerLabel.setForeground(new Color(255, 255, 255));
		int scaledFarmerLabelFont = Main.scaledFontSize(30, 1368, 912);
		farmerLabel.setFont(new Font("Sitka Text", Font.BOLD, scaledFarmerLabelFont));
		contentPane.add(farmerLabel);
		
		JLabel minerLabel = new JLabel("Miners");
		int [] scaledlabelMiner = Main.scaledUIElements(1097, 129, 132, 44, 1368, 912);
		minerLabel.setBounds(scaledlabelMiner[0], scaledlabelMiner[1], scaledlabelMiner[2], scaledlabelMiner[3]);		
		minerLabel.setForeground(new Color(255, 255, 255));
		int scaledMinerFont = Main.scaledFontSize(30, 1368, 912);
		minerLabel.setFont(new Font("Sitka Text", Font.BOLD, scaledMinerFont));
		contentPane.add(minerLabel);
		
		JLabel militaryLabel = new JLabel("Military");
		int [] scaledlabelMilitary = Main.scaledUIElements(619, 474, 144, 44, 1368, 912);
		militaryLabel.setBounds(scaledlabelMilitary[0], scaledlabelMilitary[1], scaledlabelMilitary[2], scaledlabelMilitary[3]);		militaryLabel.setForeground(new Color(255, 255, 255));
		int scaledMilitaryLabelFont = Main.scaledFontSize(30, 1368, 912);
		militaryLabel.setFont(new Font("Sitka Text", Font.BOLD, scaledMilitaryLabelFont));
		contentPane.add(militaryLabel);
		
		JButton addMilitaryButton = new JButton("+");
		addMilitaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (peopleCount > 0) {
					peopleCount = peopleCount - 1; 
					military = military + 1;
					militaryCount.setText("" + military);
					unalloPeopleCounter.setText("" + peopleCount);
				}
			}
		});
		int [] scaledButtonaddMilitary = Main.scaledUIElements(606, 529, 59, 37, 1368, 912);
		addMilitaryButton.setBounds(scaledButtonaddMilitary[0], scaledButtonaddMilitary[1], scaledButtonaddMilitary[2], scaledButtonaddMilitary[3]);	
		addMilitaryButton.setBackground(new Color(192, 192, 192));
		int scaledAddMilitaryFont = Main.scaledFontSize(40, 1368, 912);
		addMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, scaledAddMilitaryFont));
		contentPane.add(addMilitaryButton);
		
		JButton minusMilitaryButton = new JButton("-");
		minusMilitaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (military > 0) {
					military = military - 1;
					peopleCount = peopleCount + 1; 

				}
				militaryCount.setText("" + military);
				unalloPeopleCounter.setText("" + peopleCount);
			}
		});
		int [] scaledButtonminusMilitary = Main.scaledUIElements(675, 529, 64, 37, 1368, 912);
		minusMilitaryButton.setBounds(scaledButtonminusMilitary[0], scaledButtonminusMilitary[1], scaledButtonminusMilitary[2], scaledButtonminusMilitary[3]);
		minusMilitaryButton.setBackground(new Color(192, 192, 192));
		int scaledMinusMilitaryFont = Main.scaledFontSize(40, 1368, 912);
		minusMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, scaledMinusMilitaryFont));
		contentPane.add(minusMilitaryButton);
		
		JButton addMinerButton = new JButton("+");
		addMinerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (peopleCount > 0) {
					peopleCount = peopleCount - 1; 
					miner = miner + 1;
					minerCount.setText("" + miner);
					unalloPeopleCounter.setText("" + peopleCount);	
				}
			}
		});
		int [] scaledButtonaddMiner = Main.scaledUIElements(1112, 184, 59, 37, 1368, 912);
		addMinerButton.setBounds(scaledButtonaddMiner[0], scaledButtonaddMiner[1], scaledButtonaddMiner[2], scaledButtonaddMiner[3]);
		addMinerButton.setBackground(new Color(192, 192, 192));
		int scaledAddMinerFont = Main.scaledFontSize(40, 1368, 912);
		addMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, scaledAddMinerFont));
		contentPane.add(addMinerButton);
		
		JButton minusMinerButton = new JButton("-");
		minusMinerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miner > 0) {
					miner = miner - 1;
					peopleCount = peopleCount + 1; 
				}
				minerCount.setText("" + miner);
				unalloPeopleCounter.setText("" + peopleCount);
			}
		});
		int [] scaledButtonminusMiner = Main.scaledUIElements(1112, 232, 59, 37, 1368, 912);
		minusMinerButton.setBounds(scaledButtonminusMiner[0], scaledButtonminusMiner[1], scaledButtonminusMiner[2], scaledButtonminusMiner[3]);
		minusMinerButton.setBackground(new Color(192, 192, 192));
		int scaledMinusMinerFont = Main.scaledFontSize(40, 1368, 912);
		minusMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, scaledMinusMinerFont));
		contentPane.add(minusMinerButton);
		
		JButton nextDayButton = new JButton("Next Day");
		int [] scaledButtonnextDay= Main.scaledUIElements(1080, 699, 132, 37, 1368, 912);
		nextDayButton.setBounds(scaledButtonnextDay[0], scaledButtonnextDay[1], scaledButtonnextDay[2], scaledButtonnextDay[3]);
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dayCounter = dayCounter + 1; 
				dayCounterLabel.setText("" + dayCounter);
				NextDayButton.nextDayButtonActivated();
				if (dayCounter == 31) {
					
				}
				}
			}
		);
		nextDayButton.setBackground(new Color(192, 192, 192));
		int scalednextDayFont = Main.scaledFontSize(20, 1368, 912);
		nextDayButton.setFont(new Font("Trebuchet MS", Font.BOLD, scalednextDayFont));
		contentPane.add(nextDayButton);
		
		JLabel researchLabel = new JLabel("Research");
		int [] scaledResearchLabel= Main.scaledUIElements(1097, 529, 153, 37, 1368, 912);
		researchLabel.setBounds(scaledResearchLabel[0], scaledResearchLabel[1], scaledResearchLabel[2], scaledResearchLabel[3]);
		researchLabel.setForeground(new Color(255, 255, 255));
		int scaledResearchLabelFont = Main.scaledFontSize(30, 1368, 912);
		researchLabel.setFont(new Font("Sitka Text", Font.BOLD, scaledResearchLabelFont));
		contentPane.add(researchLabel);
		
		JButton addResearchButton = new JButton("+");
		addResearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (peopleCount > 0) {
					peopleCount = peopleCount - 1; 
					research = research + 1;
					researchCount.setText("" + research);
					unalloPeopleCounter.setText("" + peopleCount);
				}
			}
		});
		int [] scaledButtonaddResearch= Main.scaledUIElements(1080, 557, 59, 37, 1368, 912);
		addResearchButton.setBounds(scaledButtonaddResearch[0], scaledButtonaddResearch[1], scaledButtonaddResearch[2], scaledButtonaddResearch[3]);
		int scaledaddResearchFont = Main.scaledFontSize(40, 1368, 912);
		addResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, scaledaddResearchFont));
		addResearchButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(addResearchButton);
		
		JButton minusResearchButton = new JButton("-");
		minusResearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (research > 0) {
					research = research - 1;
					peopleCount = peopleCount + 1; 
				}
				researchCount.setText("" + research);
				unalloPeopleCounter.setText("" + peopleCount);
			}
		});
		int [] scaledButtonminusResearch= Main.scaledUIElements(1153, 557, 59, 37, 1368, 912);
		minusResearchButton.setBounds(scaledButtonminusResearch[0], scaledButtonminusResearch[1], scaledButtonminusResearch[2], scaledButtonminusResearch[3]);
		int scaledminusResearchFont = Main.scaledFontSize(40, 1368, 912);
		minusResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, scaledminusResearchFont));
		minusResearchButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(minusResearchButton);
		
		JButton statsOpenButton = new JButton("Statistics");
		int [] scaledButtonstats= Main.scaledUIElements(458, 794, 182, 45, 1368, 912);
		statsOpenButton.setBounds(scaledButtonstats[0], scaledButtonstats[1], scaledButtonstats[2], scaledButtonstats[3]);
		statsOpenButton.setBackground(new Color(192, 192, 192));
		statsOpenButton.setForeground(new Color(0, 0, 0));
		int scaledopenStatsFont = Main.scaledFontSize(30, 1368, 912);
		statsOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, scaledopenStatsFont));
		statsOpenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsPopover.main(null);
				frame.setEnabled(false);
			}
		});
		
		contentPane.add(statsOpenButton);
		
		JButton tradeOpenButton = new JButton("Trade");
		int [] scaledButtontrade= Main.scaledUIElements(650, 794, 138, 44, 1368, 912);
		tradeOpenButton.setBounds(scaledButtontrade[0], scaledButtontrade[1], scaledButtontrade[2], scaledButtontrade[3]);
		tradeOpenButton.setBackground(new Color(192, 192, 192));
		tradeOpenButton.setForeground(new Color(0, 0, 0));
		int scaledopenTradeFont = Main.scaledFontSize(30, 1368, 912);
		tradeOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, scaledopenTradeFont));
		tradeOpenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TradingPopover.createTradingPopover(null);
				frame.setEnabled(false);
			}
		});
		contentPane.add(tradeOpenButton);
		
		JButton resarchOpenButton = new JButton("Research");
		int [] scaledButtonresearch= Main.scaledUIElements(798, 795, 182, 43, 1368, 912);
		resarchOpenButton.setBounds(scaledButtonresearch[0], scaledButtonresearch[1], scaledButtonresearch[2], scaledButtonresearch[3]);
		resarchOpenButton.setBackground(new Color(192, 192, 192));
		resarchOpenButton.setForeground(new Color(0, 0, 0));
		int scaledopenResearchFont = Main.scaledFontSize(30, 1368, 912);
		resarchOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, scaledopenResearchFont));
		resarchOpenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResearchPopover.createResearchPopover();
				frame.setEnabled(false);
			}
		});
		contentPane.add(resarchOpenButton);
		
		JButton militaryFindButton = new JButton("Military Search");
		militaryFindButton.setForeground(Color.BLACK);
		int scaledFindFont = Main.scaledFontSize(30, 1368, 912);
		militaryFindButton.setFont(new Font("Sitka Text", Font.PLAIN, scaledFindFont));
		militaryFindButton.setBackground(Color.LIGHT_GRAY);
		int [] scaledButtonFind = Main.scaledUIElements(193, 794, 246, 45, 1368, 912);
		militaryFindButton.setBounds(scaledButtonFind[0], scaledButtonFind[1], scaledButtonFind[2], scaledButtonFind[3]);
		contentPane.add(militaryFindButton);
		
		
	}
}
