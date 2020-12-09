package mainmenu;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.swing.JButton;

public class _12paycash_locker {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JTextField cash;
	LocalDateTime time_now = LocalDateTime.now();
  
	public _12paycash_locker()  {
		frame = new JFrame();
		frame.setBounds(600, 150, 420, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 381, 266);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		String price ="10000";

		JLabel lblNewLabel = new JLabel("결제 금액 : "+price+"원");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(57, 49, 236, 39);
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("입금 금액");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_1.setBounds(57, 98, 120, 39);
		panel.add(lblNewLabel_1);

		cash = new JTextField();
		cash.setBounds(173, 98, 120, 40);
		panel.add(cash);
		cash.setColumns(10);

		JButton pay_btn = new JButton("결제");
		pay_btn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		pay_btn.setBounds(116, 181, 140, 39);
		panel.add(pay_btn);

		pay_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(price)<=Integer.parseInt(cash.getText())) {
					
					int change = Integer.parseInt(cash.getText())-Integer.parseInt(price);
					String msg= "거스름 돈 : "+Integer.toString(change)+"원\n 결제 완료";
					JOptionPane.showMessageDialog(null,msg); 
				  
					
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521/XEPDB1",
						"hr",
						"1234"
						);
				PreparedStatement pstmt = null; 
		for(int i=0;i<20;i++) { 
						 
			if( _05selectLocker.lockers.get(i).isSelected()&&(_05selectLocker.lockers.get(i).isEnabled()==true)) {
				_05selectLocker.lockers.get(i).setEnabled(false);
				String sql3 = "update locker set Locker_Statement ='사용 중' where Locker_Number= ?";
				pstmt = conn.prepareStatement(sql3);
				pstmt.setInt(1, i+1);
				int row3 = pstmt.executeUpdate();
		
				String sqlt2 = "update locker set l_time_enter =?,l_time_checkout=? where Locker_Number= ?";
				pstmt = conn.prepareStatement(sqlt2);
				pstmt.setTimestamp(1, Time.localDateTimeTOTimeStamp(time_now));
				pstmt.setTimestamp(2, Time.localDateTimeTOTimeStamp(time_now.plusMonths(1)));
				pstmt.setInt(3, i+1);
				int rowt2 = pstmt.executeUpdate();
								
				//결제테이블에 저장
				String sql_pay = " insert into Payment_Record(Paid_Time,Exit_Time,Locker_Type,Pay_Method,Payment) values(?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql_pay);
				pstmt.setTimestamp(1, Time.localDateTimeTOTimeStamp(time_now));
				pstmt.setTimestamp(2, Time.localDateTimeTOTimeStamp(time_now.plusMonths(1)));
				pstmt.setString(3, "1달 이용권");
				pstmt.setString(4, "현금");
				pstmt.setInt(5,25000);
				int rowp = pstmt.executeUpdate();

				System.out.printf("%d번 사물함이 예약되었습니다.(%d행 업데이트)\n", i+1,row3);
				System.out.printf("입실/퇴실 시간이 업데이트되었습니다.(%d행 업데이트)\n",rowt2);
				System.out.printf("결제 기록이 업데이트되었습니다.(%d행 업데이트)\n",rowp);						   
				}
			}
		System.exit(0);
						 
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
			} catch (ClassNotFoundException | SQLException e1) { 
				e1.printStackTrace();
			} 	 
		}else {
			int change2 = Integer.parseInt(price)-Integer.parseInt(cash.getText()) ;
			String msg2= Integer.toString(change2)+"원이 부족합니다";
			JOptionPane.showMessageDialog(null,msg2); 
		}

	}
});

	}
	public static void main(String[] args) {
		_12paycash_locker window = new _12paycash_locker();
		window.frame.setVisible(true);
	}
}
