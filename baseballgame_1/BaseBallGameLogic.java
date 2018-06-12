package baseballgame_1;

public class BaseBallGameLogic {
	//컴터가 채번한 값을 담을 배열
	int com[]  = new int[3];
	//사용자가 입력한 값을 담을 배열
	int user[] = new int[3];
	
	//힌트-판정-세자리 숫자를 맞추어가는 과정
//	public String result(){
//		return +strike+"스"+ball+"볼";
//}

//	public String result(String user){
//		return +strike+"스"+ball+"볼";	
//	}
	
	public String result(String userInput) {
		//힌트에 사용된 스트라이크 갯수를 담을 변수		
		int strike = 0;
		//힌트에 사용될 볼 갯수를 담을 변수 - 바뀌어야되므로 지역변수
		int ball = 0;
		//입력받은 문자열을 정수 타입으로 바꾸어 담을 변수 선언
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
			return "정답입니다.";
		}
		//return "1스 0볼";
		return +strike+"스"+ball+"볼";
	}///end of result
	
	//랜덤 수 채번 메소드-정답
	public void ranCom() {
		
	}

}
