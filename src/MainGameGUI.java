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
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton addFarmerButton = new JButton("+");
		sl_contentPane.putConstraint(SpringLayout.NORTH, addFarmerButton, 251, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, addFarmerButton, 252, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, addFarmerButton, 282, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, addFarmerButton, 311, SpringLayout.WEST, contentPane);
		addFarmerButton.setBackground(new Color(192, 192, 192));
		addFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addFarmerButton);
		
		JButton minusFarmerButton = new JButton("-");
		sl_contentPane.putConstraint(SpringLayout.NORTH, minusFarmerButton, 251, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, minusFarmerButton, 321, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, minusFarmerButton, 282, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, minusFarmerButton, 380, SpringLayout.WEST, contentPane);
		minusFarmerButton.setBackground(new Color(192, 192, 192));
		minusFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(minusFarmerButton);
		
		JLabel farmerLabel = new JLabel("Farmers");
		sl_contentPane.putConstraint(SpringLayout.NORTH, farmerLabel, 262, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, farmerLabel, 104, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, farmerLabel, 293, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, farmerLabel, 276, SpringLayout.WEST, contentPane);
		farmerLabel.setForeground(new Color(255, 255, 255));
		farmerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(farmerLabel);
		
		JLabel minerLabel = new JLabel("Miners");
		sl_contentPane.putConstraint(SpringLayout.NORTH, minerLabel, 124, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, minerLabel, 1092, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, minerLabel, 168, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, minerLabel, 1224, SpringLayout.WEST, contentPane);
		minerLabel.setForeground(new Color(255, 255, 255));
		minerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(minerLabel);
		
		JLabel militaryLabel = new JLabel("Military");
		sl_contentPane.putConstraint(SpringLayout.NORTH, militaryLabel, 469, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, militaryLabel, 614, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, militaryLabel, 513, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, militaryLabel, 758, SpringLayout.WEST, contentPane);
		militaryLabel.setForeground(new Color(255, 255, 255));
		militaryLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(militaryLabel);
		
		JButton addMinerButton = new JButton("+");
		sl_contentPane.putConstraint(SpringLayout.NORTH, addMinerButton, 524, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, addMinerButton, 601, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, addMinerButton, 561, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, addMinerButton, 660, SpringLayout.WEST, contentPane);
		addMinerButton.setBackground(new Color(192, 192, 192));
		addMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addMinerButton);
		
		JButton minusMinerButton = new JButton("-");
		sl_contentPane.putConstraint(SpringLayout.NORTH, minusMinerButton, 524, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, minusMinerButton, 670, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, minusMinerButton, 561, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, minusMinerButton, 734, SpringLayout.WEST, contentPane);
		minusMinerButton.setBackground(new Color(192, 192, 192));
		minusMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(minusMinerButton);
		
		JButton addMilitaryButton = new JButton("+");
		sl_contentPane.putConstraint(SpringLayout.NORTH, addMilitaryButton, 179, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, addMilitaryButton, 1107, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, addMilitaryButton, 216, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, addMilitaryButton, 1166, SpringLayout.WEST, contentPane);
		addMilitaryButton.setBackground(new Color(192, 192, 192));
		addMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(addMilitaryButton);
		
		JButton minusMilitaryButton = new JButton("-");
		sl_contentPane.putConstraint(SpringLayout.NORTH, minusMilitaryButton, 227, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, minusMilitaryButton, 1107, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, minusMilitaryButton, 264, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, minusMilitaryButton, 1166, SpringLayout.WEST, contentPane);
		minusMilitaryButton.setBackground(new Color(192, 192, 192));
		minusMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		contentPane.add(minusMilitaryButton);
		
		JButton nextDayButton = new JButton("Next Day");
		sl_contentPane.putConstraint(SpringLayout.NORTH, nextDayButton, 694, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, nextDayButton, 1075, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nextDayButton, 731, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, nextDayButton, 1207, SpringLayout.WEST, contentPane);
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomEventPopover.createNewRandomEventPopover();
			}
		});
		nextDayButton.setBackground(new Color(192, 192, 192));
		nextDayButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		contentPane.add(nextDayButton);
		
		JLabel researchLabel = new JLabel("Research");
		sl_contentPane.putConstraint(SpringLayout.NORTH, researchLabel, 524, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, researchLabel, 1092, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, researchLabel, 561, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, researchLabel, 1245, SpringLayout.WEST, contentPane);
		researchLabel.setForeground(new Color(255, 255, 255));
		researchLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		contentPane.add(researchLabel);
		
		JButton addResearchButton = new JButton("+");
		sl_contentPane.putConstraint(SpringLayout.NORTH, addResearchButton, 552, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, addResearchButton, 1075, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, addResearchButton, 589, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, addResearchButton, 1134, SpringLayout.WEST, contentPane);
		addResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addResearchButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(addResearchButton);
		
		JButton minusResearchButton = new JButton("-");
		sl_contentPane.putConstraint(SpringLayout.NORTH, minusResearchButton, 552, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, minusResearchButton, 1148, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, minusResearchButton, 589, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, minusResearchButton, 1207, SpringLayout.WEST, contentPane);
		minusResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusResearchButton.setBackground(Color.LIGHT_GRAY);
		contentPane.add(minusResearchButton);
		
		JButton statsOpenButton = new JButton("Statistics");
		sl_contentPane.putConstraint(SpringLayout.EAST, statsOpenButton, -779, SpringLayout.EAST, contentPane);
		statsOpenButton.setBackground(new Color(192, 192, 192));
		statsOpenButton.setForeground(new Color(0, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, statsOpenButton, -94, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, statsOpenButton, -49, SpringLayout.SOUTH, contentPane);
		statsOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		statsOpenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		contentPane.add(statsOpenButton);
		
		JButton tradeOpenButton = new JButton("Trade");
		sl_contentPane.putConstraint(SpringLayout.NORTH, tradeOpenButton, 2, SpringLayout.NORTH, statsOpenButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, tradeOpenButton, 0, SpringLayout.WEST, addMinerButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tradeOpenButton, 46, SpringLayout.NORTH, statsOpenButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, tradeOpenButton, -31, SpringLayout.EAST, militaryLabel);
		tradeOpenButton.setBackground(new Color(192, 192, 192));
		tradeOpenButton.setForeground(new Color(0, 0, 0));
		tradeOpenButton.setFont(new Font("Sitka Text", Font.PLAIN, 30));
		contentPane.add(tradeOpenButton);
		
		JButton resarchOpenButton = new JButton("Research");
		sl_contentPane.putConstraint(SpringLayout.NORTH, resarchOpenButton, 2, SpringLayout.NORTH, statsOpenButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, resarchOpenButton, 12, SpringLayout.EAST, tradeOpenButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, resarchOpenButton, 0, SpringLayout.SOUTH, statsOpenButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, resarchOpenButton, -386, SpringLayout.EAST, contentPane);
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
