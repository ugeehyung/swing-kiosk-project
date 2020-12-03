package loginFeature;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JPanel;

public class ClickSignUp extends MouseAdapter{

	static int person_id;
	static String person_name;
//
//	Container card_panel;
//	
//	public ClickSignUp(Container card_panel) {
//		this.card_panel = card_panel;
//	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");	
				

				Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521/XEPDB1",
						"hr",
						"1234"
				);
				
				
				PreparedStatement insertPersonInfo = 
						conn.prepareStatement("INSERT INTO Person_Info "
								+ "(Person_Id,Check_Time,Person_Name, Phone_Number,PW,Total_Payment)"
								+ " VALUES(SignUpSeq.nextval, ?, ?, ?, ?, ?)");
				
				// Batch : 일괄처리 
		        DateFormat simple = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		        Date now = new Date();
		        
					insertPersonInfo.setString(1, simple.format(now));
					insertPersonInfo.setString(2, SignUp.textList.get(0).getText());
					insertPersonInfo.setString(3, SignUp.textList.get(1).getText());	
					insertPersonInfo.setString(4, SignUp.textList.get(2).getText());
					insertPersonInfo.setInt(5, 0);
					insertPersonInfo.addBatch();
					

				int[] rows = insertPersonInfo.executeBatch();			
//				System.out.println(Arrays.toString(rows));
					
				if (insertPersonInfo != null) insertPersonInfo.close();
	
				PreparedStatement read_name_ID_from_personInfo = 
						conn.prepareStatement("SELECT person_id, person_name FROM person_info");

				ResultSet rs = read_name_ID_from_personInfo.executeQuery();
				
				while (rs.next()) {
//					System.out.printf("%-15s\t%-10s\t%-10d\t%-10d\n",
//							rs.getString("last_name"),
//							rs.getString("first_name"),
//							rs.getInt("salary"),
//							rs.getInt("department_id")
//					);								
					person_id = rs.getInt(1);
					person_name = rs.getString(2);
				}	
				
				new SignUpSuccessWindow(person_id, person_name);
				
				if (rs != null) rs.close();
				if (read_name_ID_from_personInfo != null) read_name_ID_from_personInfo.close();
				if (conn != null) conn.close();
				
				System.out.println("성공");
				
			} catch (SQLException a) {			
				a.printStackTrace();
			} catch (ClassNotFoundException a) {		
				a.printStackTrace();
				System.out.println("[ojdbc] 클래스 경로가 틀렸습니다.");
			}
		}
	}
	
}
