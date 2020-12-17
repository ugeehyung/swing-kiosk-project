package login.mainmenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import login.design.Style;
import login.page.MainPage;

public class _08reservation extends JPanel implements ActionListener {
	static LocalDateTime time11;
	static int price11;
	static int price;
	static String type11;

//	static ArrayList<Integer> limitSingle;
//	static ArrayList<Integer> limitRoom;
//	static ArrayList<Integer> limitLocker;
//
//	static {
//		for (int i = 0; i < 20; i++)
//			limitSingle.add(0);
//		for (int i = 0; i < 4; i++)
//			limitRoom.add(0);
//		for (int i = 0; i < 20; i++)
//			limitLocker.add(0);
//	}

	public static String number = "";
	JLabel label_msg;
	static LocalDateTime time_now = LocalDateTime.now();
	String time_checkout;

	int a = 0;
	int d = 0;
	int e = 0;
	int f = 0;
	int g = 0;
	int c = 0;
	static ArrayList<JButton> seats_btn = new ArrayList<>(); // 1~20번 좌석 (1인석) 버튼
	{
		for (int i = 0; i < 20; i++) {
			seats_btn.add(new JButton());
		}
	}
	static ArrayList<JButton> room_btn = new ArrayList<>(); // 1~20번 좌석 (1인석) 버튼
	{
		for (int i = 0; i < 4; i++) {// 0~3
			room_btn.add(new JButton());
		}
	}
	static ArrayList<JButton> locker_btn = new ArrayList<>(); // 1~20번 좌석 (1인석) 버튼
	{
		for (int i = 0; i < 20; i++) {
			locker_btn.add(new JButton());
		}
	}

	public _08reservation(LocalDateTime ss, int price, String seat_type) {

		new Style(this);
		JButton OK;
		JButton back;
//		JLabel label = new JLabel("1인석");
//		new Style(label);
//		JLabel label02 = new JLabel("룸");
//		new Style(label02);
//		label_msg = new JLabel("");
//		new Style(label_msg);
//		label.setBounds(10,10,50,30);
//		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
//		this.add(label);
//		label02.setBounds(10,103,50,30);
//		label02.setFont(new Font("맑은 고딕", Font.BOLD, 15));
//	 
//		label_msg.setBounds(200,310,500,30);
//		label_msg.setFont(new Font("맑은 고딕", Font.BOLD, 15));
//		this.add(label_msg); 
//		this.add(label02);

		JLabel label03 = new JLabel("사물함");
		label03.setBounds(15, 350, 50, 30);
		label03.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		this.add(label03);
		label03.setForeground(Color.gray);

		JLabel label04 = new JLabel("휴게실");
		label04.setOpaque(true);
		label04.setBorder(BorderFactory.createLineBorder(Color.gray));
		label04.setBackground(Color.black);
		label04.setForeground(Color.decode("#5590cf"));
		label04.setBounds(250, 255, 180, 85);
		label04.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label04.setHorizontalAlignment(JLabel.CENTER);
		this.add(label04);

		JLabel label05 = new JLabel("사용 가능");
		label05.setOpaque(true);
		label05.setBackground(Color.black);
		label05.setForeground(Color.orange);
		label05.setHorizontalAlignment(JLabel.CENTER);
		label05.setBounds(40, 465, 100, 30);
		this.add(label05);

		JLabel label06 = new JLabel("사용 중");
		label06.setOpaque(true);
		label06.setBackground(Color.black);
		label06.setForeground(Color.gray);
		label06.setHorizontalAlignment(JLabel.CENTER);
		label06.setBounds(40, 500, 100, 30);
		this.add(label06);

		for (int i = 0; i < 3; i++) {// 1인석 버튼 위치 설정
			seats_btn.get(i).setBackground(Color.BLACK);
			seats_btn.get(i).setText(i + 1 + "번");
			seats_btn.get(i).setForeground(Color.orange);
			this.add(seats_btn.get(i));
			seats_btn.get(i).addActionListener(new ActionBtn_select(seats_btn.get(i)));
			seats_btn.get(i).setBounds(30 + f, 40, 60, 60);
			f += 60;
			seats_btn.get(i).setEnabled(true);
			if (!(price >= 3000 && price <= 10000 || price >= 90000)) {
				seats_btn.get(i).setEnabled(false);
			}
		}
		for (int i = 3; i < 6; i++) {// 1인석 버튼 위치 설정
			seats_btn.get(i).setBackground(Color.BLACK);
			seats_btn.get(i).setText(i + 1 + "번");
			seats_btn.get(i).setForeground(Color.orange);
			this.add(seats_btn.get(i));
			seats_btn.get(i).addActionListener(new ActionBtn_select(seats_btn.get(i)));
			seats_btn.get(i).setBounds(70 + f, 40, 60, 60);
			f += 60;
			seats_btn.get(i).setEnabled(true);
			if (!(price >= 3000 && price <= 10000 || price >= 90000)) {
				seats_btn.get(i).setEnabled(false);
			}
		}
		for (int i = 6; i < 11; i++) {// 1인석 버튼 위치 설정
			seats_btn.get(i).setBackground(Color.BLACK);
			seats_btn.get(i).setText(i + 1 + "번");
			seats_btn.get(i).setForeground(Color.orange);
			this.add(seats_btn.get(i));
			seats_btn.get(i).addActionListener(new ActionBtn_select(seats_btn.get(i)));
			seats_btn.get(i).setBounds(120 + f, 40 + a, 60, 60);
			a += 60;
			seats_btn.get(i).setEnabled(true);
			if (!(price >= 3000 && price <= 10000 || price >= 90000)) {
				seats_btn.get(i).setEnabled(false);
			}
		}
		for (int i = 11; i < 14; i++) { // 1인석 버튼 위치 설정
			seats_btn.add(new JButton());
			seats_btn.get(i).setBackground(Color.BLACK);
			seats_btn.get(i).setText(i + 1 + "번");
			seats_btn.get(i).setForeground(Color.orange);
			this.add(seats_btn.get(i));
			seats_btn.get(i).addActionListener(new ActionBtn_select(seats_btn.get(i)));
			seats_btn.get(i).setBounds(30 + g, 110, 60, 60);
			g += 60;
			seats_btn.get(i).setEnabled(true);
			if (!(price >= 3000 && price <= 10000 || price >= 90000)) {
				seats_btn.get(i).setEnabled(false);
			}
		}
		for (int i = 14; i < 17; i++) { // 1인석 버튼 위치 설정
			seats_btn.add(new JButton());
			seats_btn.get(i).setBackground(Color.BLACK);
			seats_btn.get(i).setText(i + 1 + "번");
			seats_btn.get(i).setForeground(Color.orange);
			this.add(seats_btn.get(i));
			seats_btn.get(i).addActionListener(new ActionBtn_select(seats_btn.get(i)));
			seats_btn.get(i).setBounds(70 + g, 110, 60, 60);
			g += 60;
			seats_btn.get(i).setEnabled(true);
			if (!(price >= 3000 && price <= 10000 || price >= 90000)) {
				seats_btn.get(i).setEnabled(false);
			}
		}
		g -= 180;
		for (int i = 17; i < 20; i++) { // 1인석 버튼 위치 설정
			seats_btn.add(new JButton());
			seats_btn.get(i).setBackground(Color.BLACK);
			seats_btn.get(i).setText(i + 1 + "번");
			seats_btn.get(i).setForeground(Color.orange);
			this.add(seats_btn.get(i));
			seats_btn.get(i).addActionListener(new ActionBtn_select(seats_btn.get(i)));
			seats_btn.get(i).setBounds(70 + g, 190, 60, 60);
			g += 60;
			seats_btn.get(i).setEnabled(true);
			if (!(price >= 3000 && price <= 10000 || price >= 90000)) {
				seats_btn.get(i).setEnabled(false);
			}
		}

		for (int i = 0; i < 2; i++) {// 0~3
			room_btn.get(i).setBackground(Color.BLACK);
			room_btn.get(i).setText(i + 101 + "호");
			room_btn.get(i).setForeground(Color.orange);
			this.add(room_btn.get(i));
			room_btn.get(i).addActionListener(new ActionBtn_select(room_btn.get(i)));
			room_btn.get(i).setBounds(30 + e, 190, 90, 75);
			e += 90;
			room_btn.get(i).setEnabled(true);
			if (!(price >= 12000 && price <= 40000 && price != 25000))
				room_btn.get(i).setEnabled(false);
		}

		for (int i = 2; i < 4; i++) {// 0~3
			room_btn.get(i).setBackground(Color.BLACK);
			room_btn.get(i).setText(i + 101 + "호");
			room_btn.get(i).setForeground(Color.orange);
			this.add(room_btn.get(i));
			room_btn.get(i).addActionListener(new ActionBtn_select(room_btn.get(i)));
			room_btn.get(i).setBounds(30 + d, 265, 90, 75);
			d += 90;
			room_btn.get(i).setEnabled(true);
			if (!(price >= 12000 && price <= 40000 && price != 25000))
				room_btn.get(i).setEnabled(false);
		}
		for (int i = 0; i < 10; i++) {// 사물함 버튼 위치 설정
			locker_btn.get(i).setBackground(Color.BLACK);
			locker_btn.get(i).setText(i + 1 + "번");
			locker_btn.get(i).setForeground(Color.orange);
			this.add(locker_btn.get(i));
			locker_btn.get(i).addActionListener(new ActionBtn_select(locker_btn.get(i)));
			locker_btn.get(i).setBounds(10 + c, 380, 60, 30);
			c += 55;
			locker_btn.get(i).setEnabled(true);
			if (price != 25000) {
				locker_btn.get(i).setEnabled(false);
			}

		}
		d = 0;
		for (int i = 10; i < 20; i++) { // 사물함 버튼 위치 설정
			locker_btn.get(i).setBackground(Color.BLACK);
			locker_btn.get(i).setText(i + 1 + "번");
			locker_btn.get(i).setForeground(Color.orange);
			this.add(locker_btn.get(i));
			locker_btn.get(i).addActionListener(new ActionBtn_select(locker_btn.get(i)));
			locker_btn.get(i).setBounds(10 + d, 410, 60, 30);
			d += 55;
			locker_btn.get(i).setEnabled(true);
			if (price != 25000) {
				locker_btn.get(i).setEnabled(false);
			}
		}

		//System.out.println(seats_btn.get(0).getSize() +" " + room_btn.get(0).getSize() + " " + locker_btn.get(0).getSize());
		
		ActionListener back_btn = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				for (int i = 0; i < 20; i++) {
					seats_btn.get(i).setSelected(false);
				}
				for (int i = 0; i < 4; i++) {
					room_btn.get(i).setSelected(false);
				}
				for (int i = 0; i < 20; i++) {
					locker_btn.get(i).setSelected(false);
				}

				MainPage.main_cards.show(MainPage.main_page_panel, "사용자메뉴");
				MainPage.user_cards.show(MainPage.user_page_panel, "이용권구매");
				MainPage.userToggle = "이용권구매";
				number = "";
			}
		};

		back = new JButton("이전 화면");
		new Style(back);
		back.setBounds(200, 460, 150, 80);
		this.add(back);
		back.addActionListener(back_btn);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "hr", "1234");
//			//시간 비교
//			String sql = "SELECT seat_number, time_checkout FROM seat "
//					+ "WHERE seat_statement ='사용 중'";
//			PreparedStatement pstm = conn.prepareStatement(sql);
//			ResultSet rs = pstm.executeQuery();
//		 
//			while(rs.next()) {//퇴실 시간 지난 좌석 퇴실처리
//				int seat_chk = rs.getInt("seat_number");
//				Timestamp time_chk = rs.getTimestamp("time_checkout");
//				if(time_now.isAfter(Time.TimeStampTOlocalDateTime(time_chk))) {
//					String change = "update seat set Seat_Statement ='사용 가능',time_enter=null,time_checkout=null where Seat_Number= ?";
//					PreparedStatement pstmtas = conn.prepareStatement(change);
//					pstmtas.setInt(1, seat_chk);
//					int row3 = pstmtas.executeUpdate();
//				}  
//			} 

			// 사용중인 좌석이면 체크박스 체크 및 비활성화
			String sql = "select seat_number from seat where seat_statement='사용 중'";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			System.out.print("예약된 자리 : ");

			while (rs.next()) {
				int sn = rs.getInt("seat_number");
				if (sn <= 20) {
					System.out.printf("%d번 ", sn);
					seats_btn.get(sn - 1).setSelected(true);
					seats_btn.get(sn - 1).setEnabled(false);
				} else if (sn >= 101) {
					System.out.printf("[%d호] ", sn);
					room_btn.get(sn - 101).setSelected(true);
					room_btn.get(sn - 101).setEnabled(false);
				}
			}

//			// 사용중인 사물함 중 이용기간이 지나면 사용가능으로 업데이트
//						sql = "SELECT Locker_Number,l_time_checkout FROM locker "
//								+ "WHERE Locker_Statement='사용 중'";
//						 pstm = conn.prepareStatement(sql);
//						 rs = pstm.executeQuery();
//					 
//						while(rs.next()) { 
//							int locker_chk = rs.getInt("Locker_Number");
//							Timestamp l_time_chk = rs.getTimestamp("l_time_checkout");
//							if(time_now.isAfter(Time.TimeStampTOlocalDateTime(l_time_chk))) {
//								String change = "update locker set Locker_Statement ='사용 가능',l_time_enter=null,l_time_checkout=null where Locker_Number= ?";
//								PreparedStatement pstm2 = conn.prepareStatement(change);
//								pstm2.setInt(1, locker_chk);
//								int row4 = pstm2.executeUpdate();
//							}  
//						}

			// 사용중인 사물함이면 체크박스 체크 및 비활성화
			sql = "select locker_number from locker where locker_statement='사용 중'";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			System.out.println();
			System.out.printf("예약된 사물함 : ");
			while (rs.next()) {
				int sn = rs.getInt("locker_number");
				System.out.printf("%d번 ", sn);
				locker_btn.get(sn - 1).setSelected(true);
				locker_btn.get(sn - 1).setEnabled(false);

			}

			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
			if (conn != null)
				conn.close();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}

		OK = new JButton("결제하기");
		new Style(OK);
		OK.setBounds(360, 460, 150, 80);
		this.add(OK);
		OK.addActionListener(this);

		setSize(600, 500);
		setLocation(600, 150);

		this.setBounds(0, 100, 600, 500);
		this.setLayout(null);
		time11 = ss;
		price11 = price;
		type11 = seat_type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int count_only = 0;
		int count_only2 = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "hr", "1234");
			PreparedStatement pstmt = null;

			String msg = "";

			price = 0;
			if ((price11 >= 3000 && price11 <= 10000 || price11 >= 90000)) {
				for (int i = 0; i <= 19; i++) {// 자리 체크(비활성화 되있는건 제외)
					if (seats_btn.get(i).isSelected() && (seats_btn.get(i).isEnabled() == true)) {
						msg = i + 1 + "번 (1인석) 자리\n";
						number += i + 1 + "번 좌석 ";

						price += price11;
						count_only++;
					}
				}
			}
			if (price11 >= 12000 && price11 <= 40000 && price11 != 25000) {
				for (int i = 0; i <= 3; i++) {
					if (room_btn.get(i).isSelected() && (room_btn.get(i).isEnabled() == true)) {
						msg = i + 101 + "호 룸\n";
						number += i + 101 + " 호 룸 ";

						price += price11;
						count_only++;

					}
				}
			}
			if (price11 == 25000) {
				for (int i = 0; i <= 19; i++) {
					if (locker_btn.get(i).isSelected() && (locker_btn.get(i).isEnabled() == true)) {
						msg = i + 1 + "번 사물함\n";
						number += i + 1 + "번 사물함 ";
						price += price11;
						count_only++;
					}
				}
			}

			msg += "결제하시겠습니까?";
			if (count_only == 0) {
				msg = "결제할 자리를 선택해주세요";
				JOptionPane.showMessageDialog(this, msg);// 예약이 없으면 다시선택 메세지 창 띄우기(메세지 길이로 체크)
			} else if (count_only > 1) {
				String warning = "   1인 1선택 가능";
				JOptionPane.showMessageDialog(this, warning);
				number = "";
			} else {
				// (창끄기 or 예 or 취소)버튼

				int result = JOptionPane.showConfirmDialog(null, msg, "Message", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {
					// (재 확인 창 끄기)
				} else if (result == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(this, "취소");// 취소 메세지
				} else {
					setVisible(false);
					// yes버튼 -> 결제 페이지

					MainPage.user_page_panel.add("결제페이지", new _09payment(time11, price, type11));
					MainPage.main_cards.show(MainPage.main_page_panel, "사용자메뉴");
					MainPage.user_cards.show(MainPage.user_page_panel, "결제페이지");
					MainPage.userToggle = "결제페이지";

				}
			}
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

}
