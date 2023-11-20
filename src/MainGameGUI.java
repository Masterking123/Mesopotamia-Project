import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToolBar;
import java.awt.Font;

public class MainGameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(100, 100, 1650, 1080);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addFarmerButton = new JButton("+");
		addFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		addFarmerButton.setBounds(121, 404, 59, 37);
		contentPane.add(addFarmerButton);
		
		JButton minusFarmerButton = new JButton("-");
		minusFarmerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		minusFarmerButton.setBounds(234, 404, 64, 37);
		contentPane.add(minusFarmerButton);
		
		JLabel lblNewLabel = new JLabel("Farmers");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblNewLabel.setBounds(149, 350, 172, 23);
		contentPane.add(lblNewLabel);
	}
}
