package studyroom.admin.adminmode;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import studyroom.MainPage;
import studyroom.design.Style;

public class PassChangePage extends JPanel implements ActionListener{

	JButton back;

	static JScrollPane scroll;

	static ArrayList<JFormattedTextField> text = new ArrayList<>(); 
	{
		for (int i = 0; i < 4; i++) {
			text.add(new JFormattedTextField(new NumberFormatter()));
			text.get(i).setText("0");
		}
	}

	public static ArrayList<JComboBox<String>> combobox; 


	ArrayList<JButton> change = new ArrayList<>();
	{
		for (int i = 0; i < 4; i++) {
			change.add(new JButton("???? ????"));
		}
	}

	int a=0;
	int b=0;
	int c=0;
	int d=0;
	public PassChangePage() { 
		combobox = new ArrayList<JComboBox<String>>();
		combobox.add(new JComboBox<String>(new ManagementDate().passTable));
		combobox.add(new JComboBox<String>(new ManagementDate().passTable2));
		combobox.add(new JComboBox<String>(new ManagementDate().passTable3));
		combobox.add(new JComboBox<String>(new ManagementDate().passTable4));

		setLayout(null);
		new Style(this);

		scroll = new JScrollPane();
		new Style(scroll); 
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		scroll.getHorizontalScrollBar().setUnitIncrement(10);
		scroll.setBounds(72, 215, 560, 250);
		add(scroll);


		for(int i=0;i<4;i++) {
			combobox.get(i).setBounds(72, 50+a, 200, 30);
			add(combobox.get(i));
			new Style(combobox.get(i));
			a+=40;
		}
		for(int i=0; i<4;i++) { 
			new Style(text.get(i));
			text.get(i).setBounds(300, 50+b, 65, 30);
			add(text.get(i));
			text.get(i).setColumns(10);
			b+=40;
		}
		for(int i=0; i<4;i++) { 
			new Style(change.get(i));
			change.get(i).setBounds(380, 50+c, 100, 30);
			change.get(i).setFont(new Font("???? ????", Font.BOLD, 13));
			add(change.get(i));
			c+=40;
		}

		change.get(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PassChangeDB(1, 0); 
			}
		});
		change.get(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PassChangeDB(1, 1); 
			}
		});
		change.get(2).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PassChangeDB(1, 2); 
			}
		});
		change.get(3).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PassChangeDB(1, 3); 
			}
		});

		back = new JButton("????");
		new Style(back);
		back.setBounds(540, 480, 90, 30);
		add(back);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				MainPage.main_cards.show(MainPage.main_page_panel, "?????ڸ޴?");
				MainPage.userToggle = "?????ڸ޴?";
			}
		}); 
		new PassChangeDB(1,5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainPage.main_page_panel.add("?̿??? ???? ????", new PassChangePage());
		MainPage.main_cards.show(MainPage.main_page_panel, "?̿??? ???? ????");
		MainPage.userToggle = "?̿??? ???? ????"; 
	} 
}