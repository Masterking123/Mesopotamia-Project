import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class losePopover extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					losePopover frame = new losePopover();
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
	public losePopover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
          Image img = Toolkit.getDefaultToolkit().getImage(  
          winPopover.class.getResource("/images/sadEmoji.gif"));  
          g.drawImage(img, 350, 30, 80, 60, this);  
              }  
          };  		
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
          contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loseLabel = new JLabel("OH NO!!!!");
		loseLabel.setFont(new Font("Sylfaen", Font.BOLD, 25));
		loseLabel.setBounds(228, 45, 146, 51);
		contentPane.add(loseLabel);
		
		JTextArea loseMessage = new JTextArea();
		loseMessage.setEditable(false);
		loseMessage.setText("The rival village led their settlement to victory on the frontier! You must assess your strategy and try again to improve.");
		loseMessage.setFont(new Font("Monospaced", Font.BOLD, 20));
		loseMessage.setLineWrap(true);
		loseMessage.setBounds(57, 95, 467, 143);
		contentPane.add(loseMessage);
		
		JButton exitButton = new JButton("Exit Game");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setForeground(Color.BLACK);
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBounds(218, 261, 114, 32);
		contentPane.add(exitButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(0, 128, 255));
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 588, 34);
		contentPane.add(textArea);
		

	}

}
