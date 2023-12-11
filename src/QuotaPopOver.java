import javax.swing.*;

public class QuotaPopOver extends JFrame {

    private static final long serialVersionUID = 1L;
    private static JPanel contentPane;
    private static Quota quota;

    public QuotaPopOver() {
        initialize();
    }

    private void initialize() {
        JFrame frame = new JFrame("Quota Status");
        JTextArea textArea = new JTextArea();
        textArea.setText(PlayerObject.playerName + " ! Your village, " + PlayerObject.playerVillageName + " Needs:\n" +
                "- Food needed: " + Quota.foodRequiredPerPerson + "\n" +
                "- Food: " + PlayerObject.food + "\n" +
                "- People left for food: " + Quota.peopleLeftForFood + "\n" +
                "- Reputation: " + PlayerObject.reputation + "\n" +
                "- Wood needed: " + Quota.woodRequiredPerPerson + "\n" +
                "- Wood: " + PlayerObject.miningAndWood + "\n" +
                "- People left for wood: " + Quota.peopleLeftForWood + "\n" +
                "- Total amount of people: " + PlayerObject.totalPeople + "\n");

        frame.getContentPane().add(textArea);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Use appropriate close operation
        frame.setVisible(true);
    }

    public static void main(String[] args) {
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
