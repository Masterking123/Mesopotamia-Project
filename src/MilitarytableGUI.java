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
	/*
	public static int peopleInMilitary;
	public static double food;
	public static double miningAndWood;
	public static int totalPeople;*/
	int counter1 = 0;
	int counter2 = 0;
	int counter3 = 0;
	int counter4 = 0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 Random random = new Random();
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
		
		JLabel lblNewLabel = new JLabel("Military Find Table");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(350, 28, 141, 24);
		contentPane.add(lblNewLabel);
		
		JTextArea recoursetextarea = new JTextArea();
		recoursetextarea.setEditable(false);
		recoursetextarea.setBounds(425, 105, 167, 128);
		contentPane.add(recoursetextarea);
		
		JTextArea testareaforpeople = new JTextArea();
		testareaforpeople.setEditable(false);
		testareaforpeople.setBounds(48, 105, 167, 128);
		contentPane.add(testareaforpeople);
		
		JTextArea textareaforfood = new JTextArea();
		textareaforfood.setEditable(false);
		textareaforfood.setBounds(237, 105, 167, 128);
		contentPane.add(textareaforfood);
		
		JTextArea aicamptstealtextarea = new JTextArea();
		aicamptstealtextarea.setEditable(false);
		aicamptstealtextarea.setBounds(617, 105, 167, 128);
		contentPane.add(aicamptstealtextarea);
		
		JButton Buttonforpeople = new JButton("Start");
		Buttonforpeople.setBounds(85, 256, 85, 21);
		contentPane.add(Buttonforpeople);
		
		JButton buttonforfood = new JButton("Start");
		buttonforfood.setBounds(283, 256, 85, 21);
		contentPane.add(buttonforfood);
		
		JButton buttonforresources = new JButton("Start");
		buttonforresources.setBounds(467, 256, 85, 21);
		contentPane.add(buttonforresources);
		
		JButton stealaicampbutton = new JButton("Start");
		stealaicampbutton.setBounds(662, 256, 85, 21);
		contentPane.add(stealaicampbutton);
		
		JButton goback = new JButton("Back");
		goback.setBounds(383, 485, 85, 21);
		goback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainGameGUI.frame.setAlwaysOnTop(true);
				MainGameGUI.frame.setAlwaysOnTop(false);
				MainGameGUI.frame.setEnabled(true);
			}
		});
		contentPane.add(goback);
		
		JTextArea textAreaforfinsihedtable = new JTextArea();
		textAreaforfinsihedtable.setBounds(85, 297, 649, 178);
		contentPane.add(textAreaforfinsihedtable);
		
		testareaforpeople.append("This is to search for people " + "\n" + "for your village, to start" + "\n" + "you need " + "20 people and " + "\n" + "you have " + PlayerObject.peopleInMilitary+  " in your village");
		if( PlayerObject.peopleInMilitary >= 20)
		{
			Buttonforpeople.setEnabled(true);
		}
		else
		{
			Buttonforpeople.setEnabled(false);
		}
		
		textareaforfood.append("This is to search for food " + "\n" + "for your village, to start" + "\n" + "you need " + "15 people and " + "\n" + "you have " + PlayerObject.peopleInMilitary + " in " +  "your village");
		if(PlayerObject.peopleInMilitary >= 14 )
		{
			buttonforfood.setEnabled(true);
		}
		else 
		{
			buttonforfood.setEnabled(false);
		}
		
		recoursetextarea.append("This is to search for resources " + "\n"+  "for your village, to start" + "\n" + "you need " + "10 people and " + "\n" + "you have " + PlayerObject.peopleInMilitary + " in " + "your village");
		if( PlayerObject.peopleInMilitary >= 10)
		{
			buttonforresources.setEnabled(true);
		}
		else
		{
			buttonforresources.setEnabled(false);
		}
		
		aicamptstealtextarea.append("This is to search for resources " + "\n" + "for your village, to start" + "\n" + "you need " + "10 people and " + "\n" + "you have " + PlayerObject.peopleInMilitary + " in " + "your village");
		if( PlayerObject.peopleInMilitary >= 10)
		{
			stealaicampbutton.setEnabled(true);
		}
		else
		{
			stealaicampbutton.setEnabled(false);
		}
		
		Buttonforpeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaforfinsihedtable.setText("");
				for (int i = 0; i < 10; i++) {
		            if (obtainItem(random)) {
		            	textAreaforfinsihedtable.append("Item obtained!" + "\n");
		            	counter1++;
		            } 
		            
		            else {
		            	textAreaforfinsihedtable.append("No item this time." + "\n");
		            }
		        }
				textAreaforfinsihedtable.append("You got " + counter1 + " people for your village.");
				PlayerObject.totalPeople = counter1 + PlayerObject.totalPeople;
				counter1 = 0;
				System.out.println(PlayerObject.totalPeople);
		    }
				
			}
		);
	
		buttonforfood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaforfinsihedtable.setText("");
				for (int i = 0; i < 10; i++) {
		            if (obtainItem2(random)) {
		            	textAreaforfinsihedtable.append("Item obtained!" + "\n");
		            	counter2++;
		            	
		            } 
		            
		            else {
		            	textAreaforfinsihedtable.append("No item this time." + "\n");
		            }
		        }
				textAreaforfinsihedtable.append("You got " + counter2 + " food for your village.");
				PlayerObject.food = counter2 + PlayerObject.food;
				counter2 = 0;
				System.out.println(PlayerObject.food);
			}
		});
		
		buttonforresources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaforfinsihedtable.setText("");
				for (int i = 0; i < 10; i++) {
		            if (obtainItem(random)) {
		            	textAreaforfinsihedtable.append("Item obtained!" + "\n");
		            	counter3++;
		            	
		            } 
		            
		            else {
		            	textAreaforfinsihedtable.append("No item this time." + "\n");
		            }
		        }
				textAreaforfinsihedtable.append("You got " + counter3 + " resources for your village.");
				PlayerObject.miningAndWood = counter3 + PlayerObject.miningAndWood;
				counter3 = 0;
				System.out.println(PlayerObject.miningAndWood);
			}
		});
		
		stealaicampbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaforfinsihedtable.setText("");
				for (int i = 0; i < 10; i++) {
		            if (obtainItem3(random)) {
		            	textAreaforfinsihedtable.append("Item obtained!" + "\n");
		            	counter4++;
		            	
		            } 
		            
		            else {
		            	textAreaforfinsihedtable.append("No item this time." + "\n");
		            }
		        }
				textAreaforfinsihedtable.append("You got " + counter4 + " resources for your village.");
				PlayerObject.miningAndWood = counter4 + PlayerObject.miningAndWood;
				counter4 = 0;
				System.out.println(PlayerObject.miningAndWood);
			}
		});
		
		goback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
	}
private static boolean obtainItem(Random random) {
    return random.nextDouble() < 0.1;
}

private static boolean obtainItem2(Random random) {
    return random.nextDouble() < 0.2;
}

private static boolean obtainItem3(Random random) {
    return random.nextDouble() < 0.25;
}
}
