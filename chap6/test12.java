package chap6;

public class test12 { //클래스 선언 
		public static void main(String[]args ) {
			
			Elevater3 ko28_elev3; //객체 생성 
			ko28_elev3=new Elevater3(); //levater3는 Elevater2를 상속받은 서브클래스이므로 Elevater2의 모든 기능 사용가능 
			for(int ko28_i=0; ko28_i<10; ko28_i++) { //for문 0부터 10까지 증가 
				ko28_elev3.ko28_up();//위층으로 이동 
				System.out.printf("MSG elev3[%s]\n", ko28_elev3.ko28_help);//최상층에 도달하면 마지막 층이라는 메세지가 출력 
				
			}
			for(int ko28_i=0; ko28_i<10;ko28_i++) {//for문 0부터 10까지 감소 
				ko28_elev3.ko28_down(); //아래층으로 이동 
				System.out.printf("MSG elev3[%s]\n",ko28_elev3.ko28_help);//최하층애 도달하면 처음층이라는 메세지가 출력 
				
			}
			ko28_elev3.ko28_Repair();//객체 생성 
			System.out.printf("MSG elev3[%s]\n",ko28_elev3.ko28_help); //수리중이라는 메세지가 뜸 
		}
}
