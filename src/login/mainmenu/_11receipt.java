package login.mainmenu;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import login.design.Style;
import login.page.MainPage;
import login.swingTools.State;

public class _11receipt extends JPanel {

	JTable table;
	   DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분 ss초");

	   String type;
	   
	   public _11receipt(String type) {
		this.type = type;
	}
	   
	public _11receipt(LocalDateTime ss, int price) {
		
		MainPage.updateTable.add(new State());
		MainPage.statecard.next(MainPage.updateTable);

		setLayout(null);
		new Style(this);
		setVisible(true);

		JPanel p2 = new JPanel();
		new Style(p2);
		p2.setBounds(0, 0, 800, 600);
		p2.setLayout(null);
		add(p2);

		JLabel headTitle = new JLabel("<html><pre>KG STUDY</pre>");
		new Style(headTitle);
		headTitle.setBounds(300, 0, 440, 80);
		headTitle.setFont(new Font("Courier", Font.PLAIN, 35));
		p2.add(headTitle);
		
		JLabel smallTtile = new JLabel("KG STUDY");
		new Style(smallTtile);
		smallTtile.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		smallTtile.setBounds(100, 70, 150, 20);
		p2.add(smallTtile);
		
		JLabel paidTime = new JLabel(_09payment.time_now.format(dateTimeFormatter).substring(0, 24));
		new Style(paidTime);
		paidTime.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		paidTime.setBounds(370, 70, 250, 20);
		p2.add(paidTime);
		
		JLabel businessNum = new JLabel("사업자번호:1541600462");
		new Style(businessNum);
		businessNum.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		businessNum.setBounds(100, 90, 170, 20);
		p2.add(businessNum);

		JLabel ceo = new JLabel("대표:서민주");
		new Style(ceo);
		ceo.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		ceo.setBounds(100, 110, 170, 20);
		p2.add(ceo);
		
		JLabel address = new JLabel("서울 강남구 강남대로84길 16 11, 12층");
		new Style(address);
		address.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		address.setBounds(100, 130, 250, 20);
		p2.add(address);
		
		String header1[] = { "상품명", "단가", "수량", "금액" };
		String contents1[][] = { { _08reservation.type11, Integer.toString((_08reservation.price)),
			"1", String.valueOf(_08reservation.price * Integer.parseInt("1"))}
				};
		
		DefaultTableModel model1 = new DefaultTableModel(contents1, header1);
		
		JTable priceTable = new JTable(model1);
		new Style(priceTable);
		priceTable.setBounds(57, 104, 390, 50);
		priceTable.setRowHeight(35);
		p2.add(priceTable);
		
		String header2[] = { "결제", "정보" };
		String contents2[][] = { { "회원 번호", _08reservation.number },
				 { "퇴실(만료) 예정 시간", ss.format(dateTimeFormatter).substring(0, 24) },
				{ "결제 금액", Integer.toString((_08reservation.price)) }, 
				{ "공급가금액", String.valueOf(_08reservation.price / 1.1) },
				{ "부가세", String.valueOf(_08reservation.price - _08reservation.price / 1.1) },
				{ "투입 금액", Integer.toString(price)  },
				{ "거스름 돈", Integer.toString(_10paycash.change) } };

		DefaultTableModel model2 = new DefaultTableModel(contents2, header2);

		table = new JTable(model2);
		new Style(table);
		table.setBounds(57, 154, 390, 250);
		table.setRowHeight(35);
		p2.add(table);
		
		JLabel payType = new JLabel("거래종류:"+type);
		new Style(payType);
		payType.setBounds(57, 434, 130, 20);
		p2.add(payType);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "hr", "1234");
			PreparedStatement pstmt = null;
		  
			PreparedStatement readPrice = conn
					.prepareStatement("SELECT payment FROM payment_record where person_id = ?");
			readPrice.setInt(1, _00main.id);
			ResultSet rs = readPrice.executeQuery();

			int payment = 0;
			while (rs.next()) {
				payment = rs.getInt(1);
			}

			String total_payment = "update person_info set total_payment = total_payment + ? where person_id = ?";
			pstmt = conn.prepareStatement(total_payment);
			pstmt.setInt(1, payment);
			pstmt.setInt(2, _00main.id);
			int rowtp = pstmt.executeUpdate();

			if (rs != null) rs.close();
			if (readPrice != null) readPrice.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
