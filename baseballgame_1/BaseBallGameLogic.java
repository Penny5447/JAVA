package baseballgame_1;

public class BaseBallGameLogic {
	//���Ͱ� ä���� ���� ���� �迭
	int com[]  = new int[3];
	//����ڰ� �Է��� ���� ���� �迭
	int user[] = new int[3];
	
	//��Ʈ-����-���ڸ� ���ڸ� ���߾�� ����
//	public String result(){
//		return +strike+"��"+ball+"��";
//}

//	public String result(String user){
//		return +strike+"��"+ball+"��";	
//	}
	
	public String result(String userInput) {
		//��Ʈ�� ���� ��Ʈ����ũ ������ ���� ����		
		int strike = 0;
		//��Ʈ�� ���� �� ������ ���� ���� - �ٲ��ߵǹǷ� ��������
		int ball = 0;
		//�Է¹��� ���ڿ��� ���� Ÿ������ �ٲپ� ���� ���� ����
		int temp = 0;
		temp = Integer.parseInt(userInput);
		user[0] = temp/100;
		user[1] = (temp%100)/10;
		user[2] = temp%10;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(user[i]==com[j]) {
					if(i==j) {
						strike++;												
					}
					else {
						ball++;
					}
					
				}//end of if
			}//end of inner for
		}//end of outter for
		if(strike==3) {
			return "�����Դϴ�.";
		}
		//return "1�� 0��";
		return +strike+"��"+ball+"��";
	}///end of result
	
	//���� �� ä�� �޼ҵ�-����
	public void ranCom() {
		
	}

}
