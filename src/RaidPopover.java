import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class RaidPopover extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static int raidDayCount = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RaidPopover frame = new RaidPopover();
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
	public RaidPopover() {
		
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		if (raidDayCount != 0) {
			setVisible(false);
		}
	
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel raidTitleLabel = new JLabel("RAID!!!");
		raidTitleLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 35));
		raidTitleLabel.setBounds(170, 11, 146, 41);
		contentPane.add(raidTitleLabel);
		
		JTextArea infoTextArea = new JTextArea();
		infoTextArea.setBackground(new Color(192, 192, 192));
		infoTextArea.setLineWrap(true);
		infoTextArea.setWrapStyleWord(true);
		infoTextArea.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
		infoTextArea.setEditable(false);
		infoTextArea.setRows(5);
		infoTextArea.setText("The Rival Village has decided to raid your village. Now you must play a game of connect 4 to determine who wins the raid. If the rival village wins, then they will steal your resources!");
		infoTextArea.setBounds(47, 63, 347, 117);
		contentPane.add(infoTextArea);
		
		JButton contButton = new JButton("Continue");
		contButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ConnectFourGame.CreateConnectFour(null);
			}
		});
		contButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		contButton.setBounds(150, 201, 134, 41);
		contentPane.add(contButton);
	}
}
