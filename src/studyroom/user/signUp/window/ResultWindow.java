package studyroom.user.signUp.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import studyroom.MainPage;
import studyroom.design.Style;
import studyroom.swingTools.SwingToolsSubPage;
import studyroom.user.login.LoginPage;
import studyroom.user.signUp.PhoneNumberEnum;
import studyroom.user.signUp.SignUpEnum;
import studyroom.user.signUp.SignUpPage;

public class ResultWindow extends JFrame {

	private JPanel gridPanel21;
	private JButton confirmButton;
	private JPanel panelInGrid2;
	private JPanel gridPanel31InGrid1;
	private JLabel failLabel1;
	private JLabel failLabel2;
	private JLabel failLabel3;
	private String error;
	private int person_id;
	private String person_name;
	private boolean result = false;

	// 가입 성공 & 실패 창 클래스
	
	public ResultWindow(int person_id, String person_name) {
		this.person_id = person_id;
		this.person_name = person_name;
		result = true;
		ResultCalc();
	}

	public ResultWindow(String error) {
		this.error = error;
		ResultCalc();
	}

	void ResultCalc() {
		SwingToolsSubPage.initTestFrame(this);
		setLayout(new BorderLayout(0, 15));
		add(Style.getnewPanel(), BorderLayout.NORTH);
		
		gridPanel21 = new JPanel();
		gridPanel21.setLayout(new GridLayout(2, 1, 0, 0));
		new Style(gridPanel21);
		add(gridPanel21, BorderLayout.CENTER);

		gridPanel31InGrid1 = new JPanel(new GridLayout(3, 1, 0, 10));
		new Style(gridPanel31InGrid1);

		if (result) {
			failLabel1 = new JLabel("가입 성공", JLabel.CENTER);
			failLabel2 = new JLabel("성 함 : " + this.person_name + " 님", JLabel.CENTER);
			failLabel3 = new JLabel("[ 회원 번호 : " + this.person_id + " ]", JLabel.CENTER);
			
			
		} else {
			failLabel1 = new JLabel("가입 실패", JLabel.CENTER);
			failLabel2 = new JLabel("하기 사항을 확인하세요", JLabel.CENTER);
			failLabel3 = new JLabel("[ " + this.error + " ]", JLabel.CENTER);
		}

		new Style(failLabel1);
		gridPanel31InGrid1.add(failLabel1);
		new Style(failLabel2);
		gridPanel31InGrid1.add(failLabel2);
		new Style(failLabel3);
		gridPanel31InGrid1.add(failLabel3);

		gridPanel21.add(gridPanel31InGrid1);

		panelInGrid2 = new JPanel();
		new Style(panelInGrid2);
		gridPanel21.add(panelInGrid2);
		panelInGrid2.setLayout(null);
		
		confirmButton = new JButton("확인");
		confirmButton.setBounds(121, 22, 110, 30);
		new Style(confirmButton);
		panelInGrid2.add(confirmButton);

		// 확인 누르면 성공했을 때 회원가입창 초기화 및 로그인페이지로 귀환
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (result) {
						MainPage.main_cards.show(MainPage.main_page_panel, "로그인");
						for (SignUpEnum value : SignUpEnum.values()) {
							value.text.setText(value.labelName);;
							value.blindPW.setText(value.labelName);
						}
						for(int i = 0; i < SignUpPage.phoneTotal.length; i++) {
							SignUpPage.phoneTotal[i].setText(PhoneNumberEnum.values()[i].labelName);
						}
						SignUpPage.year.setSelectedItem("2000");
						for (Entry<JCheckBox, JButton> kv : SignUpPage.consent.entrySet()) {
							kv.getKey().setSelected(false);
							kv.getKey().setEnabled(false);
						}
					}
						dispose();
				}

			}
		});

	}

}
