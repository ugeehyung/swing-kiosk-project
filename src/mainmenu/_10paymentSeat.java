package mainmenu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import mainmenu._08selectSeat;
import mainmenu._10paymentSeat;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;

public class _10paymentSeat {

	private JFrame frame;
	private JTable table;
	LocalDateTime time_now = LocalDateTime.now();
	String time_checkout;
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분 s초");
  
	_10paymentSeat(LocalDateTime ss,int seat_price, String seat_type) {
		frame = new JFrame();
		frame.setSize(750,500);
		frame.setLocation(600,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setVisible(true);

		JPanel p2 = new JPanel();
		p2.setBounds(12, 10, 706, 453);
		frame.getContentPane().add(p2);
		p2.setLayout(null);



		String header[] = {"결제","정보"};
		String contents[][]= {
				{"좌석 번호",_08selectSeat.number},
				{"입실 시간",time_now.format(dateTimeFormatter)},
				{"퇴실 예정 시간",ss.format(dateTimeFormatter)}, 
				{"이용권",_08selectSeat.type11},
				{"결제 금액",Integer.toString((_08selectSeat.price11))}
		};


		DefaultTableModel model = new DefaultTableModel(contents,header);
		table = new JTable(model);
		table.setBounds(135, 104, 437, 200);
		table.setRowHeight(40);

		Color color = UIManager.getColor("Table.gridColor");
		MatteBorder border = new MatteBorder(1, 1, 0, 0, color);
		table.setBorder(border);
		p2.add(table);

		JRadioButton card_btn = new JRadioButton("카드");
		card_btn.setBounds(361, 332, 121, 23);
		p2.add(card_btn);

		JRadioButton cash_btn = new JRadioButton("현금");
		cash_btn.setBounds(200, 332, 121, 23);
		p2.add(cash_btn);

		ButtonGroup group = new ButtonGroup();
		group.add(cash_btn);
		group.add(card_btn);


		JButton back_btn = new JButton("돌아가기");
		back_btn.setBounds(200, 381, 121, 42);
		p2.add(back_btn);

		JButton pay_btn = new JButton("결제하기");
		pay_btn.setBounds(361, 381, 121, 42);
		p2.add(pay_btn);

		pay_btn.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) { 
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521/XEPDB1",
							"hr",
							"1234"
							);
					PreparedStatement pstmt = null;

			if(cash_btn.isSelected()) {// 현금결제
				new _11paycash_seat();

			}


	if(card_btn.isSelected()==true) {//카드 결제
		int result= JOptionPane.showConfirmDialog(null, "카드를 삽입하세요","Message",JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.CLOSED_OPTION) {

		}else if(result==JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null,"취소");//취소 메세지
		}else {

		for(int i=0;i<20;i++) {//(카드 결제 버튼 누를시)
			if( _08selectSeat.seats.get(i).isSelected()&&(_08selectSeat.seats.get(i).isEnabled()==true)) {//이미 예약되있는 건(비활성화) 빼고 체크
				_08selectSeat.seats.get(i).setEnabled(false);
									
				//사용중으로 db저장
				String sql = "update seat set Seat_Statement ='사용 중' where Seat_Number= ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, i+1);
				int row = pstmt.executeUpdate();

				//입실/퇴실시간 저장
				String sqlt1 = "update seat set time_enter =?,time_checkout=? where Seat_Number= ?";
				pstmt = conn.prepareStatement(sqlt1);
				pstmt.setTimestamp(1, Time.localDateTimeTOTimeStamp(time_now));
				pstmt.setTimestamp(2, Time.localDateTimeTOTimeStamp(ss));
				pstmt.setInt(3, i+1);
				int rowt1 = pstmt.executeUpdate();

				//결제테이블에 저장
				String sql_pay = " insert into Payment_Record(Paid_Time,Exit_Time,Seat_Type,Pay_Method,Payment) values(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql_pay);
				pstmt.setTimestamp(1, Time.localDateTimeTOTimeStamp(time_now));
				pstmt.setTimestamp(2, Time.localDateTimeTOTimeStamp(ss));
			    pstmt.setString(3, _08selectSeat.type11);
				pstmt.setString(4, "카드");
				pstmt.setInt(5,_08selectSeat.price11);
				int rowp = pstmt.executeUpdate(); 

				System.out.printf("%d번 자리가 예약되었습니다.(%d행 업데이트)\n", i+1,row);
				System.out.printf("입실/퇴실 시간이 업데이트되었습니다.(%d행 업데이트)\n",rowt1);
				System.out.printf("결제 기록이 업데이트되었습니다.(%d행 업데이트)\n",rowp);
			}

		}
			for(int i=0;i<4;i++) {
			if(_08selectSeat.room.get(i).isSelected()&&(_08selectSeat.room.get(i).isEnabled()==true)) {
			_08selectSeat.room.get(i).setEnabled(false);
			String sql2 = "update seat set Seat_Statement ='사용 중' where Seat_Number= ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, i+101);
			int row2 = pstmt.executeUpdate();

	     	String sqlt3 = "update seat set time_enter =?,time_checkout=? where Seat_Number= ?";
			pstmt = conn.prepareStatement(sqlt3);
			pstmt.setTimestamp(1, Time.localDateTimeTOTimeStamp(time_now));
			pstmt.setTimestamp(2, Time.localDateTimeTOTimeStamp(ss));
			pstmt.setInt(3, i+101);
			int rowt3 = pstmt.executeUpdate();
									
			//결제테이블에 저장
			String sql_pay = " insert into Payment_Record(Paid_Time,Exit_Time,Seat_Type,Pay_Method,Payment) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql_pay);
			pstmt.setTimestamp(1, Time.localDateTimeTOTimeStamp(time_now));
			pstmt.setTimestamp(2, Time.localDateTimeTOTimeStamp(ss));
			pstmt.setString(3, _08selectSeat.type11);
			pstmt.setString(4, "카드");
			pstmt.setInt(5,_08selectSeat.price11);
			int rowp = pstmt.executeUpdate();
									

			System.out.printf("%d호 룸이 예약되었습니다.(%d행 업데이트)\n", i+101,row2);
			System.out.printf("입실/퇴실 시간이 업데이트되었습니다.(%d행 업데이트)\n",rowt3); 
			System.out.printf("결제 기록이 업데이트되었습니다.(%d행 업데이트)\n",rowp);
		}	
	}  
			JOptionPane.showMessageDialog(null,"결제 완료"); 
			frame.setVisible(false);

			}
		}
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (ClassNotFoundException | SQLException e1) { 
			e1.printStackTrace();
				} 

			}
		}); 
		back_btn.addActionListener(new ActionListener() {

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		new _08selectSeat(_08selectSeat.time11,_08selectSeat.price11,_08selectSeat.type11); 
			}
		}); 
	} 
	public static void main(String[] args) {
		_10paymentSeat window = new _10paymentSeat(_08selectSeat.time11,_08selectSeat.price11,_08selectSeat.type11);
		window.frame.setVisible(true);
	}
 
}
