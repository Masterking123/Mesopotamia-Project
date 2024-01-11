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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;



public class TradingPopover extends JFrame {
	
	public static JButton backtradebutton;
	public static JLabel lblNewLabel;
	public static JLabel lblNewLabel_1;
	public static JLabel lblNewLabel_2;
	public static JLabel lblNewLabel_3;
	public static JLabel lblNewLabel_4;
	public static JTextArea villagerMarketing_textbox;
	public static JTextArea Foodtextarea;
	public static JTextArea resourceTextArea;
	public static JTextArea researchPointsTextArea;
	public static JButton villagerAdd;
	public static JButton villagerAdd2;
	public static JButton foodAdd;
	public static JButton resourcesAdd;
	public static JButton researchAdd;
	public static JButton researchAdd2;
	public static JTextArea Testareamaintrade;
	public static JLabel Tradingtextbox;

	
	double countertosave1 = PlayerObject.food;
	double countertosave = PlayerObject.miningAndWood;
	double countertosave2 = PlayerObject.research;
	double percentDiscount2 = (float)((PlayerObject.percentDiscountOnSales*2)/100);
	
	
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
		backtradebutton = new JButton("Go Back");
		backtradebutton.setBounds(23, 414, 85, 21);
		backtradebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainGameGUI.frame.setEnabled(true);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
			}
		});
		contentPane.add(backtradebutton);

		lblNewLabel = new JLabel("Food trade");
		lblNewLabel.setBounds(224, 80, 64, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Villager marketing");
		lblNewLabel_1.setBounds(44, 76, 108, 21);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Trading screen");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(325, 10, 153, 48);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Resource trade");
		lblNewLabel_3.setBounds(391, 80, 96, 13);
		contentPane.add(lblNewLabel_3);
	
		lblNewLabel_4 = new JLabel("Research points");
		lblNewLabel_4.setBounds(593, 80, 100, 13);
		contentPane.add(lblNewLabel_4);
		
		villagerMarketing_textbox = new JTextArea();
		villagerMarketing_textbox.setFont(new Font("Arial", Font.PLAIN, 11));
		villagerMarketing_textbox.setEditable(false);
		villagerMarketing_textbox.setBounds(23, 96, 129, 67);
		contentPane.add(villagerMarketing_textbox);
		
		Foodtextarea = new JTextArea();
		Foodtextarea.setFont(new Font("Arial", Font.PLAIN, 11));
		Foodtextarea.setEditable(false);
		Foodtextarea.setBounds(191, 96, 129, 67);
		contentPane.add(Foodtextarea);
		
		resourceTextArea = new JTextArea();
		resourceTextArea.setFont(new Font("Arial", Font.PLAIN, 11));
		resourceTextArea.setEditable(false);
		resourceTextArea.setBounds(375, 96, 129, 67);
		contentPane.add(resourceTextArea);
		
		researchPointsTextArea = new JTextArea();
		researchPointsTextArea.setFont(new Font("Arial", Font.PLAIN, 11));
		researchPointsTextArea.setEditable(false);
		researchPointsTextArea.setBounds(575, 99, 129, 64);
		contentPane.add(researchPointsTextArea);
		
		villagerAdd = new JButton("FOOD");
		villagerAdd.setBounds(44, 176, 100, 21);
		contentPane.add(villagerAdd);
		
		villagerAdd2 = new JButton("RESOURCE");
		villagerAdd2.setBounds(44, 200, 100, 21);
		contentPane.add(villagerAdd2);
		
		foodAdd = new JButton("TRADE");
		foodAdd.setBounds(201, 176, 100, 21);
		contentPane.add(foodAdd);
		
		resourcesAdd = new JButton("TRADE");
		resourcesAdd.setBounds(391, 176, 100, 21);
		contentPane.add(resourcesAdd);

		researchAdd = new JButton("FOOD");
		researchAdd.setBounds(595, 173, 100, 21);
		contentPane.add(researchAdd);
		
		researchAdd2 = new JButton("RESOURCE");
		researchAdd2.setBounds(595, 200, 100, 21);
		contentPane.add(researchAdd2);
		
		
		Testareamaintrade = new JTextArea();
		Testareamaintrade.setEditable(false);
		Testareamaintrade.setBounds(172, 230, 423, 190);
		
		JScrollPane scrollPane = new JScrollPane(Testareamaintrade);
		scrollPane.setBounds(10,60,780,500);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		contentPane.add(Testareamaintrade);
		
		Tradingtextbox = new JLabel("Trading Messages");
		Tradingtextbox.setBounds(326, 207, 152, 13);
		contentPane.add(Tradingtextbox);
		
		
		// Village marketing textbox
		villagerMarketing_textbox.append("Food: " + PlayerObject.food + "\n" + 
		"Resource: " + PlayerObject.miningAndWood + "\n"
		+ "Unallocated People: " + PlayerObject.totalPeople + "\n");
		villagerMarketing_textbox.append((2-percentDiscount2) + " food = 1 villager" + "\n" + "5 Resource = 1 villager");
		
		// food tradingtextbox
		Foodtextarea.append("Resources: " + PlayerObject.miningAndWood + "\n" + "Food: " + PlayerObject.food + "\n");
		Foodtextarea.append("5 food = 5 resources");
		
		resourceTextArea.append("Food:" + PlayerObject.food + "\n" + "Resources: " + PlayerObject.miningAndWood + "\n");
		resourceTextArea.append("5 resources = 5 food" + "\n");
		
		// researchpoints textbox
		researchPointsTextArea.append("Research Points: " + PlayerObject.research + "\n"
		+ "Food: " + PlayerObject.food + "\n"
		+ "Resourced: "+ PlayerObject.miningAndWood);
		researchPointsTextArea.append("1 research point = 5 food" + " \n " + "or  5 resource");
		

		
		villagerAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (PlayerObject.food >= (2 - percentDiscount2))
			{
				PlayerObject.food = PlayerObject.food - (2 - percentDiscount2);
				PlayerObject.totalPeople++;
				PlayerObject.unallocatedPeople++;
				MainGameGUI.unalloPeopleCounter.setText("" + PlayerObject.unallocatedPeople);
				Testareamaintrade.append("You traded 2 food. The Unallocated people in the village is " + PlayerObject.unallocatedPeople +"\n");
				updateTradeInformation();

				System.out.println((2*percentDiscount2));
				System.out.println(percentDiscount2);
			}
			
			else
			{
				Testareamaintrade.append("You have no more food to trade" + "\n");
				villagerAdd.setEnabled(false);
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
					//foodSubtract.setEnabled(true);
					updateTradeInformation();
				}
				
				else
				{
					Testareamaintrade.append("You have no more resources to trade" + "\n");
				foodAdd.setEnabled(false);
				}
			}
		});

		resourcesAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerObject.food >= 5 )
				{
					PlayerObject.miningAndWood = PlayerObject.miningAndWood + 5;
					PlayerObject.food = PlayerObject.food - 5;
					Testareamaintrade.append("You traded 5 wood" + "\n" + "Food: " + PlayerObject.food + "\n");
					updateTradeInformation();
				}
				
				else
				{
					Testareamaintrade.append("You have no more resources to trade" + "\n");
					resourcesAdd.setEnabled(false);
				}
			}
		});
		
		
		researchAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PlayerObject.food >= 5 )
				{
					PlayerObject.research = PlayerObject.research + 1;
					PlayerObject.food = PlayerObject.food - 5;
					Testareamaintrade.append("You traded 5 food" + "\n" + " Research points: " + PlayerObject.research+ "\n");
					//researchSubtract.setEnabled(true);
					updateTradeInformation();
				}
				
				else
				{
					Testareamaintrade.append("You have no more resources to trade" + "\n");
					researchAdd.setEnabled(false);
				}
			}
		});
		villagerMarketing_textbox.setHighlighter(null);
		disableAllFunctionalityForTextArea(villagerMarketing_textbox);
		disableAllFunctionalityForTextArea(Foodtextarea);
		disableAllFunctionalityForTextArea(resourceTextArea);
		disableAllFunctionalityForTextArea(researchPointsTextArea);
		
	}
	
	public void updateTradeInformation() {
	    // Clear text areas
	    villagerMarketing_textbox.setText("");
	    Foodtextarea.setText("");
	    resourceTextArea.setText("");
	    researchPointsTextArea.setText("");
	    
	    // Update villager marketing text area
	    villagerMarketing_textbox.append("Food: " + PlayerObject.food + "\n" + "Unallocated People: " + PlayerObject.totalPeople + "\n");
	    villagerMarketing_textbox.append("1 villager = 2 food" + "\n");
	    
	    // Update food trading text area
	    Foodtextarea.append("Resources: " + PlayerObject.miningAndWood + "\n" + "Food: " + PlayerObject.food + "\n");
	    Foodtextarea.append("5 food = 5 resources" + "\n");
	    
	    // Update resource trading text area
	    resourceTextArea.append("Food:" + PlayerObject.food + "\n" + "Resources: " + PlayerObject.miningAndWood + "\n");
	    resourceTextArea.append("5 resources = 5 food" + "\n");
	    
	    // Update research points text area
	    researchPointsTextArea.append("Research Points: " + PlayerObject.research + "\n" + "Food: " + PlayerObject.food + "\n");
	    researchPointsTextArea.append("1 research point = 5 food" + "\n");
	}
	
	public void disableAllFunctionalityForTextArea(JTextArea currTextArea) {
		currTextArea.setEditable(false);
		currTextArea.setHighlighter(null);
		currTextArea.setCursor(null);
		currTextArea.setFocusable(false);
	}


}
