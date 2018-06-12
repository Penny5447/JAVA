package baseballgame_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGameView {
	
	//선언부 - 선언부에는 절대로 메소드를 호출하지 않는다.
		JFrame jf_ball = new JFrame();//전역변수
		JPanel jp_east = new JPanel();//동쪽에 붙일 속지
		JPanel jp_center = new JPanel();//JFrame의 중앙에 배치할 속지이다.
		//버튼 4개 추가해봐요 - 버튼에 대해서는 이벤트 처리도 해야되니깐 전역변수로 하자
		//이벤트처리는 따로 메소드를 꺼내서 처리한다.-전역변수
		JButton jbtn_new = new JButton("새게임");
		JButton jbtn_dap = new JButton("정답");
		JButton jbtn_clear = new JButton("지우기");
		JButton jbtn_exit = new JButton("종료");
		//center속지에 들어갈 클래스 추가하기
		JTextArea 	jta_display = new JTextArea();//센터에 배치
		JScrollPane jsp_display = new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JTextField 	jtf_input 	= new JTextField();//남쪽에 배치
		Font f = new Font("Thoma",Font.BOLD,16);
		
/*
 * 디폴트 생성자는 생략할 수 있다. 왜? 파라미터가 없으니까 대신(개발자) 해 줄수 있다.
 * 파라미터를 가진 생성자가 하나라도 있으면 디폴트 생성자는 제공 안된다. (생성자 없으면 JVM이 제공해줌)
 * 생성자 호출할 때 파라미터를 여러게 넘길 수 있어요.
 * 어차피 BaseBallGameEvent에서 생성자를 선언했으니까 this넘길때, 두번째 파라미터 자리에서 BaseBallGameEvent
 * 주소번지를 하나 더 넘겨봅시다
 * 넘기려면 먼저 인스턴스화를 해야 되니까 생성자 호출하기 저에 먼저 인스턴스화를 해야 되겠지
 */
		BaseBallGameLogic bbglLogic = new BaseBallGameLogic();
		BaseBallGameEvent bbgEvent = new BaseBallGameEvent(this);

	//화면표시메소드
	public void initDisplay() {
		//이벤트 처리 대상 콤퍼넌트와 이벤트 처리 클래스를 매핑하기
		//여기 this는 BaseBallGame를 가리키는 예약어인데
		//이벤트 처리를 담당하는 actionPerformed메소드를 구현하고 있기 때문에...
		//아래 메소드 호출은 이벤트 처리소스(jtf_input)와 이벤트 처리를 담당하는 클래스를 연결하는 코드 - JVM이 이벤트가 감지 되었을때 actionPerformed
		
//		jtf_input.addActionListener(this); this - BaseBallGameView 왜냐면 ActionListener가 내안에 없어서 사용불가
//		jbtn_new.addActionListener(this);
//		jbtn_clear.addActionListener(this);
//		jbtn_exit.addActionListener(this);
		
		jtf_input.addActionListener(bbgEvent); 
		jbtn_new.addActionListener(bbgEvent);
		jbtn_dap.addActionListener(bbgEvent);
		jbtn_clear.addActionListener(bbgEvent);
		jbtn_exit.addActionListener(bbgEvent);
		jbtn_new.setBackground(new Color(158,9,9));
		jbtn_new.setForeground(new Color(255,255,200));
		jbtn_dap.setBackground(new Color(19,99,57));
		jbtn_dap.setForeground(new Color(255,255,200));
		jbtn_clear.setBackground(new Color(7,84,170));
		jbtn_clear.setForeground(new Color(255,255,200));
		jbtn_exit.setBackground(new Color(54,54,54));
		jbtn_exit.setForeground(new Color(255,255,200));
		jta_display.setLineWrap(true);
		//jp_center속지는 중앙에 JTextArea, 남쪽에 JTextField를 붙일 거니까
		//레이아웃은 BorderLayout으로 지정함.
		jp_center.setLayout(new BorderLayout());
		jp_center.setBackground(Color.YELLOW);
		//버튼 4개를 jp_east속지에 붙이기 위해서는 먼저 레이아웃(배치)지정해야 함.
		jp_east.setLayout(new GridLayout(4,1,2,2));
		//jp_east.setBackground(new Color(120,34,59));
		jp_east.setBackground(Color.pink);
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		//Center속지에 jta_display와 jtf_input붙임.
		//jp_center속지의 중앙에 배치
		jp_center.add("Center",jsp_display);
		//jp_center속지의 남쪽에 배치
		jp_center.add("South",jtf_input);
		//아직 화면에 속지가 보이지 않아요-메모리에는 로딩되어 있지만 jf_ball에 아직 붙이지 않음.
		jf_ball.add("East",jp_east);
		//jp_center속지를 JFrame붙이기
		jf_ball.add("Center", jp_center);
		jf_ball.setResizable(false);
		jf_ball.setTitle("야구숫자게임 Ver1.0");
		jf_ball.setSize(300, 400);//창의 가로와 세로 길이 지정
		jf_ball.setVisible(true);//창 활성화|비활성화
	}
	
	//메인메소드
	public static void main(String[] args) {
		//insert here - initDisplay()호출하기
		//내안에 있는 메소드는 인스턴스화 없이 사용할 수 있지. 그런데 non-static은 static영역에서 사용불가니까
		//인스턴스화 해야댐.
		BaseBallGameView bbGame = new BaseBallGameView();//지역변수 - 다른곳에서 사용X,main메소드 안에서만 사용가능
		bbGame.initDisplay();
//		bbGame.ranCom();//채번하기
	}

	
}
