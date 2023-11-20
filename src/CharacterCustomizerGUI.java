import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CharacterCustomizerGUI{
	private static JTextField playerName;
	private static JTextField rivalVillageName;
	private static JTextField playerVillageName;

		public static void CharacterCustomizerGUI() {
			JFrame frame = new JFrame();
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			frame.setSize (1000, 300);
			
			frame.getContentPane ().add (panel);
			
			JLabel characterCustomizerLabel = new JLabel("Character Customizer");
			characterCustomizerLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
			characterCustomizerLabel.setBounds(350, 11, 287, 35);
			frame.getContentPane().add(characterCustomizerLabel);
			
			JLabel playerNameLabel = new JLabel("Enter Your Name");
			playerNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			playerNameLabel.setBounds(90, 77, 153, 24);
			frame.getContentPane().add(playerNameLabel);
			
			JLabel rivalVillageNameLabel = new JLabel("Enter Rival Village Name");
			rivalVillageNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			rivalVillageNameLabel.setBounds(384, 77, 220, 24);
			frame.getContentPane().add(rivalVillageNameLabel);
			
			JLabel playerVillageNameLabel = new JLabel("Enter Player Village Name");
			playerVillageNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
			playerVillageNameLabel.setBounds(698, 77, 230, 24);
			frame.getContentPane().add(playerVillageNameLabel);
			
			playerName = new JTextField();
			playerName.setFont(new Font("Times New Roman", Font.BOLD, 20));
			playerName.setBounds(38, 124, 263, 35);
			frame.getContentPane().add(playerName);
			playerName.setColumns(10);
			
			rivalVillageName = new JTextField();
			rivalVillageName.setFont(new Font("Times New Roman", Font.BOLD, 20));
			rivalVillageName.setColumns(10);
			rivalVillageName.setBounds(359, 124, 263, 35);
			frame.getContentPane().add(rivalVillageName);
			
			playerVillageName = new JTextField();
			playerVillageName.setFont(new Font("Tahoma", Font.BOLD, 20));
			playerVillageName.setColumns(10);
			playerVillageName.setBounds(679, 124, 263, 35);
			frame.getContentPane().add(playerVillageName);
			
			JButton characterCustomizerSaveButton = new JButton("Save");
			characterCustomizerSaveButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
			characterCustomizerSaveButton.setBounds(430, 205, 127, 49);
			frame.getContentPane().add(characterCustomizerSaveButton);
			frame.setVisible(true);

			
	}
		
	public static void main(String[] args) {
		CharacterCustomizerGUI();
	}
}
