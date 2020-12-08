package mainmenu;

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



import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JDialog;

public class _10paymentSeat {

	private JFrame frame;
	private JTable table;
	LocalDateTime time_now = LocalDateTime.now();
	String time_checkout;
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy�� M�� d�� a h�� m�� s��");
	/**
	 * Launch the application.
	 */


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_10paymentSeat window = new _10paymentSeat(_08selectSeat.time11);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	 

	/**
	 * Initialize the contents of the frame.
	 */
	  _10paymentSeat(LocalDateTime ss) {
		frame = new JFrame();
		frame.setSize(750,500);
		frame.setLocation(1050,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setVisible(true);

		JPanel p2 = new JPanel();
		p2.setBounds(12, 10, 706, 453);
		frame.getContentPane().add(p2);
		p2.setLayout(null);

		time_checkout = time_now.plusHours(2).format(dateTimeFormatter);

		String header[] = {"����","����"};
		String contents[][]= {
				{"���� ��ȣ",_08selectSeat.number},
				{"�Խ� �ð�",time_now.format(dateTimeFormatter)},
				{"��� ���� �ð�",time_checkout}, 
				{"���� �ݾ�",""}
		};


		DefaultTableModel model = new DefaultTableModel(contents,header);
		table = new JTable(model);
		table.setBounds(135, 104, 437, 200);
		table.setRowHeight(40);
		p2.add(table);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("ī��");
		rdbtnNewRadioButton.setBounds(361, 332, 121, 23);
		p2.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("����");
		rdbtnNewRadioButton_1.setBounds(200, 332, 121, 23);
		p2.add(rdbtnNewRadioButton_1);

		JButton back_btn = new JButton("���ư���");
		back_btn.setBounds(200, 381, 121, 42);
		p2.add(back_btn);

		JButton pay_btn = new JButton("�����ϱ�");
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

					String msg="������ �Ϸ�Ǿ����ϴ�";
					JOptionPane.showMessageDialog(null, msg);

					for(int i=0;i<20;i++) {//(���� �Ϸ� ��ư ������)
						if( _08selectSeat.seats.get(i).isSelected()&&(_08selectSeat.seats.get(i).isEnabled()==true)) {//�̹� ������ִ� ��(��Ȱ��ȭ) ���� üũ
							_08selectSeat.seats.get(i).setEnabled(false);

							String sql = "update seat set Seat_Statement ='��� ��' where Seat_Number= ?";

							pstmt = conn.prepareStatement(sql);

							pstmt.setInt(1, i+1);
							int row = pstmt.executeUpdate();

							//�Խ�/��ǽð� ����
							String sqlt1 = "update seat set time_enter =?,time_checkout=? where Seat_Number= ?";
							pstmt = conn.prepareStatement(sqlt1);
							pstmt.setTimestamp(1, Time.localDateTimeTOTimeStamp(time_now));
							pstmt.setTimestamp(2, Time.localDateTimeTOTimeStamp(ss));
							pstmt.setInt(3, i+1);
							int rowt1 = pstmt.executeUpdate();

							System.out.printf("%d�� �ڸ��� ����Ǿ����ϴ�.(%d�� ������Ʈ)\n", i+1,row);
							System.out.printf("�Խ�/��� �ð��� ������Ʈ�Ǿ����ϴ�.(%d�� ������Ʈ)\n",rowt1);
						}
					
						
					}
					for(int i=0;i<4;i++) {
						if(_08selectSeat.room.get(i).isSelected()&&(_08selectSeat.room.get(i).isEnabled()==true)) {
							_08selectSeat.room.get(i).setEnabled(false);
							String sql2 = "update seat set Seat_Statement ='��� ��' where Seat_Number= ?";
							pstmt = conn.prepareStatement(sql2);
							pstmt.setInt(1, i+101);
							int row2 = pstmt.executeUpdate();

							String sqlt3 = "update seat set time_enter =?,time_checkout=? where Seat_Number= ?";
							pstmt = conn.prepareStatement(sqlt3);
							pstmt.setTimestamp(1, Time.localDateTimeTOTimeStamp(time_now));
							pstmt.setTimestamp(2, Time.localDateTimeTOTimeStamp(ss));
							pstmt.setInt(3, i+101);
							int rowt3 = pstmt.executeUpdate();
							//����������̺��� ���� - �Խ�,���,Ÿ��,�������

							System.out.printf("%dȣ ���� ����Ǿ����ϴ�.(%d�� ������Ʈ)\n", i+101,row2);
							System.out.printf("�Խ�/��� �ð��� ������Ʈ�Ǿ����ϴ�.(%d�� ������Ʈ)\n",rowt3); 
						}
					}  
					frame.setVisible(false);

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
				new _08selectSeat(_08selectSeat.time11);

			}
		});


	}
}