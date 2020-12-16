package login.signUp.window;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import login.design.Style;
import login.swingTools.SwingToolsSubPage;

public class ConsentContent extends JFrame implements ActionListener {

   private JPanel panel;
   private JButton confirmButton;
   private JScrollPane scrollPane;
   private JLabel contentLabel;
   private int consentNum;
   private String content;

   public ConsentContent(int consentNum) {
      this.consentNum = consentNum;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      panel = new JPanel();

      panel.setLayout(null);
      new Style(panel);

      setContentPane(panel);

      confirmButton = new JButton("확인");
      confirmButton.setBounds(750, 800, 145, 23);
      new Style(confirmButton);
      panel.add(confirmButton);

      confirmButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1)
               dispose();
         }
      });
      
      scrollPane = new JScrollPane();
      scrollPane.getVerticalScrollBar().setUnitIncrement(20);
      scrollPane.setBounds(50, 36, 1500, 750);

      new Style(scrollPane);
      panel.add(scrollPane);

      if (consentNum == 1) {
         content = "<html>제 1 장 환영합니다!\r\n" + "제 1 조 목적 및 정의\r\n"
               + "주식회사 카카오(이하 ‘회사’)가 제공하는 서비스를 이용해 주셔서 감사합니다. 회사는 여러분이 회사가 제공하는 다양한 인터넷과 모바일 서비스(카카오 서비스, Daum 서비스, 멜론 서비스 등을 의미하며 이하 해당 서비스들을 모두 합하여 “통합서비스” 또는 “서비스”라 함)에 더 가깝고 편리하게 다가갈 수 있도록 ‘카카오 통합서비스약관’(이하 ‘본 약관’)을 마련하였습니다. 여러분은 본 약관에 동의함으로써 통합서비스에 가입하여 통합서비스를 이용할 수 있습니다. 단, 여러분은 회사가 아닌 계열사를 포함한 제3자가 제공하는 서비스 \r\n (예: ㈜카카오모빌리티가 제공하는 카카오 T 택시 서비스)에 가입되지는 않으며, 회사가 제공하는 유료서비스 (예: 멜론 유료서비스)의 경우 여러분이 별도의 유료이용약관에 대한 동의한 때에 회사와 여러분 간의 유료서비스 이용계약이 성립합니다. 본 약관은 여러분이 통합서비스를 이용하는 데 필요한 권리, 의무 및 책임사항, 이용조건 및 절차 등 기본적인 사항을 규정하고 있으므로 조금만 시간을 내서 주의 깊게 읽어주시기 바랍니다.\r\n"
               + "\r\n"
               + "카카오 서비스: 회사가 제공하는 1) “카카오” 브랜드를 사용하는 서비스(예:카카오톡) 또는 2) 카카오계정으로 이용하는 서비스(Daum 및 Melon 브랜드 서비스는 제외, 예: 브런치) (단, 서비스 명칭에 ‘카카오’가 사용되더라도 회사가 아닌 카카오 계열사에서 제공하는 서비스 (예: 카카오 T택시 서비스)는 본 약관의 카카오 서비스에 포함되지 않습니다)\r\n"
               + "Daum 서비스: 회사가 제공하는 Daum(다음) 브랜드를 사용하는 서비스(예: Daum 포털 서비스)\r\n"
               + "멜론 서비스: 회사가 제공하는 Melon(멜론) 브랜드를 사용하는 서비스(예: Melon 서비스)\r\n"
               + "개별 서비스: 통합서비스를 구성하는 카카오 서비스, Daum 서비스, 멜론 서비스 등 브랜드 단위의 서비스를 각 의미함\r\n"
               + "세부 하위 서비스: 개별 서비스를 구성하는 개별 서비스 내의 세부 하위 서비스를 의미하며, 예를 들어 각 개별 서비스 내의 유료서비스, 카카오 서비스 내의 카카오톡 서비스, Daum 서비스 내의 카페, 메일 등 서비스, 멜론 서비스 내의 멜론티켓 서비스 등을 의미함\r\n"
               + "제 2 조 약관의 효력 및 변경\r\n"
               + "① 본 약관의 내용은 통합서비스의 화면에 게시하거나 기타의 방법으로 공지하고, 본 약관에 동의한 여러분 모두에게 그 효력이 발생합니다.\r\n"
               + "② 회사는 필요한 경우 관련 법령을 위배하지 않는 범위 내에서 본 약관을 변경할 수 있습니다. 본 약관이 변경되는 경우 회사는 변경사항을 시행일자 15일 전부터 여러분에게 서비스 공지사항에서 공지 또는 통지하는 것을 원칙으로 하며, 피치 못하게 여러분에게 불리한 내용으로 변경할 경우에는<br/> 그 시행일자 30일 전부터 카카오계정에 등록된 이메일 주소로 이메일<br/>(이메일주소가 없는 경우 서비스 내 전자쪽지 발송, 서비스 내 알림 메시지를 띄우는 등의 별도의 전자적 수단)\r\n 발송 또는 여러분이 등록한 휴대폰번호로 카카오톡 메시지 또는 문자메시지 발송하는 방법 등으로 개별적으로 알려 드리겠습니다.\r\n"
               + "③ 회사가 전 항에 따라 공지 또는 통지를 하면서 공지 또는 통지일로부터 개정약관 시행일 7일 후까지 거부의사를 표시하지 아니하면 승인한 것으로 본다는 뜻을 명확하게 고지하였음에도 여러분의 의사표시가 없는 경우에는<br/> 변경된 약관을 승인한 것으로 봅니다.\r\n"
               + "④ 여러분은 변경된 약관에 대하여 거부의사를 표시함으로써 이용계약의 해지를 선택할 수 있습니다. 멜론 서비스 내에서의 개별 유료이용권의 해지 효력과 관련하여서는 멜론 유료서비스 약관 관련 조항의 내용을 따릅니다.\r\n"
               + "⑤ 본 약관은 여러분이 본 약관에 동의한 날로부터 본 약관 제13조에 따른 이용계약의 해지 시까지 적용하는 것을 원칙으로 합니다. 단, 본 약관의 일부 조항은 이용계약의 해지 후에도 유효하게 적용될 수 있습니다.\r\n"
               + "제 3 조 약관 외 준칙\r\n"
               + "본 약관에 규정되지 않은 사항에 대해서는 관련 법령 또는 통합서비스를 구성하는 개별 서비스의 운영정책 및 규칙, 개별 서비스 내 세부 하위서비스의 이용약관, 카카오 운영정책 및 규칙 등(이하 총칭하여 ‘세부지침’)의 규정에 따릅니다. 또한 본 약관과 세부지침의 내용이 충돌할 경우 세부지침에 따릅니다.\r\n"
               + "\r\n" + "제 2 장 통합서비스 이용계약\r\n" + "제 4 조 계약의 성립\r\n"
               + "① 통합서비스에 가입하기 위해서는 카카오계정이 필요합니다. 카카오계정이 없으신 경우 카카오계정을 먼저 생성하시기 바랍니다.\r\n"
               + "② 통합서비스 이용계약은 여러분이 본 약관의 내용에 동의한 후 회사가 여러분의 카카오계정 정보 등을 확인한 후 승낙함으로써 체결됩니다.\r\n"
               + "제 5 조 통합서비스 가입의 제한\r\n"
               + "① 제4조에 따른 가입 신청자에게 회사는 원칙적으로 통합서비스 가입을 승낙합니다. 다만, 회사는 아래 각 호의 경우에는 그 사유가 해소될 때까지 승낙을 유보하거나 승낙하지 않을 수 있습니다. 특히, 여러분이 만 14세 미만인 경우에는 부모님 등 법정대리인의 동의가 있는 경우에만 통합서비스에 가입할 수 있습니다.\r\n"
               + "1. 여러분이 다른 사람의 명의나 이메일 주소 등 개인정보를 이용하여 통합서비스에 가입하려고 한 경우\r\n"
               + "2. 통합서비스 제공 설비 용량에 현실적인 여유가 없는 경우\r\n" + "3. 통합서비스 제공을 위한 기술적인 부분에 문제가 있다고 판단되는 경우\r\n"
               + "4. 기타 회사가 재정적, 기술적으로 필요하다고 인정하는 경우\r\n"
               + "5. 회사로부터 통합서비스 이용정지 조치 등을 받은 자가 그 조치기간에 통합서비스 이용계약을 임의로 해지하고 재가입을 신청하는 경우\r\n"
               + "6. 기타 관련 법령에 위배되거나 세부지침 등 회사가 정한 기준에 반하는 경우\r\n"
               + "② 만약, 여러분이 위 조건에 위반하여 통합서비스에 가입한 것으로 판명된 때에는 회사는 즉시 여러분의 통합서비스 이용을 정지시키거나 카카오계정을 삭제하는 등 적절한 제한을 할 수 있습니다.\r\n"

               + "\r\n" + "공고일자 : 2020년 10월 19일\r\n" + "시행일자 : 2020년 11월 3일,</html>";
      } else {
         content = "<html>제 1 장 환영합니다!\r\n" + "제 1 조 목적 및 정의\r\n"
               + "주식회사 카카오(이하 ‘회사’)가 제공하는 서비스를 이용해 주셔서 감사합니다. 회사는 여러분이 회사가 제공하는 다양한 인터넷과 모바일 서비스(카카오 서비스, Daum 서비스, 멜론 서비스 등을 의미하며 이하 해당 서비스들을 모두 합하여 “통합서비스” 또는 “서비스”라 함)에 더 가깝고 편리하게 다가갈 수 있도록 ‘카카오 통합서비스약관’(이하 ‘본 약관’)을 마련하였습니다. 여러분은 본 약관에 동의함으로써 통합서비스에 가입하여 통합서비스를 이용할 수 있습니다. 단, 여러분은 회사가 아닌 계열사를 포함한 제3자가 제공하는 서비스 \r\n (예: ㈜카카오모빌리티가 제공하는 카카오 T 택시 서비스)에 가입되지는 않으며, 회사가 제공하는 유료서비스 (예: 멜론 유료서비스)의 경우 여러분이 별도의 유료이용약관에 대한 동의한 때에 회사와 여러분 간의 유료서비스 이용계약이 성립합니다. 본 약관은 여러분이 통합서비스를 이용하는 데 필요한 권리, 의무 및 책임사항, 이용조건 및 절차 등 기본적인 사항을 규정하고 있으므로 조금만 시간을 내서 주의 깊게 읽어주시기 바랍니다.\r\n"
               + "\r\n"
               + "카카오 서비스: 회사가 제공하는 1) “카카오” 브랜드를 사용하는 서비스(예:카카오톡) 또는 2) 카카오계정으로 이용하는 서비스(Daum 및 Melon 브랜드 서비스는 제외, 예: 브런치) (단, 서비스 명칭에 ‘카카오’가 사용되더라도 회사가 아닌 카카오 계열사에서 제공하는 서비스 (예: 카카오 T택시 서비스)는 본 약관의 카카오 서비스에 포함되지 않습니다)\r\n"
               + "Daum 서비스: 회사가 제공하는 Daum(다음) 브랜드를 사용하는 서비스(예: Daum 포털 서비스)\r\n"
               + "멜론 서비스: 회사가 제공하는 Melon(멜론) 브랜드를 사용하는 서비스(예: Melon 서비스)\r\n"
               + "개별 서비스: 통합서비스를 구성하는 카카오 서비스, Daum 서비스, 멜론 서비스 등 브랜드 단위의 서비스를 각 의미함\r\n"
               + "세부 하위 서비스: 개별 서비스를 구성하는 개별 서비스 내의 세부 하위 서비스를 의미하며, 예를 들어 각 개별 서비스 내의 유료서비스, 카카오 서비스 내의 카카오톡 서비스, Daum 서비스 내의 카페, 메일 등 서비스, 멜론 서비스 내의 멜론티켓 서비스 등을 의미함\r\n"
               + "제 2 조 약관의 효력 및 변경\r\n"
               + "① 본 약관의 내용은 통합서비스의 화면에 게시하거나 기타의 방법으로 공지하고, 본 약관에 동의한 여러분 모두에게 그 효력이 발생합니다.\r\n"
               + "② 회사는 필요한 경우 관련 법령을 위배하지 않는 범위 내에서 본 약관을 변경할 수 있습니다. 본 약관이 변경되는 경우 회사는 변경사항을 시행일자 15일 전부터 여러분에게 서비스 공지사항에서 공지 또는 통지하는 것을 원칙으로 하며, 피치 못하게 여러분에게 불리한 내용으로 변경할 경우에는<br/> 그 시행일자 30일 전부터 카카오계정에 등록된 이메일 주소로 이메일(이메일주소가 없는 경우 서비스 내 전자쪽지 발송, 서비스 내 알림 메시지를 띄우는 등의 별도의 전자적 수단)\r\n 발송 또는 여러분이 등록한 휴대폰번호로 카카오톡 메시지 또는 문자메시지 발송하는 방법 등으로 개별적으로 알려 드리겠습니다.\r\n"
               + "③ 회사가 전 항에 따라 공지 또는 통지를 하면서 공지 또는 통지일로부터 개정약관 시행일 7일 후까지 거부의사를 표시하지 아니하면 승인한 것으로 본다는 뜻을 명확하게 고지하였음에도 여러분의 의사표시가 없는 경우에는<br/> 변경된 약관을 승인한 것으로 봅니다.\r\n"
               + "④ 여러분은 변경된 약관에 대하여 거부의사를 표시함으로써 이용계약의 해지를 선택할 수 있습니다. 멜론 서비스 내에서의 개별 유료이용권의 해지 효력과 관련하여서는 멜론 유료서비스 약관 관련 조항의 내용을 따릅니다.\r\n"
               + "⑤ 본 약관은 여러분이 본 약관에 동의한 날로부터 본 약관 제13조에 따른 이용계약의 해지 시까지 적용하는 것을 원칙으로 합니다. 단, 본 약관의 일부 조항은 이용계약의 해지 후에도 유효하게 적용될 수 있습니다.\r\n"
               + "제 3 조 약관 외 준칙\r\n"
               + "본 약관에 규정되지 않은 사항에 대해서는 관련 법령 또는 통합서비스를 구성하는 개별 서비스의 운영정책 및 규칙, 개별 서비스 내 세부 하위서비스의 이용약관, 카카오 운영정책 및 규칙 등(이하 총칭하여 ‘세부지침’)의 규정에 따릅니다. 또한 본 약관과 세부지침의 내용이 충돌할 경우 세부지침에 따릅니다.\r\n"
               + "\r\n" + "제 2 장 통합서비스 이용계약\r\n" + "제 4 조 계약의 성립\r\n"
               + "① 통합서비스에 가입하기 위해서는 카카오계정이 필요합니다. 카카오계정이 없으신 경우 카카오계정을 먼저 생성하시기 바랍니다.\r\n"
               + "② 통합서비스 이용계약은 여러분이 본 약관의 내용에 동의한 후 회사가 여러분의 카카오계정 정보 등을 확인한 후 승낙함으로써 체결됩니다.\r\n"
               + "제 5 조 통합서비스 가입의 제한\r\n"
               + "① 제4조에 따른 가입 신청자에게 회사는 원칙적으로 통합서비스 가입을 승낙합니다. 다만, 회사는 아래 각 호의 경우에는 그 사유가 해소될 때까지 승낙을 유보하거나 승낙하지 않을 수 있습니다. 특히, 여러분이 만 14세 미만인 경우에는 부모님 등 법정대리인의 동의가 있는 경우에만 통합서비스에 가입할 수 있습니다.\r\n"
               + "1. 여러분이 다른 사람의 명의나 이메일 주소 등 개인정보를 이용하여 통합서비스에 가입하려고 한 경우\r\n"
               + "2. 통합서비스 제공 설비 용량에 현실적인 여유가 없는 경우\r\n" + "3. 통합서비스 제공을 위한 기술적인 부분에 문제가 있다고 판단되는 경우\r\n"
               + "4. 기타 회사가 재정적, 기술적으로 필요하다고 인정하는 경우\r\n"
               + "5. 회사로부터 통합서비스 이용정지 조치 등을 받은 자가 그 조치기간에 통합서비스 이용계약을 임의로 해지하고 재가입을 신청하는 경우\r\n"
               + "6. 기타 관련 법령에 위배되거나 세부지침 등 회사가 정한 기준에 반하는 경우\r\n"
               + "② 만약, 여러분이 위 조건에 위반하여 통합서비스에 가입한 것으로 판명된 때에는 회사는 즉시 여러분의 통합서비스 이용을 정지시키거나 카카오계정을 삭제하는 등 적절한 제한을 할 수 있습니다.\r\n"
               + "제 3 장 통합서비스 이용\r\n" + "제 6 조 다양한 서비스의 제공\r\n"
               + "① 통합서비스 이용계약이 성립되면, 여러분은 통합서비스를 구성하는 카카오 서비스, Daum 서비스, 멜론 서비스를 여러분이 원하는 때에 자유롭게 이용할 수 있고, 개별 서비스에 대한 별도의 이용계약을 체결할 필요는 없습니다.\r\n"
               + "② 다만, 통합서비스 내에서도 일부 세부 하위 서비스의 경우 별도의 이용약관에 동의해야 이용이 가능하며 필요한 추가 정보를 기재하거나, 이메일 주소 승인 또는 문자메시지 인증 등 회사가 정한 인증 절차를 완료하여야 서비스 이용이 가능합니다. 멜론 서비스의 경우에도 최초 로그인 시점에 국내 전용 휴대폰 인증 절차를 완료하여야 서비스 이용이 가능합니다.\r\n"
               + "③ 여러분은 통합서비스 가입 후에도 언제든지 통합서비스를 구성하는 개별 서비스 내지 세부 하위 서비스 화면 또는 메뉴에서 제공하는 기능을 이용하여 해당 개별 서비스 또는 세부 하위 서비스의 이용을 종료할 수 있으며, 이 경우 관련 법령에서 정하는 바에 따라<br/> 일정기간 보관해야 하는 정보를 제외하고는 해당 서비스 이용기록, 여러분이 작성한 게시물 등 모든 데이터는 즉시 삭제 처리됩니다. 다만, 여러분이 작성한 게시물이 제3자에 의하여 스크랩 또는 다른 공유 기능으로 게시되거나, 여러분이 제3자의 게시물에 댓글 등 게시물을 추가하는 등의 경우에는 해당 게시물 및 댓글은 삭제되지 않으므로 반드시 이용 종료 전에 삭제하시기 바라며, \r\n 일부 서비스의 특성 및 콘텐츠의 성질 등에 따라 게시물의 삭제가 불가능할 수도 있으니 이 점 유의하여 주시기 바랍니다. 개별 서비스 또는 세부 하위 서비스 이용 종료 시점에 향후 일정기간 해당 서비스의 재이용에 제한이 있을 수 있다는 별도 안내가 있는 경우 해당 안내에 따라 해당 서비스의 재이용에 일정한 시간적 제한이 있을 수 있는 점 또한<br/> 유의하여 주시기 바랍니다.\r\n"
               + "④ 전항에 따른 개별 서비스 또는 세부 하위 서비스의 이용 종료는 해당 개별 서비스 또는 세부 하위 서비스의 이용 종료만을 의미하며, 통합서비스를 구성하는 다른 서비스의 이용이 종료되지는 않습니다. 여러분이 통합서비스 전체의 이용을 종료하고 싶은 경우에는 본 약관 제13조에서 정한 바처럼 통합서비스 이용계약을 해지하여야 합니다.\r\n"
               + "⑤ 회사는 여러분에게 SNS, 게시판 서비스, 온라인 콘텐츠 제공 서비스, 위치기반서비스 등 여러분이 인터넷과 모바일로 즐길 수 있는 다양한 서비스를 제공합니다. 여러분은 스마트폰의 어플리케이션 스토어 등에서 서비스를 다운받아 설치하거나 직접 PC에 설치 혹은 웹페이지에 접속하여 서비스를 이용할 수 있습니다. 그런데 회사는 여러분이 원하는 다양한 서비스를 시시각각 제공하기 때문에 서비스의 자세한 내용은 별도로 알려드릴 수밖에 없습니다. 이러한 회사의 사정을 이해하여 주시길 바라며, 회사도 개별적인 서비스 이용방법을 어플리케이션 스토어와 각 서비스의 Q&A 센터, 해당 안내 및 고지사항에서 더 상세하게 안내하고 있으니 언제든지 확인하여 주시기 바랍니다.\r\n"
               + "⑥ 회사는 여러분이 통합서비스를 마음껏 이용할 수 있도록 이에 필요한 소프트웨어의 개인적이고 전 세계적이며 양도불가능하고 비독점적인 무상의 라이선스를 여러분에게 제공합니다. 단, 회사가 여러분에게 회사의 상표 및 로고를 사용할 권리를 부여하는 것은 아니라는 점은 잊지 말아주시기 바랍니다.\r\n"
               + "⑦ 회사는 더 나은 통합서비스를 위하여 통합서비스에 필요한 소프트웨어의 업데이트 버전을 제공할 수 있습니다. 소프트웨어의 업데이트에는 중요한 기능의 추가 또는 기능의 제거 등이 포함되어 있습니다. 여러분들도 통합서비스를 즐겁게 이용할 수 있도록 꾸준히 업데이트를 하여 주시기 바랍니다.\r\n"
               + "⑧ 회사는 스팸성 메일(피싱, 바이러스 유포, 개인정보 탈취 등 각종 불법 및 사행성 스팸을 의미합니다)로부터 이용자를 보호하기 위해 수발신 메일에 대한 스팸 대응 및 보안 조치를 합니다. 더불어 유관기관의 권고가 있거나 이용자 보호를 위하여 필요하다고 판단하는 경우 이에 따른 추가적인 스팸 운영정책 및 기능을 제공합니다.\r\n"
               + "⑨ 회사는 더 나은 통합서비스의 제공을 위하여 여러분에게 통합서비스의 이용과 관련된 각종 고지, 관리 메시지 및 기타 광고를 비롯한 다양한 정보를 통합서비스 내에 표시하거나 여러분의 카카오계정 정보에 등록되어 있는 연락처로 직접 발송할 수 있습니다. 단, 광고성 정보 전송의 경우에는 사전에 수신에 동의한 경우에만 전송합니다.\r\n"
               + "⑩ 통합서비스 이용 중 시스템 오류 등 문제점을 발견하신다면 언제든지 고객센터로 알려주시기 바랍니다.\r\n"
               + "⑪ 여러분이 통합서비스를 이용하는 과정에서 Wi-Fi 무선인터넷을 사용하지 않고, 가입하신 이동통신사의 무선인터넷에 연결하여 이용하는 경우 이동통신사로부터 여러분에게 별도의 데이터 통신요금이 부과될 수 있는 점을 유의하여 주시기 바랍니다. 통합서비스 이용 과정에서 발생하는 데이터 통신요금은 여러분이 여러분의 비용과 책임 하에 이동통신사에 납부하셔야 합니다. 데이터 통신요금에 대한 자세한 안내는 여러분이 가입하신 이동통신사에 문의하시기 바랍니다.\r\n"
               + "제 7 조 통합서비스의 변경 및 종료\r\n"
               + "① 회사는 통합서비스를 365일, 24시간 쉬지 않고 제공하기 위하여 최선의 노력을 다합니다. 다만, 아래 각 호의 경우 통합서비스의 전부 또는 일부를 제한하거나 중지할 수 있습니다.\r\n"
               + "1. 통합서비스용 설비의 유지·보수 등을 위한 정기 또는 임시 점검의 경우\r\n"
               + "2. 정전, 제반 설비의 장애 또는 이용량의 폭주 등으로 정상적인 통합서비스 이용에 지장이 있는 경우\r\n"
               + "3. 관계사와의 계약 종료, 정부의 명령/규제 등 회사의 제반 사정으로 통합서비스의 전부 또는 일부를 유지할 수 없는 경우\r\n"
               + "4. 기타 천재지변, 국가비상사태 등 불가항력적 사유가 있는 경우\r\n"
               + "② 전항에 의한 통합서비스 중단의 경우에는 미리 제17조에서 정한 방법으로 여러분에게 통지 내지 공지하겠습니다. 다만, 회사로서도 예측할 수 없거나 통제할 수 없는 사유(회사의 과실이 없는 디스크 내지 서버 장애, 시스템 다운 등)로 인해 사전 통지 내지 공지가 불가능한 경우에는 그러하지 아니합니다. 이러한 경우에도 회사가 상황을 파악하는 즉시 최대한 빠른 시일 내에 서비스를 복구하도록 노력하겠습니다.\r\n"
               + "제 8 조 게시물의 관리\r\n"
               + "① 여러분의 게시물이 정보통신망 이용촉진 및 정보보호 등에 관한 법률(이하 ‘정보통신망법’)및 저작권법 등 관련 법령에 위반되는 내용을 포함하는 경우, 권리자는 회사에 관련 법령이 정한 절차에 따라 해당 게시물의 게시중단 및 삭제 등을 요청할 수 있으며, 회사는 관련 법령에 따라 조치를 취합니다.\r\n"
               + "② 회사는 권리자의 요청이 없는 경우라도 권리침해가 인정될 만한 사유가 있거나 기타 회사의 정책 및 관련 법령에 위반되는 경우에는 관련 법령에 따라 해당 게시물에 대해 임시조치 등을 취할 수 있습니다.\r\n"
               + "③ 위와 관련된 세부 절차는 정보통신망법 및 저작권법이 규정한 범위 내에서 회사가 정한 권리침해 신고 절차에 따릅니다.\r\n"
               + "제 9 조 권리의 귀속 및 저작물의 이용\r\n"
               + "① 여러분은 사진, 글, 정보, (동)영상, 통합서비스 또는 회사에 대한 의견이나 제안 등 콘텐츠(이하 ‘게시물’)를 통합서비스 내에 게시할 수 있으며, 이러한 게시물에 대한 저작권을 포함한 지적재산권은 당연히 권리자가 계속하여 보유합니다.\r\n"
               + "② 여러분이 통합서비스 내에 게시물을 게시하는 경우, 해당 게시물이 통합서비스에 포함되는 개별 서비스에 노출될 수 있고 이에 필요한 범위 내에서 사용, 저장, 수정, 복제, 공중송신, 전시, 배포 등의 방식으로 이용할 수 있도록 사용을 허락하는 전 세계적인<br/> 라이선스를 회사에게 제공하게 됩니다. 다시 한 번 알려드리지만, 본 라이선스에서 여러분이 회사에게 부여하는 권리는 통합서비스를 운영, 개선, 홍보하고 새로운 서비스를 개발하기 위한 범위 내에서 사용됩니다. 일부 개별 서비스에서는 여러분이 제공한 콘텐츠에 접근하거나 이를 삭제하는 방법을 제공할 수 있습니다(다만 일부 서비스의 특성 및 콘텐츠의 성질 등에 따라 게시물의 삭제가 불가능할 수도 있습니다). 또한 일부 서비스에서는 제공된 콘텐츠에 대한 회사의 사용 범위를 제한하는 설정이 있습니다.\r\n"
               + "③ 여러분은 회사에 제공한 콘텐츠에 대해 회사에 라이선스를 부여하기 위해 필요한 권리를 보유해야 합니다. 이러한 권리를 보유하지 않아 발생하는 모든 문제에 대해서는 게시자가 책임을 부담하게 됩니다. 또한, 여러분은 음란하거나 폭력적이거나 기타 공서양속 및 법령에 위반하는 콘텐츠를 공개 또는 게시할 수 없습니다.\r\n"
               + "④ 회사는 여러분의 콘텐츠가 관련 법령에 위반되거나 음란 또는 청소년에게 유해한 게시물, 차별 갈등을 조장하는 게시물, 도배 · 광고 · 홍보 · 스팸성 게시물, 계정을 양도 또는 거래하는 내용의 게시물, 타인을 사칭하는 게시물 등이라고 판단되는 경우 이를 삭제하거나<br/> 게시를 거부할 수 있습니다. 다만 회사가 모든 콘텐츠를 검토할 의무가 있는 것은 아닙니다. 누군가 여러분의 권리를 침해하였다면, 고객센터를 통해 게시중단 요청에 대한 도움을 받으실 수 있습니다. 위와 관련된 구체적인 기준 및 이용제한 절차의 내용은 카카오 운영정책에서 확인하실 수 있습니다.\r\n"
               + "⑤ 통합서비스에서는 회사가 보유하지 않은 일부 콘텐츠가 표시될 수 있습니다. 그러한 콘텐츠에 대해서는 콘텐츠를 제공한 주체가 단독으로 모든 책임을 부담하게 됩니다. 여러분이 통합서비스를 이용하더라도 다른 이용자의 콘텐츠에 대하여 어떠한 권리를 가지게 되는 것은 아닙니다. 여러분이 다른 이용자의 콘텐츠를 사용하기 위해서는 콘텐츠 소유자로부터 별도로 허락을 받아야 합니다.\r\n"
               + "제 10 조 유료 서비스의 이용\r\n"
               + "① 통합서비스를 구성하는 개별 서비스의 대부분은 무료로 제공하고 있으나, 개별 서비스 내의 일부 세부 하위 서비스는 유료로 제공될 수 있습니다. 예를 들면, 카카오톡에서 친구들과 무료로 메시지를 주고 받을 수 있으나 일부 이모티콘 등은 유료로 구매해야 친구들에게 보낼 수 있으며, Daum 메일은 무료로 이용할 수 있으나 프리미엄 메일은 유료로 이용할 수 있으며, Melon의 경우 아티스트의 정보 검색,<br/> 실시간 음원 순위 등의 정보 확인은 무료로 이용할 수 있으나 1분 이상 음원 듣기 등은 유료 상품을 구매해야 이용할 수 있습니다.\r\n"
               + "② 여러분이 회사가 제공하는 유료서비스를 이용하는 경우 이용대금을 납부한 후 이용하는 것을 원칙으로 합니다. 회사가 제공하는 유료서비스에 대한 이용요금의 결제 방법은 핸드폰결제, 신용카드결제, 일반전화결제, 계좌이체, 무통장입금, 선불전자지급수단 결제 등이 있으며 각 유료서비스마다 결제 방법의 차이가 있을 수 있습니다. 매월 정기적인 결제가 이루어지는 서비스의 경우 여러분 개인이 해당 서비스의 이용을 중단하고 정기 결제의 취소를 요청하지 않는 한 매월 결제가 이루어집니다.\r\n"
               + "③ 회사는 결제의 이행을 위하여 반드시 필요한 여러분의 개인정보를 추가적으로 요구할 수 있으며, 여러분은 회사가 요구하는 개인정보를 정확하게 제공하여야 합니다.\r\n"
               + "④ 본 조에서 정하지 않은 내용은 개별 서비스 내의 각 세부 하위 서비스의 유료서비스 약관(예: 카카오 유료서비스 이용약관, 멜론 유료서비스약관 등)에서 정하며, 본 조의 내용과 각 세부 하위 서비스의 유료서비스 약관의 내용이 충돌하는 경우 세부 하위 서비스의 유료서비스 약관의 규정에 따릅니다.\r\n"
               + "제 11 조 게시판 이용 상거래\r\n"
               + "① 여러분이 서비스를 이용하여 통신판매 또는 통신판매중개를 업으로 하는 경우 전자상거래 등에서의 소비자보호에 관한 법률(이하 ‘전자상거래법’)에 따른 의무사항을 준수하여야 합니다.\r\n"
               + "② 여러분이 통신판매 또는 통신판매중개를 함에 있어 다른 이용자와 전자상거래 관련 분쟁이 발생하는 경우, 회사는 다른 이용자에게 소비자피해 구제 대행 신청을 할 수 있는 장치를 마련합니다.\r\n"
               + "③ 회사는 전자상거래법에 따라 신원정보를 입력하는 기능 등을 제공하여 여러분의 신원정보를 확인하고, 여러분과 다른 이용자 사이에 분쟁이 발생하여 전자상거래법에 따라 소비자피해 분쟁조정기구, 공정거래위원회, 시·도지사 또는 시장·군수·구청장이<br/> 신원정보 제공을 요구하는 경우 이에 협조합니다.\r\n"
               + "제 12 조 통합서비스 이용 방법 및 주의점\r\n" + "① 여러분은 통합서비스를 자유롭게 이용할 수 있으나, 아래 각 호의 행위는 하여서는 안 됩니다.\r\n"
               + "1. 이용 신청 또는 변경 시 허위 사실을 기재하거나, 다른 사람의 카카오계정 및 비밀번호를 도용, 부정하게 사용하거나, 다른 사람의 명의를 사용하거나 명의자의 허락 없이 문자메시지(SMS) 인증 등을 수행하는 행위\r\n"
               + "2. 회사의 서비스 정보를 이용하여 얻은 정보를 회사의 사전 승낙 없이 복제 또는 유통시키거나 상업적으로 이용하는 행위\r\n"
               + "3. 서비스 내에서 다운로드 또는 스트리밍을 통해 제공받은 음원을 사적 목적으로 이용하는 것 외에, 공공장소 및 영리를 목적으로 하는 영업장, 매장 등에서 재생하는 등의 방법으로 이용하는 행위\r\n"
               + "4. 타인의 명예를 손상시키거나 불이익을 주는 행위\r\n" + "5. 게시판 등에 음란물을 게재하거나 음란사이트를 연결(링크)하는 행위\r\n"
               + "6. 회사 또는 제3자의 저작권 등 기타 권리를 침해하는 행위(국내외 제3자의 저작권 등을 침해하는 행위로서 회사가 IP 접속 차단 등 기술적인 조치를 통하여 타인에 대한 권리 침해 방지 조치를 취하였음에도 불구하고 이용자가 회사를 기망하는 수단과<br/> 방법 등을 통하여 서비스에 접속 하는 등 제3자의 저작권 등을 침해하는 행위를 포함합니다)\r\n"
               + "7. 서비스 내에 회사나 제3자 등에 대한 허위의 사실을 게시하는 행위\r\n"
               + "8. 공공질서 및 미풍양속에 위반되는 내용의 정보, 문장, 도형, 음성 등을 타인에게 유포하는 행위\r\n"
               + "9. 통합서비스와 관련된 설비의 오동작이나 정보 등의 파괴 및 혼란을 유발시키는 컴퓨터 바이러스 감염 자료를 등록 또는 유포하는 행위\r\n"
               + "10. 통합서비스의 운영을 방해하거나 안정적 운영을 방해할 수 있는 정보 및 수신자의 명시적인 수신거부의사에 반하여 또는 수신자의 명시적인 동의 없이 광고성 정보 또는 스팸메일(Spam Mail)을 전송하는 행위\r\n"
               + "11. 회사의 동의 없이 서비스 또는 이에 포함된 소프트웨어의 일부를 복사, 수정, 배포, 판매, 양도, 대여, 담보제공하거나 타인에게 그 이용을 허락하는 행위와 소프트웨어를 역설계하거나 소스 코드의 추출을 시도하는 등 서비스를 복제, 분해 또는 모방하거나 기타 변형하는 행위\r\n"
               + "12. 타인으로 가장하는 행위 및 타인과의 관계를 허위로 명시하는 행위\r\n" + "13. 다른 이용자의 개인정보를 수집, 저장, 공개하는 행위\r\n"
               + "14. 자기 또는 타인에게 재산상의 이익을 주거나 타인에게 손해를 가하는 등 피해를 입힐 목적으로 허위의 정보를 유통시키는 행위\r\n"
               + "15. 재물을 걸고 도박하거나 사행행위를 하는 행위\r\n" + "16. 윤락행위를 알선하거나 음행을 매개하는 내용의 정보를 유통시키는 행위\r\n"
               + "17. 수치심이나 혐오감 또는 공포심을 일으키는 말이나 음향, 글이나 화상 또는 영상을 계속하여 상대방에게 도달하게 하여 상대방의 일상적 생활을 방해하는 행위\r\n"
               + "18. 관련 법령에 의하여 그 전송 또는 게시가 금지되는 정보(컴퓨터 프로그램 포함)의 전송 또는 게시 행위\r\n"
               + "19. 회사 또는 관계사의 직원이나 운영자를 가장하거나 사칭하여 또는 타인의 명의를 도용하여 글을 게시하거나 E-mail, 카카오톡 메시지 등을 발송하는 행위\r\n"
               + "20. 컴퓨터 소프트웨어, 하드웨어, 전기통신 장비의 정상적인 가동을 방해, 파괴할 가능성이 있는 소프트웨어 바이러스, 기타 다른 컴퓨터 코드, 파일, 프로그램을 포함하고 있는 자료를 게시하거나 E-mail, 카카오톡 메시지 등으로 발송하는 행위\r\n"
               + "21. 스토킹(stalking), 허위 또는 악의적 신고 남용 등 다른 이용자를 괴롭히는 행위\r\n"
               + "22. 1개월 이내 통합서비스 가입 및 유료서비스 구매 후 다시 해지하는 행위를 2회 이상 반복하는 등 통합서비스를 부당하게 악용하는 행위\r\n"
               + "23. 기타 현행 법령, 본 약관 및 운영정책 등 회사가 제공하는 서비스 관련 세부지침을 위반하는 행위\r\n"
               + "② 여러분은 서비스의 이용 권한, 기타 이용계약상 지위를 타인에게 양도·증여할 수 없으며, 담보로 제공할 수 없습니다.\r\n"
               + "③ 여러분의 자격 혹은 나이에 따라 아래 각 호처럼 통합서비스 이용의 일부가 제한될 수 있습니다.\r\n"
               + "1. 만19세 미만의 이용자는(단, 만 19세에 도달하는 해의 1월 1일을 맞이한 자는 제외, 이하 본 조에서 동일함) 정보통신망법 및 청소년보호법의 규정에 의하여 청소년유해매체물은 이용할 수 없습니다.\r\n"
               + "2. 청소년유해매체물을 이용하시기 위해서는 만 19세 이상이어야 하며, 정보통신망법 및 청소년보호법의 규정에 의하여 실명인증을 통해 본인 및 연령 인증을 받으셔야 합니다. 인증을 받지 않으시면, 해당 서비스의 이용이 제한됩니다.\r\n"
               + "④ 혹시라도 여러분이 관련 법령, 회사의 모든 약관 또는 정책을 준수하지 않는다면, 회사는 여러분의 위반행위 등을 조사할 수 있고, 해당 게시물 등을 삭제 또는 임시 삭제하거나 여러분의 통합서비스 전체 또는 통합서비스를 구성하는 일부 개별 서비스의 이용을<br/> 잠시 또는 계속하여 중단하거나, 통합서비스 재가입 또는 일부 개별 서비스의 재이용에 제한을 둘 수도 있습니다.\r\n"
               + "⑤ 이용 제한은 위반 활동의 누적 정도에 따라 한시적 제한에서 영구적 제한으로 단계적 제한하는 것을 원칙으로 하지만, 음란한 내용의 게시와 유포 및 사행성 도박 홍보 등 관련 법령에서 금지하는 명백한 불법행위나 타인의 권리침해로서 긴급한 위험<br/> 또는 피해 차단이 요구되는 사안에 대해서는 위반 활동 횟수의 누적 정도와 관계 없이 즉시 영구적으로 이용이 제한될 수 있습니다.\r\n"
               + "⑥ 본 조에서 정한 사항 및 그 밖에 통합서비스의 이용에 관한 자세한 사항은 카카오 운영정책 등을 참고해 주시기 바랍니다.\r\n" + "제 13 조 이용계약 해지\r\n"
               + "① 여러분이 카카오계정 탈퇴를 하는 경우 통합서비스 이용계약도 자동으로 해지됩니다.\r\n"
               + "② 통합서비스 이용계약 해지를 원하는 경우 여러분은 언제든지 서비스 내 제공되는 메뉴를 이용하여 해지 신청을 할 수 있으며, 회사는 법령이 정하는 바에 따라 신속히 처리하겠습니다.\r\n"
               + "③ 통합서비스 이용계약이 해지되면 관련 법령 및 카카오 개인정보 처리방침에 따라 여러분의 일정 정보를 보유하는 경우를 제외하고는 여러분의 정보나 여러분이 작성한 게시물 등 모든 데이터는 삭제됩니다. 다만, 여러분이 작성한 게시물이 제3자에 의하여 스크랩 또는 다른 공유 기능으로 게시되거나, 여러분이 제3자의 게시물에 댓글 등 게시물을 추가하는 등의 경우에는 해당 게시물 및 댓글은 삭제되지 않으므로 반드시 해지 신청 전에 삭제하시기 바랍니다.\r\n"
               + "④ 전항에 따라 여러분이 삭제하지 않은 게시물은 다른 이용자의 정상적 서비스 이용을 위하여 필요한 범위 내에서 통합서비스 내에 삭제되지 않고 남아 있게 됩니다.\r\n"
               + "⑤ 유료서비스 이용계약의 해지는 여러분의 유료서비스 이용계약 해지 신청 및 회사의 승낙에 의해 성립하게 되고, 환불할 금액이 있는 경우 환불도 이루어 지게 됩니다. 다만 각 세부 하위서비스의 유료서비스에서 본 약관과 다른 계약해지 방법 및 효과를 규정하고 있는 경우 각 유료서비스 약관 및 관련 세부지침에서 정한 바에 따릅니다.\r\n"
               + "⑥ 통합서비스를 구성하는 일부 개별 서비스의 경우 일정기간 동안 해당 개별 서비스를 이용하지 않을 경우 여러분의 정보를 파기하거나 분리 보관할 수 있으며, 또는 해당 개별 서비스 기능의 일부 또는 전부를 이용할 수 없도록 제한할 수 있습니다. 자세한 사항은 개별 서비스의 세부지침에서 확인하실 수 있습니다.\r\n"
               + "⑦ 통합서비스 이용계약이 해지된 경우라도 여러분은 다시 회사에 대하여 이용계약의 체결을 신청할 수 있습니다. 다만, 여러분이 관련 법령, 본 약관 및 세부지침을 준수하지 않아 서비스의 이용이 중단된 상태에서 이용계약을 해지한 후 다시 이용계약 체결을 신청하는 경우에는 통합서비스 가입에 일정기간 시간적 제한이 있을 수 있습니다. 또한 통합서비스를 구성하는 일부 개별 서비스의 경우 다시 통합서비스 이용계약을 체결한 후에도 해당 개별 서비스를 바로 이용하는 것에는 제6조 제3항에서 정한 바와 같이 일정한 시간적 제한 등이 따를 수 있습니다.\r\n"
               + "제 14 조 개인정보의 보호\r\n"
               + "여러분의 개인정보의 안전한 처리는 회사에게 있어 가장 중요한 일 중 하나입니다. 여러분의 개인정보는 통합서비스의 원활한 제공을 위하여 여러분이 동의한 목적과 범위 내에서만 이용됩니다. 관련 법령에 의하거나 여러분이 별도로 동의하지 아니하는 한 회사가 여러분의 개인정보를 제3자에게 제공하는 일은 결코 없으므로, 안심하셔도 좋습니다. 회사가 여러분의 개인정보를 안전하게 처리하기 위하여 기울이는 노력이나 기타 자세한 사항은 카카오 개인정보처리방침을 참고하여 주십시오.\r\n"
               + "\r\n" + "제 4 장 기타\r\n" + "제 15 조 손해배상 등\r\n"
               + "① 회사는 관련 법령상 허용되는 한도 내에서 통합서비스와 관련하여 본 약관에 명시되지 않은 어떠한 구체적인 사항에 대한 약정이나 보증을 하지 않습니다. 또한, 회사는 CP(Contents Provider)가 제공하거나 여러분이 작성하는 등의 방법으로 통합서비스에 게재된 정보, 자료, 사실의 신뢰도, 정확성 등에 대해서는 보증을 하지 않으며, 회사의 과실 없이 발생된 여러분의 손해에 대하여는 책임을 부담하지 아니합니다.\r\n"
               + "② 회사는 회사의 과실로 인하여 여러분이 손해를 입게 될 경우 본 약관 및 관련 법령에 따라 여러분의 손해를 배상하겠습니다. 다만 회사는 회사의 과실 없이 발생된 아래와 같은 손해에 대해서는 책임을 부담하지 않습니다. 또한 회사는 법률상 허용되는 한도 내에서 간접 손해, 특별 손해, 결과적 손해, 징계적 손해, 및 징벌적 손해에 대한 책임을 부담하지 않습니다.\r\n"
               + "1. 천재지변 또는 이에 준하는 불가항력의 상태에서 발생한 손해\r\n" + "2. 여러분의 귀책사유로 통합서비스 이용에 장애가 발생한 경우\r\n"
               + "3. 통합서비스에 접속 또는 이용과정에서 발생하는 개인적인 손해\r\n" + "4. 제3자가 불법적으로 회사의 서버에 접속하거나 서버를 이용함으로써 발생하는 손해\r\n"
               + "5. 제3자가 회사 서버에 대한 전송 또는 회사 서버로부터의 전송을 방해함으로써 발생하는 손해\r\n"
               + "6. 제3자가 악성 프로그램을 전송 또는 유포함으로써 발생하는 손해\r\n"
               + "7. 전송된 데이터의 생략, 누락, 파괴 등으로 발생한 손해, 명예훼손 등 제3자가 서비스를 이용하는 과정에서 발생된 손해\r\n"
               + "8. 기타 회사의 고의 또는 과실이 없는 사유로 인해 발생한 손해\r\n"
               + "③ 회사는 여러분이 통합서비스를 이용하여 기대하는 수익을 상실한 것에 대하여 책임을 지지 않으며 그 밖에 통합서비스를 통하여 얻은 자료로 인한 손해 등에 대하여도 책임을 지지 않습니다.\r\n"
               + "④ 회사는 회사의 과실이 없는 한 여러분 상호간 또는 여러분과 제3자 상호간에 통합서비스를 매개로 발생한 분쟁에 대해서는 개입할 의무가 없으며 이로 인한 손해를 배상할 책임도 없습니다.\r\n"
               + "제 16 조 청소년보호\r\n"
               + "통합서비스는 기본적으로 모든 연령대가 자유롭게 이용할 수 있는 공간으로서 유해 정보로부터 청소년을 보호하고 청소년의 안전한 인터넷 사용을 돕기 위해 정보통신망법에서 정한 청소년보호정책을 별도로 시행하고 있으며, 구체적인 내용은 통합서비스를<br/> 구성하는 개별 서비스 초기 화면 등에서 확인할 수 있습니다.\r\n"
               + "\r\n" + "제 17 조 통지 및 공지\r\n"
               + "회사는 여러분과의 의견 교환을 소중하게 생각합니다. 여러분은 언제든지 카카오 고객센터에 방문하여 의견을 개진할 수 있습니다. 서비스 이용자 전체에 대한 공지는 칠(7)일 이상 서비스 공지사항란에 게시함으로써 효력이 발생합니다. 여러분에게 중대한 영향을 미치는 사항의 경우에는 카카오계정에 등록된 이메일 주소로 이메일(이메일주소가 없는 경우 서비스 내 전자쪽지 발송, 서비스 내 알림 메시지를 띄우는 등의 별도의 전자적 수단) 발송 또는 여러분이 등록한 휴대폰번호로 카카오톡 메시지 또는 문자메시지 발송하는 방법 등으로 개별적으로 알려 드리겠습니다.\r\n"
               + "\r\n" + "제 18 조 분쟁의 해결\r\n"
               + "본 약관 또는 통합서비스는 대한민국법령에 의하여 규정되고 이행됩니다. 통합서비스 이용과 관련하여 회사와 여러분 간에 분쟁이 발생하면 이의 해결을 위해 성실히 협의할 것입니다. 그럼에도 불구하고 해결되지 않으면 민사소송법의 관할법원에 소를 제기할 수 있습니다.\r\n"
               + "\r\n" + "공고일자 : 2020년 10월 19일\r\n" + "시행일자 : 2020년 11월 3일,</html>";
      }

      String replaced1 = content.replace("\r\n", "<br/> ");
      String replaced2 = replaced1.replace(".", ".<br/> ");
      String replaced3 = replaced2.replace("(", "<br/> (");
      String replaced4 = replaced3.replace(")", ")<br/> ");
      String replaced5 = replaced4.replace(",", ",<br/> ");
      
      contentLabel = new JLabel(replaced5);
      new Style(contentLabel);
      contentLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
      scrollPane.setViewportView(contentLabel);
      //getContentPane().setBackground(Color.decode("#404040"));
      SwingToolsSubPage.initTestFrame(this);
      setBounds(50, 50, 1600, 900);
   }

}