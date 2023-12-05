import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.util.Random;

public class MilitarytablleGUI extends JFrame {
	public static int peopleInMilitary;
	public static double food;
	public static double miningAndWood;
	public static int totalPeople;
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MilitarytablleGUI frame = new MilitarytablleGUI();
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
	public MilitarytablleGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton buttonforrecourses = new JButton("Start");
		buttonforrecourses.setBounds(467, 256, 85, 21);
		contentPane.add(buttonforrecourses);
		
		JButton stealaicampbutton = new JButton("Start");
		stealaicampbutton.setBounds(662, 256, 85, 21);
		contentPane.add(stealaicampbutton);
		
		JButton goback = new JButton("Back");
		goback.setBounds(383, 485, 85, 21);
		contentPane.add(goback);
		
		JTextArea textAreaforfinsihedtable = new JTextArea();
		textAreaforfinsihedtable.setBounds(85, 297, 649, 178);
		contentPane.add(textAreaforfinsihedtable);
		
		testareaforpeople.append("This is to search for people " + "\n" + "for your village, to start you need" + "\n" + "20 people and you have " + peopleInMilitary+ " \n" + " in your village");
		if( 100 >= 20)
		{
			Buttonforpeople.setEnabled(true);
		}
		else
		{
			Buttonforpeople.setEnabled(false);
		}
		
		textareaforfood.append("This is to search for food " + "\n" + "for your village, to start you need" + "\n"+ "15 people and you have " + peopleInMilitary + " in " + "\n" + "your village");
		if( 100 >= 14 )
		{
			buttonforfood.setEnabled(true);
		}
		else 
		{
			buttonforfood.setEnabled(false);
		}
		
		recoursetextarea.append("This is to search for recourses " + "\n" + "for your village, to start you need" + "\n"+ "10 people and you have " + peopleInMilitary + " in " + "\n" + "your village");
		if( 100 >= 10)
		{
			buttonforrecourses.setEnabled(true);
		}
		else
		{
			buttonforrecourses.setEnabled(false);
		}
		
		aicamptstealtextarea.append("This is to search for recourses " + "\n" + "for your village, to start you need" + "\n"+ "10 people and you have " + peopleInMilitary + " in " + "\n" + "your village");
		if( peopleInMilitary >= 10)
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
		            } else {
		            	textAreaforfinsihedtable.append("No item this time." + "\n");
		            }
		        }
				textAreaforfinsihedtable.append("You got " + counter1 + " people for your village.");
				totalPeople = counter1 + totalPeople;
				counter1 = 0;
				System.out.println(totalPeople);
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
		            	
		            } else {
		            	textAreaforfinsihedtable.append("No item this time." + "\n");
		            }
		        }
				textAreaforfinsihedtable.append("You got " + counter2 + " food for your village.");
				food = counter2 + food;
				counter2 = 0;
				System.out.println(food);
			}
		});
		
		buttonforrecourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaforfinsihedtable.setText("");
				for (int i = 0; i < 10; i++) {
		            if (obtainItem(random)) {
		            	textAreaforfinsihedtable.append("Item obtained!" + "\n");
		            	counter3++;
		            	
		            } else {
		            	textAreaforfinsihedtable.append("No item this time." + "\n");
		            }
		        }
				textAreaforfinsihedtable.append("You got " + counter3 + " recourses for your village.");
				miningAndWood = counter3 + miningAndWood;
				counter3 = 0;
				System.out.println(miningAndWood);
			}
		});
		
		stealaicampbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaforfinsihedtable.setText("");
				for (int i = 0; i < 10; i++) {
		            if (obtainItem3(random)) {
		            	textAreaforfinsihedtable.append("Item obtained!" + "\n");
		            	counter4++;
		            	
		            } else {
		            	textAreaforfinsihedtable.append("No item this time." + "\n");
		            }
		        }
				textAreaforfinsihedtable.append("You got " + counter4 + " recourses for your village.");
				miningAndWood = counter4 + miningAndWood;
				counter4 = 0;
				System.out.println(miningAndWood);
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
