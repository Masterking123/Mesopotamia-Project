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
	public double military; 
	public double farmer; 
	public double miner; 
	public double research; 
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
		
		JButton addFarmerButton = new JButton("+");
		int [] scaledButtonaddFarmer = Main.scaledUIElements(257, 256, 59, 31, 1368, 912);
		addFarmerButton.setBounds(scaledButtonaddFarmer[0], scaledButtonaddFarmer[1], scaledButtonaddFarmer[2], scaledButtonaddFarmer[3]);
		addFarmerButton.setBackground(new Color(192, 192, 192));
		addFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addFarmerButton);
		
		JButton minusFarmerButton = new JButton("-");
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
		int [] scaledlabelMiner = Main.scaledUIElements(1097, 129, 132, 44, 1368, 912);
		minerLabel.setBounds(scaledlabelMiner[0], scaledlabelMiner[1], scaledlabelMiner[2], scaledlabelMiner[3]);
		minerLabel.setForeground(new Color(255, 255, 255));
		minerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(minerLabel);
		
		JLabel militaryLabel = new JLabel("Military");
		int [] scaledlabelMilitary = Main.scaledUIElements(619, 474, 144, 44, 1368, 912);
		militaryLabel.setBounds(scaledlabelMilitary[0], scaledlabelMilitary[1], scaledlabelMilitary[2], scaledlabelMilitary[3]);
		militaryLabel.setForeground(new Color(255, 255, 255));
		militaryLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(militaryLabel);
		
		JButton addMinerButton = new JButton("+");
		int [] scaledButtonaddMiner = Main.scaledUIElements(606, 529, 59, 37, 1368, 912);
		addMinerButton.setBounds(scaledButtonaddMiner[0], scaledButtonaddMiner[1], scaledButtonaddMiner[2], scaledButtonaddMiner[3]);
		addMinerButton.setBackground(new Color(192, 192, 192));
		addMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addMinerButton);
		
		JButton minusMinerButton = new JButton("-");
		int [] scaledButtonminusMiner = Main.scaledUIElements(675, 529, 64, 37, 1368, 912);
		minusMinerButton.setBounds(scaledButtonminusMiner[0], scaledButtonminusMiner[1], scaledButtonminusMiner[2], scaledButtonminusMiner[3]);
		minusMinerButton.setBackground(new Color(192, 192, 192));
		minusMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(minusMinerButton);
		
		JButton addMilitaryButton = new JButton("+");
		int [] scaledButtonaddMilitary = Main.scaledUIElements(1112, 184, 59, 37, 1368, 912);
		addMilitaryButton.setBounds(scaledButtonaddMilitary[0], scaledButtonaddMilitary[1], scaledButtonaddMilitary[2], scaledButtonaddMilitary[3]);
		addMilitaryButton.setBackground(new Color(192, 192, 192));
		addMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addMilitaryButton);
		
		JButton minusMilitaryButton = new JButton("-");
		int [] scaledButtonminusMilitary = Main.scaledUIElements(1112, 232, 59, 37, 1368, 912);
		minusMilitaryButton.setBounds(scaledButtonminusMilitary[0], scaledButtonminusMilitary[1], scaledButtonminusMilitary[2], scaledButtonminusMilitary[3]);
		minusMilitaryButton.setBackground(new Color(192, 192, 192));
		minusMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(minusMilitaryButton);
		
		JButton nextDayButton = new JButton("Next Day");
		int [] scaledButtonnextDay= Main.scaledUIElements(1080, 699, 132, 37, 1368, 912);
		nextDayButton.setBounds(scaledButtonnextDay[0], scaledButtonnextDay[1], scaledButtonnextDay[2], scaledButtonnextDay[3]);
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
		int [] scaledResearchLabel= Main.scaledUIElements(1097, 529, 153, 37, 1368, 912);
		researchLabel.setBounds(scaledResearchLabel[0], scaledResearchLabel[1], scaledResearchLabel[2], scaledResearchLabel[3]);
		researchLabel.setForeground(new Color(255, 255, 255));
		researchLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(researchLabel);
		
		JButton addResearchButton = new JButton("+");
		int [] scaledButtonaddResearch= Main.scaledUIElements(1080, 557, 59, 37, 1368, 912);
		addResearchButton.setBounds(scaledButtonaddResearch[0], scaledButtonaddResearch[1], scaledButtonaddResearch[2], scaledButtonaddResearch[3]);
		addResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addResearchButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(addResearchButton);
		
		JButton minusResearchButton = new JButton("-");
		int [] scaledButtonminusResearch= Main.scaledUIElements(1153, 557, 59, 37, 1368, 912);
		minusResearchButton.setBounds(scaledButtonminusResearch[0], scaledButtonminusResearch[1], scaledButtonminusResearch[2], scaledButtonminusResearch[3]);
		minusResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusResearchButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(minusResearchButton);
		
		JButton statsOpenButton = new JButton("Statistics");
		int [] scaledButtonstats= Main.scaledUIElements(458, 794, 182, 45, 1368, 912);
		statsOpenButton.setBounds(scaledButtonstats[0], scaledButtonstats[1], scaledButtonstats[2], scaledButtonstats[3]);
		statsOpenButton.setBackground(new Color(192, 192, 192));
		statsOpenButton.setForeground(new Color(0, 0, 0));
		statsOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		statsOpenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		contentPane.add(statsOpenButton);
		
		JButton tradeOpenButton = new JButton("Trade");
		int [] scaledButtontrade= Main.scaledUIElements(650, 794, 138, 44, 1368, 912);
		tradeOpenButton.setBounds(scaledButtontrade[0], scaledButtontrade[1], scaledButtontrade[2], scaledButtontrade[3]);
		tradeOpenButton.setBackground(new Color(192, 192, 192));
		tradeOpenButton.setForeground(new Color(0, 0, 0));
		tradeOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		contentPane.add(tradeOpenButton);
		
		JButton resarchOpenButton = new JButton("Research");
		int [] scaledButtonresearch= Main.scaledUIElements(798, 795, 182, 43, 1368, 912);
		resarchOpenButton.setBounds(scaledButtonresearch[0], scaledButtonresearch[1], scaledButtonresearch[2], scaledButtonresearch[3]);
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
