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
	public static void main(String[] args) {
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
          MainGameGUI.class.getResource("/images/gameBackgroundImage(2).jpg"));  
          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
          };  
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addFarmerButton = new JButton("+");
		addFarmerButton.setBackground(new Color(255, 255, 255));
		addFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addFarmerButton.setBounds(262, 421, 59, 37);
		contentPane.add(addFarmerButton);
		
		JButton minusFarmerButton = new JButton("-");
		minusFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusFarmerButton.setBounds(341, 421, 64, 37);
		contentPane.add(minusFarmerButton);
		
		JLabel farmerLabel = new JLabel("Farmers");
		farmerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		farmerLabel.setBounds(274, 303, 172, 31);
		contentPane.add(farmerLabel);
		
		JLabel minerLabel = new JLabel("Miners");
		minerLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		minerLabel.setBounds(645, 414, 132, 44);
		contentPane.add(minerLabel);
		
		JLabel militaryLabel = new JLabel("Military");
		militaryLabel.setFont(new Font("Sitka Text", Font.BOLD, 30));
		militaryLabel.setBounds(927, 251, 144, 44);
		contentPane.add(militaryLabel);
	}
}
