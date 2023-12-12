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

	
	public static double miningAndWood;
	public static double food;
	public static double military;
	public static double research;
	public static int totalPeople;

	int countervilliger = 0;
	int counterreasrerch = 0;
	double countertosave1 = food;
	double countertosave = miningAndWood;
	double countertosave2 = research;
	
	
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
		
		JLabel lblNewLabel_1 = new JLabel("Villigar marketing");
		lblNewLabel_1.setBounds(44, 76, 108, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Trading screen");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(325, 10, 153, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Recorse trade");
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
		
		JButton Villiigeradd = new JButton("+");
		Villiigeradd.setBounds(44, 176, 49, 21);
		contentPane.add(Villiigeradd);
		
		JButton Villigersubtract = new JButton("-");
		Villigersubtract.setBounds(90, 176, 49, 21);
		contentPane.add(Villigersubtract);
		
		JButton Foodadd = new JButton("+");
		Foodadd.setBounds(201, 176, 51, 21);
		contentPane.add(Foodadd);
		
		JButton Foodsubract = new JButton("-");
		Foodsubract.setBounds(249, 176, 49, 21);
		contentPane.add(Foodsubract);
		
		JButton Recouseadd = new JButton("+");
		Recouseadd.setBounds(391, 176, 49, 21);
		contentPane.add(Recouseadd);
		
		JButton Recourcesubtract = new JButton("-");
		Recourcesubtract.setBounds(439, 176, 49, 21);
		contentPane.add(Recourcesubtract);
		
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
		villigarmarketing_textbox.append("you have " + food + " food" + "\n");
		villigarmarketing_textbox.append("to recive 1 villigar, " + "\n" + "give 2 food");
		
		// food tradingtextbox
		Foodtextarea.append("you have " + miningAndWood + " recources" + "\n");
		Foodtextarea.append("to recive 5 food, " + "\n" + "give 5 recourses");
		
		// recourse tradingtextbox fix this.
		Recoursetextarea.append("you have " + food + " food" + "\n");
		Recoursetextarea.append("to recive 5 reacourses" + "\n" +  "give 5 food");
		
		// researchpoints textbox
		Reasechpointstextarea.append("you have " + research + " reaserch points" + "\n");
		Reasechpointstextarea.append("to recive 1 reaserch point " + "\n" + "give 5 food");
		
		 Villigersubtract.setEnabled(false);
		 Foodsubract.setEnabled(false);
		 Reaserchsubtract.setEnabled(false);
		 Recourcesubtract.setEnabled(false);
		
		Villiigeradd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (food >= 2 )
			{
				food = food - 2;
				countervilliger++;
				Testareamaintrade.append("you subbmitted 2 food for" + countervilliger + " villigers" + "\n");
				 Villigersubtract.setEnabled(true);
				 
			}
			
			else
			{
				Testareamaintrade.append("you have no more food to trade" + "\n");
				Villiigeradd.setEnabled(false);
			}
			
			}
		});
		
		Villigersubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 if(food != countertosave1)
		 {
			 
			 food = food + 2;
			 countervilliger--;
			 Testareamaintrade.append("you retracted 2 food for" + countervilliger + " villigers" + "\n");
			 Villiigeradd.setEnabled(true);
		 }
		 
		if (countervilliger <= 0) {
			 Testareamaintrade.append("you have no more food to retract" + "\n");
			 Villigersubtract.setEnabled(false);
		 }
			}
		});
		
		
		Foodadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miningAndWood >= 5 )
				{
					food = food + 5;
					miningAndWood = miningAndWood - 5;
					Testareamaintrade.append("you subbmitted 5 wood for" + food + " food" + "\n");
					Foodsubract.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more recourses to trade" + "\n");
				Foodadd.setEnabled(false);
				}
			}
		});
		
		
		Foodsubract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (miningAndWood != countertosave )
				{
					food = food - 5;
					miningAndWood = miningAndWood + 5;
					Testareamaintrade.append("you retracted 5 wood for" + food + " food" + "\n");
					Foodadd.setEnabled(true);
					Villiigeradd.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more recourses to trade" + "\n");
					Foodsubract.setEnabled(false);
				}
			}
		});
		
		
		Recouseadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (food >= 5 )
				{
					miningAndWood = miningAndWood + 5;
					food = food - 5;
					Testareamaintrade.append("you submitted 5 wood for" + food + " food" + "\n");
					Recourcesubtract.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more recourses to trade" + "\n");
					Recouseadd.setEnabled(false);
				}
			}
		});
		
		
		Recourcesubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (food != countertosave1 )
				{
					miningAndWood = miningAndWood - 5;
					food = food + 5;
					Testareamaintrade.append("you retracted 5 food for" + miningAndWood + " recourses" + "\n");
					Foodadd.setEnabled(true);
					Recouseadd.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more recourses to trade" + "\n");
					Recouseadd.setEnabled(false);
				}
			}
		});
		
		Reaserchadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (food >= 5 )
				{
					research = research + 1;
					counterreasrerch = counterreasrerch + 1;
					food = food - 5;
					Testareamaintrade.append("you submitted 5 food for" + counterreasrerch + " reaserch" + "\n");
					Reaserchsubtract.setEnabled(true);
				}
				
				else
				{
					Testareamaintrade.append("you have no more recourses to trade" + "\n");
					Reaserchadd.setEnabled(false);
				}
			}
		});
		
		
		Reaserchsubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (research != countertosave2 )
				{
					research = research - 1;
					food = food + 5;
					Testareamaintrade.append("you retracted 1 reaserch point for" + food + " food" + "\n");
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
