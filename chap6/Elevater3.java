package chap6;

public class Elevater3 extends Elevater2{ //Elevater3은 Elevater 2에게 상속을 받음 
	void ko28_Repair() {//즉, Elevater2의 모든 속성 및 메서드를 사용
		
		ko28_help=String.format("수리중입니다");//추가적으로 새로운 기능(Repair() 메서드)을 정의
		
	}

}
