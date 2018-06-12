package baseballgame_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameEvent implements ActionListener{
	int cnt = 0;
//	JTextArea 	jta_display = null;
//	JTextField 	jtf_input = null;
	BaseBallGameLogic bbgl = new BaseBallGameLogic();
//	BaseBallGameView bbgv = new BaseBallGameView();//복사본
	BaseBallGameView bbgv = null;
	public BaseBallGameEvent(BaseBallGameView bbgv) {//bbgv는 현재 null|BaseBallGameView에 대한 주소번지를 가지고 있다
		System.out.println("BaseBallGameEvent생성자 호출 성공");
		this.bbgv = bbgv;//초기화
	}

	//같은 이름의 생성자를 여러개 선언할 수 있어요.
	//단 조건은 파라미터의 갯수나 혹은 파라미터 타입이 반드 시 달라야 해요. 규칙이니깐 기억해 봐요..
	public BaseBallGameEvent(BaseBallGameView bbgv,BaseBallGameLogic bbgl) {//bbgv는 현재 null|BaseBallGameView에 대한 주소번지를 가지고 있다
		System.out.println("BaseBallGameEvent생성자 호출 성공");
		this.bbgv = bbgv;//초기화 null이었다가 파라미터로 넘어오는 주소번지를 갖게 되겠죠..
		this.bbgl = bbgl;//초기화 null이었다가 파라미터로 넘어오는 주소번지를 갖게됨
	}
//	public BaseBallGameEvent(JTextArea jta_display, JTextField jtf_input) {
//		super();
//		this.jta_display = jta_display;
//		this.jtf_input = jtf_input;
//	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//이벤트가 발생한 클래스의 주소번지,jtf_input
		String label = e.getActionCommand();//버튼의 라벨-새게임,정답,지우기,종료
		System.out.println(obj);
		System.out.println(label);
		if(obj==bbgv.jtf_input) {
			//jta_display.append(jtf_input.getText()+"\n");
			//사용자가 3자리 숫자를 입력하고 enter쳤을 때 아래 처럼 출력해주세요. 부탁해요^^
			//1회 257 : 0스 1볼
			//2회 526 : 1스 0볼
			bbgv.jta_display.append((++cnt)+"회."+bbgv.jtf_input.getText()+" : "
									+bbgl.result(bbgv.jtf_input.getText())+"\n");
			bbgv.jtf_input.setText("");
		}
//		//너 새게임 버튼 클릭한거야?
//		//else if(obj==jbtn_new) {//주소번지가 같아?
//		else if("새게임".equals(label)) {//너가 클릭한 버튼의 문자열이 새게임이야? 주소번지(jbtn_new)가 가진 문자열비교
//			ranCom();
//		}
//		//너 지우기 버튼 누른거야?
//		else if("지우기".equals(label)) {
//			bbgv.jta_display.setText("");
//		}
//		//너 종료버튼 눌렀니?
//		else if("종료".equals(label)) {
//			System.exit(0);
//		}
	}
}
