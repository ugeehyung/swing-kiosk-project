package studyroom.admin.adminmode;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import studyroom.MainPage;
import studyroom.design.Style;

public class MemberManagementPage extends JPanel implements ActionListener{

	JButton back;
	JButton num_member;
	JButton type;
	JButton current_user;

	static JScrollPane scrollPane;

	public static JComboBox<String> month;
	public static JComboBox<String> dayOrWeek;
	public static JComboBox<String> seat_room_locker;

	static JLabel totalmember;
	static JLabel newmember;


	public MemberManagementPage() {

		setLayout(null);
		new Style(this);

		totalmember = new JLabel();
		new Style(totalmember);
		totalmember.setBounds(72, 475, 150, 30);
		add(totalmember);

		newmember = new JLabel();
		new Style(newmember);
		newmember.setBounds(215, 475, 150, 30);
		add(newmember);

		scrollPane = new JScrollPane();
		new Style(scrollPane);

		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(20);
		scrollPane.setBounds(72, 110, 560, 350);
		add(scrollPane);

		month = new JComboBox<String>(new ManagementDate().monthTable2);
		month.setBounds(95, 65, 80, 30);
		add(month);
		new Style(month);

		dayOrWeek = new JComboBox<String>(new ManagementDate().typeTable);
		dayOrWeek.setBounds(276, 65, 80, 30);
		add(dayOrWeek);
		new Style(dayOrWeek);

		seat_room_locker = new JComboBox<String>(new ManagementDate().use_statusTable);
		seat_room_locker.setBounds(447, 65, 80, 30);
		add(seat_room_locker);
		new Style(seat_room_locker);

		num_member = new JButton("ȸ?? ??");
		new Style(num_member);
		num_member.setBounds(180, 65, 70, 30);
		add(num_member);

		num_member.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberDB(1); 
			}
		});

		type = new JButton("?̿???");
		new Style(type);
		type.setBounds(361, 65, 60, 30);
		add(type);

		type.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberDB(2); 
			}
		});

		current_user = new JButton("?̿? ??Ȳ");
		new Style(current_user);
		current_user.setBounds(532, 65, 70, 30);
		add(current_user);

		current_user.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemberDB(3); 
			}
		});

		back = new JButton("????");
		new Style(back);
		back.setBounds(540, 475, 90, 30);
		add(back);

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				MainPage.main_cards.show(MainPage.main_page_panel, "?????ڸ޴?");
				MainPage.userToggle = "?????ڸ޴?";
			}
		}); 
		new MemberDB(1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainPage.main_page_panel.add("ȸ??????", new MemberManagementPage());
		MainPage.main_cards.show(MainPage.main_page_panel, "ȸ??????");
		MainPage.userToggle = "ȸ??????";
	}
}