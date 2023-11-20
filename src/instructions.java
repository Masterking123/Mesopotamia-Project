import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JButton;

public class instructions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instructions frame = new instructions();
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
	public instructions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 55, 538, 311);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		layeredPane.add(panel_3, "name_917827582001041");
		
		JPanel panel_2 = new JPanel();
		layeredPane.add(panel_2, "name_917817333654630");
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_917802674356474");
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_917770200247221");
		
		JButton backToMainButton = new JButton("Back");
		backToMainButton.setBounds(0, 0, 80, 29);
		contentPane.add(backToMainButton);
		
		JButton mainIdeaButton = new JButton("Main Idea");
		mainIdeaButton.setBounds(80, 0, 95, 29);
		contentPane.add(mainIdeaButton);
	}
}
