import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class MilitarytableGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JButton btnForPeopleMission;
	private static JButton btnForFoodMission;
	private static JButton btnForResourceMission;
	private static JButton btnForStealResourcesMission;
	
	/**
	 * Launch the application.
	 */
	public static void createMilitaryFindTable(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MilitarytableGUI frame = new MilitarytableGUI();
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
	public MilitarytableGUI() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				MainGameGUI.frame.setEnabled(true);
			}
			
		});
		setBounds(100, 100, 878, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Military Find Table");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setBounds(350, 28, 141, 24);
		contentPane.add(titleLabel);
		
		JTextArea textAreaForResource = new JTextArea();
		textAreaForResource.setEditable(false);
		textAreaForResource.setBounds(425, 105, 167, 128);
		contentPane.add(textAreaForResource);
		
		JTextArea textAreaForPeople = new JTextArea();
		textAreaForPeople.setEditable(false);
		textAreaForPeople.setBounds(48, 105, 167, 128);
		contentPane.add(textAreaForPeople);
		
		JTextArea textAreaForFood = new JTextArea();
		textAreaForFood.setEditable(false);
		textAreaForFood.setBounds(237, 105, 167, 128);
		contentPane.add(textAreaForFood);
		
		JTextArea textAreaForStealResources = new JTextArea();
		textAreaForStealResources.setEditable(false);
		textAreaForStealResources.setBounds(617, 105, 210, 128);
		contentPane.add(textAreaForStealResources);
		
		btnForPeopleMission = new JButton("Start");
		btnForPeopleMission.setBounds(85, 256, 85, 21);
		contentPane.add(btnForPeopleMission);
		
		btnForFoodMission = new JButton("Start");
		btnForFoodMission.setBounds(283, 256, 85, 21);
		contentPane.add(btnForFoodMission);
		
		btnForResourceMission = new JButton("Start");
		btnForResourceMission.setBounds(467, 256, 85, 21);
		contentPane.add(btnForResourceMission);
		
		btnForStealResourcesMission = new JButton("Start");
		btnForStealResourcesMission.setBounds(662, 256, 85, 21);
		contentPane.add(btnForStealResourcesMission);
		
		JButton btnForBack = new JButton("Back");
		btnForBack.setBounds(383, 485, 85, 21);
		btnForBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		contentPane.add(btnForBack);
		
		JTextArea textAreaForUserOutput = new JTextArea();
		textAreaForUserOutput.setBounds(85, 297, 649, 178);
		textAreaForUserOutput.setEditable(false);
		contentPane.add(textAreaForUserOutput);
		
		disableAllButtons();
		textAreaForPeople.append("This is to search for people " + "\n" + "for your village, to start" + "\n" + "you need " + "20 people and " + "\n" + "you have " + PlayerObject.peopleInMilitary +  " in your village");
		if(PlayerObject.peopleInMilitary >= 20) {
			btnForPeopleMission.setEnabled(true);
		}
		textAreaForFood.append("This is to search for food " + "\n" + "for your village, to start" + "\n" + "you need " + "15 people and " + "\n" + "you have " + PlayerObject.peopleInMilitary + " in " +  "your village");
		if(PlayerObject.peopleInMilitary >= 15) {
			btnForFoodMission.setEnabled(true);
		}
		textAreaForResource.append("This is to search for resources " + "\n"+  "for your village, to start" + "\n" + "you need " + "10 people and " + "\n" + "you have " + PlayerObject.peopleInMilitary + " in " + "your village");
		if(PlayerObject.peopleInMilitary >= 10) {
			btnForResourceMission.setEnabled(true);
		}
		textAreaForStealResources.append("This is to steal resources from AI Village" + "\n" + "for your village, to start" + "\n" + "you need " + "30 people and " + "\n" + "you have " + PlayerObject.peopleInMilitary + " in " + "your village");
		if(PlayerObject.peopleInMilitary >= 30) {
			btnForStealResourcesMission.setEnabled(true);
		}
		
		
		
		// Disable buttons if a mission was started that day
		if(PlayerObject.militaryMissionStarted == true) {
			disableAllButtons();
			textAreaForUserOutput.setText("Today's mission has been completed!");
		}
		
		btnForPeopleMission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnForPeopleMission.setEnabled(false);
				disableAllButtons();
				PlayerObject.militaryMissionStarted = true;
				if(Main.randomPercentOccurance(10)) {
					textAreaForUserOutput.setText("YOU FOUND 10 PEOPLE!!");
					PlayerObject.totalPeople += 10;
					PlayerObject.unallocatedPeople += 10;
					MainGameGUI.unalloPeopleCounter.setText("" + PlayerObject.unallocatedPeople);
				}
				else {
					textAreaForUserOutput.setText("You found nothing :(");
				}
			}
		});
		
		btnForFoodMission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnForFoodMission.setEnabled(false);
				disableAllButtons();
				PlayerObject.militaryMissionStarted = true;
				if(Main.randomPercentOccurance(20)) {
					textAreaForUserOutput.setText("YOU FOUND 100 PIECES OF FOOD!!");
					PlayerObject.food += 100;
				}
				else {
					textAreaForUserOutput.setText("You found nothing :(");
				}
			}
		});
		
		btnForResourceMission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnForResourceMission.setEnabled(false);
				disableAllButtons();
				PlayerObject.militaryMissionStarted = true;
				if(Main.randomPercentOccurance(10)) {
					textAreaForUserOutput.setText("YOU FOUND 100 RESOURCES!!");
					PlayerObject.miningAndWood += 100;
				}
				else {
					textAreaForUserOutput.setText("You found nothing :(");
				}
			}
		});
		
		btnForStealResourcesMission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnForStealResourcesMission.setEnabled(false);
				disableAllButtons();
				PlayerObject.militaryMissionStarted = true;
				if(Main.randomPercentOccurance(25)) {
					textAreaForUserOutput.setText("YOU STOLE 25 FOOD AND 25 RESOURCES FROM THE AI!!");
					PlayerObject.food += 25;
					PlayerObject.miningAndWood += 25;
					AiEventResponse.Aifood -= 25;
					AiEventResponse.AiminingAndWood -= 25;
				}
				else {
					textAreaForUserOutput.setText("You found nothing :(");
				}
			}
		});
		
		
	}

public static void disableAllButtons() {
	btnForPeopleMission.setEnabled(false);
	btnForFoodMission.setEnabled(false);
	btnForResourceMission.setEnabled(false);
	btnForStealResourcesMission.setEnabled(false);
}
 

}
