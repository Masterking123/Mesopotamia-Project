import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReputationSystemGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int reputation;
	public static int percentFoodBoost;
	public static int percentMiningAndWoodBoost; 
	public static int percentMilitaryBoost; 
	public static int percentResearchBoost;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReputationSystemGUI frame = new ReputationSystemGUI();
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
	public ReputationSystemGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Reputationlabel = new JLabel("Reputation Popover");
		Reputationlabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		Reputationlabel.setBounds(306, 10, 189, 59);
		contentPane.add(Reputationlabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(97, 154, 167, 22);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Current Reputation");
		lblNewLabel.setBounds(129, 131, 94, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Current Boost");
		lblNewLabel_1.setBounds(501, 131, 133, 13);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(471, 154, 144, 22);
		contentPane.add(textArea_1);
		
		JTextArea reputationtextarea = new JTextArea();
		reputationtextarea.setEditable(false);
		reputationtextarea.setBounds(184, 248, 400, 111);
		contentPane.add(reputationtextarea);
		
		JLabel lblNewLabel_2 = new JLabel("Viligar review");
		lblNewLabel_2.setBounds(340, 225, 155, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Go back");
		btnNewButton.setBounds(340, 415, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Villiger Review");
		btnNewButton_1.setBounds(316, 369, 125, 21);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reputationtextarea.append("You are a really good leader you make sure the village has enough resources" + "\n" + "Really enjoying this!");
			}
		});

		
	}
	
	public static void Reputationsytemboost()
	{
		if( reputation >= 60)
		{
			percentFoodBoost = percentFoodBoost + 5;
			 percentMiningAndWoodBoost =  percentMiningAndWoodBoost + 5; 
			 percentMilitaryBoost = percentMilitaryBoost + 5; 
			 percentResearchBoost = percentResearchBoost + 5;
			
		}
	}
	
	public static void Reputationsytemnegative()
	{
		if( reputation <= 20)
		{
			// negative effect on village for eevrrything
			percentFoodBoost = percentFoodBoost - 5;
			 percentMiningAndWoodBoost =  percentMiningAndWoodBoost - 5; 
			 percentMilitaryBoost = percentMilitaryBoost - 5; 
			 percentResearchBoost = percentResearchBoost - 5;
		}
	}
}
