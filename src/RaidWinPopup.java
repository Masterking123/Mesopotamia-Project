import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class RaidWinPopup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void createRaidWinPopup(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RaidWinPopup frame = new RaidWinPopup();
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
	public RaidWinPopup() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
				MainGameGUI.frame.requestFocus();
			}
			
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel winLabel = new JLabel("Congratulations!");
		winLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		winLabel.setBounds(136, 11, 208, 42);
		contentPane.add(winLabel);
		
		JTextArea winTextArea = new JTextArea();
		winTextArea.setLineWrap(true);
		winTextArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
		winTextArea.setBackground(new Color(192, 192, 192));
		winTextArea.setText("You have succesfully stopped the rival village from raiding your village. ");
		winTextArea.setEditable(false);
		winTextArea.setBounds(55, 83, 325, 78);
		contentPane.add(winTextArea);
		
		JButton contButton = new JButton("Continue");
		contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainGameGUI.frame.setEnabled(true);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
			}
		});
		contButton.setBounds(156, 198, 123, 30);
		contentPane.add(contButton);
	}
}
