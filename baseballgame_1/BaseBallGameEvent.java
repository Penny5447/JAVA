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
//	BaseBallGameView bbgv = new BaseBallGameView();//���纻
	BaseBallGameView bbgv = null;
	public BaseBallGameEvent(BaseBallGameView bbgv) {//bbgv�� ���� null|BaseBallGameView�� ���� �ּҹ����� ������ �ִ�
		System.out.println("BaseBallGameEvent������ ȣ�� ����");
		this.bbgv = bbgv;//�ʱ�ȭ
	}

	//���� �̸��� �����ڸ� ������ ������ �� �־��.
	//�� ������ �Ķ������ ������ Ȥ�� �Ķ���� Ÿ���� �ݵ� �� �޶�� �ؿ�. ��Ģ�̴ϱ� ����� ����..
	public BaseBallGameEvent(BaseBallGameView bbgv,BaseBallGameLogic bbgl) {//bbgv�� ���� null|BaseBallGameView�� ���� �ּҹ����� ������ �ִ�
		System.out.println("BaseBallGameEvent������ ȣ�� ����");
		this.bbgv = bbgv;//�ʱ�ȭ null�̾��ٰ� �Ķ���ͷ� �Ѿ���� �ּҹ����� ���� �ǰ���..
		this.bbgl = bbgl;//�ʱ�ȭ null�̾��ٰ� �Ķ���ͷ� �Ѿ���� �ּҹ����� ���Ե�
	}
//	public BaseBallGameEvent(JTextArea jta_display, JTextField jtf_input) {
//		super();
//		this.jta_display = jta_display;
//		this.jtf_input = jtf_input;
//	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();//�̺�Ʈ�� �߻��� Ŭ������ �ּҹ���,jtf_input
		String label = e.getActionCommand();//��ư�� ��-������,����,�����,����
		System.out.println(obj);
		System.out.println(label);
		if(obj==bbgv.jtf_input) {
			//jta_display.append(jtf_input.getText()+"\n");
			//����ڰ� 3�ڸ� ���ڸ� �Է��ϰ� enter���� �� �Ʒ� ó�� ������ּ���. ��Ź�ؿ�^^
			//1ȸ 257 : 0�� 1��
			//2ȸ 526 : 1�� 0��
			bbgv.jta_display.append((++cnt)+"ȸ."+bbgv.jtf_input.getText()+" : "
									+bbgl.result(bbgv.jtf_input.getText())+"\n");
			bbgv.jtf_input.setText("");
		}
//		//�� ������ ��ư Ŭ���Ѱž�?
//		//else if(obj==jbtn_new) {//�ּҹ����� ����?
//		else if("������".equals(label)) {//�ʰ� Ŭ���� ��ư�� ���ڿ��� �������̾�? �ּҹ���(jbtn_new)�� ���� ���ڿ���
//			ranCom();
//		}
//		//�� ����� ��ư �����ž�?
//		else if("�����".equals(label)) {
//			bbgv.jta_display.setText("");
//		}
//		//�� �����ư ������?
//		else if("����".equals(label)) {
//			System.exit(0);
//		}
	}
}
