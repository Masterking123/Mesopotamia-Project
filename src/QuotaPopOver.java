import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class QuotaPopOver extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static Quota quota;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuotaPopOver frame = new QuotaPopOver();
                    frame.setVisible(true);
                    
                    // Initializing Quota object
                    quota = new Quota();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public QuotaPopOver() {
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

        frame.add(textArea);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
