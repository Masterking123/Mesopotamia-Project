import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RandomEventPopover extends JFrame {

	private static JPanel contentPane;
	private static RandomEventPopover frame;

	public static void createNewRandomEventPopover() {
		
		frame = new RandomEventPopover();
		// This default close operation lets it when clicking the x button on the top right
		// Only hides the popup instead of closing all JFrame
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.contentPane = new JPanel();
		frame.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		frame.contentPane.setLayout(null);
		
		JButton yesButton = new JButton("Yes");
		yesButton.setBounds(95, 240, 89, 23);
		yesButton.setVisible(false);
		frame.contentPane.add(yesButton);
		
		JButton noButton = new JButton("No");
		noButton.setBounds(222, 240, 89, 23);
		noButton.setVisible(false);
		frame.contentPane.add(noButton);
		
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		okButton.setBounds(153, 167, 109, 34);
		frame.contentPane.add(okButton);
		
		JLabel nameOfRandomEvent = new JLabel("Hurricane");
		nameOfRandomEvent.setFont(new Font("Tahoma", Font.PLAIN, 30));
		nameOfRandomEvent.setHorizontalAlignment(SwingConstants.CENTER);
		nameOfRandomEvent.setBounds(95, 0, 216, 41);
		frame.contentPane.add(nameOfRandomEvent);
		
		JTextPane descriptionTextPane = new JTextPane();
		descriptionTextPane.setText("The Tornado has come across your land and has a variety of effects like killing some of your people and the storage house of food has been broken, resulting in some food being spoiled/ destroyed.");
		descriptionTextPane.setBounds(71, 52, 302, 69);
		descriptionTextPane.setEditable(false);
		frame.contentPane.add(descriptionTextPane);
		frame.setVisible(true);
	}
}
