import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class winPopover extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winPopover frame = new winPopover();
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
	public winPopover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel() {  
			public void paintComponent(Graphics g) {  
          Image img = Toolkit.getDefaultToolkit().getImage(  
          winPopover.class.getResource("/images/confetti.gif"));  
          g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
              }  
          };  
       contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel congratsLabel = new JLabel("CONGRATULATIONS!!");
		congratsLabel.setFont(new Font("Sylfaen", Font.BOLD, 25));
		congratsLabel.setBounds(170, 26, 318, 45);
		contentPane.add(congratsLabel);
		
		JTextArea winMessage = new JTextArea();
		winMessage.setEditable(false);
		winMessage.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 20));
		winMessage.setText("You successfully led your settlement to victory on the frontier.");
		winMessage.setLineWrap(true);
		winMessage.setBounds(68, 138, 456, 80);
		contentPane.add(winMessage);
		
		JButton exitButton = new JButton("Exit Game");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBackground(new Color(192, 192, 192));
		exitButton.setForeground(new Color(0, 0, 0));
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exitButton.setBounds(240, 257, 114, 32);
		contentPane.add(exitButton);
	}
}
