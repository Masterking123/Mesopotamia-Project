import java.awt.Font;

import javax.swing.*;

public class QuotaPopOver extends JFrame {

    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private static Quota quota;
	public static String playerVillageName;
	
    public QuotaPopOver() {
        initialize();
    }

    private void initialize() {
        JFrame frame = new JFrame("Quota Status");
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 30));
        textArea.setText(PlayerObject.playerName + " ! Your village, " + PlayerObject.playerVillageName + " Needs:\n" +
                "- Your Village power " + PlayerObject.calculateVillagePower() + "\n" +
                "- Rival Village power: " + AiEventResponse.calculateVillagePowerAi() + "\n" +
                "- People left for food: " + Quota.peopleLeftForFood + "\n" +
                "- Reputation: " + PlayerObject.reputation + "\n" +
                "- Wood needed: " + Quota.woodRequiredPerPerson + "\n" +
                "- Wood: " + PlayerObject.miningAndWood + "\n" +
                "- People left for wood: " + Quota.peopleLeftForWood + "\n" +
                "- Total amount of people: " + PlayerObject.totalPeople + "\n");

        frame.getContentPane().add(textArea);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Use appropriate close operation
        frame.setVisible(true);
    }

    public static void showPopUp(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuotaPopOver frame = new QuotaPopOver();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
