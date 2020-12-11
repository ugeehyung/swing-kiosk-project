package login.page;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import login.design.Conversion_image;
import login.design.Style;
import login.findPW.FindPasswordPage;
import login.signUp.SignUpPage;
import login.window.ActionWindow;
import login.window.Login_SwingTool;

public class MainPage extends JFrame {

	int x = new Conversion_image("image/로그인화면.jpg", 5).x;
	int y = new Conversion_image("image/로그인화면.jpg", 5).y;
	public static JPanel page_panel;
	public static CardLayout cards;

	public MainPage() {
		// 배경화면
		JPanel fram_panel = new JPanel();
		fram_panel.setLayout(null);
		fram_panel.setBounds(0, 0, x, y);

		JLabel background = new JLabel(new Conversion_image("image/로그인화면.jpg", 5).imageicon_smooth);
		background.setBounds(0, 0, x, y);

		// 낙엽쪽 카드페이지 패널
		page_panel = new JPanel();
		cards = new CardLayout();
		page_panel.setLayout(cards);
		new Style(page_panel);
		page_panel.setBounds(1577 / 5, 0, 2423 / 5, 2250 / 5);
		
		JPanel main = new JPanel(new BorderLayout());
		new Style(main);
		JButton touch = new JButton("<html>터치를 하여<br/>이용해주세요</html>");
		new Style(touch);
		touch.setBorder(null);
		touch.addActionListener(new ActionWindow(touch));
		main.add(touch);

		// 페이지 추가 작업
		page_panel.add("메인", main);
		page_panel.add("로그인", new LoginPage());
//				MainPage.page_panel.add("관리자", admin_panel);
		page_panel.add("회원가입", new SignUpPage());
		page_panel.add("비번찾기", new FindPasswordPage());

		JButton Poweroff = new JButton(new Conversion_image("image/전원.png", 30, 30).imageicon_smooth);
		new Style(Poweroff);
		Poweroff.setText("관리자");
		Poweroff.setBounds(0, 0, 30, 30);
		Poweroff.addActionListener(new ActionWindow(Poweroff));
//		Poweroff.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//			}
//		});
		background.add(Poweroff);
		fram_panel.add(background);

		Login_SwingTool.initFrame(this);

		add(page_panel);
		add(fram_panel);
		Login_SwingTool.initFrame(this);
	}

	public static void main(String[] args) {
		new MainPage();
	}
}
