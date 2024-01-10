import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class RandomEventPopoverEnded extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void createRandomEventEndedPopover(String[] eventNamesThatEnded) {
		frame = new RandomEventPopoverEnded(eventNamesThatEnded);
		frame.setVisible(true);
	};

	/**
	 * Create the frame.
	 */
	public RandomEventPopoverEnded(String[] eventsEnded) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
				MainGameGUI.frame.requestFocus();
			}
			
		});
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleText = new JLabel("Random Events Ended");
		titleText.setFont(new Font("Times New Roman", Font.BOLD, 20));
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setBounds(80, 11, 269, 35);
		contentPane.add(titleText);
		
		JTextArea listOfEndedEvents = new JTextArea();
		listOfEndedEvents.setFont(new Font("Times New Roman", Font.BOLD, 17));
		listOfEndedEvents.setBounds(27, 57, 385, 162);
		listOfEndedEvents.append("The events that have ended are:");
		
		for(int i = 0; i <  eventsEnded.length; i++) {
			if(eventsEnded[i] == "Earthquake Food") {
				eventsEnded[i] = "The Food debuff from the earthquake";
			}
			if(eventsEnded[i] == "Earthquake Mining/Wood") {
				eventsEnded[i] = "The Mining/Wood debuff from the earthquake";
			}
			listOfEndedEvents.append("\n" + eventsEnded[i]);
		}
		
		listOfEndedEvents.setEditable(false);
		listOfEndedEvents.setHighlighter(null);
		listOfEndedEvents.setCursor(null);
		listOfEndedEvents.setFocusable(false);
		contentPane.add(listOfEndedEvents);
		
		JButton continueBtn = new JButton("Continue");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGameGUI.frame.setEnabled(true);
				frame.setVisible(false);
			}
		});
		continueBtn.setBounds(173, 230, 89, 23);
		contentPane.add(continueBtn);
	}
}
