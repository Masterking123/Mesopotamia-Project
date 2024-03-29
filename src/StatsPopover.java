
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.SwingConstants;

public class StatsPopover extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private static StatsPopover frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsPopover frame = new StatsPopover();
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
	public StatsPopover() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
			}
			
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 49, 438, 217);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel statPanel = new JPanel();
		layeredPane.add(statPanel, "name_1058514652877473");
		statPanel.setLayout(null);
		
		JLabel statsLabel = new JLabel("Stats");
		statsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		statsLabel.setBounds(0, 6, 132, 22);
		statPanel.add(statsLabel);
		
		JPanel ratePanel = new JPanel();
		layeredPane.add(ratePanel, "name_1058500122019973");
		ratePanel.setLayout(null);
		
		JLabel ratesLabel = new JLabel("Rates/Boosts");
		ratesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ratesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		ratesLabel.setBounds(150, 6, 132, 22);
		ratePanel.add(ratesLabel);
		
		JButton statButton = new JButton("Stats/Quota");
		statButton.setBounds(101, 6, 117, 29);
		contentPane.add(statButton);
		
		JButton ratesButton = new JButton("Rates/Boosts");
		ratesButton.setBounds(230, 6, 117, 29);
		contentPane.add(ratesButton);
		
		switchButton(statButton, statPanel);
		
		JLabel foodStatLabel = new JLabel("Food: " + PlayerObject.food);
		foodStatLabel.setBounds(6, 36, 157, 16);
		statPanel.add(foodStatLabel);
		
		JLabel resStatLabel = new JLabel("Resources: " + PlayerObject.miningAndWood);
		resStatLabel.setBounds(6, 64, 157, 16);
		statPanel.add(resStatLabel);
		
		JLabel popStatLabel = new JLabel("Population: " + PlayerObject.totalPeople);
		popStatLabel.setBounds(6, 92, 157, 16);
		statPanel.add(popStatLabel);
		
		JLabel repStatLabel = new JLabel("Reputation: " + PlayerObject.reputation);
		repStatLabel.setBounds(6, 120, 157, 16);
		statPanel.add(repStatLabel);
		
		JLabel res2StatLabel = new JLabel("Research: " + PlayerObject.research);
		res2StatLabel.setBounds(6, 148, 157, 16);
		statPanel.add(res2StatLabel);
		
		JLabel comStatLabel = new JLabel("Combat Power: " + PlayerObject.military);
		comStatLabel.setBounds(6, 176, 157, 16);
		statPanel.add(comStatLabel);
		
		JLabel foodPpersonLabel = new JLabel("Warning");
		foodPpersonLabel.setBounds(175, 40, 257, 33);
		statPanel.add(foodPpersonLabel);
		switchButton(ratesButton, ratePanel);
		
		JLabel boostSubLabel = new JLabel("Boosts");
		boostSubLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		boostSubLabel.setBounds(32, 25, 61, 16);
		ratePanel.add(boostSubLabel);
		
		JLabel foodBoostLabel = new JLabel("Food: " + PlayerObject.percentFoodBoost + "%");
		foodBoostLabel.setBounds(6, 55, 157, 16);
		ratePanel.add(foodBoostLabel);
		
		JLabel resBoostLabel = new JLabel("Resources: " + PlayerObject.percentMiningAndWoodBoost + "%");
		resBoostLabel.setBounds(6, 83, 157, 16);
		ratePanel.add(resBoostLabel);
		
		JLabel res2BoostLabel = new JLabel("Research: " + PlayerObject.percentResearchBoost + "%");
		res2BoostLabel.setBounds(6, 111, 157, 16);
		ratePanel.add(res2BoostLabel);
		
		JLabel comBoostLabel = new JLabel("Combat Power: " + PlayerObject.percentMilitaryBoost + "%");
		comBoostLabel.setBounds(6, 139, 157, 16);
		ratePanel.add(comBoostLabel);
		
		JLabel salesBoostLabel = new JLabel("Sales: " + PlayerObject.percentDiscountOnSales + "%");
		salesBoostLabel.setBounds(6, 167, 157, 16);
		ratePanel.add(salesBoostLabel);
		
		JLabel ratesSubLabel = new JLabel("Rates");
		ratesSubLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		ratesSubLabel.setBounds(301, 25, 61, 16);
		ratePanel.add(ratesSubLabel);
		
		double foodStat = (((PlayerObject.peopleInFood * 10) * (1 + (double) (PlayerObject.percentFoodBoost / 100.0))) + PlayerObject.numberFoodBoost);
		if(PlayerObject.peopleInFood == 0) {
			foodStat = 0;
		}
		JLabel foodRateLabel = new JLabel("Food: " + foodStat + "/day");
		foodRateLabel.setBounds(275, 55, 157, 16);
		ratePanel.add(foodRateLabel);
		
		double resourceStat = ((PlayerObject.peopleInMiningAndWood * 10) * (1 + (double) (PlayerObject.percentMiningAndWoodBoost / 100.0))) + PlayerObject.numberMiningAndWoodBoost + PlayerObject.oneTimeMiningAndWoodBoost;
		if(PlayerObject.peopleInMiningAndWood == 0) {
			resourceStat = 0;
		}
		JLabel resRateLabel = new JLabel("Resources: " + resourceStat + "/day");
		resRateLabel.setBounds(275, 83, 157, 16);
		ratePanel.add(resRateLabel);
		
		double researchStat = PlayerObject.peopleInResearch * (1 + (double) (PlayerObject.percentResearchBoost / 100.0)) + PlayerObject.numberResearchBoost;
		if(PlayerObject.peopleInResearch == 0) {
			researchStat = 0;
		}
		JLabel res2RateLabel = new JLabel("Research: " + researchStat + "/day");
		res2RateLabel.setBounds(275, 111, 157, 16);
		ratePanel.add(res2RateLabel);
		
		double combatStat = (PlayerObject.peopleInMilitary * 2) * (1 + (double) (PlayerObject.percentFoodBoost / 100.0)) + PlayerObject.numberMilitaryBoost;
		if(PlayerObject.peopleInMilitary == 0) {
			combatStat = 0;
		}
		JLabel comRateLabel = new JLabel("Combat Power: " + combatStat + "/day");
		comRateLabel.setBounds(275, 139, 157, 16);
		ratePanel.add(comRateLabel);
		foodPpersonLabel.setVisible(false);
		
			foodPpersonLabel.setVisible(true);
			foodPpersonLabel.setText("Food Goal: " + (PlayerObject.totalPeople * 3));
			
			JLabel resPpersonLabel = new JLabel("Resources Goal: " + (PlayerObject.totalPeople * 2));
			resPpersonLabel.setBounds(175, 74, 257, 16);
			statPanel.add(resPpersonLabel);
			
			double foodGeneratedInADay = ((PlayerObject.peopleInFood * 10) * (1 + (double) (PlayerObject.percentFoodBoost / 100.0))) + PlayerObject.numberFoodBoost;
			if(PlayerObject.peopleInFood == 0) {
				foodGeneratedInADay = 0;
			}
			double moreFoodNeeded = PlayerObject.totalPeople * 3 - PlayerObject.food - foodGeneratedInADay;
			if(moreFoodNeeded <= 0) {
				moreFoodNeeded = 0;
			}
			JLabel foodLessLabel = new JLabel("More Food Needed: " + moreFoodNeeded);
			foodLessLabel.setBounds(175, 102, 257, 16);
			statPanel.add(foodLessLabel);
			
			
			double resourcesGeneratedInADay = ((PlayerObject.peopleInMiningAndWood * 10) * (1 + (double) (PlayerObject.percentMiningAndWoodBoost / 100.0))) + PlayerObject.numberMiningAndWoodBoost + PlayerObject.oneTimeMiningAndWoodBoost;
			if(PlayerObject.peopleInMiningAndWood == 0) {
				resourcesGeneratedInADay = 0;
			}
			double moreResourcesNeeded = (PlayerObject.totalPeople * 2) - PlayerObject.miningAndWood - resourcesGeneratedInADay;
			if (moreResourcesNeeded <= 0) {
				moreResourcesNeeded = 0;
			}
			JLabel resLessLabel = new JLabel("More Resources Needed: " + moreResourcesNeeded);
			resLessLabel.setBounds(175, 130, 257, 16);
			statPanel.add(resLessLabel);
			
			JLabel quotaLabel = new JLabel("Quota");
			quotaLabel.setHorizontalAlignment(SwingConstants.CENTER);
			quotaLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			quotaLabel.setBounds(175, 6, 132, 22);
			statPanel.add(quotaLabel);

	}
}
