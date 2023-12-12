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

	private JPanel contentPane;
	private JLabel ptsLabel;
	private double research = PlayerObject.research;
	private static ResearchPopover frame;

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
	
	void popUp() {
		JOptionPane.showMessageDialog(this, "Not enough Points");
	}
	
//	void skillItem(JButton button, int price, JButton nextButton, PlayerObject variable, int value) {	
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(research >= price) {
//					research = research - price;
//					button.setEnabled(false);
//					nextButton.setEnabled(true);
//					ptsLabel.setText("Points: " + research);
//					PlayerObject.variable = value;
//				}
//				else {
//					popUp();
//				}
//			}});
//		
//	}
//	
	

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
		
		JButton waterFilterButton = new JButton("Water Filter");
		waterFilterButton.setBounds(73, 153, 117, 45);
		contentPane.add(waterFilterButton);
		
		JButton sToolsButton = new JButton("Stone Tools");
		sToolsButton.setBounds(73, 222, 117, 45);
		contentPane.add(sToolsButton);
		
		JButton sSeedsButton = new JButton("Super Seeds");
		sSeedsButton.setBounds(73, 292, 117, 45);
		contentPane.add(sSeedsButton);
		
		JButton exFarmButton = new JButton("Expanded Farm");
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
		
		JButton exitResButton = new JButton("Exit"); //exit button
		exitResButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		exitResButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		exitResButton.setBounds(667, 6, 77, 38);
		contentPane.add(exitResButton);
		
		JButton stoneToolsButton = new JButton("Stone Tools");
		stoneToolsButton.setToolTipText("10% more food");
		stoneToolsButton.setBounds(235, 153, 117, 45);
		contentPane.add(stoneToolsButton);
		
		JButton eSafetyButton = new JButton("Extra Safety");
		eSafetyButton.setEnabled(false);
		eSafetyButton.setBounds(235, 222, 117, 45);
		contentPane.add(eSafetyButton);
		
		JButton ironToolsButton = new JButton("Iron Tools");
		ironToolsButton.setEnabled(false);
		ironToolsButton.setBounds(235, 292, 117, 45);
		contentPane.add(ironToolsButton);
		
		JButton goldButton = new JButton("Gold Mine");
		goldButton.setEnabled(false);
		goldButton.setBounds(235, 364, 117, 45);
		contentPane.add(goldButton);
		
		JButton lArmButton = new JButton("Light Armour");
		lArmButton.setBounds(418, 153, 117, 45);
		contentPane.add(lArmButton);
		
		JButton hArmourButton = new JButton("Heavy Armour");
		hArmourButton.setEnabled(false);
		hArmourButton.setBounds(418, 222, 117, 45);
		contentPane.add(hArmourButton);
		
		JButton blackButton = new JButton("Master Blacksmith");
		blackButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		blackButton.setEnabled(false);
		blackButton.setBounds(418, 292, 117, 45);
		contentPane.add(blackButton);
		
		JButton spyButton = new JButton("Spies");
		spyButton.setEnabled(false);
		spyButton.setBounds(418, 364, 117, 45);
		contentPane.add(spyButton);
		
		JButton sale1Button = new JButton("Makret Sale 1");
		sale1Button.setBounds(579, 153, 117, 45);
		contentPane.add(sale1Button);
		
		JButton sale2Button = new JButton("Market Sale 2");
		sale2Button.setEnabled(false);
		sale2Button.setBounds(579, 222, 117, 45);
		contentPane.add(sale2Button);
		
		JButton sale3Button = new JButton("Market Sale 3");
		sale3Button.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		sale3Button.setEnabled(false);
		sale3Button.setBounds(579, 292, 117, 45);
		contentPane.add(sale3Button);
		
		JButton sale4Button = new JButton("Market Sale 4");
		sale4Button.setEnabled(false);
		sale4Button.setBounds(579, 364, 117, 45);
		contentPane.add(sale4Button);
		
		//------------------Farming section------------------//
		waterFilterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(research >= 3) {
					research = research -3;
					waterFilterButton.setEnabled(false);
					sToolsButton.setEnabled(true);
					ptsLabel.setText("Points: " + research);
					PlayerObject.percentFoodBoost = 10;
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
	}
}
