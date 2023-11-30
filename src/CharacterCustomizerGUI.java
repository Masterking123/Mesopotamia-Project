import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CharacterCustomizerGUI {
    private static JTextField playerNameText;
    private static JTextField rivalVillageNameText;
    private static JTextField playerVillageNameText;
    private static String playerName;
    private static String playerVillageName;
    private static String rivalVillageName;

    public static void CharacterCustomizerGUI() {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 300);

        frame.getContentPane().add(panel);

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

        playerNameText = new JTextField();
        playerNameText.setFont(new Font("Times New Roman", Font.BOLD, 20));
        playerNameText.setBounds(38, 124, 263, 35);
        frame.getContentPane().add(playerNameText);
        playerNameText.setColumns(10);

        rivalVillageNameText = new JTextField();
        rivalVillageNameText.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rivalVillageNameText.setColumns(10);
        rivalVillageNameText.setBounds(359, 124, 263, 35);
        frame.getContentPane().add(rivalVillageNameText);

        playerVillageNameText = new JTextField();
        playerVillageNameText.setFont(new Font("Times New Roman", Font.BOLD, 20));
        playerVillageNameText.setColumns(10);
        playerVillageNameText.setBounds(679, 124, 263, 35);
        frame.getContentPane().add(playerVillageNameText);

        JButton characterCustomizerSaveButton = new JButton("Save");
        characterCustomizerSaveButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
        characterCustomizerSaveButton.setBounds(430, 205, 127, 49);
        frame.getContentPane().add(characterCustomizerSaveButton);
        frame.setVisible(true);

        characterCustomizerSaveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playerName = playerNameText.getText();
                playerVillageName = playerVillageNameText.getText();
                rivalVillageName = rivalVillageNameText.getText();

                if (playerName.isEmpty() || playerVillageName.isEmpty() || rivalVillageName.isEmpty()) {
                    characterPopUp();
                } else {
                    // Do something with the entered data (e.g., move to the main game GUI)
                    MainGameGUI.showMainGameGUI(null);
                    frame.setVisible(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        CharacterCustomizerGUI();
    }

    static void characterPopUp() {
        JOptionPane.showMessageDialog(null, "Please enter all data fields.");
    }
}
