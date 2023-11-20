import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class CharacterCustomizerGUI{

		public static void CharacterCustomizerGUI() {
			JFrame frame = new JFrame();
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			frame.setSize (1000, 500);
			
			frame.getContentPane ().add (panel);
			
			JLabel characterCustomizerLabel = new JLabel("Character Customizer");
			characterCustomizerLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
			characterCustomizerLabel.setBounds(350, 11, 287, 35);
			frame.getContentPane().add(characterCustomizerLabel);
			frame.setVisible(true);

	}
		
	public static void main(String[] args) {
		CharacterCustomizerGUI();
	}

}
