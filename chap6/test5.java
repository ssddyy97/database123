package chap6;

public class test5 { //클래스 선언 
	
	private static int ko28_inval; //초기값 설정 
	public static void up() {
		ko28_inval++; //값의 증가 
			System.out.printf("난 그냥 메소드[%d]\n",ko28_inval); //입력값의 출력 
	}		
			
	public static void main(String[] args) {
			
		ko28_inval=0; //정적 변수 초기화 
		test4 ko28_elev;  //변수설정 
		
		ko28_elev= new test4(); //엘레베이터 객체 생성 
		
		up(); //메소드 up을 호출하여 inval 값을 증가 
		for(int ko28_i=0; ko28_i<10;ko28_i++) { //for문 
			ko28_elev.ko28_up();//test4 클래스의 up() 메소드 실행 층을 증가
			
			System.out.printf("MSG[%s]\n",ko28_elev.ko28_help); //현재 층 상태 메세지를 출력 
			
		}
		
		for(int ko28_i=0; ko28_i<10;ko28_i++) { //for문 0부터 10까지 증가 
			ko28_elev.ko28_down(); //점점 내려감 
			
			System.out.printf("MSG[%s]\n",ko28_elev.ko28_help); //현재층 상태 메세지 출력 
		
	}
			
		// TODO Auto-generated method stub

	}

}
