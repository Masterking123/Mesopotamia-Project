import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class RandomEventPopover extends JFrame {
	public RandomEventPopover() {
	}

	private static JPanel contentPane;
	private static RandomEventPopover frame;

	public static void createNewRandomEventPopover(String eventName, String eventDescription) {
		
		frame = new RandomEventPopover();
		// This default close operation lets it when clicking the x button on the top right
		// Only hides the popup instead of closing all JFrame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
				MainGameGUI.frame.requestFocus();
			}
			
		});
		frame.setBounds(100, 100, 450, 300);
		frame.contentPane = new JPanel();
		frame.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		frame.contentPane.setLayout(null);
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		yesButton.setBounds(95, 230, 89, 23);
		yesButton.setVisible(false);
		frame.contentPane.add(yesButton);
		
		JButton noButton = new JButton("No");
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		noButton.setBounds(222, 230, 89, 23);
		noButton.setVisible(false);
		frame.contentPane.add(noButton);
		
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		okButton.setBounds(153, 167, 109, 34);
		frame.contentPane.add(okButton);	 
		
		JLabel nameOfRandomEvent = new JLabel(eventName);
		nameOfRandomEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nameOfRandomEvent.setHorizontalAlignment(SwingConstants.CENTER);
		nameOfRandomEvent.setVerticalAlignment(SwingConstants.CENTER);
		nameOfRandomEvent.setBounds(-50, 0, 500, 41);
		frame.contentPane.add(nameOfRandomEvent);
		
		JTextPane descriptionTextPane = new JTextPane();
		descriptionTextPane.setText(eventDescription);
		descriptionTextPane.setBounds(71, 52, 302, 69);
		descriptionTextPane.setEditable(false);
		descriptionTextPane.setHighlighter(null);
		descriptionTextPane.setCursor(null);
		descriptionTextPane.setFocusable(false);
		
		if(eventName == "Neighbouring Village") {
			okButton.setVisible(true);
			noButton.setVisible(true);
		}
		
		frame.contentPane.add(descriptionTextPane);
		frame.setVisible(true);
	}
}
