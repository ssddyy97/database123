package chap6;

public class test4 { //클래스 선언 
	int ko28_limit_up_floor=10; //초기값 설정 최고층 
	int ko28_limit_down_floor=0;//초기값 설정 최저층 
	int ko28_floor=1; //초기값 설정 현재층 
	String ko28_help; //변수 설정  층 정보를 저장할 문자열 
	
	void ko28_up() //올라갈때 
	{ 
		if (ko28_floor==ko28_limit_up_floor) { // 층수가 10층이면 
			ko28_help="마지막층입니다"; //입력값 출력 
		}else {//아닐 경우
			ko28_floor++;  //점점 증가한다 
			ko28_help=String.format("%d층입니다",ko28_floor);//현재층의 메세지값 출력 
		}
	}
	void ko28_down() //내려갈때 
	{
		if (ko28_floor==ko28_limit_down_floor) { //0층일때 
			ko28_help="처음층입니다."; //입력값 출력 
		}else { //그외일때 
			ko28_floor--; //점점 내려감 
			ko28_help=String.format("%d층입니다.",ko28_floor); //현재층의 층수를 메세지 값으로 출력 
		}
	}

}
