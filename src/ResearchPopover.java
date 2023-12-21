import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class ResearchPopover extends JFrame {

	public JPanel contentPane;
	private static JLabel ptsLabel;
	private static double research = PlayerObject.research;
	public static ResearchPopover frame;
	public static JButton waterFilterButton;
	public static JButton sToolsButton;
	public static JButton sSeedsButton;
	public static JButton exFarmButton;
	public static JButton exitResButton;
	public static JButton stoneToolsButton;
	public static JButton eSafetyButton;
	public static JButton ironToolsButton;
	public static JButton goldButton;
	public static JButton lArmButton;
	public static JButton hArmourButton;
	public static JButton blackButton;
	public static JButton spyButton;
	public static JButton sale1Button;
	public static JButton sale2Button;
	public static JButton sale3Button;
	public static JButton sale4Button;

	/**
	 * Launch the application.
	 */
	public static void createResearchPopover() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ResearchPopover();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void popUp() {
		JOptionPane.showMessageDialog( null, "Not enough Points");
	}
	
	

	/**
	 * Create the frame.
	 */
	public ResearchPopover() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
			}
			
		});
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ptsLabel = new JLabel("Points: " + research);
		ptsLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		ptsLabel.setBounds(16, 16, 204, 28);
		contentPane.add(ptsLabel);
		
		JLabel resaerchTitle = new JLabel("Research");
		resaerchTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
		resaerchTitle.setBounds(281, 6, 165, 38);
		contentPane.add(resaerchTitle);
		
		JLabel farmLabel = new JLabel("Farming");
		farmLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		farmLabel.setBounds(99, 74, 81, 22);
		contentPane.add(farmLabel);
		
		JLabel salesLabel = new JLabel("Sales");
		salesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		salesLabel.setBounds(611, 74, 61, 22);
		contentPane.add(salesLabel);
		
		JLabel mineLabel = new JLabel("Mining");
		mineLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		mineLabel.setBounds(268, 74, 61, 22);
		contentPane.add(mineLabel);
		
		JLabel milataryLabel = new JLabel("Military");
		milataryLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		milataryLabel.setBounds(442, 74, 81, 22);
		contentPane.add(milataryLabel);
		
		waterFilterButton = new JButton("Water Filter");
		waterFilterButton.setBounds(73, 153, 117, 45);
		contentPane.add(waterFilterButton);
		
		sToolsButton = new JButton("Stone Tools");
		sToolsButton.setBounds(73, 222, 117, 45);
		contentPane.add(sToolsButton);
		
		sSeedsButton = new JButton("Super Seeds");
		sSeedsButton.setBounds(73, 292, 117, 45);
		contentPane.add(sSeedsButton);
		
		exFarmButton = new JButton("Expanded Farm");
		exFarmButton.setBounds(73, 364, 117, 45);
		contentPane.add(exFarmButton);
		
		
		JLabel pts3Label = new JLabel("3 Points");
		pts3Label.setBounds(6, 166, 61, 16);
		contentPane.add(pts3Label);
		
		JLabel pts6Label = new JLabel("6 Points");
		pts6Label.setBounds(6, 235, 61, 16);
		contentPane.add(pts6Label);
		
		JLabel pts9Label = new JLabel("9 Points");
		pts9Label.setBounds(6, 305, 61, 16);
		contentPane.add(pts9Label);
		
		JLabel pts12Label = new JLabel("12 Points");
		pts12Label.setBounds(6, 377, 61, 16);
		contentPane.add(pts12Label);
		
		exitResButton = new JButton("Exit"); //exit button
		exitResButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainGameGUI.frame.setEnabled(true);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
			}
		});
		exitResButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		exitResButton.setBounds(667, 6, 77, 38);
		contentPane.add(exitResButton);
		
		stoneToolsButton = new JButton("Stone Tools");
		stoneToolsButton.setToolTipText("10% more food");
		stoneToolsButton.setBounds(235, 153, 117, 45);
		contentPane.add(stoneToolsButton);
		
		eSafetyButton = new JButton("Extra Safety");
		eSafetyButton.setEnabled(false);
		eSafetyButton.setBounds(235, 222, 117, 45);
		contentPane.add(eSafetyButton);
		
		ironToolsButton = new JButton("Iron Tools");
		ironToolsButton.setEnabled(false);
		ironToolsButton.setBounds(235, 292, 117, 45);
		contentPane.add(ironToolsButton);
		
		goldButton = new JButton("Gold Mine");
		goldButton.setEnabled(false);
		goldButton.setBounds(235, 364, 117, 45);
		contentPane.add(goldButton);
		
	    lArmButton = new JButton("Light Armour");
		lArmButton.setBounds(418, 153, 117, 45);
		contentPane.add(lArmButton);
		
		hArmourButton = new JButton("Heavy Armour");
		hArmourButton.setEnabled(false);
		hArmourButton.setBounds(418, 222, 117, 45);
		contentPane.add(hArmourButton);
		
		blackButton = new JButton("Master Blacksmith");
		blackButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		blackButton.setEnabled(false);
		blackButton.setBounds(418, 292, 117, 45);
		contentPane.add(blackButton);
		
		spyButton = new JButton("Spies");
		spyButton.setEnabled(false);
		spyButton.setBounds(418, 364, 117, 45);
		contentPane.add(spyButton);
		
		sale1Button = new JButton("Makret Sale 1");
		sale1Button.setBounds(579, 153, 117, 45);
		contentPane.add(sale1Button);
		
		sale2Button = new JButton("Market Sale 2");
		sale2Button.setEnabled(false);
		sale2Button.setBounds(579, 222, 117, 45);
		contentPane.add(sale2Button);
		
		sale3Button = new JButton("Market Sale 3");
		sale3Button.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		sale3Button.setEnabled(false);
		sale3Button.setBounds(579, 292, 117, 45);
		contentPane.add(sale3Button);
		
		sale4Button = new JButton("Market Sale 4");
		sale4Button.setEnabled(false);
		sale4Button.setBounds(579, 364, 117, 45);
		contentPane.add(sale4Button);
		
		
		
		waterFilterButton.setToolTipText("10% more food");
		sToolsButton.setToolTipText("+25 food per day");
		sSeedsButton.setToolTipText("40% more food");
		exFarmButton.setToolTipText("2x more food per person");
		
		stoneToolsButton.setToolTipText("+10 resources per day");
		eSafetyButton.setToolTipText("25% more resources");
		ironToolsButton.setToolTipText("75% more resources");
		goldButton.setToolTipText("+400 resources");
		
		lArmButton.setToolTipText("+20 attack");
		hArmourButton.setToolTipText("+45 attack");
		blackButton.setToolTipText("60% more attack");
		spyButton.setToolTipText("+200 attack");
		
		sale1Button.setToolTipText("10% off on all trades");
		sale2Button.setToolTipText("20% off on all trades");
		sale3Button.setToolTipText("30% off on all trades");
		sale4Button.setToolTipText("40% off on all trades");
		
		
		
		//------------------Farming section------------------//
		waterFilterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 3) {
					research = research -3;
					waterFilterButton.setEnabled(false);
					sToolsButton.setEnabled(true);
					ptsLabel.setText("Points: " + research);
					PlayerObject.percentFoodBoost = 10;
					PlayerObject.researchApplied[0] = "waterFilter";
				}
				else {
					popUp();
				}
			}});
		sToolsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 6) {
					research = research - 6;
					sToolsButton.setEnabled(false);
					sSeedsButton.setEnabled(true);
					ptsLabel.setText("Points: " + research);
					PlayerObject.numberFoodBoost = 25;
					PlayerObject.researchApplied[1] = "sTools";
				}
				else {
					popUp();
				}
			}});
		sSeedsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 6) {
					research = research - 6;
					sSeedsButton.setEnabled(false);
					exFarmButton.setEnabled(true);
					ptsLabel.setText("Points: " + research);
					PlayerObject.percentFoodBoost = 40;
					PlayerObject.researchApplied[2] = "sSeeds";
				}
				else {
					popUp();
				}
			}});
		exFarmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 12) {
					research = research - 12;
					exFarmButton.setEnabled(false);
					ptsLabel.setText("Points: " + research);
					PlayerObject.percentFoodBoost = 100;
					PlayerObject.researchApplied[3] = "exFarm";
				}
				else {
					popUp();
				}
			}});
		//------------------Mining section------------------//
		stoneToolsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 3) {
					research = research -3;
					stoneToolsButton.setEnabled(false);
					eSafetyButton.setEnabled(true);
					ptsLabel.setText("Points: " + research);
					PlayerObject.numberMiningAndWoodBoost = 10;
					PlayerObject.researchApplied[4] = "stoneTools";
				}
				else {
					popUp();
				}
			}});
		eSafetyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 6) {
					research = research - 6;
					eSafetyButton.setEnabled(false);
					ironToolsButton.setEnabled(true);
					ptsLabel.setText("Points: " + research);
					PlayerObject.percentMiningAndWoodBoost = 25;
					PlayerObject.researchApplied[5] = "eSafety";
				}
				else {
					popUp();
				}
			}});
		ironToolsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 6) {
					research = research - 6;
					ironToolsButton.setEnabled(false);
					goldButton.setEnabled(true);
					ptsLabel.setText("Points: " + research);
					PlayerObject.percentMiningAndWoodBoost = 75;
					PlayerObject.researchApplied[6] = "ironTools";
				}
				else {
					popUp();
				}
			}});
		goldButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 12) {
					research = research - 12;
					goldButton.setEnabled(false);
					ptsLabel.setText("Points: " + research);
					PlayerObject.oneTimeMiningAndWoodBoost = 400;
					PlayerObject.researchApplied[7] = "gold";
				}
				else {
					popUp();
				}
			}});
		
		//-----------------Military section------------------//
		lArmButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(research >= 3) {
							research = research -3;
							lArmButton.setEnabled(false);
							hArmourButton.setEnabled(true);
							ptsLabel.setText("Points: " + research);
							PlayerObject.numberMilitaryBoost = 20;
							PlayerObject.researchApplied[8] = "lArm";
						}
						else {
							popUp();
						}
					}});
		hArmourButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(research >= 6) {
							research = research - 6;
							hArmourButton.setEnabled(false);
							blackButton.setEnabled(true);
							ptsLabel.setText("Points: " + research);
							PlayerObject.numberMilitaryBoost = 45;
							PlayerObject.researchApplied[9] = "hArm";
						}
						else {
							popUp();
						}
					}});
		blackButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(research >= 6) {
							research = research - 6;
							blackButton.setEnabled(false);
							spyButton.setEnabled(true);
							ptsLabel.setText("Points: " + research);
							PlayerObject.percentMilitaryBoost = 60;
							PlayerObject.researchApplied[10] = "black";
						}
						else {
							popUp();
						}
					}});
		spyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(research >= 12) {
							research = research - 12;
							spyButton.setEnabled(false);
							ptsLabel.setText("Points: " + research);
							PlayerObject.numberMilitaryBoost = 200;
							PlayerObject.researchApplied[11] = "spy";
						}
						else {
							popUp();
						}
					}});
		
		//-----------------Sales section------------------//
		sale1Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(research >= 3) {
							research = research -3;
							sale1Button.setEnabled(false);
							sale2Button.setEnabled(true);
							ptsLabel.setText("Points: " + research);
							PlayerObject.percentDiscountOnSales = 10;
							PlayerObject.researchApplied[12] = "sale1";
						}
						else {
							popUp();
						}
					}});
		sale2Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(research >= 6) {
							research = research - 6;
							sale2Button.setEnabled(false);
							sale3Button.setEnabled(true);
							ptsLabel.setText("Points: " + research);
							PlayerObject.percentDiscountOnSales = 20;
							PlayerObject.researchApplied[13] = "sale2";
						}
						else {
							popUp();
						}
					}});
		sale3Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(research >= 6) {
							research = research - 6;
							sale3Button.setEnabled(false);
							sale4Button.setEnabled(true);
							ptsLabel.setText("Points: " + research);
							PlayerObject.percentDiscountOnSales = 30;
							PlayerObject.researchApplied[14] = "sale3";
						}
						else {
							popUp();
						}
					}});
		sale4Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(research >= 12) {
							research = research - 12;
							sale4Button.setEnabled(false);
							ptsLabel.setText("Points: " + research);
							PlayerObject.percentDiscountOnSales = 40;
							PlayerObject.researchApplied[15] = "sale4";
						}
						else {
							popUp();
						}
					}});
		
		sToolsButton.setEnabled(false);
		sSeedsButton.setEnabled(false);
		exFarmButton.setEnabled(false);
		
		eSafetyButton.setEnabled(false);
		ironToolsButton.setEnabled(false);
		goldButton.setEnabled(false);
		
		hArmourButton.setEnabled(false);
		blackButton.setEnabled(false);
		spyButton.setEnabled(false);
		
		sale2Button.setEnabled(false);
		sale3Button.setEnabled(false);
		sale4Button.setEnabled(false);
		
		//famring section
		if(PlayerObject.researchApplied[0] == "waterFilter") {
			waterFilterButton.setEnabled(false);
			sToolsButton.setEnabled(true);
			PlayerObject.percentFoodBoost = 10;
		}
		if(PlayerObject.researchApplied[1] == "sTools") {
			sToolsButton.setEnabled(false);
			sSeedsButton.setEnabled(true);
			PlayerObject.numberFoodBoost = 25;
		}
		if(PlayerObject.researchApplied[2] == "sSeeds") {
			sToolsButton.setEnabled(false);
			sSeedsButton.setEnabled(true);
			PlayerObject.numberFoodBoost = 25;
		}
		if(PlayerObject.researchApplied[3] == "exFarm") {
			exFarmButton.setEnabled(false);
			PlayerObject.percentFoodBoost = 100;
		}
		
		//mining section
		if(PlayerObject.researchApplied[4] == "stoneTools") {
			stoneToolsButton.setEnabled(false);
			eSafetyButton.setEnabled(true);
			PlayerObject.numberMiningAndWoodBoost = 10;
		}
		if(PlayerObject.researchApplied[5] == "eSafety") {
			eSafetyButton.setEnabled(false);
			ironToolsButton.setEnabled(true);
			PlayerObject.percentMiningAndWoodBoost = 25;
		}
		if(PlayerObject.researchApplied[6] == "ironTools") {
			ironToolsButton.setEnabled(false);
			goldButton.setEnabled(true);
			PlayerObject.percentMiningAndWoodBoost = 75;
		}
		if(PlayerObject.researchApplied[7] == "gold") {
			goldButton.setEnabled(false);
			PlayerObject.oneTimeMiningAndWoodBoost = 400;
		}
		
		//miltary section
		if(PlayerObject.researchApplied[8] == "lArm") {
			lArmButton.setEnabled(false);
			hArmourButton.setEnabled(true);
			PlayerObject.numberMilitaryBoost = 20;
		}
		if(PlayerObject.researchApplied[9] == "hArm") {
			hArmourButton.setEnabled(false);
			blackButton.setEnabled(true);
			PlayerObject.numberMilitaryBoost = 45;
		}
		if(PlayerObject.researchApplied[10] == "black") {
			blackButton.setEnabled(false);
			spyButton.setEnabled(true);
			PlayerObject.percentMilitaryBoost = 60;
		}
		if(PlayerObject.researchApplied[11] == "spy") {
			spyButton.setEnabled(false);
			PlayerObject.numberMilitaryBoost = 200;
		}
		
		//sales section
		if(PlayerObject.researchApplied[12] == "sale1") {
			sale1Button.setEnabled(false);
			sale2Button.setEnabled(true);
			PlayerObject.percentDiscountOnSales = 10;
		}
		if(PlayerObject.researchApplied[13] == "sale2") {
			sale2Button.setEnabled(false);
			sale3Button.setEnabled(true);
			PlayerObject.percentDiscountOnSales = 20;
		}
		if(PlayerObject.researchApplied[14] == "sale3") {
			sale3Button.setEnabled(false);
			sale4Button.setEnabled(true);
			PlayerObject.percentDiscountOnSales = 30;
		}
		if(PlayerObject.researchApplied[15] == "sale4") {
			sale4Button.setEnabled(false);
			PlayerObject.percentDiscountOnSales = 40;
		}
		

	}
}
