package chap6;

public class Elevater2 { //클래스 선언 
	
	  int ko28_limit_up_floor; // 엘리베이터가 갈 수 있는 최상층
	 int ko28_limit_down_floor;// 엘리베이터가 갈 수 있는 최하층
	 int ko28_floor; // 현재 층
	 String ko28_help;// 현재 상태 메시지
	
	Elevater2(){ //기본 생성자
		ko28_limit_up_floor=10; // 초기값 설정 최대 10층 
		ko28_limit_down_floor=1; //초기값 설정 최소 1층
		ko28_floor=1; //초기층 설정 
		ko28_help="엘레베이터 기본 준공완료"; //엘레베이터 기본 준공 완료 메세지 설정 
	}
	
	Elevater2(int ko28_up_floor, int ko28_d_floor,int ko28_in_floor){ //사용 지정 생성자
		ko28_limit_up_floor=ko28_up_floor;  //최대 층과  올라가는층이 같을때
		ko28_limit_down_floor=ko28_d_floor; //최소 층과 내려가는 층이 같을때
		ko28_floor=ko28_in_floor; //플로어는 같을때
		ko28_help="엘레베이터 맞춤 준공완료"; //메세지 값 설정 
	}
	void ko28_up() { //올라갈때
		if(ko28_floor==ko28_limit_up_floor) { //최대 층에 도달했을때 
			ko28_help="마지막층입니다"; //메세지 출력 
		}else { //그외 
			ko28_floor++; //계속 증가 
			ko28_help=String.format("[%d] 층입니다",ko28_floor); //메세지 업데이트 
		}
		}
	void ko28_down() { //내려갈때 
		if(ko28_floor==ko28_limit_down_floor){ //최소 층에 도달했을때 
			ko28_help="처음 층입니다"; //메세지 출력 
		}else { //그외 
			ko28_floor--;//계속 감소 
			ko28_help=String.format("[%d]층입니다",ko28_floor); //메세지 업데이트 
		
		}
		
	}
	void ko28_up(int ko28_u) { //매개변수 u만큼 층을 내리는 기능 
	 for(int ko28_i=0; ko28_i<ko28_u; ko28_i++) this.ko28_up();//for this메소드를 u번 출력  this를 쓰면 명확해짐 
	 
	}
	
	void ko28_down(int ko28_u) { //매개변수 u만큼 층을 내리는 기능 
		for(int ko28_i=0;ko28_i<ko28_u; ko28_i++) ko28_down();//for this메소드를 u번 출력  thtis를 안써봣음 
	}
	void ko28_msg(String ko28_id) { //현재 엘레베이터 상태 정보를 출력하는 메서드 
		System.out.printf("%s=>[%s] 최대층[%d] 최소층[%d] 현재층[%d]\n",
				ko28_id,ko28_help,ko28_limit_up_floor,ko28_limit_down_floor,ko28_floor); //전부 출력 
	}
} 