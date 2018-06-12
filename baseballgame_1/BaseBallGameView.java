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
	
	//����� - ����ο��� ����� �޼ҵ带 ȣ������ �ʴ´�.
		JFrame jf_ball = new JFrame();//��������
		JPanel jp_east = new JPanel();//���ʿ� ���� ����
		JPanel jp_center = new JPanel();//JFrame�� �߾ӿ� ��ġ�� �����̴�.
		//��ư 4�� �߰��غ��� - ��ư�� ���ؼ��� �̺�Ʈ ó���� �ؾߵǴϱ� ���������� ����
		//�̺�Ʈó���� ���� �޼ҵ带 ������ ó���Ѵ�.-��������
		JButton jbtn_new = new JButton("������");
		JButton jbtn_dap = new JButton("����");
		JButton jbtn_clear = new JButton("�����");
		JButton jbtn_exit = new JButton("����");
		//center������ �� Ŭ���� �߰��ϱ�
		JTextArea 	jta_display = new JTextArea();//���Ϳ� ��ġ
		JScrollPane jsp_display = new JScrollPane(jta_display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JTextField 	jtf_input 	= new JTextField();//���ʿ� ��ġ
		Font f = new Font("Thoma",Font.BOLD,16);
		
/*
 * ����Ʈ �����ڴ� ������ �� �ִ�. ��? �Ķ���Ͱ� �����ϱ� ���(������) �� �ټ� �ִ�.
 * �Ķ���͸� ���� �����ڰ� �ϳ��� ������ ����Ʈ �����ڴ� ���� �ȵȴ�. (������ ������ JVM�� ��������)
 * ������ ȣ���� �� �Ķ���͸� ������ �ѱ� �� �־��.
 * ������ BaseBallGameEvent���� �����ڸ� ���������ϱ� this�ѱ涧, �ι�° �Ķ���� �ڸ����� BaseBallGameEvent
 * �ּҹ����� �ϳ� �� �Ѱܺ��ô�
 * �ѱ���� ���� �ν��Ͻ�ȭ�� �ؾ� �Ǵϱ� ������ ȣ���ϱ� ���� ���� �ν��Ͻ�ȭ�� �ؾ� �ǰ���
 */
		BaseBallGameLogic bbglLogic = new BaseBallGameLogic();
		BaseBallGameEvent bbgEvent = new BaseBallGameEvent(this);

	//ȭ��ǥ�ø޼ҵ�
	public void initDisplay() {
		//�̺�Ʈ ó�� ��� ���۳�Ʈ�� �̺�Ʈ ó�� Ŭ������ �����ϱ�
		//���� this�� BaseBallGame�� ����Ű�� ������ε�
		//�̺�Ʈ ó���� ����ϴ� actionPerformed�޼ҵ带 �����ϰ� �ֱ� ������...
		//�Ʒ� �޼ҵ� ȣ���� �̺�Ʈ ó���ҽ�(jtf_input)�� �̺�Ʈ ó���� ����ϴ� Ŭ������ �����ϴ� �ڵ� - JVM�� �̺�Ʈ�� ���� �Ǿ����� actionPerformed
		
//		jtf_input.addActionListener(this); this - BaseBallGameView �ֳĸ� ActionListener�� ���ȿ� ��� ���Ұ�
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
		//jp_center������ �߾ӿ� JTextArea, ���ʿ� JTextField�� ���� �Ŵϱ�
		//���̾ƿ��� BorderLayout���� ������.
		jp_center.setLayout(new BorderLayout());
		jp_center.setBackground(Color.YELLOW);
		//��ư 4���� jp_east������ ���̱� ���ؼ��� ���� ���̾ƿ�(��ġ)�����ؾ� ��.
		jp_east.setLayout(new GridLayout(4,1,2,2));
		//jp_east.setBackground(new Color(120,34,59));
		jp_east.setBackground(Color.pink);
		jp_east.add(jbtn_new);
		jp_east.add(jbtn_dap);
		jp_east.add(jbtn_clear);
		jp_east.add(jbtn_exit);
		//Center������ jta_display�� jtf_input����.
		//jp_center������ �߾ӿ� ��ġ
		jp_center.add("Center",jsp_display);
		//jp_center������ ���ʿ� ��ġ
		jp_center.add("South",jtf_input);
		//���� ȭ�鿡 ������ ������ �ʾƿ�-�޸𸮿��� �ε��Ǿ� ������ jf_ball�� ���� ������ ����.
		jf_ball.add("East",jp_east);
		//jp_center������ JFrame���̱�
		jf_ball.add("Center", jp_center);
		jf_ball.setResizable(false);
		jf_ball.setTitle("�߱����ڰ��� Ver1.0");
		jf_ball.setSize(300, 400);//â�� ���ο� ���� ���� ����
		jf_ball.setVisible(true);//â Ȱ��ȭ|��Ȱ��ȭ
	}
	
	//���θ޼ҵ�
	public static void main(String[] args) {
		//insert here - initDisplay()ȣ���ϱ�
		//���ȿ� �ִ� �޼ҵ�� �ν��Ͻ�ȭ ���� ����� �� ����. �׷��� non-static�� static�������� ���Ұ��ϱ�
		//�ν��Ͻ�ȭ �ؾߴ�.
		BaseBallGameView bbGame = new BaseBallGameView();//�������� - �ٸ������� ���X,main�޼ҵ� �ȿ����� ��밡��
		bbGame.initDisplay();
//		bbGame.ranCom();//ä���ϱ�
	}

	
}
