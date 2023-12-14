import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;



public class TradingPopover extends JFrame {

	/*
	public static double miningAndWood;
	public static double food;
	public static double military;
	public static double research;
	public static int totalPeople;
*/
	int counterVillager = 0;
	int counterreasrerch = 0;
	double countertosave1 = PlayerObject.food;
	double countertosave = PlayerObject.miningAndWood;
	double countertosave2 = PlayerObject.research;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void createTradingPopover(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TradingPopover frame = new TradingPopover();
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
	public TradingPopover() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
			}
			
		});
		setBounds(100, 100, 791, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		setContentPane(contentPane);
		JButton backtradebutton = new JButton("Go Back");
		backtradebutton.setBounds(23, 414, 85, 21);
		backtradebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		contentPane.add(backtradebutton);
		
		JButton Tradebutton = new JButton("Trade");
		Tradebutton.setBounds(682, 414, 85, 21);
		contentPane.add(Tradebutton);
		
		JLabel lblNewLabel = new JLabel("Food trade");
		lblNewLabel.setBounds(224, 80, 64, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Villager marketing");
		lblNewLabel_1.setBounds(44, 76, 108, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Trading screen");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(325, 10, 153, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Resource trade");
		lblNewLabel_3.setBounds(391, 80, 96, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Reaserch points");
		lblNewLabel_4.setBounds(593, 80, 100, 13);
		contentPane.add(lblNewLabel_4);
		
		JTextArea villigarmarketing_textbox = new JTextArea();
		villigarmarketing_textbox.setFont(new Font("Arial", Font.PLAIN, 11));
		villigarmarketing_textbox.setEditable(false);
		villigarmarketing_textbox.setBounds(23, 96, 129, 67);
		contentPane.add(villigarmarketing_textbox);
		
		JTextArea Foodtextarea = new JTextArea();
		Foodtextarea.setFont(new Font("Arial", Font.PLAIN, 11));
		Foodtextarea.setEditable(false);
		Foodtextarea.setBounds(191, 96, 129, 67);
		contentPane.add(Foodtextarea);
		
		JTextArea Recoursetextarea = new JTextArea();
		Recoursetextarea.setFont(new Font("Arial", Font.PLAIN, 11));
		Recoursetextarea.setEditable(false);
		Recoursetextarea.setBounds(375, 96, 129, 67);
		contentPane.add(Recoursetextarea);
		
		JTextArea Reasechpointstextarea = new JTextArea();
		Reasechpointstextarea.setFont(new Font("Arial", Font.PLAIN, 11));
		Reasechpointstextarea.setEditable(false);
		Reasechpointstextarea.setBounds(575, 99, 129, 64);
		contentPane.add(Reasechpointstextarea);
		
		JButton villageradd = new JButton("+");
		villageradd.setBounds(44, 176, 49, 21);
		contentPane.add(villageradd);
		
		JButton villagerSubtract = new JButton("-");
		villagerSubtract.setBounds(90, 176, 49, 21);
		contentPane.add(villagerSubtract);
		
		JButton foodAdd = new JButton("+");
		foodAdd.setBounds(201, 176, 51, 21);
		contentPane.add(foodAdd);
		
		JButton foodSubtract = new JButton("-");
		foodSubtract.setBounds(249, 176, 49, 21);
		contentPane.add(foodSubtract);
		
		JButton resourcesAdd = new JButton("+");
		resourcesAdd.setBounds(391, 176, 49, 21);
		contentPane.add(resourcesAdd);
		
		JButton resourcesSubtract = new JButton("-");
		resourcesSubtract.setBounds(439, 176, 49, 21);
		contentPane.add(resourcesSubtract);
		
		JButton Reaserchadd = new JButton("+");
		Reaserchadd.setBounds(595, 173, 51, 21);
		contentPane.add(Reaserchadd);
		
		JButton Reaserchsubtract = new JButton("-");
		Reaserchsubtract.setBounds(644, 173, 49, 21);
		contentPane.add(Reaserchsubtract);
		
		JTextArea Testareamaintrade = new JTextArea();
		Testareamaintrade.setEditable(false);
		Testareamaintrade.setBounds(172, 230, 423, 190);
		contentPane.add(Testareamaintrade);
		
		JLabel Tradingtextbox = new JLabel("Trading text box");
		Tradingtextbox.setBounds(326, 207, 152, 13);
		contentPane.add(Tradingtextbox);
		
		
		// Village marketing textbox
		villigarmarketing_textbox.append("Food: " + PlayerObject.food + "\n" + "Total People: " + PlayerObject.totalPeople + "\n");
		villigarmarketing_textbox.append("1 villager = 2 food");
		
		// food tradingtextbox
		Foodtextarea.append("Resources: " + PlayerObject.miningAndWood + "\n" + "Food: " + PlayerObject.food + "\n");
		Foodtextarea.append("5 food = 5 resources");
		
		// recourse tradingtextbox fix this.
		Recoursetextarea.append("Food:" + PlayerObject.food + "\n" + "Resources: " + PlayerObject.miningAndWood + "\n");
		Recoursetextarea.append("5 resources = 5 food" + "\n");
		
		// researchpoints textbox
		Reasechpointstextarea.append("Research Points: " + PlayerObject.research + "\n" + "Food: " + PlayerObject.food + "\n");
		Reasechpointstextarea.append("1 research point = 5 food");
		
		 villagerSubtract.setEnabled(false);
		 foodSubtract.setEnabled(false);
		 Reaserchsubtract.setEnabled(false);
		 resourcesSubtract.setEnabled(false);
		
		villageradd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (PlayerObject.food >= 2 )
			{
				PlayerObject.food = PlayerObject.food - 2;
				counterVillager++;
				Testareamaintrade.append("You traded 2 food. The current people in the village is " + counterVillager +"\n");
				 villagerSubtract.setEnabled(true);
				 
			}
			
			else
			{
				Testareamaintrade.append("You have no more food to trade" + "\n");
				villageradd.setEnabled(false);
			}
			
			}
		});
		
		villagerSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 if(PlayerObject.food != countertosave1)
		 {
			 
			 PlayerObject.food = PlayerObject.food + 2;
			 counterVillager--;
			 Testareamaintrade.append("You traded 2 food. The current unallocated people in the village is " + counterVillager + "\n");
			 villageradd.setEnabled(true);
		 }
		 
		if (counterVillager <= 0) {
			 Testareamaintrade.append("You have no more food to trade" + "\n");
			 villagerSubtract.setEnabled(false);
		 }
			}
		});
		
		
		foodAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerObject.miningAndWood >= 5 )
				{
					PlayerObject.food = PlayerObject.food + 5;
					PlayerObject.miningAndWood = PlayerObject.miningAndWood - 5;
					Testareamaintrade.append("You traded 5 wood." + "\n" + "Wood: " + PlayerObject.miningAndWood + "\n" + "Food: " + PlayerObject.food + "\n" );
					foodSubtract.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more resources to trade" + "\n");
				foodAdd.setEnabled(false);
				}
			}
		});
		
		
		foodSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerObject.miningAndWood != countertosave )
				{
					PlayerObject.food = PlayerObject.food - 5;
					PlayerObject.miningAndWood = PlayerObject.miningAndWood + 5;
					Testareamaintrade.append("you retracted 5 wood for" + PlayerObject.food + " food" + "\n");
					foodAdd.setEnabled(true);
					villageradd.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more resources to trade" + "\n");
					foodSubtract.setEnabled(false);
				}
			}
		});
		
		
		resourcesAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerObject.food >= 5 )
				{
					PlayerObject.miningAndWood = PlayerObject.miningAndWood + 5;
					PlayerObject.food = PlayerObject.food - 5;
					Testareamaintrade.append("you submitted 5 wood for" + PlayerObject.food + " food" + "\n");
					resourcesSubtract.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more resources to trade" + "\n");
					resourcesAdd.setEnabled(false);
				}
			}
		});
		
		
		resourcesSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerObject.food != countertosave1 )
				{
					PlayerObject.miningAndWood = PlayerObject.miningAndWood - 5;
					PlayerObject.food =PlayerObject.food + 5;
					Testareamaintrade.append("you retracted 5 food for" + PlayerObject.miningAndWood + " resources" + "\n");
					foodAdd.setEnabled(true);
					resourcesAdd.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more resources to trade" + "\n");
					resourcesAdd.setEnabled(false);
				}
			}
		});
		
		Reaserchadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerObject.food >= 5 )
				{
					PlayerObject.research = PlayerObject.research + 1;
					counterreasrerch = counterreasrerch + 1;
					PlayerObject.food = PlayerObject.food - 5;
					Testareamaintrade.append("you submitted 5 food for" + counterreasrerch + " reaserch" + "\n");
					Reaserchsubtract.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more resources to trade" + "\n");
					Reaserchadd.setEnabled(false);
				}
			}
		});
		
		
		Reaserchsubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerObject.research != countertosave2 )
				{
					PlayerObject.research = PlayerObject.research - 1;
					PlayerObject.food = PlayerObject.food + 5;
					Testareamaintrade.append("you retracted 1 reaserch point for" + PlayerObject.food + " food" + "\n");
					Reaserchsubtract.setEnabled(true);
					Reaserchadd.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more reaserch points to trade" + "\n");
					Reaserchsubtract.setEnabled(false);
				}
			}
		});
	}

}
