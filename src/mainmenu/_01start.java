package mainmenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
 

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.Action;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.ImageIcon;

public class _01start extends JFrame {
 
	JTable table;
	 
	private JPanel contentPane;

	DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
	DateTimeFormatter time = DateTimeFormatter.ofPattern("a h시 m분 ");
	 
	public _01start() { 
		 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 150, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//메뉴 버튼 4개
		JButton seat_btn = new JButton("좌석 이용권"); 
		seat_btn.setBounds(5, 95, 208, 121);  
		contentPane.add(seat_btn);

		JButton locker_btn = new JButton("사물함 이용권");
		locker_btn.setBounds(218, 95, 213, 121); 
		contentPane.add(locker_btn);

		JButton room_btn = new JButton("룸 이용권");
		room_btn.setBounds(5, 221, 208, 126); 
		contentPane.add(room_btn);

	    JButton back_btn = new JButton("이전 화면");
	    back_btn.setBounds(218, 221, 213, 126); 
	    contentPane.add(back_btn);

		//스터디룸 상황표
		String header[] = {"1인석","스터디룸","사물함","현재시간"};
		String contents[][]= {
				{
					"<html>사용중 1인석<br/>&emsp;&emsp;"+Integer.toString(_00main.count_seat)+" / 20",
					"<html>사용중 스터디룸<br/>&emsp;&emsp;&emsp;"+Integer.toString(_00main.count_room)+" / 4",
					"<html>사용중 사물함<br/>&emsp;&emsp;"+Integer.toString(_00main.count_locker)+" / 20",
					"<html>&emsp;&nbsp;&nbsp;&nbsp;현재시간<br/>"+LocalDate.now().format(date)+"<br/>&nbsp;&nbsp;&nbsp;"+LocalTime.now().format(time)} 
		};

		DefaultTableModel model = new DefaultTableModel(contents,header);
		table = new JTable(model);
		table.setBounds(0, 0, 437, 80);
		table.setRowHeight(80);
		
		//테두리
		Color color = UIManager.getColor("Table.gridColor");
		MatteBorder border = new MatteBorder(1, 1, 0, 0, color);
		table.setBorder(border);

		//상황표 글씨 중앙 정렬
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("1인석").setCellRenderer(celAlignCenter);
		table.getColumn("스터디룸").setCellRenderer(celAlignCenter);
		table.getColumn("사물함").setCellRenderer(celAlignCenter);
		table.getColumn("현재시간").setCellRenderer(celAlignCenter);
		contentPane.add(table); 
		
		setVisible(true);
		
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection conn = DriverManager.getConnection(
		               "jdbc:oracle:thin:@localhost:1521/XEPDB1",
		               "hr",
		               "1234"
		               );
			 
			 seat_btn.addActionListener(new ActionListener() { //다음 페이지
					@Override
					public void actionPerformed(ActionEvent e) {
				  
				try {//좌석만료시간이 안지나면 구매 불가 
					String sql = "SELECT expiration_seat from person_info where login_state='On'";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					
					 while(rs.next()) { 
				          
				            Timestamp time_chk = rs.getTimestamp("expiration_seat");
				            if(LocalDateTime.now().isBefore(Time.TimeStampTOlocalDateTime(time_chk))) {
				            	String msg= "결제한 좌석이 이미 존재합니다";
								JOptionPane.showMessageDialog(null,msg); 
				            }else {
				            	 setVisible(false);
								 _02dayOrWeek frame = new _02dayOrWeek();
								 frame.setVisible(true);
				            }
				         }
					
				} catch (SQLException e1) { 
					e1.printStackTrace();
				}
			 
					  
					}
				}); 
				
			      room_btn.addActionListener(new ActionListener() { //다음 페이지
			          @Override
			          public void actionPerformed(ActionEvent e) {
			        	  try {//좌석만료시간이 안지나면 구매 불가 
								String sql = "SELECT expiration_room from person_info where login_state='On'";
								PreparedStatement pstmt = conn.prepareStatement(sql);
								ResultSet rs = pstmt.executeQuery();
								
								 while(rs.next()) { 
							          
							            Timestamp time_chk = rs.getTimestamp("expiration_room");
							            if(LocalDateTime.now().isBefore(Time.TimeStampTOlocalDateTime(time_chk))) {
							            	String msg= "결제한 룸이 이미 존재합니다";
											JOptionPane.showMessageDialog(null,msg); 
							            }else {
							           	 
									           setVisible(false);
									           _02dayRoom frame = new _02dayRoom();
									           frame.setVisible(true);
							            }
							         }
								
							} catch (SQLException e1) { 
								e1.printStackTrace();
							} 
			          }
			       });  
				
			      back_btn.addActionListener(new ActionListener() { //이전 페이지
			          @Override
			          public void actionPerformed(ActionEvent e) {
			           setVisible(false);
			           _00main frame = new _00main();
			           frame.setVisible(true);
			          }
			       });
			      
				locker_btn.addActionListener(new ActionListener() { //다음 페이지
					@Override
					public void actionPerformed(ActionEvent e) {
						 try {//좌석만료시간이 안지나면 구매 불가 
								String sql = "SELECT expiration_locker from person_info where login_state='On'";
								PreparedStatement pstmt = conn.prepareStatement(sql);
								ResultSet rs = pstmt.executeQuery();
								
								 while(rs.next()) { 
							          
							            Timestamp time_chk = rs.getTimestamp("expiration_locker");
							            if(LocalDateTime.now().isBefore(Time.TimeStampTOlocalDateTime(time_chk))) {
							            	String msg= "결제한 사물함이 이미 존재합니다";
											JOptionPane.showMessageDialog(null,msg); 
							            }else {	 
							            	setVisible(false);
										 _05locker frame = new _05locker();
										 frame.setVisible(true);
							            }
							         }
								
							} catch (SQLException e1) { 
								e1.printStackTrace();
							}
				 
					}
				});
				
		} catch (ClassNotFoundException | SQLException e1) {
		 
			e1.printStackTrace();
		}
         
		
		
		 
	 
	}  
	
	public static void main(String[] args) {
		new _01start(); 
		 
	}
}


