package chap2;

public class test18 { //클래스 선언

	public static void main(String[] args) { //메인으로부터 프로그램시작
		// TODO Auto-generated method stub
		int ko28_year=0; //year라는 숫자형 변수를 정의하고 0으로 초기화
		int ko28_age=14; //age라는 숫자형 변수를 정의하고 14로 초기화
		
		System.out.println("결과1:"+ko28_year); //year변수를 화면에 출력
		System.out.println("결과2:"+ko28_age); //age변수를 화면에 출력
		 
		ko28_year=ko28_age+2000; //변수 age의 값에 2000을 더해서 변수 year에 저장
		ko28_age=ko28_age+1;    //변수 age에 저장된 값을 1증가시킨다.
		
		System.out.println("결과3:"+ko28_year); //다시 year변수를 화면에 출력
		System.out.println("결과4:"+ko28_age); // 다시 age 변수를 화면에 출력
	}

}
