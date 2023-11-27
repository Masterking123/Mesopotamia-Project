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
		addFarmerButton.setBackground(new Color(192, 192, 192));
		addFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addFarmerButton.setBounds(252, 251, 59, 31);
		contentPane.add(addFarmerButton);
		
		JButton minusFarmerButton = new JButton("-");
		minusFarmerButton.setBackground(new Color(192, 192, 192));
		minusFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusFarmerButton.setBounds(321, 251, 59, 31);
		contentPane.add(minusFarmerButton);
		
		JLabel farmerLabel = new JLabel("Farmers");
		farmerLabel.setForeground(new Color(255, 255, 255));
		farmerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		farmerLabel.setBounds(104, 262, 172, 31);
		contentPane.add(farmerLabel);
		
		JLabel minerLabel = new JLabel("Miners");
		minerLabel.setForeground(new Color(255, 255, 255));
		minerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		minerLabel.setBounds(1092, 124, 132, 44);
		contentPane.add(minerLabel);
		
		JLabel militaryLabel = new JLabel("Military");
		militaryLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		militaryLabel.setBounds(614, 469, 144, 44);
		contentPane.add(militaryLabel);
		
		JButton addMinerButton = new JButton("+");
		addMinerButton.setBackground(new Color(192, 192, 192));
		addMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addMinerButton.setBounds(601, 524, 59, 37);
		contentPane.add(addMinerButton);
		
		JButton minusMinerButton = new JButton("-");
		minusMinerButton.setBackground(new Color(192, 192, 192));
		minusMinerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusMinerButton.setBounds(670, 524, 64, 37);
		contentPane.add(minusMinerButton);
		
		JButton addMilitaryButton = new JButton("+");
		addMilitaryButton.setBackground(new Color(192, 192, 192));
		addMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addMilitaryButton.setBounds(1107, 179, 59, 37);
		contentPane.add(addMilitaryButton);
		
		JButton minusMilitaryButton = new JButton("-");
		minusMilitaryButton.setBackground(new Color(192, 192, 192));
		minusMilitaryButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusMilitaryButton.setBounds(1107, 227, 59, 37);
		contentPane.add(minusMilitaryButton);
		
		JButton btnNewButton = new JButton("Next Day");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomEventPopover.createNewRandomEventPopover(null);
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnNewButton.setBounds(1075, 694, 132, 37);
		contentPane.add(btnNewButton);
		
		JLabel researchLabel = new JLabel("Research");
		researchLabel.setForeground(new Color(255, 255, 255));
		researchLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		researchLabel.setBounds(1092, 524, 153, 37);
		contentPane.add(researchLabel);
		
		JButton addResearchButton = new JButton("+");
		addResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addResearchButton.setBackground(Color.LIGHT_GRAY);
		addResearchButton.setBounds(1075, 552, 59, 37);
		contentPane.add(addResearchButton);
		
		JButton minusResearchButton = new JButton("-");
		minusResearchButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusResearchButton.setBackground(Color.LIGHT_GRAY);
		minusResearchButton.setBounds(1148, 552, 59, 37);
		contentPane.add(minusResearchButton);
	}
}
