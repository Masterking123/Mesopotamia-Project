import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static MainMenuGUI frame;

	/**
	 * Launch the application.
	 */
	public static void createMainMenu(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainMenuGUI();
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
	public MainMenuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
          Image img = Toolkit.getDefaultToolkit().getImage(  
          MainGameGUI.class.getResource("/images/bonzeagetest2.jpg"));  
          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
          };  
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Mesopotamia: Dawn of Civilization");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(82, 50, 289, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnStart = new JButton("Start"); 
		btnStart.setBounds(150, 121, 133, 38);
		contentPane.add(btnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CharacterCustomizerGUI.CharacterCustomizerGUI();
				frame.setVisible(false);
			}
		});
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(150, 169, 133, 38);
		contentPane.add(btnHelp);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructionsPopover.createInstructionMenu(null);
				frame.setVisible(false);
			}
		});
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(150, 215, 133, 38);
		contentPane.add(btnQuit);
	}

}
